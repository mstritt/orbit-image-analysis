/*
 * Copyright 1997-2016 Actelion Ltd., Inc.
 * Gewerbestrasse 16
 * CH-4123 Allschwil, Switzerland
 *
 * All Rights Reserved.
 * This software is the proprietary information of Actelion Pharmaceuticals, Ltd.
 * Use is subject to license terms.
 *
 * User: stritma1
 * Date: 6/10/16 4:25 PM
 *
 *
 */

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.mapReduceGeneric.RemoteFile;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.ITaskResultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * retrieve existing Map-Reduce results
 */
public class ExistingMRResultsViewSamba extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    protected Logger logger = LoggerFactory.getLogger(ExistingMRResultsViewSamba.class);
    protected final JList taskList = new JList(new DefaultListModel());
    protected final JEditorPane resultView = new JEditorPane("text/html", "");
    protected final JTextField statusField = new JTextField("Model:");
    protected final JButton refreshBtn = new JButton("Refresh");
    protected final DownloadBtn modelDownloadBtn = new DownloadBtn("Download Model");
    protected final JCheckBox roiAreaCb = new JCheckBox("Compute ROI Areas", false);
    protected TaskEntry selectedTask = null;
    protected AtomicBoolean updating = new AtomicBoolean(false);
    protected DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    public ExistingMRResultsViewSamba() throws Exception {

        taskList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                updateValues(true);
            }
        });

        refreshBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                updateValues(false);
            }
        });

        modelDownloadBtn.setEnabled(false);
        modelDownloadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("downloading: "+modelDownloadBtn.getOrbitModel());
                OrbitImageAnalysis.getInstance().saveModel(modelDownloadBtn.getOrbitModel(),modelDownloadBtn.getOrbitModel().getName());
            }
        });

        fillTaskList();

        // layout
        setLayout(new BorderLayout());
        setBounds(10, 10, 1100, 800);

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(refreshBtn, BorderLayout.WEST);
        upperPanel.add(statusField, BorderLayout.CENTER);
        upperPanel.add(modelDownloadBtn, BorderLayout.EAST);

        roiAreaCb.setToolTipText("Compute and report the ROI area per image. This might take some time!");
        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        taskPanel.add(roiAreaCb, BorderLayout.SOUTH);

        JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(taskPanel), new JScrollPane(resultView));
        add(upperPanel, BorderLayout.NORTH);
        add(splitter, BorderLayout.CENTER);

        setVisible(true);
    }

    protected void updateValues(final boolean selectionChange) {
        if (updating.get()) return;
        updating.set(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    TaskEntry task = (TaskEntry) taskList.getSelectedValue();
                    if (task == null && (!selectionChange)) { // nothing selected, take last task
                        task = selectedTask;
                    }

                    if (task != null) {
                        selectedTask = task;
                        String res = "<html><body>Results not ready</body></html>";
                        try {
                            fillTaskList();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } 
                        logger.info("reading resultfile: "+selectedTask);
                            try (InputStream fis = new ByteArrayInputStream(DALConfig.getScaleOut().getRemoteContextStore().readFromRemote("sparkresults/"+selectedTask.getFilename()))) {
                                ObjectInputStream ois = new ObjectInputStream(fis);
                                Map map = (Map) ois.readObject();  // <Integer, ClassificationResult>
                                
                            ITaskResultProducer worker = TaskResultProducerFactoryGeneric.createTaskResultProducer(map);
                            TaskResult taskResult = worker.produceTaskResult(map, roiAreaCb.isSelected());
//                                ITaskResultProducer resultProducer = new ClassificationWorkerMapReduce();
//                                TaskResult taskResult = resultProducer.produceTaskResult(map, false);

                                System.out.println(taskResult.getResultStr());
                                res = OrbitUtils.text2SmartHtml(taskResult.getResultStr());

                                if (taskResult.getModel()!=null) {
                                    OrbitModel model = taskResult.getModel();
                                    String modelName = "Model :: Name: "+ model.getName();
                                    if (model.getUser().length()>0) modelName += " / User: "+model.getUser();
                                    statusField.setText(modelName);
                                    modelDownloadBtn.setOrbitModel(model);
                                }
                                modelDownloadBtn.setEnabled(taskResult.getModel()!=null);

                            } catch (Exception e) {
                                e.printStackTrace();
                                logger.error("Error retrieving results", e);
                            } 

                        resultView.setText(res);
                        resultView.setCaretPosition(0);
                        resultView.repaint();
                    }
                } finally {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    updating.set(false);
                }
            }

            ;
        });
    }


    public void writeTask(int idx) {

    }


    protected void fillTaskList() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
        List<RemoteFile> files = DALConfig.getScaleOut().getRemoteContextStore().listFilenames("sparkresults",true);
        DefaultListModel model = new DefaultListModel();
        for (RemoteFile file : files) {
            model.addElement(new TaskEntry(file.getName(),file.getDate()));
        }
        taskList.setModel(model);
    }

    class TaskEntry {
        String filename;
        long date;

        public TaskEntry(String filename, long date) {
            this.filename = filename;
            this.date = date;
        }

        public String getFilename() {
            return filename;
        }

        public long getDate() {
            return date;
        }

        @Override
        public String toString() {
            return filename+" ("+ dateFormat.format(new Date(date))+")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TaskEntry taskEntry = (TaskEntry) o;
            return date == taskEntry.date &&
                    Objects.equals(filename, taskEntry.filename);
        }

        @Override
        public int hashCode() {

            return Objects.hash(filename, date);
        }
    }

    class DownloadBtn extends JButton  {
        private OrbitModel orbitModel;

        public DownloadBtn(String text) {
            super(text);
        }

        public OrbitModel getOrbitModel() {
            return orbitModel;
        }

        public void setOrbitModel(OrbitModel orbitModel) {
            this.orbitModel = orbitModel;
        }
    }


}
