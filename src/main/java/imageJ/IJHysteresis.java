
package imageJ;

import ij.ImagePlus;
import ij.ImageStack;
import ij.gui.GenericDialog;
import ij.plugin.filter.PlugInFilter;
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;

public class IJHysteresis implements PlugInFilter {
    ImagePlus imp;


    /**
     * Description of the Method
     *
     * @param arg Description of the Parameter
     * @param imp Description of the Parameter
     * @return Description of the Return Value
     */
    public int setup(String arg, ImagePlus imp) {
        this.imp = imp;
        return DOES_ALL;
    }


    /**
     * Main processing method for the Hysteresis_ object
     *
     * @param ip Description of the Parameter
     */
    public void run(ImageProcessor ip) {
        GenericDialog gd = new GenericDialog("Parameters");
        gd.addNumericField("High threshold", 100, 2);
        gd.addNumericField("Low threshold", 50, 2);
        gd.showDialog();
        float T1 = (float) gd.getNextNumber();
        float T2 = (float) gd.getNextNumber();

        ImageStack stack = imp.getStack();
        ImageStack res_trin = new ImageStack(stack.getWidth(), stack.getHeight());
        ImageStack res_hyst = new ImageStack(stack.getWidth(), stack.getHeight());

        ImageProcessor tmp1;
        ImageProcessor tmp2;

        for (int s = 1; s <= stack.getSize(); s++) {
            tmp1 = trin(stack.getProcessor(s), T1, T2);
            tmp2 = hyst(tmp1);
            res_trin.addSlice("", tmp1);
            res_hyst.addSlice("", tmp2);
        }
        new ImagePlus("Trinarisation", res_trin).show();
        new ImagePlus("Hysteresis", res_hyst).show();
    }


    /**
     * Like run() but with parameters 100,50 fix and no GUI dialog.
     * Used for nerve detection.
     *
     * @param ip
     */
    public ImageProcessor runNerveDetection(ImageProcessor ip, float thresh1, float thresh2) {
        float T1 = thresh1;
        float T2 = thresh2;

        ImageProcessor res = trin(ip, T1, T2);
        return hyst(res);
    }

    /**
     * Double thresholding
     *
     * @param ima original image
     * @param T1  high threshold
     * @param T2  low threshold
     * @return "trinarised" image
     */
    ImageProcessor trin(ImageProcessor ima, float T1, float T2) {
        int la = ima.getWidth();
        int ha = ima.getHeight();
        ByteProcessor res = new ByteProcessor(la, ha);
        float pix;

        for (int x = 0; x < la; x++) {
            for (int y = 0; y < ha; y++) {
                pix = ima.getPixelValue(x, y);
                if (pix >= T1) {
                    res.putPixel(x, y, 255);
                } else if (pix >= T2) {
                    res.putPixel(x, y, 128);
                }
            }
        }
        return res;
    }


    /**
     * Hysteresis thresholding
     *
     * @param ima original image
     * @return thresholded image
     */
    ImageProcessor hyst(ImageProcessor ima) {
        int la = ima.getWidth();
        int ha = ima.getHeight();
        ImageProcessor res = ima.duplicate();
        float pix;
        boolean change = true;

        // connection
        while (change) {
            change = false;
            for (int x = 1; x < la - 1; x++) {
                for (int y = 1; y < ha - 1; y++) {
                    if (res.getPixelValue(x, y) == 255) {
                        if (res.getPixelValue(x + 1, y) == 128) {
                            change = true;
                            res.putPixelValue(x + 1, y, 255);
                        }
                        if (res.getPixelValue(x - 1, y) == 128) {
                            change = true;
                            res.putPixelValue(x - 1, y, 255);
                        }
                        if (res.getPixelValue(x, y + 1) == 128) {
                            change = true;
                            res.putPixelValue(x, y + 1, 255);
                        }
                        if (res.getPixelValue(x, y - 1) == 128) {
                            change = true;
                            res.putPixelValue(x, y - 1, 255);
                        }
                        if (res.getPixelValue(x + 1, y + 1) == 128) {
                            change = true;
                            res.putPixelValue(x + 1, y + 1, 255);
                        }
                        if (res.getPixelValue(x - 1, y - 1) == 128) {
                            change = true;
                            res.putPixelValue(x - 1, y - 1, 255);
                        }
                        if (res.getPixelValue(x - 1, y + 1) == 128) {
                            change = true;
                            res.putPixelValue(x - 1, y + 1, 255);
                        }
                        if (res.getPixelValue(x + 1, y - 1) == 128) {
                            change = true;
                            res.putPixelValue(x + 1, y - 1, 255);
                        }
                    }
                }
            }
            if (change) {
                for (int x = la - 2; x > 0; x--) {
                    for (int y = ha - 2; y > 0; y--) {
                        if (res.getPixelValue(x, y) == 255) {
                            if (res.getPixelValue(x + 1, y) == 128) {
                                change = true;
                                res.putPixelValue(x + 1, y, 255);
                            }
                            if (res.getPixelValue(x - 1, y) == 128) {
                                change = true;
                                res.putPixelValue(x - 1, y, 255);
                            }
                            if (res.getPixelValue(x, y + 1) == 128) {
                                change = true;
                                res.putPixelValue(x, y + 1, 255);
                            }
                            if (res.getPixelValue(x, y - 1) == 128) {
                                change = true;
                                res.putPixelValue(x, y - 1, 255);
                            }
                            if (res.getPixelValue(x + 1, y + 1) == 128) {
                                change = true;
                                res.putPixelValue(x + 1, y + 1, 255);
                            }
                            if (res.getPixelValue(x - 1, y - 1) == 128) {
                                change = true;
                                res.putPixelValue(x - 1, y - 1, 255);
                            }
                            if (res.getPixelValue(x - 1, y + 1) == 128) {
                                change = true;
                                res.putPixelValue(x - 1, y + 1, 255);
                            }
                            if (res.getPixelValue(x + 1, y - 1) == 128) {
                                change = true;
                                res.putPixelValue(x + 1, y - 1, 255);
                            }
                        }
                    }
                }
            }
        }
        // suppression
        for (int x = 0; x < la; x++) {
            for (int y = 0; y < ha; y++) {
                if (res.getPixelValue(x, y) == 128) {
                    res.putPixelValue(x, y, 0);
                }
            }
        }
        return res;
    }

}

