/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.beans.OrbitUser;
import com.actelion.research.orbit.imageAnalysis.components.AbstractOrbitModule;
import com.actelion.research.orbit.imageAnalysis.components.ImageFrame;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.utils.TiffConverter;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.painter.Painter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public abstract class AbstractSpotModule extends AbstractOrbitModule {

    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_USER = "Orbit";
    protected static final Logger logger = LoggerFactory.getLogger(AbstractSpotModule.class);
    protected final DefaultListModel listModel = new DefaultListModel();
    protected final JList list = new JList(listModel);
    protected static final int thumbnailWidth = 100; // 70
    protected static final int thumbnailHeight = 100;
    protected SpotCellRenderer cellRenderer = null;
    protected int lastCnt = 0;
    protected int bbExtend = 30;

    protected abstract JButton getBtnStatistics();


    protected DefaultListModel copyModel(DefaultListModel oldModel) {
        Object[] obj = new Object[oldModel.size()];
        oldModel.copyInto(obj);
        DefaultListModel newModel = new DefaultListModel();
        for (Object o : obj) {
            newModel.addElement(o);
        }
        return newModel;
    }

    /**
     * resets all spots (set to undefined)
     */
    protected void resetAllSpots() {
        if (list.getModel().getSize() > 0) {
            for (int i = 0; i < list.getModel().getSize(); i++) {
                ImageAnnotation anno = (ImageAnnotation) ((DefaultListModel) list.getModel()).get(i);
                if (anno instanceof SpotAnnotation) {
                    SpotAnnotation spotAnno = (SpotAnnotation) anno;
                    spotAnno.setClassNum(-1);
                }
            }
        }
    }

    /**
     * Removes all selected spots from the list.
     */
    protected void removeSpots() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        List<Object> remSpots = new ArrayList<Object>();
        if (list.getSelectedIndices() != null && list.getSelectedIndices().length > 0) {
            for (int i = 0; i < list.getSelectedIndices().length; i++) {
                remSpots.add(list.getSelectedValues()[i]);
            }
            for (Object r : remSpots) {
                ((DefaultListModel) list.getModel()).removeElement(r);
                if (iFrame != null) {
                    iFrame.getRecognitionFrame().getAnnotations().remove(r);
                }
            }
        } else {
            logger.error("Please first mark the spots that should be removed.");
        }
    }

    /**
     * removes all spots in list (even the unselected)
     */
    protected void removeAllSpots() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (list.getModel().getSize() > 0) {
            for (int i = 0; i < list.getModel().getSize(); i++) {
                ImageAnnotation anno = (ImageAnnotation) ((DefaultListModel) list.getModel()).get(i);
                if (iFrame != null) {
                    iFrame.getRecognitionFrame().getAnnotations().remove(anno);
                }
            }
        }
        list.setModel(new DefaultListModel());
    }

    /**
     * Removes all spots inside a selected ROI from the list.
     */
    protected void removeSpotsInROI() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (iFrame == null) return;
        List<Object> remSpots = new ArrayList<Object>();
        if (iFrame.recognitionFrame.getROI() != null) {
            Shape roi = iFrame.recognitionFrame.getROI().getScaledInstance(100, new Point(0, 0));
            double x, y;
            for (int i = 0; i < list.getModel().getSize(); i++) {
                SpotAnnotation spot = (SpotAnnotation) ((DefaultListModel) list.getModel()).get(i);
                if (spot.getShape().getShapeList() != null) {
                    boolean found = false;
                    for (Shape shape : spot.getShape().getShapeList()) {
                        Rectangle2D re = shape.getBounds2D();
                        x = re.getCenterX();
                        y = re.getCenterY();
                        if (roi.contains(x, y)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) remSpots.add(spot);
                }
            }
            DefaultListModel newModel = copyModel((DefaultListModel) list.getModel());
            for (Object r : remSpots) {
                //((DefaultListModel)list.getModel()).removeElement(r);
                newModel.removeElement(r);
                iFrame.getRecognitionFrame().getAnnotations().remove(r);
            }
            list.setModel(newModel);
        } else {
            logger.error("Please first mark a region of interest (ROI) with the ROI tool.");
        }
    }

    protected int[] computeCounts() {
        return computeCounts(null);
    }

    protected int[] computeCounts(Shape shape) {
        final OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
        int[] counts = new int[model.getClassShapes().size()];
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        for (int i = 0; i < listModel.getSize(); i++) {
            SpotAnnotation annotation = (SpotAnnotation) listModel.getElementAt(i);
            if (annotation.getClassNum() >= 0
                    && annotation.getClassNum() < counts.length
                    && (shape == null || shape.contains(annotation.getShape().getShapeList().get(0).getBounds())))
                counts[annotation.getClassNum()]++;
        }
        return counts;
    }

    /**
     * counts the number of spots within one annotation
     */
    protected int countNumSpots(Shape shape) {
        int num = 0;
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        for (int i = 0; i < listModel.getSize(); i++) {
            SpotAnnotation annotation = (SpotAnnotation) listModel.getElementAt(i);
            if (annotation.getClassNum() >= 0
                    && (shape == null || shape.contains(annotation.getShape().getShapeList().get(0).getBounds())))
                num++;
        }
        return num;
    }


    protected void shuffle() {
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        List<SpotAnnotation> annotationList = new ArrayList<SpotAnnotation>(listModel.size());
        for (int i = 0; i < listModel.getSize(); i++) {
            SpotAnnotation annotation = (SpotAnnotation) listModel.get(i);
            annotationList.add(annotation);
        }
        Collections.shuffle(annotationList);
        clear();
        DefaultListModel newModel = new DefaultListModel();
        for (SpotAnnotation annotation : annotationList) {
            newModel.addElement(annotation);
        }
        list.setModel(newModel);
    }


    /**
     * Traverses the whole list and checks if an SpotAnnotation entry has the rawAnnotationId.
     *
     * @param id
     * @return
     */
    protected boolean listContainsAnnotationId(int id) {
        for (int i = 0; i < list.getModel().getSize(); i++) {
            if (((SpotAnnotation) list.getModel().getElementAt(i)).getRawAnnotationId() == id)
                return true;
        }
        return false;
    }

    public DefaultListModel getListModel() {
        //return listModel;
        return (DefaultListModel) list.getModel();
    }

    public JList getList() {
        return list;
    }

    /**
     * clears list model and icon cache
     */
    public void clear() {
        list.setModel(new DefaultListModel());
        cellRenderer.clear();
        System.gc();
    }

    protected void repaintFrameAndList() {
        final OrbitImageAnalysis oia = OrbitImageAnalysis.getInstance();
        final ImageFrame iFrame = oia.getIFrame();
        if (iFrame != null) {
            iFrame.repaint();
        }
        list.repaint();
    }

    @Override
    public void reset() {
        clear();
    }

    @Override
    public void init() {
    }

    protected boolean removeOld() {
        return (JOptionPane.showConfirmDialog(this,
                "Do you want to delete spots in the database which are not in the list anymore?",
                "Delete old spots permanently?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION);
    }

    /**
     * Added to the parsed class number when pressed a key for setting a class, e.g. -1 for nominal class assignment or 0 for counting.
     * In this implementation it returns -1.
     *
     * @return
     */
    protected int getClassNumOffset() {
        return -1;
    }

    protected class SpotModuleKeyListener extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keyNum = -1;
            try {
                keyNum = Integer.parseInt(e.getKeyChar() + "") + getClassNumOffset(); // number pressed? (if so, substract -1 because we count from 0)
            } catch (Exception e1) {
            }
            if (keyNum >= 0) {
                setClass(keyNum, e);
            } else {
                // del pressed? -> remove selected items
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    removeSpots();
                    OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    unsetClass();
                    OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    acceptClass(e);
                    OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                }
            }

        }

        private void acceptClass(KeyEvent e) {
            final OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
            final String user = OrbitImageAnalysis.loginUser.equals(OrbitImageAnalysis.GUEST_USER) ? null : OrbitImageAnalysis.loginUser;
            SpotAnnotation annotation = (SpotAnnotation) list.getSelectedValue();
            if (annotation != null && annotation.getProposedClassNum() >= 0) {
                annotation.setClassNum(annotation.getProposedClassNum());
                if (annotation.getClassNum() >= 0) {
                    String classLabel = model.getClassShapes().get(annotation.getClassNum()).getName();
                    annotation.setDescription(classLabel);
                    if (user != null) annotation.setUserId(user);
                }
                if (!e.isControlDown()) {
                    while ((list.getSelectedIndex() < list.getModel().getSize() - 1) && ((SpotAnnotation) list.getModel().getElementAt(list.getSelectedIndex())).getClassNum() >= 0) {
                        list.setSelectedIndex(list.getSelectedIndex() + 1);
                    }
                    list.ensureIndexIsVisible(list.getSelectedIndex());
                }
                list.repaint();
                OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                fireNumClassifiedCount();
            }
        }

        private void setClass(int num, KeyEvent e) {
            final OrbitModel model = OrbitImageAnalysis.getInstance().getModel();
            final String user = OrbitImageAnalysis.loginUser.equals(OrbitImageAnalysis.GUEST_USER) ? null : OrbitImageAnalysis.loginUser;
            SpotAnnotation annotation = (SpotAnnotation) list.getSelectedValue();
            if (annotation != null) {
                annotation.setClassNum(num);
                if (annotation.getClassNum() >= 0 && annotation.getClassNum() < model.getClassShapes().size()) {
                    String classLabel = model.getClassShapes().get(annotation.getClassNum()).getName();
                    annotation.setDescription(classLabel);
                    if (user != null) annotation.setUserId(user);
                }
                if (!e.isControlDown()) {
                    while ((list.getSelectedIndex() < list.getModel().getSize() - 1) && ((SpotAnnotation) list.getModel().getElementAt(list.getSelectedIndex())).getClassNum() >= 0) {
                        list.setSelectedIndex(list.getSelectedIndex() + 1);
                    }
                    list.ensureIndexIsVisible(list.getSelectedIndex());
                }
                list.repaint();
                OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                fireNumClassifiedCount();
            }
        }

        private void unsetClass() {
            SpotAnnotation annotation = (SpotAnnotation) list.getSelectedValue();
            if (annotation != null) {
                annotation.setClassNum(-1);
                annotation.setDescription(SpotAnnotation.LABEL_UNIDENTIFIED);
                list.repaint();
                OrbitImageAnalysis.getInstance().getIFrame().getRecognitionFrame().repaint();
                fireNumClassifiedCount();
            }
        }

        private void fireNumClassifiedCount() {
            int[] counts = computeCounts();
            int numCounts = 0;
            for (int i = 0; i < counts.length - 1; i++) numCounts += counts[i];
            if (getBtnStatistics() != null)
                getBtnStatistics().setText("Statistics [" + numCounts + "]");
            firePropertyChange(NumSpotsClassifiedListener.NUMSPOTSCLASSIFIED, lastCnt, numCounts);
            lastCnt = numCounts;
        }
    }


    protected class SpotCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;
        protected final long maxHashSize = 2000;
        protected Map<Integer, ImageIcon> cellCache = new ConcurrentHashMap<Integer, ImageIcon>();
        private ExecutorService executor = createExecutor();
        private ImageIcon dummyThn = null;
        OrbitModel model;
        ImageAnnotation annotation;
        OrbitUser emp;
        String userFullname;
        String s;
        JLabel label;
        final JXLabelExt jxlab = new JXLabelExt();

        public SpotCellRenderer() {
            dummyThn = new ImageIcon(new BufferedImage(thumbnailWidth, thumbnailHeight, BufferedImage.TYPE_INT_RGB));
            dummyThn.getImage().getGraphics().setColor(Color.white);
            dummyThn.getImage().getGraphics().fillRect(0, 0, dummyThn.getIconWidth(), dummyThn.getIconHeight());

            jxlab.setBackgroundPainter(new Painter<JXLabelExt>() {
                public void paint(Graphics2D g2d, JXLabelExt label, int width, int height) {
                    if (label.isProposed)
                        g2d.setPaint(new GradientPaint(0, 0, label.getBackground(), label.getWidth(), label.getHeight(), Color.white));
                    else g2d.setPaint(label.getBackground());
                    g2d.fillRect(0, 0, label.getWidth(), label.getHeight());
                }
            });

        }

        private ExecutorService createExecutor() {
            //return Executors.newSingleThreadExecutor();
            //return Executors.newCachedThreadPool();
            return new ThreadPoolExecutor(0, 10, 10L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        }

        /**
         * clears the cell cache
         */
        public void clear() {
            executor.shutdownNow();
            executor = createExecutor();
            cellCache.clear();
        }


        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            model = OrbitImageAnalysis.getInstance().getModel();
            annotation = (ImageAnnotation) value;
            emp = DALConfig.getImageProvider().getOrbitUser(annotation.getUserId());
            userFullname = annotation.getUserId();
            if (emp != null) userFullname = emp.getFirstName() + " " + emp.getLastName();
            s = "<html><body>" + annotation.getDescription();
            s += "<font size=\"2\"><br/>[" + userFullname + "]</font></body></html>";

            label = (JLabel) super.getListCellRendererComponent(list, s, index, isSelected, cellHasFocus);
            jxlab.setText(s);
            jxlab.setForeground(label.getForeground());
            jxlab.setBackground(label.getBackground());
            jxlab.setBorder(label.getBorder());
            label = jxlab;

            if (annotation.getDescription().length() > 100)
                label.setVerticalTextPosition(TOP);
            else label.setVerticalTextPosition(CENTER);
            // get and set icon

            ImageIcon icon = dummyThn;
            int shapeHash = 0;
            if (annotation.getShape().getShapeList() != null && annotation.getShape().getShapeList().size() > 0)
                shapeHash = annotation.getShape().getShapeList().get(0).getBounds().x + annotation.getShape().getShapeList().get(0).getBounds().y + annotation.getShape().getShapeList().get(0).getBounds().width + annotation.getShape().getShapeList().get(0).getBounds().height;
            int hash = label.getText().hashCode() + index + shapeHash;
            if (cellCache.containsKey(hash)) icon = cellCache.get(hash);
            else {
                try {
                    if (cellCache.size() <= maxHashSize)
                        executor.execute(new ThnRunny(annotation, hash));
                } catch (Throwable re) {
                    // can happen while shutting down the executor, but no problem
                }
            } // not in hash
            label.setIcon(icon);
            if (annotation instanceof SpotAnnotation) { // set background to class color
                if (((SpotAnnotation) annotation).getClassNum() >= 0) {
                    if (model.getClassShapes().size() > ((SpotAnnotation) annotation).getClassNum()) {
                        Color col = model.getClassShapes().get(((SpotAnnotation) annotation).getClassNum()).getColor();
                        label.setBackground(col);
                        ((JXLabelExt) label).setProposed(false);
                    }
                } else if (((SpotAnnotation) annotation).getProposedClassNum() >= 0) {
                    if (model.getClassShapes().size() > ((SpotAnnotation) annotation).getProposedClassNum()) {
                        Color col = model.getClassShapes().get(((SpotAnnotation) annotation).getProposedClassNum()).getColor();
                        label.setBackground(col);
                        ((JXLabelExt) label).setProposed(true);
                    }
                }
            }

            return label;
        }


        /**
         * Helper class for thumbnail creation in separate thread.
         *
         * @author stritma1
         */
        public class ThnRunny implements Runnable {

            private ImageAnnotation annotation = null;
            private int hash = 0;

            public ThnRunny(ImageAnnotation annotation, int hash) {
                this.hash = hash;
                this.annotation = annotation;
            }

            private void extendBB(Rectangle r, int extend) {
                r.setBounds(r.x - extend, r.y - extend, r.width + (extend * 2), r.height + (extend * 2));
                if (r.x < 0) r.x = 0;
                if (r.y < 0) r.y = 0;
                // todo: maxWidth, maxHeight
            }

            public void run() {
                try {
                    ClassShape classShape = annotation.getShape();
                    if (classShape != null && classShape.getShapeList() != null) {
                        if (classShape.getShapeList() != null && classShape.getShapeList().size() > 0) {
                            IScaleableShape p = (IScaleableShape) classShape.getShapeList().get(0); // only the first shape
                            ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
                            if (iFrame != null) {
                                final long maxW = 2000;
                                Rectangle rect = p.getScaledInstance(100d, new Point(0, 0)).getBounds();
                                extendBB(rect, bbExtend);
                                PlanarImage img = iFrame.recognitionFrame.bimg.getImage();
                                if ((long) rect.getWidth() * rect.getHeight() > (maxW * maxW)) {
                                    if (iFrame.recognitionFrame.bimg.getMipMaps() != null && iFrame.recognitionFrame.bimg.getMipMaps().length > 0) {
                                        img = iFrame.recognitionFrame.bimg.getMipMaps()[iFrame.recognitionFrame.bimg.getMipMaps().length - 1].getImage();
                                        double scale = (double) img.getWidth() / (double) iFrame.recognitionFrame.bimg.getImage().getWidth();
                                        rect = p.getScaledInstance(scale * 100d, new Point(0, 0)).getBounds();
                                    }
                                }
                                BufferedImage bi = img.getAsBufferedImage(rect, iFrame.recognitionFrame.bimg.getImage().getColorModel());
                                bi = TiffConverter.makeScaledImage(bi, thumbnailWidth, thumbnailHeight);
                                ImageIcon icon = new ImageIcon(bi);
                                if ((cellCache != null) && (icon != null)) {
                                    cellCache.put(hash, icon);
                                    list.revalidate();
                                    list.repaint();
                                }
                            }
                        }
                    }

                } catch (Throwable t) {
                    // can happen (e.g, outofmemory), but no problem
                }

            }
        } // ThnRunny

    }

    class JXLabelExt extends JXLabel {
        private static final long serialVersionUID = 1L;
        private boolean isProposed = false;

        public JXLabelExt() {
            super();
        }

        public JXLabelExt(String text) {
            super(text);
        }

        public boolean isProposed() {
            return isProposed;
        }

        public void setProposed(boolean isProposed) {
            this.isProposed = isProposed;
        }


    }

}
