package com.actelion.research.orbit.imageAnalysis.TMA;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.tasks.ClassificationTaskTiled;
import com.actelion.research.orbit.imageAnalysis.utils.TiffConverter;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter;
import ij.ImagePlus;
import ij.blob.Blob;
import ij.blob.ManyBlobs;
import ij.process.ImageConverter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;

public class TMAData implements Serializable {
    private int rdfId;
    private BufferedImage originalImage;
    private BufferedImage originalMaskImage;

    private BufferedImage filteredMaskImage;

    private BufferedImage maskImage;
    private BufferedImage processedImage = null;

    private ManyBlobs blobs = null;

    private List<Spot> spots = null;
    private List<Spot> gridSpots = null;

    private int[] rowSeperatorList;
    private int[] colSeperatorList;
    private boolean typeCircle = true;

    /**
     * Convenience constructor for testing the code.
     *
     * @param img   the rescaled image for testing
     * @param model the orbit model for generating the mask
     */
    public TMAData(BufferedImage img, OrbitModel model) throws Exception {
        this.originalImage = img;

        generateMask(model);
    }

    /**
     * Use this constructor normally.
     *
     * @param rdfId the rdfId of the image to be processed.
     * @param model the orbit model for generating the mask
     */
    public TMAData(int rdfId, OrbitModel model) throws Exception {
        this.rdfId = rdfId;

        this.originalImage = rescaleImage(1024);

        generateMask(model);
    }

    public BufferedImage rescaleImage(final int rescaledWidth) throws Exception {
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(this.rdfId);
        // read lowres image
        TiledImagePainter tip = new TiledImagePainter();
        tip.loadImage(rdf);
        tip.close();

        BufferedImage lowres = tip.getMipMaps()[tip.getMipMaps().length - 1].getImage().getAsBufferedImage();

        return TiffConverter.getScaledImage(lowres, rescaledWidth, -1);
    }

    public void generateMask(final OrbitModel model) throws Exception {
        // compute classification map
        RecognitionFrame rf = new RecognitionFrame(this.originalImage);
        rf.setClassShapes(model.getClassShapes());
        rf.initializeClassColors();
        rf.setClassImage(new TiledImageWriter(rf.bimg.getWidth(), rf.bimg.getHeight(), rf.bimg.getTileWidth(), rf.bimg.getTileHeight()));
        ClassificationTaskTiled ctt = new ClassificationTaskTiled(model, null, rf.bimg, null, rf.getClassImage(), Collections.singletonList(new Point(-1, -1)), true);
        ctt.call();
        Raster classRaster = rf.getClassImage().getImage().getData();

        int foreground = Color.white.getRGB();
        int background = Color.black.getRGB();
        BufferedImage classImage = new BufferedImage(classRaster.getWidth(), classRaster.getHeight(), TYPE_BYTE_BINARY);
        for (int y = 0; y < classRaster.getHeight(); y++)
            for (int x = 0; x < classRaster.getWidth(); x++) {
                if (rf.getClass(x, y) == 1) classImage.setRGB(x, y, foreground);  // only class 1 is active
                else classImage.setRGB(x, y, background);
            }

        this.originalMaskImage = classImage;
    }

    public void cleanMask(int minBlobSize, int maxBlobSize) {
        ImagePlus imp = new ImagePlus("maskImage", this.originalMaskImage);

        ImageConverter ic = new ImageConverter(imp);
        ic.convertToGray8();

        ManyBlobs allBlobs = new ManyBlobs(imp); // Extended ArrayList
        allBlobs.setBackground(0); // 0 for black, 1 for 255
        allBlobs.findConnectedComponents(); // Start the Connected Component Algorithm

        allBlobs.get(0).getPerimeter(); // Read the perimeter of a Blob
        this.blobs = allBlobs.filterBlobs(minBlobSize, maxBlobSize, Blob.GETFERETDIAMETER);

        filteredMaskImage = blobs.getLabeledImage().getBufferedImage();
        // Would be good to combine close blobs at this point?
    }

    public void detectSpots(int roiDiameter, int numRows, int numCols) {
        SmallFunctions sm = new SmallFunctions();

        int[] rowSeperatorList = sm.getRowMids(numRows, this.originalMaskImage);
        this.setRowSeperatorList(rowSeperatorList);

        int[] colSeperatorList = sm.getColMids(numCols, this.originalMaskImage);
        this.setColSeperatorList(colSeperatorList);

        List<Spot> spots = sm.getRectangleSpots(rowSeperatorList, colSeperatorList, this.originalImage);
        List<Spot> circleSpots = new ArrayList<>();
        Iterator<Spot> spotIt = spots.iterator();
        while (spotIt.hasNext()) {
            Spot spot = spotIt.next();
            Point2D spotPoint = new Point2D.Double();
            spotPoint.setLocation(spot.getRoi().getBounds2D().getCenterX(), spot.getRoi().getBounds2D().getCenterY());

            List<Blob> nearBlobs = new ArrayList<>();
            List<Blob> centeredBlobs = new ArrayList<>();

            for (Blob blob : blobs) {
                Point2D point = blob.getCenterOfGravity();
                Point2D center = new Point2D.Double(spot.getRoi().getBounds().getCenterX(), spot.getRoi().getBounds().getCenterY());
                if (spot.getRoi().getBounds().contains(point)) {
                    nearBlobs.add(blob);
                    if (center.distance(point) < spot.getRoi().getBounds().getWidth() / 3) {
                        centeredBlobs.add(blob);
                    }
                }
            }

            if (centeredBlobs.size() > 0) {
                nearBlobs = centeredBlobs;
            }

            if (nearBlobs.size() != 0) {
                Point2D betterPoint = sm.getMiddle(nearBlobs);
                Ellipse2D updatedRoi = new Ellipse2D.Double(betterPoint.getX() - roiDiameter / 2.0, betterPoint.getY() - roiDiameter / 2.0, roiDiameter, roiDiameter);
                Spot circleSpot = new Spot(spot.getName(), updatedRoi);
                circleSpots.add(circleSpot);
            } else {
                // This removes empty spots... but logic is probably wrong.
                spotIt.remove();
            }

        }
        this.spots = circleSpots;
        this.gridSpots = spots;

    }

    public List<Spot> setRectangleSpots(int[] rowSeperatorList, int[] colSeperatorList) {
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i <= rowSeperatorList.length; i++) {
            for (int j = 0; j <= colSeperatorList.length; j++) {
                String spotName = getCharForNumber(i + 1) + String.format("%02d", (j + 1));
                double x = j == 0 ? 0 : colSeperatorList[j - 1];
                double y = i == 0 ? 0 : rowSeperatorList[i - 1];
                double recWidth = j == 0 ? colSeperatorList[j] : j < colSeperatorList.length ? colSeperatorList[j] - x : this.originalImage.getWidth() - x - 1;
                double recHeight = i == 0 ? rowSeperatorList[i] : i < rowSeperatorList.length ? rowSeperatorList[i] - y : this.originalImage.getHeight() - y - 1;
                Rectangle2D spotRoi = new Rectangle2D.Double(x, y, recWidth, recHeight);
                Spot spot = new Spot(spotName, spotRoi);
                spots.add(spot);
            }
        }
        this.gridSpots = spots;
        return spots;
    }


    public static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

    private void drawSpot(Graphics2D g2d, Spot spot) {
        g2d.draw(spot.getRoi());
        Rectangle bounds = spot.getRoi().getBounds();
        g2d.drawString(spot.getName(), bounds.x - 8 + (int) (bounds.getWidth() / 2), bounds.y + 6 + (int) (bounds.getHeight() / 2));
    }

    private BufferedImage copyImage(BufferedImage source) {
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    public BufferedImage drawSpots(Boolean isCircle) {
        //BufferedImage bim = params.showOriginal ? params.currentTMAData.getOriginalImage() : params.currentTMAData.getMaskImage();
        //BufferedImage bim2 = copyImage(bim);
        // TODO: this is totally a candidate for generics
        List<Spot> theSpots;
        if (isCircle) {
            theSpots = this.getSpots();
        } else {
            theSpots = this.getGridSpots();
        }

        BufferedImage bim2 = copyImage(this.getOriginalImage());
        Graphics2D g2d = bim2.createGraphics();
        g2d.setColor(Color.red);

        for (Spot spot : theSpots) {
            drawSpot(g2d, spot);
        }

        g2d.dispose();
        return bim2;
    }

    public BufferedImage showVerticalLine(int x) {
        BufferedImage bim2 = copyImage(this.originalImage);
        Graphics2D g = bim2.createGraphics();
        g.setColor(Color.red);
        g.drawLine(x, 0, x, this.originalImage.getHeight());
        g.dispose();
        return bim2;
    }

    public BufferedImage showHorizontalLine(int y) {
        BufferedImage bim2 = copyImage(this.originalImage);
        Graphics2D g = bim2.createGraphics();
        g.setColor(Color.red);
        g.drawLine(0, y, this.originalImage.getWidth(), y);
        g.dispose();
        return bim2;
    }

    public static class Spot {
        private String name;
        private Shape roi;

        public Spot(String name, Shape roi) {
            this.name = name;
            this.roi = roi;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Shape getRoi() {
            return roi;
        }

        public void setRoi(Shape roi) {
            this.roi = roi;
        }
    }

    public BufferedImage getOriginalImage() {
        return this.originalImage;
    }

    public BufferedImage getOriginalMaskedImage() {
        return this.originalMaskImage;
    }

    public BufferedImage getFilteredMaskImage() {
        return this.filteredMaskImage;
    }

    public void setMaskImage(BufferedImage maskImage) {
        this.maskImage = maskImage;
    }

    public BufferedImage getMaskImage() {
        return this.maskImage;
    }

    public void setProcessedImage(BufferedImage processedImage) {
        this.processedImage = processedImage;
    }

    public BufferedImage getProcessedImage() {
        return processedImage == null ? this.originalImage : this.processedImage;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Spot> getSpots() {
        return this.spots;
    }

    public void setGridSpots(List<Spot> spots) {
        this.gridSpots = spots;
    }

    public List<Spot> getGridSpots() {
        return this.gridSpots;
    }

    public void setRowSeperatorList(int[] rowSeperatorList) {
        this.rowSeperatorList = rowSeperatorList;
    }

    public int[] getRowSeperatorList() {
        return rowSeperatorList;
    }

    public void setColSeperatorList(int[] colSeperatorList) {
        this.colSeperatorList = colSeperatorList;
    }

    public int[] getColSeperatorList() {
        return colSeperatorList;
    }

    public void setTypeCircle(boolean typeCircle) {
        this.typeCircle = typeCircle;
    }

    public boolean getTypeCircle() {
        return this.typeCircle;
    }

    public int getRdfId() {
        return this.rdfId;
    }

    public ManyBlobs getBlobs() {
        return this.blobs;
    }
}
