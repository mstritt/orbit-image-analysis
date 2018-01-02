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

package com.actelion.research.orbit.imageAnalysis.modules;

import com.actelion.research.orbit.imageAnalysis.components.AbstractOrbitModule;
import com.actelion.research.orbit.imageAnalysis.components.ClassAdminFrame;
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.mask.IOrbitMask;
import com.actelion.research.orbit.imageAnalysis.mask.OrbitMaskClassificationModel;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.ClassListCellRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Model stack
 */
public class ModelExplorer extends AbstractOrbitModule {

    private static final Logger logger = LoggerFactory.getLogger(ModelExplorer.class);
    final private DefaultListModel<OrbitModel> listModel = new DefaultListModel<>();
    final private JList<OrbitModel> list = new JList<>(listModel);
    final private JButton btnAddModel = new JButton("add");
    final private JButton btnRemoveModel = new JButton("remove");
    final private JButton btnSetAsClassificationModel = new JButton("set as classification");
    final private JButton btnSetAsMask = new JButton("set as mask");
    final private JButton btnConfigureModel = new JButton("configure");
    private final static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public ModelExplorer() {

        btnAddModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
                if (oia.getModel()==null) {
                    logger.error("model is null, please create a model first");
                    return;
                }
                final OrbitModel model = new OrbitModel(oia.getModel(),true);
                addModel(model,oia.getIFrames(),true);
            }
        });

        btnRemoveModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<OrbitModel> selectedList = list.getSelectedValuesList();
                if (selectedList!=null) {
                    for (OrbitModel orbitModel : selectedList) {
                        listModel.removeElement(orbitModel);
                    }
                }
            }
        });

        btnConfigureModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrbitModel model = list.getSelectedValue();
                if (model!=null) {
                    configureClasses(model);
                }
            }
        });

        btnSetAsClassificationModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
                OrbitModel model = list.getSelectedValue();
                if (model!=null) {
                    oia.setModel(new OrbitModel(model, true));
                    oia.updateStatusBar();
                }
            }
        });

        btnSetAsMask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
                OrbitModel model = list.getSelectedValue();
                if (model!=null) {
                    IOrbitMask mask = new OrbitMaskClassificationModel(model.clone());
                    oia.getModel().setMask(mask);
                    oia.updateStatusBar();
                }
            }
        });



        // UI

        list.setCellRenderer(new ModelCellRenderer());

        JPanel topPanel = new JPanel();
        topPanel.add(btnAddModel);
        topPanel.add(btnRemoveModel);
        topPanel.add(btnConfigureModel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnSetAsClassificationModel);
        bottomPanel.add(btnSetAsMask);

        JScrollPane scrollPane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
        add(scrollPane,BorderLayout.CENTER);
    }

    /**
     * Add the model to the explorer.
     * If prepareForSaving, the model will be prepared for saving and thus modified!
     * iFrames can be null.
     */
    public void addModel(OrbitModel model, List<ImageFrame> iFrames, boolean prepareForSaving) {
        if (prepareForSaving) {
            model.prepareModelforSaving(iFrames);
        }
        listModel.add(0,model);
    }

    @Override
    public String getName() {
        return "Model Explorer";
    }

    @Override
    public void init() {
         // image specific, don't do anything here
    }

    @Override
    public void reset() {
        // image specific, don't do anything here
    }

    private void configureClasses(OrbitModel model) {
        ClassAdminFrame configFrame = new ClassAdminFrame(model.getClassShapes(), new ClassListCellRenderer(), -1, false);
        configFrame.setAlwaysOnTop(true);
        configFrame.setVisible(true);
    }

    public OrbitModel getSelectedModel() {
        return list.getSelectedValue();
    }

    public List<OrbitModel> getSelectedValues() {
        return list.getSelectedValuesList();
    }

    protected class ModelCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            OrbitModel model = (OrbitModel) value;
            String val = "<html><body>";
            if (model!=null) {
                String name = model.getName();
                if (name==null||name.length()==0) {
                    name = "classification "+model.getRevision();
                    if (model.getSegmentationModel()!=null) {
                        name = "segmentation "+model.getRevision();
                    }
                    if (model.isCellClassification()) {
                        name = "object classification "+model.getRevision();
                    }
                }
                val += "<font size=5>"+name+"</font>"+
                       "<br/> <font size=3>"+"trained:"+((model.getClassifier()!=null&&model.getClassifier().isBuild())?"yes":"no") +"| segm:"+(model.getSegmentationModel()!=null?"yes":"no")+"| excl:"+(model.getExclusionModel()!=null?"yes":"no")+"| mask:"+(model.getMask()!=null?"yes":"no")+"</font>"+
                       "<br/> <font size=3>revision: "+model.getRevision()+" classes: "+model.getClassShapes().size()+"</font>"+
                       "<br/> <font size=3>trained on "+dateFormat.format(new Date(model.getLastUpdate()))+" user: "+model.getUser()+"</font>";
            }
            val += "</body></html>";
            JLabel label = (JLabel) super.getListCellRendererComponent(list,val,index,isSelected,cellHasFocus);
            Color col = Color.white;
            switch (model.getType()) {
                case OrbitModel.TYPE_CLASSIFICATION: {col = new Color(0,200,124); break;}
                case OrbitModel.TYPE_SEGMENTATION: {col = new Color(40,40,200); break;}
                case OrbitModel.TYPE_EXCLUSION: {col = new Color(200,72,0); break;}
                case OrbitModel.TYPE_MASK: {col = new Color(135,23,200); break;}
            }
            col = col.darker();
            if (index%2>0) col = col.darker();
            Color fontCol = Color.white;
            if (isSelected) {
                col = col.brighter();
                if (index%2>0) col = col.brighter();
                fontCol = Color.black;
            }
            if (cellHasFocus) col = col.brighter();
            label.setBackground(col);
            label.setForeground(fontCol);
            return label;
        }
    }

}
