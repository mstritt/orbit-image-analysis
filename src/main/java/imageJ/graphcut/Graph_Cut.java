

package imageJ.graphcut;

import ij.IJ;
import ij.ImagePlus;
import ij.ImageStack;
import ij.gui.GenericDialog;
import ij.io.FileInfo;
import ij.plugin.PlugIn;
import ij.process.LUT;
import mpicbg.imglib.cursor.LocalizableByDimCursor;
import mpicbg.imglib.image.Image;
import mpicbg.imglib.image.ImagePlusAdapter;
import mpicbg.imglib.type.numeric.RealType;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;

/**
 * Graph_Cut plugin
 * <p>
 * This is the interface plugin to the graph cut algorithm for images as
 * proposed by Boykkov and Kolmogorov in:
 * <p>
 * "An Experimental Comparison of Min-Cut/Max-Flow Algorithms for Energy
 * Minimization in Vision."
 * Yuri Boykov and Vladimir Kolmogorov
 * In IEEE Transactions on Pattern Analysis and Machine
 * Intelligence (PAMI),
 * September 2004
 * <p>
 * The GUI implementation reuses code/ideas of the Trainable Segmentation
 * plugin.
 *
 * @author Jan Funke <jan.funke@inf.tu-dresden.de>
 */


/**
 *
 * Manuel 2.10.2014: Modified version which works with ImageJ 1.x. GUI methods removed. Uses lib  legacy-imglib1-2.0.0-SNAPSHOT.jar (from fiji)
 *
 * Plugin interface to the graph cut algorithm.
 *
 * @author Jan Funke <jan.funke@inf.tu-dresden.de>
 * @version 0.1
 */
public class Graph_Cut<T extends RealType<T>> implements PlugIn {

    // the image the gui was started with
    private ImagePlus imp;

    // the edge image
    private ImagePlus edge;

    // the segmentation image for the gui
    private ImagePlus seg;

    // the sequence segmentation image
    private ImagePlus seq;

    // the potts weight
    private float dataWeight = DATA_INIT;
    private float pottsWeight = POTTS_INIT;
    private float edgeWeight = EDGE_INIT;
    private float edgeVariance = EDGE_VARIANCE_INIT;

    // Indicates that edge weights are given implicity as gray-scale differences
    // of the edge image. This will be false for edge images with 2n-1 pixels
    // per dimension of the imp image. In this case, the edge weights are stored
    // directly in the edge image between the doubled pixel coordinates, e.g.,
    // [2x,2y,...] and [x+2,y,...].
    private boolean implicitEdgeWeights = true;

    private static final float DATA_SCALE = 0.01f;
    private static final int DATA_MIN = 0;
    private static final int DATA_MAX = 100;
    public static final float DATA_INIT = DATA_SCALE * ((float) DATA_MAX / 2.0f);

    private static final float POTTS_SCALE = 0.01f;
    private static final int POTTS_MIN = 0;
    private static final int POTTS_MAX = 1000;
    public static final float POTTS_INIT = POTTS_SCALE * ((float) POTTS_MAX / 2.0f);

    private static final float EDGE_SCALE = 0.1f;
    private static final int EDGE_MIN = 0;
    private static final int EDGE_MAX = 1000;
    public static final float EDGE_INIT = EDGE_SCALE * ((float) EDGE_MAX / 2.0f);

    private static final float EDGE_VARIANCE_SCALE = 0.1f;
    private static final int EDGE_VARIANCE_MIN = 0;
    private static final int EDGE_VARIANCE_MAX = 1000;
    public static final float EDGE_VARIANCE_INIT = EDGE_VARIANCE_SCALE * ((float) EDGE_VARIANCE_MAX / 2.0f);

    // use an eight connected neighborhood?
    private boolean eightConnect = true;


    // the segmentation overlay
    private ImageOverlay resultOverlay;

    // color look up table for the segmentation overlay
    private LUT overlayLUT;

    // the image to show in the GUI
    private ImagePlus displayImage;

    // trasparency of the overlay
    private float overlayAlpha = 0.5f;

    // show the segmentation overlay?
    private boolean showColorOverlay = false;

    // the whole GUI
    private Panel all = new Panel();

    // panel for the left side of the GUI
    private JPanel applyPanel;

    // panel containing all buttons
    private JPanel buttonsPanel;

    // panel containing the potts slider
    private JPanel dataPanel;
    private JPanel pottsPanel;
    private JPanel edgesPanel;
    private JPanel edgeVariancePanel;
    private JPanel edgeSelectorPanel;

    // start graph cut button
    private JButton applyButton;

    // create a parameter sequence button
    private JButton sequenceButton;

    // start graph cut on several files
    private JButton batchButton;

    // toggle segmentation overlay button
    private JButton overlayButton;

    // slider to adjust the data weight
    private JSlider dataSlider;

    // slider to adjust the potts weight
    private JSlider pottsSlider;

    // slider to adjust the edge weight
    private JSlider edgeSlider;

    // slider to adjust the edge image value variance
    private JSlider edgeVarianceSlider;

    // combo box to select the edge image
    private JComboBox edgeSelector;


    /**
     * Processes a single channel image.
     * <p>
     * The intensities of the image are interpreted as the probability of each
     * pixel to belong to the foreground. The potts weight represents an
     * isotropic edge weight.
     *
     * @param imp         The image to process
     * @param edge        An edge image that increases the likelihood for cuts
     *                    between certain pixels (can be null).
     * @param pottsWeight Isotropic edge weights.
     * @param edgeWeight  The influence of the edge image.
     * @return A binary segmentation image
     */
    public ImagePlus processSingleChannelImage(ImagePlus imp, ImagePlus edge, float dataWeight, float pottsWeight, float edgeWeight) {

        // prepare segmentation image
        int[] dimensions = imp.getDimensions();
        int width = dimensions[0];
        int height = dimensions[1];
        int zslices = dimensions[3];

        ImagePlus seg = IJ.createImage(imp.getTitle() + " GraphCut segmentation", "8-bit",
                width, height, zslices);

        // fill it with the segmentation
        processSingleChannelImage(imp, edge, dataWeight, pottsWeight, edgeWeight, seg);

        return seg;
    }

    /**
     * Processes a single channel image.
     * <p>
     * The intensities of the image are interpreted as the probability of each
     * pixel to belong to the foreground. The potts weight represents an
     * isotropic edge weight.
     *
     * @param imp         The image to process
     * @param edge        An edge image that increases the likelihood for cuts
     *                    between certain pixels (can be null).
     * @param pottsWeight Isotropic edge weights.
     * @param edgeWeight  The influence of the edge image.
     * @param seg         A grayscale image to store the binary result.
     */
    public void processSingleChannelImage(ImagePlus imp, ImagePlus edge, float dataWeight, float pottsWeight, float edgeWeight, ImagePlus seg) {

        float maxValue = (float) Math.pow(2, imp.getBitDepth());
        Image<T> image = ImagePlusAdapter.wrap(imp);
        Image<T> edgeImage = null;
        if (edge != null)
            edgeImage = ImagePlusAdapter.wrap(edge);

        // get some statistics
        int[] dimensions = image.getDimensions();
        int numNodes = image.size();
        int numEdges = 0;

        // determine type of edge image
        if (edge != null) {
            int[] edgeDimensions = edge.getDimensions();
            implicitEdgeWeights = edgeDimensions[0] != 2 * dimensions[0] - 1;
        }

        // compute number of edges
        if (eightConnect) {

            // straight and diagonal edges

            // n = (2*a-1)*(2*b-1)*...
            //   - a*b*c*...
            //   + (a-1)*(b-1)*...
            int prod1 = 1;
            for (int d = 0; d < dimensions.length; d++)
                prod1 *= (2 * dimensions[d] - 1);

            int prod2 = 1;
            for (int d = 0; d < dimensions.length; d++)
                prod2 *= dimensions[d];

            int prod3 = 1;
            for (int d = 0; d < dimensions.length; d++)
                prod3 *= (dimensions[d] - 1);

            numEdges = prod1 - prod2 + prod3;
        } else {

            // straight edges
            for (int d = 0; d < dimensions.length; d++)
                numEdges += numNodes - numNodes / dimensions[d];
        }

        // setup imglib cursors
        LocalizableByDimCursor<T> cursor = image.createLocalizableByDimCursor();
        LocalizableByDimCursor<T> edgeCursor = null;
        int[] imagePosition = new int[dimensions.length];

        // create a new graph cut instance
        // TODO: reuse an old one
        IJ.log("Creating graph structure of " + numNodes + " nodes and " + numEdges + " edges...");
        long start = System.currentTimeMillis();
        GraphCut graphCut = new GraphCut(numNodes, numEdges);
        long end = System.currentTimeMillis();
        IJ.log("...done. (" + (end - start) + "ms)");

        // set terminal weights, i.e., segmentation probabilities
        IJ.log("Setting terminal weights with data prior " + dataWeight + "...");
        start = System.currentTimeMillis();
        while (cursor.hasNext()) {

            cursor.fwd();
            cursor.getPosition(imagePosition);

            int nodeNum = listPosition(imagePosition, dimensions);

            T type = cursor.getType();
            float value = type.getRealFloat();

            float probData = (value / maxValue);
            float probPrior = dataWeight;
            float fweight = -(float) Math.log(probData) - (float) Math.log(probPrior);
            float bweight = -(float) Math.log(1.0 - probData) - (float) Math.log(1.0 - probPrior);

            graphCut.setTerminalWeights(nodeNum, fweight, bweight);
        }
        end = System.currentTimeMillis();
        IJ.log("...done. (" + (end - start) + "ms)");

        // set edge weights

        // create neighbor offsets
        int[][] neighborPositions;

        if (eightConnect) {

            int numNeighbors = dimensions.length * 2;
            int numDiagonal = 1;
            for (int d = 0; d < dimensions.length; d++)
                numDiagonal *= 2;
            numNeighbors += numDiagonal;
            numNeighbors /= 2; // consider only half of the edges per pixel

            IJ.log("num neighbors per pixel: " + numNeighbors);

            neighborPositions = new int[numNeighbors][dimensions.length];

            Arrays.fill(neighborPositions[0], -1);

            for (int i = 1; i < neighborPositions.length; i++) {

                System.arraycopy(neighborPositions[i - 1], 0, neighborPositions[i], 0, dimensions.length);

                boolean valid = false;
                do {

                    for (int d = dimensions.length - 1; d >= 0; d--) {

                        neighborPositions[i][d]++;
                        if (neighborPositions[i][d] < 2)
                            break;
                        neighborPositions[i][d] = -1;
                    }

                    // check if valid neighbor
                    for (int d = dimensions.length - 1; d >= 0; d--) {

                        if (neighborPositions[i][d] < 0) {
                            valid = true;
                            break;
                        }
                    }

                } while (!valid);
                System.out.println(Arrays.toString(neighborPositions[i]));
            }
        } else {

            neighborPositions = new int[dimensions.length][dimensions.length];

            for (int d = 0; d < dimensions.length; d++) {
                Arrays.fill(neighborPositions[d], 0);
                neighborPositions[d][d] = -1;
            }
        }

        IJ.log("Setting edge weights to " + pottsWeight + "...");
        if (edge != null) {
            IJ.log("   (under consideration of edge image with weight " + edgeWeight + ")");
            if (implicitEdgeWeights)
                cursor = edgeImage.createLocalizableByDimCursor();
            else {
                cursor = image.createLocalizableByDimCursor();
                edgeCursor = edgeImage.createLocalizableByDimCursor();
            }
        } else
            cursor = image.createLocalizableByDimCursor();

        int[] neighborPosition = new int[dimensions.length];
        int[] edgePosition = new int[dimensions.length];
        int e = 0;
        start = System.currentTimeMillis();

        while (cursor.hasNext()) {

            cursor.fwd();

            // image position
            cursor.getPosition(imagePosition);
            int nodeNum = listPosition(imagePosition, dimensions);

            float value = cursor.getType().getRealFloat();

            A:
            for (int i = 0; i < neighborPositions.length; i++) {

                for (int d = 0; d < dimensions.length; d++) {

                    neighborPosition[d] = imagePosition[d] + neighborPositions[i][d];
                    edgePosition[d] = 2 * imagePosition[d] + neighborPositions[i][d];

                    if (neighborPosition[d] < 0 || neighborPosition[d] >= dimensions[d])
                        continue A;
                }

                int neighborNum = listPosition(neighborPosition, dimensions);

                float weight = pottsWeight;

                if (edge != null) {

                    if (implicitEdgeWeights) {

                        cursor.setPosition(neighborPosition);
                        float neighborValue = cursor.getType().getRealFloat();

                        // TODO:
                        // cache neighbor distances
                        weight += edgeWeight * edgeLikelihood(value, neighborValue, imagePosition, neighborPosition, dimensions);
                    } else {

                        edgeCursor.setPosition(edgePosition);
                        float edgeValue = edgeCursor.getType().getRealFloat();

                        // TODO:
                        // cache neighbor distances
                        weight += edgeWeight * edgeLikelihood(0, edgeValue, imagePosition, neighborPosition, dimensions);
                    }
                }

                // add weight_00 to source weight of node,
                // add weight_11 to sink weight of neighbor,
                // set edge weight node->neighbor to weight_10,
                // set edge weight neighbor->node to weight_01 - weight_00 -
                // weight_11
                //
                // since weight_00 = weight_11 = 0 and weight_01 = weight_10 =
                // weight, the following does it:
                graphCut.setEdgeWeight(nodeNum, neighborNum, weight);
                e++;
            }

            cursor.setPosition(imagePosition);
        }
        end = System.currentTimeMillis();
        IJ.log("...done inserting " + e + " edges. (" + (end - start) + "ms)");

        // calculate max flow
        IJ.log("Calculating max flow...");
        start = System.currentTimeMillis();
        float maxFlow = graphCut.computeMaximumFlow(false, null);
        end = System.currentTimeMillis();
        IJ.log("...done. Max flow is " + maxFlow + ". (" + (end - start) + "ms)");

        Image<T> segmentation = ImagePlusAdapter.wrap(seg);

        // create segmentation image
        cursor = segmentation.createLocalizableByDimCursor();
        imagePosition = new int[dimensions.length];
        while (cursor.hasNext()) {

            cursor.fwd();

            cursor.getPosition(imagePosition);

            int nodeNum = listPosition(imagePosition, dimensions);

            if (graphCut.getTerminal(nodeNum) == Terminal.FOREGROUND)
                cursor.getType().setReal(255.0);
            else
                cursor.getType().setReal(0.0);
        }
    }

    public ImagePlus createSequenceImage(ImagePlus imp, ImagePlus edge,
                                         float dataStart, float dataStop, float dataStep,
                                         float pottsWeight, float edgeWeight) {

        // prepare sequence image
        int[] dimensions = imp.getDimensions();
        int width = dimensions[0];
        int height = dimensions[1];
        int zslices = dimensions[3];
        int frames = (int) ((dataStop - dataStart) / dataStep) + 1;

        ImageStack seqStack = new ImageStack(width, height);

        final int numThreads = Runtime.getRuntime().availableProcessors() + 1;

        class ImageProcessingThread extends Thread {

            ImageStack result;

            final ImagePlus imp;
            final ImagePlus edge;

            final float dataStart;
            final float numSteps;
            final float dataStep;
            final float pottsWeight;
            final float edgeWeight;

            public ImageProcessingThread(final ImagePlus imp, final ImagePlus edge,
                                         final float dataStart, final int numSteps, final float dataStep,
                                         final float pottsWeight, final float edgeWeight) {

                this.imp = imp;
                this.edge = edge;

                this.dataStart = dataStart;
                this.numSteps = numSteps;
                this.dataStep = dataStep;

                this.pottsWeight = pottsWeight;
                this.edgeWeight = edgeWeight;
            }

            public void run() {

                result = new ImageStack(imp.getWidth(), imp.getHeight());

                float dataWeight = dataStart;
                for (int i = 0; i < numSteps; i++) {

                    IJ.log("Processing data weight " + dataWeight + "...");
                    IJ.showProgress((float) i / numSteps);
                    ImagePlus seg = processSingleChannelImage(imp, edge, dataWeight, pottsWeight, edgeWeight);
                    for (int s = 0; s < seg.getStack().getSize(); s++)
                        result.addSlice("", seg.getStack().getProcessor(s + 1));

                    dataWeight += dataStep;
                }
            }

            public ImageStack getResult() {
                return result;
            }
        }

        Vector<ImageProcessingThread> threads = new Vector<ImageProcessingThread>(numThreads);

        int numSteps = frames / numThreads;

        for (int i = 0; i < numThreads; i++) {

            float start = dataStart + dataStep * (i * numSteps + 1);

            if (i == numThreads - 1)
                numSteps = frames - (numThreads - 1) * numSteps;

            IJ.log("Starting thread " + i + " from " + start + ", " + numSteps + " steps (step " + dataStep + ")");
            threads.add(new ImageProcessingThread(imp, edge, start, numSteps, dataStep, pottsWeight, edgeWeight));
            threads.get(i).start();
        }

        for (int i = 0; i < numThreads; i++)
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        IJ.showProgress(1.0);

        for (ImageProcessingThread ipt : threads) {

            ImageStack result = ipt.getResult();
            IJ.log("Merging result with " + result.getSize() + " slices...");

            for (int s = 0; s < result.getSize(); s++)
                seqStack.addSlice("", result.getProcessor(s + 1));
        }

        ImagePlus seq = new ImagePlus(imp.getTitle() + " sequence segmentation " + dataStart + " - " + dataStop, seqStack);
        seq.setDimensions(1, zslices, frames);
        seq.setOpenAsHyperStack(true);

        return seq;
    }

    /**
     * Apply graph cut to several images
     */
    public void batchProcessImages() {
        // array of files to process
        File[] imageFiles;
        String storeDir = "";

        // create a file chooser for the image files
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);

        // get selected files or abort if no file has been selected
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            imageFiles = fileChooser.getSelectedFiles();
        } else {
            return;
        }

        boolean showResults = true;
        boolean storeResults = false;

        if (imageFiles.length >= 3) {

            int decision = JOptionPane.showConfirmDialog(null, "You decided to process three or more image files. Do you want the results to be stored on the disk instead of opening them in Fiji?", "Save results?", JOptionPane.YES_NO_OPTION);

            if (decision == JOptionPane.YES_OPTION) {
                // ask for the directory to store the results
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setMultiSelectionEnabled(false);
                returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    storeDir = fileChooser.getSelectedFile().getPath();
                } else {
                    return;
                }
                showResults = false;
                storeResults = true;
            }
        }

        final int numProcessors = Runtime.getRuntime().availableProcessors();

        IJ.log("Processing " + imageFiles.length + " image files in " + numProcessors + " threads....");

        setButtonsEnabled(false);

        Thread[] threads = new Thread[numProcessors];

        class ImageProcessingThread extends Thread {

            final int numThread;
            final int numProcessors;
            final File[] imageFiles;
            final boolean storeResults;
            final boolean showResults;
            final String storeDir;

            public ImageProcessingThread(int numThread, int numProcessors,
                                         File[] imageFiles,
                                         boolean storeResults, boolean showResults,
                                         String storeDir) {
                this.numThread = numThread;
                this.numProcessors = numProcessors;
                this.imageFiles = imageFiles;
                this.storeResults = storeResults;
                this.showResults = showResults;
                this.storeDir = storeDir;
            }

            public void run() {

                for (int i = numThread; i < imageFiles.length; i += numProcessors) {

                    File file = imageFiles[i];

                    ImagePlus batchImage = IJ.openImage(file.getPath());

                    // take first channel only if image has several channels
                    if (batchImage.getNChannels() > 1)
                        batchImage = extractChannel(batchImage, 1);

                    IJ.log("Processing image " + file.getName() + " in thread " + numThread);

                    ImagePlus segmentation = processSingleChannelImage(batchImage, null, dataWeight, pottsWeight, edgeWeight);

                    if (showResults) {
                        segmentation.show();
                        batchImage.show();
                    }

                    if (storeResults) {
                        String filename = storeDir + File.separator + file.getName();
                        IJ.log("Saving results to " + filename);
                        IJ.save(segmentation, filename);
                        segmentation.close();
                        batchImage.close();
                    }
                }
            }
        }

        // start threads
        for (int i = 0; i < numProcessors; i++) {

            threads[i] = new ImageProcessingThread(i, numProcessors, imageFiles, storeResults, showResults, storeDir);
            threads[i].start();
        }

        // join all threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }

        setButtonsEnabled(true);
    }

    private ImagePlus extractChannel(ImagePlus imp, int channel) {

        int width = imp.getWidth();
        int height = imp.getHeight();
        int zslices = imp.getNSlices();
        int frames = imp.getNFrames();

        FileInfo fileInfo = imp.getOriginalFileInfo();

        // create empty stack
        ImageStack stack2 = new ImageStack(width, height);
        // create new ImagePlus for selected channel
        ImagePlus imp2 = new ImagePlus();
        imp2.setTitle("C" + channel + "-" + imp.getTitle());

        // copy slices
        for (int t = 1; t <= frames; t++)
            for (int z = 1; z <= zslices; z++) {
                int slice = imp.getStackIndex(channel, z, t);
                stack2.addSlice("", imp.getStack().getProcessor(slice));
            }

        imp2.setStack(stack2);
        imp2.setDimensions(1, zslices, frames);
        if (zslices * frames > 1)
            imp2.setOpenAsHyperStack(true);
        imp2.setFileInfo(fileInfo);

        return imp2;
    }

    private ImagePlus extractZSlice(ImagePlus imp, int zslice) {

        int width = imp.getWidth();
        int height = imp.getHeight();
        int channels = imp.getNChannels();
        int frames = imp.getNFrames();

        FileInfo fileInfo = imp.getOriginalFileInfo();

        // create empty stack
        ImageStack stack2 = new ImageStack(width, height);
        // create new ImagePlus for selected frame
        ImagePlus imp2 = new ImagePlus();
        imp2.setTitle("Z" + zslice + "-" + imp.getTitle());

        // copy slices
        for (int f = 1; f <= frames; f++)
            for (int c = 1; c <= channels; c++) {
                int slice = imp.getStackIndex(c, zslice, f);
                stack2.addSlice("", imp.getStack().getProcessor(slice));
            }

        imp2.setStack(stack2);
        imp2.setDimensions(channels, 1, frames);
        if (channels * frames > 1)
            imp2.setOpenAsHyperStack(true);
        imp2.setFileInfo(fileInfo);

        return imp2;
    }

    private void updateSegmentationImage() {

        if (seg == null)
            seg = processSingleChannelImage(imp, edge, dataWeight, pottsWeight, edgeWeight);
        else
            processSingleChannelImage(imp, edge, dataWeight, pottsWeight, edgeWeight, seg);
    }

    private void createSequence() {

        // array of files to process
        File[] imageFiles;
        String storeDir = "";

        // create a file chooser for the image files
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);

        // get selected files or abort if no file has been selected
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            imageFiles = fileChooser.getSelectedFiles();
        } else {
            return;
        }

        boolean showResults = true;
        boolean storeResults = false;

        if (imageFiles.length >= 3) {

            int decision = JOptionPane.showConfirmDialog(null, "You decided to process three or more image files. Do you want the results to be stored on the disk instead of opening them in Fiji?", "Save results?", JOptionPane.YES_NO_OPTION);

            if (decision == JOptionPane.YES_OPTION) {
                // ask for the directory to store the results
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setMultiSelectionEnabled(false);
                returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    storeDir = fileChooser.getSelectedFile().getPath();
                } else {
                    return;
                }
                showResults = false;
                storeResults = true;
            }
        }

        GenericDialog gd = new GenericDialog("Sequence Parameter");
        gd.addNumericField("Start", 0.0, 3);
        gd.addNumericField("End", 1.0, 3);
        gd.addNumericField("Step", 0.01, 3);

        gd.showDialog();

        if (gd.wasCanceled())
            return;

        float start = (float) gd.getNextNumber();
        float end = (float) gd.getNextNumber();
        float step = (float) gd.getNextNumber();

        boolean zsliceByZslice = false;
        boolean rememberDecision = false;

        for (int i = 0; i < imageFiles.length; i++) {

            File file = imageFiles[i];

            ImagePlus sequenceImage = IJ.openImage(file.getPath());
            ImagePlus edgeImage;

            int width = sequenceImage.getWidth();
            int height = sequenceImage.getHeight();
            int channels = sequenceImage.getNChannels();
            int zslices = sequenceImage.getNSlices();
            int sequenceLength = -1;

            if (zslices > 1 && rememberDecision == false) {
                int decision = JOptionPane.showConfirmDialog(null, "Process image zslice by zslice (as opposed to as a whole)?", "Frame by frame?", JOptionPane.YES_NO_OPTION);

                if (decision == JOptionPane.YES_OPTION)
                    zsliceByZslice = true;

                // presumably, a lot of images are to be processed. in this
                // case, don't bother the user again...
                if (storeResults)
                    rememberDecision = true;
            }

            // create empty stack
            ImageStack resultStack = new ImageStack(width, height);

            for (int zslice = 1; zslice <= (zsliceByZslice ? zslices : 1); zslice++) {

                ImagePlus sequenceSlice = (zsliceByZslice ? extractZSlice(sequenceImage, zslice) : sequenceImage);

                // take first channel as probability map and second as edge prior
                // (if available)
                if (channels > 1) {
                    edgeImage = extractChannel(sequenceSlice, 2);
                    sequenceSlice = extractChannel(sequenceSlice, 1);
                } else
                    edgeImage = edge;

                IJ.log("Processing image " + file.getName() +
                        (edgeImage != null ? " under consideration of edge image in " + edgeImage.getTitle() : "") +
                        "...");

                seq = createSequenceImage(sequenceSlice, edgeImage, start, end, step, pottsWeight, edgeWeight);
                if (sequenceLength == -1)
                    sequenceLength = seq.getStackSize();

                // add all slices of the segmentation result
                for (int s = 0; s < seq.getStack().getSize(); s++)
                    resultStack.addSlice("", seq.getStack().getProcessor(s + 1), (zslice - 1) + s * (zslice));
            }

            // create result image plus
            ImagePlus result = new ImagePlus();
            result.setTitle("sequence-" + sequenceImage.getTitle());
            result.setStack(resultStack);
            result.setDimensions(1, zslices, sequenceLength);
            if (zslices * sequenceLength > 1)
                result.setOpenAsHyperStack(true);

            if (showResults) {
                result.show();
                result.updateAndDraw();
            }

            if (storeResults) {
                String filename = storeDir + File.separator + file.getName();
                IJ.log("Saving results to " + filename);
                IJ.save(result, filename);
                if (!showResults)
                    result.close();
            }

            sequenceImage.close();
        }
    }

    private float edgeLikelihood(float value1, float value2, int[] position1, int[] position2, int[] dimensions) {

        float dist = 0;
        for (int d = 0; d < dimensions.length; d++)
            dist += (position1[d] - position2[d]) * (position1[d] - position2[d]);
        dist = (float) Math.sqrt(dist);

        return (float) Math.exp(-((value1 - value2) * (value1 - value2)) / (2 * edgeVariance)) / dist;
    }

    private int listPosition(int[] imagePosition, int[] dimensions) {

        int pos = 0;
        int fac = 1;
        for (int d = 0; d < dimensions.length; d++) {
            pos += fac * imagePosition[d];
            fac *= dimensions[d];
        }
        return pos;
    }

    private void setButtonsEnabled(boolean enabled) {
        applyButton.setEnabled(enabled);
        batchButton.setEnabled(enabled);
        overlayButton.setEnabled(enabled);
        sequenceButton.setEnabled(enabled);
    }

    @Override
    public void run(String arg) {

    }
}
