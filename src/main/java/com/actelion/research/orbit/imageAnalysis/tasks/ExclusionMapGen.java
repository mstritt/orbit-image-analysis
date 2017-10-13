/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.exceptions.OrbitImageServletException;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.models.ClassShape;
import com.actelion.research.orbit.imageAnalysis.models.IScaleableShape;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExclusionMapGen {

    private final static Logger logger = LoggerFactory.getLogger(ExclusionMapGen.class);
    public RecognitionFrame recognitionFrame = null;
    public TiledImageWriter classificationImage = null;
    public OrbitModel model = null;
    private short[][] smap = null;
    private boolean isGenerated = false;
    private double scaleFactor = 1d;
    private boolean doNormalize = true;
    private int numThreads = Runtime.getRuntime().availableProcessors();
    private boolean keepVisualClassificationImage = true;


    public ExclusionMapGen(RecognitionFrame recognitionFrame, OrbitModel model) {
        this.recognitionFrame = recognitionFrame;
        this.model = model;
    }


    /**
     * Constructs an ExclusionMapGen based on the recognitionframe (uses the lowest MIP resolution if available) and the model.getExclusionModel().
     * If the exclusionModel is null, then null is returned.
     * Attention: ROI is ignored!
     */
    public static ExclusionMapGen constructExclusionMap(RawDataFile rdf, RecognitionFrame originalFrame, OrbitModel model) {
        return constructExclusionMap(rdf, originalFrame, model, null);
    }


    /**
     * Constructs an ExclusionMapGen based on the recognitionframe (uses the lowest MIP resolution if available) and the model.getExclusionModel().
     * If the exclusionModel is null, then null is returned.
     * Attention: ROI is ignored!
     */
    public static ExclusionMapGen constructExclusionMap(RawDataFile rdf, RecognitionFrame originalFrame, OrbitModel model, IScaleableShape roi) {
        ExclusionMapGen exMap = null;
        if (model != null && model.getExclusionModel() != null) {
            try {
                logger.debug("Exclusion Model perform erode and dilate: " + model.getExclusionModel().isPerformErodeDiliate());
                RecognitionFrame rFrame = getExclusionMapFrame(rdf, originalFrame, model);
                List<ClassShape> classShapes = model.getExclusionModel().getClassShapes();
                double scaleFactor = rFrame.bimg.getWidth() / (double) originalFrame.bimg.getWidth();
                rFrame.setClassShapes(classShapes);
                rFrame.setFeatureDescription(model.getExclusionModel().getFeatureDescription());
                rFrame.setWindowSize(model.getExclusionModel().getFeatureDescription().getWindowSize());
                exMap = new ExclusionMapGen(rFrame, model.getExclusionModel());
                exMap.setScaleFactor(scaleFactor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exMap;
    }


    /**
     * Returns the recognitionFrame used for the exclusionMap.
     *
     * @param rf
     * @param model
     * @return
     */
    public static RecognitionFrame getExclusionMapFrame(RawDataFile rdf, RecognitionFrame rf, OrbitModel model) {
        RecognitionFrame rFrame = null;
        // if MIPS are available, the lowest resolution is taken, otherwise the original frame

        if (rdf != null) {
            try {
                rf = new RecognitionFrame(rdf, false);   // load full frame (ignore lower level rf)
                rf.loadAnnotationROI(rdf.getRawDataFileId(), model.getAnnotationGroup());
                rf.loadImageScale(rdf.getRawDataFileId());
            } catch (OrbitImageServletException e) {
                e.printStackTrace();
            }
        }

        if (rf.bimg.getMipMaps() != null) {
            int numMIPS = rf.bimg.getMipMaps().length;
            int selectedMip = Math.max(0, numMIPS - model.getExclusionLevel());
            logger.debug("seleted MIP: " + selectedMip + " (model.exclusionLevel=" + model.getExclusionLevel() + ")");
            rFrame = new RecognitionFrame(rf, selectedMip, false); // -1
        } else { // clone current frame
            logger.debug("no MIPS available, cloning current frame");
            if (model.isApplyExclusionOnNegativeChannel() && rf.getNegativeChannel() == null) {
                System.out.println("Exclusion map should be used on negative channel, but no negative channel available.");
            }
            if (model.isApplyExclusionOnNegativeChannel() && rf.getNegativeChannel() != null) {
                rFrame = new RecognitionFrame(rf.getNegativeChannel(), false);
            } else {
                rFrame = new RecognitionFrame(rf, false);
            }
        }
        return rFrame;
    }

    public void generateMap() throws OrbitImageServletException {
        logger.trace("generateMap start");
        isGenerated = false;
        // classify

        // in future for numThreads==1 the direct method with ClassificationTaskTiled should be used (but does not work yet, ratios are always 0...
        //if (numThreads>1)
        {
            ClassificationWorker classificationWorker = new ClassificationWorker(recognitionFrame, model, true, null, null);
            classificationWorker.setNumClassificationThreads(numThreads);
            classificationWorker.setDoNormalize(doNormalize);
            logger.trace("executing recognitionWorker");
            classificationWorker.doWork();
        }  /*else {
            // direct single threaded method without extra thread (used for map reduce tasks)
			try {
				double[] ratio = new double[model.getClassShapes().size()];
				recognitionFrame.setRatio(ratio);
				recognitionFrame.setClassImage(new TiledImageWriter(recognitionFrame.bimg.getWidth(), recognitionFrame.bimg.getHeight(), recognitionFrame.bimg.getTileWidth(), recognitionFrame.bimg.getTileHeight()));
				ClassificationTaskTiled classificationTask = new ClassificationTaskTiled(ClassifierWrapper.makeCopy(model.getClassifier()), model.getStructure(), model.getFeatureDescription(),model.getClassShapes(), recognitionFrame.getROI(), recognitionFrame.bimg, recognitionFrame.getClassImage(), null, true);
				classificationTask.setPixelFuzzyness(0d);
				Long[] vals = classificationTask.call();
				for (int i = 0; i < vals.length; i++) {
					recognitionFrame.getRatio()[i] = vals[i];
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new OrbitImageServletException("error classifying exclusion frame");
			}
		}    */

        // a classification image is only needed if computed on different (mip-)level than original image
        if (keepVisualClassificationImage) {
            if (recognitionFrame.getClassImage().getImage().getWidth() * (long) recognitionFrame.getClassImage().getImage().getHeight() < 12000L * 12000L) {
                classificationImage = new TiledImageWriter(PlanarImage.wrapRenderedImage(recognitionFrame.getClassImage().getImage().getAsBufferedImage()));
            } else {
                // bad luck...
                logger.warn("classimage too big for exclusion map. Dims: " + recognitionFrame.getClassImage().getImage().getWidth() + "x" + recognitionFrame.getClassImage().getImage().getHeight());
                logger.error("Exclusion map size too big. Please select a small exclusion model level.");
            }
        }

        logger.trace("recognitionWorker finished");
        recognitionFrame.initializeClassColors();

		/* (1) */
        /*
        if (model.isPerformErodeDiliate())
		{
			logger.trace("start erode and diliate");
			for (int i=0; i<3; i++) smap = diliate(smap); // 3
			for (int i=0; i<50; i++) smap = erode(smap); //10
			logger.trace("end erode and diliate");
		} else {
			logger.trace("erode and diliate not active");
		}
	 	*/

        logger.trace("start class merging");
        List<Byte> exclList = new ArrayList<Byte>();
        List<Byte> inclList = new ArrayList<Byte>();
        for (byte ci = 0; ci < model.getClassShapes().size(); ci++) {
            if (model.getClassShapes().get(ci).getIncExcMode() == ClassShape.INCLUSION) inclList.add(ci);
            else if (model.getClassShapes().get(ci).getIncExcMode() == ClassShape.EXCLUSION) exclList.add(ci);
        }
        if (model.getVersion() < 7) {    // backward compatibility
            logger.debug("model version<7 detected: using class 1+2 as exclusion and 3+4 as inclusion class");
            exclList.add((byte) 0);
            exclList.add((byte) 1);
            inclList.add((byte) 2);
            inclList.add((byte) 3);
        }
        recognitionFrame.changeClassLabels(exclList, (byte) 1, inclList, (byte) 0);

        logger.trace("finished class merging");

        // generate smap
        smap = new short[recognitionFrame.getClassImage().getWidth()][recognitionFrame.getClassImage().getHeight()];


        // init
        Point[] tileArr = recognitionFrame.getClassImage().getImage().getTileIndices(null);
        for (Point tileNum : tileArr) {
            for (int x = recognitionFrame.getClassImage().getImage().tileXToX(tileNum.x); x < Math.min(recognitionFrame.getClassImage().getImage().tileXToX(tileNum.x) + recognitionFrame.getClassImage().getImage().getTileWidth(), recognitionFrame.getClassImage().getImage().getWidth()); x++) {
                for (int y = recognitionFrame.getClassImage().getImage().tileYToY(tileNum.y); y < Math.min(recognitionFrame.getClassImage().getImage().tileYToY(tileNum.y) + recognitionFrame.getClassImage().getImage().getTileHeight(), recognitionFrame.getClassImage().getImage().getHeight()); y++) {
                    byte c = recognitionFrame.getClass(x, y);
                    if (c > 0) {  // > 0 not background, not assigned
                        smap[x][y] = 1; // c0, c1 -> excluded
                    } else {
                        smap[x][y] = 0; // c2, c3
                    }
                } //y
            } // x
        } // tileNum

        // TODO!!!
            /*
             * does not work here, maybe because of classmerging before (and getClass does not work anymore...?) Move to (1), but then smap does not exist...
			 * do it directly on recongitionFrame.bimg ?
			 */
			/*
			if (model.isPerformErodeDiliate())
			{
				logger.trace("start erode and diliate");
				for (int i=0; i<3; i++) smap = diliate(smap);
				for (int i=0; i<10; i++) smap = erode(smap);
				logger.trace("end erode and diliate");
			} else {
				logger.trace("erode and diliate not active");
			}
			*/


        isGenerated = true;
        logger.trace("generateMap end");

        if (logger.isTraceEnabled()) {
            int cnt0 = 0;
            int cnt1 = 0;
            for (int x = 0; x < smap.length; x++)
                for (int y = 0; y < smap[0].length; y++) {
                    if (smap[x][y] == 0) cnt0++;
                    else cnt1++;
                }
            logger.trace("cnt class 0:" + cnt0 + "  cnt class 1:" + cnt1);
        }
    }

    /**
     * generateMap must be called before (no check will be done).<br>
     * setScaleFactor should be set before (will not automatically be done!)
     *
     * @param x
     * @param y
     * @return if pixel x,y should be excluded or not
     */
    public boolean isExcluded(int x, int y) {
        if ((x * scaleFactor) >= smap.length || (y * scaleFactor) >= smap[0].length) {
            //logger.trace("warning: coordinates out of range: "+nx+"/"+ny+" xy: "+x+"/"+y+" scale: "+scaleFactor);
            return true;
        }
        //logger.trace("ex: "+nx+"/"+ny+" xy: "+x+"/"+y+" scale: "+scaleFactor+" smap: "+smap[nx][ny]);
        return smap[(int) (x * scaleFactor)][(int) (y * scaleFactor)] > 0;
    }

    /**
     * checks if a certain percent (pIncluded=0..1) is included or not
     *
     * @param shape
     * @return
     */
    public boolean isExcluded(Shape shape, double pIncluded) {
        long cnt = 0;
        long hit = 0;
        Rectangle re = shape.getBounds();
        for (int x = re.x; x < re.getMaxX(); x += 2)
            for (int y = re.y; y < re.getMaxY(); y += 2) {
                if (shape.contains(x, y)) {
                    cnt++;
                    if (!isExcluded(x, y)) {
                        hit++;
                    }
                }
            }
        double pInc = (double) hit / (double) cnt;
        return (pInc < pIncluded);
    }


    @Deprecated
    private short[][] erode(final short[][] buf) {
        short cb = 0;
        short cf = 1;
        short[][] res = new short[buf.length][buf[0].length];
        for (int x = 0; x < buf.length; x++)
            for (int y = 0; y < buf[x].length; y++) {
                res[x][y] = buf[x][y];
                if (x > 0 && buf[x - 1][y] == cf) res[x][y] = cf;
                else if (x < buf.length - 1 && buf[x + 1][y] == cf) res[x][y] = cf;
                else if (y > 0 && buf[x][y - 1] == cf) res[x][y] = cf;
                else if (y < buf[x].length - 1 && buf[x][y + 1] == cf) res[x][y] = cf;
            }
        return res;
    }

    @Deprecated
    private short[][] diliate(final short[][] buf) {
        short cb = 1;
        short cf = 0;
        short[][] res = new short[buf.length][buf[0].length];
        for (int x = 0; x < buf.length; x++)
            for (int y = 0; y < buf[x].length; y++) {
                res[x][y] = buf[x][y];
                if (x > 0 && buf[x - 1][y] == cf) res[x][y] = cf;
                else if (x < buf.length - 1 && buf[x + 1][y] == cf) res[x][y] = cf;
                else if (y > 0 && buf[x][y - 1] == cf) res[x][y] = cf;
                else if (y < buf[x].length - 1 && buf[x][y + 1] == cf) res[x][y] = cf;
            }
        return res;
    }


    public RecognitionFrame getRecognitionFrame() {
        return recognitionFrame;
    }

    public OrbitModel getModel() {
        return model;
    }

    public boolean isGenerated() {
        return isGenerated;
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public boolean useForSegmentation() {
        return model.isUseExclusionForSegmentation();
    }

    public TiledImageWriter getClassificationImage() {
        return classificationImage;
    }

    public void setClassificationImage(TiledImageWriter classificationImage) {
        this.classificationImage = classificationImage;
    }

    /**
     * are classification results normalized? (sets normalize in classificationWorker)
     */
    public boolean isDoNormalize() {
        return doNormalize;
    }

    /**
     * classification results will be normalized (sets normalize in classificationWorker)
     */
    public void setDoNormalize(boolean doNormalize) {
        this.doNormalize = doNormalize;
    }

    public int getNumThreads() {
        return numThreads;
    }

    public void setNumThreads(int numThreads) {
        this.numThreads = numThreads;
    }

    public boolean isKeepVisualClassificationImage() {
        return keepVisualClassificationImage;
    }

    public void setKeepVisualClassificationImage(boolean keepVisualClassificationImage) {
        this.keepVisualClassificationImage = keepVisualClassificationImage;
    }
}
