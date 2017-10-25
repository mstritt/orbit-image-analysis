/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.mapReduceGeneric.IRemoteContextStore;
import com.actelion.research.mapReduceGeneric.utils.TaskResultGeneric;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
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
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/**
 * retrieve existing Map-Reduce results
 */
public class SambaMRResultsView extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    protected Logger logger = LoggerFactory.getLogger(SambaMRResultsView.class);
    protected final JList taskList = new JList(new DefaultListModel());
    protected final JEditorPane resultView = new JEditorPane("text/html", "");
    protected final JTextField statusField = new JTextField("Status:");
    protected final JButton refreshBtn = new JButton("Refresh");
    protected final JCheckBox roiAreaCb = new JCheckBox("Compute ROI Areas", false);
    protected TaskResultGeneric selectedTask = null;
    protected AtomicBoolean updating = new AtomicBoolean(false);
    public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
    };
    private String shareName = "spark";

    public SambaMRResultsView() throws Exception {

        taskList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                return super.getListCellRendererComponent(list, task2String((TaskResultGeneric) value), index, isSelected, cellHasFocus);
            }
        });

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


        fillTaskList();

        // layout
        setLayout(new BorderLayout());
        setBounds(10, 10, 1100, 800);

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(refreshBtn, BorderLayout.WEST);
        upperPanel.add(statusField, BorderLayout.CENTER);

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
                    TaskResultGeneric task = (TaskResultGeneric) taskList.getSelectedValue();
                    if (task == null && (!selectionChange)) { // nothing selected, take last task
                        task = selectedTask;
                    }

                    if (task != null) {
                        selectedTask = task;
                        String res = "<html><body>Results not ready</body></html>";
                        try {
                            fillTaskList();
                            statusField.setText("Status of task " + task2String(task) + ": " + task.getStatus());
                            if (task.getStatus() == 0) { // 0 means finished
                                Map map = task.getResults();
                                ITaskResultProducer worker = TaskResultProducerFactoryMapReduce.createTaskResultProducer(task.getClassName());
                                TaskResult taskResult = worker.produceTaskResult(map, roiAreaCb.isSelected());
                                res = OrbitUtils.text2SmartHtml(taskResult.getResultStr());
                            } // task finished

                        } catch (Exception e) {
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


    protected void fillTaskList() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
        IRemoteContextStore store = DALConfig.getScaleOut().getRemoteContextStore();
        List<String> filenames = store.listFilenames(shareName);

        DefaultListModel model = new DefaultListModel();
        for (String s : filenames) {
            System.out.println(s);
            byte[] bytes = store.readFromRemote(shareName + "/" + s);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new GZIPInputStream(new ByteArrayInputStream(bytes)));
                TaskResultGeneric taskResult = (TaskResultGeneric) ois.readObject();
                taskResult.setStringId(s);
                model.addElement(taskResult);
            } catch (Exception e) {
                logger.error("cannot read taskresult", e);
            } finally {
                if (ois != null) ois.close();
            }
        }

        taskList.setModel(model);
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    protected String task2String(TaskResultGeneric task) {
        String name = "";
        if (task.getClassName() != null) name = task.getClassName();
        if (name.contains(".")) name = name.substring(name.lastIndexOf(".") + 1);
        //if (task.getNumericId()>0) name += " ("+dateFormat.get().format(new Date(task.getNumericId()))+")";
        name += " [" + task.getStringId() + "]";
        return name;
    }

    public static void main(String[] args) throws Exception {
        SambaMRResultsView view = new SambaMRResultsView();
        view.setVisible(true);
    }


}
