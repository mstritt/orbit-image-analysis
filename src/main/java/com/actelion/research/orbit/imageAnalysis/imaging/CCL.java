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

package com.actelion.research.orbit.imageAnalysis.imaging;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kiran Lonikar's connected-components-labeling from https://github.com/klonikar/connected-components-labeling/blob/master/src/org/ml/ccl/CCL.java
 * Pixel and Label classes included in this file.
 */
public class CCL {
    private int[][] _board;
    private BufferedImage _input;
    private Graphics inputGD;
    private int _width;
    private int _height;
    private int backgroundColor;

    public Map<Integer, BufferedImage> Process(BufferedImage input, int bgColor) {
        backgroundColor = bgColor;
        _input = input;
        _width = input.getWidth();
        _height = input.getHeight();
        _board = new int[_width][];
        for (int i = 0; i < _width; i++)
            _board[i] = new int[_height];

        Map<Integer, List<Pixel>> patterns = Find();
        Map<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();

        inputGD = _input.getGraphics();
        inputGD.setColor(Color.BLUE);
        for (Integer id : patterns.keySet()) {
            BufferedImage bmp = CreateBitmap(patterns.get(id));
            images.put(id, bmp);
        }
        inputGD.dispose();

        return images;
    }

    protected boolean CheckIsBackGround(Pixel currentPixel) {
        // check if pixel color is backgroundColor (white).
        //return currentPixel.color.getAlpha() == 255 && currentPixel.color.getRed() == 255 && currentPixel.color.getGreen() == 255 && currentPixel.color.getBlue() == 255;
        return currentPixel.color == backgroundColor;
    }

    private static int Min(List<Integer> neighboringLabels, Map<Integer, Label> allLabels) {
        if (neighboringLabels.isEmpty())
            return 0; // TODO: is 0 appropriate for empty list

        int ret = allLabels.get(neighboringLabels.get(0)).GetRoot().name;
        for (Integer n : neighboringLabels) {
            int curVal = allLabels.get(n).GetRoot().name;
            ret = (ret < curVal ? ret : curVal);
        }
        return ret;
    }

    private static int Min(List<Pixel> pattern, boolean xOrY) {
        if (pattern.isEmpty())
            return 0; // TODO: is 0 appropriate for empty list

        int ret = (xOrY ? pattern.get(0).x : pattern.get(0).y);
        for (Pixel p : pattern) {
            int curVal = (xOrY ? p.x : p.y);
            ret = (ret < curVal ? ret : curVal);
        }
        return ret;
    }

    private static int Max(List<Pixel> pattern, boolean xOrY) {
        if (pattern.isEmpty())
            return 0; // TODO: is 0 appropriate for empty list

        int ret = (xOrY ? pattern.get(0).x : pattern.get(0).y);
        for (Pixel p : pattern) {
            int curVal = (xOrY ? p.x : p.y);
            ret = (ret > curVal ? ret : curVal);
        }
        return ret;
    }

    private Map<Integer, List<Pixel>> Find() {
        int labelCount = 1;
        Map<Integer, Label> allLabels = new HashMap<Integer, Label>();

        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                Pixel currentPixel = new Pixel(j, i, _input.getRGB(j, i));

                if (CheckIsBackGround(currentPixel)) {
                    continue;
                }

                List<Integer> neighboringLabels = GetNeighboringLabels(currentPixel);
                int currentLabel;

                if (neighboringLabels.isEmpty()) {
                    currentLabel = labelCount;
                    allLabels.put(currentLabel, new Label(currentLabel));
                    labelCount++;
                } else {
                    currentLabel = Min(neighboringLabels, allLabels);
                    Label root = allLabels.get(currentLabel).GetRoot();

                    for (Integer neighbor : neighboringLabels) {
                        if (root.name != allLabels.get(neighbor).GetRoot().name) {
                            allLabels.get(neighbor).Join(allLabels.get(currentLabel));
                        }
                    }
                }

                _board[j][i] = currentLabel;
            }
        }


        Map<Integer, List<Pixel>> patterns = AggregatePatterns(allLabels);

        return patterns;
    }

    private List<Integer> GetNeighboringLabels(Pixel pix) {
        List<Integer> neighboringLabels = new ArrayList<Integer>();

        for (int i = pix.y - 1; i <= pix.y + 2 && i < _height - 1; i++) {
            for (int j = pix.x - 1; j <= pix.x + 2 && j < _width - 1; j++) {
                if (i > -1 && j > -1 && _board[j][i] != 0) {
                    neighboringLabels.add(_board[j][i]);
                }
            }
        }

        return neighboringLabels;
    }

    private Map<Integer, List<Pixel>> AggregatePatterns(Map<Integer, Label> allLabels) {
        Map<Integer, List<Pixel>> patterns = new HashMap<Integer, List<Pixel>>();

        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                int patternNumber = _board[j][i];

                if (patternNumber != 0) {
                    patternNumber = allLabels.get(patternNumber).GetRoot().name;

                    if (!patterns.containsKey(patternNumber)) {
                        patterns.put(patternNumber, new ArrayList<Pixel>());
                    }

                    patterns.get(patternNumber).add(new Pixel(j, i, _input.getRGB(j, i)));
                }
            }
        }

        return patterns;
    }

    private BufferedImage CreateBitmap(List<Pixel> pattern) {
        int minX = Min(pattern, true);
        int maxX = Max(pattern, true);

        int minY = Min(pattern, false);
        int maxY = Max(pattern, false);

        int width = maxX + 1 - minX;
        int height = maxY + 1 - minY;

        BufferedImage bmp = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (Pixel pix : pattern) {
            bmp.setRGB(pix.x - minX, pix.y - minY, pix.color); //shift position by minX and minY
        }

        inputGD.drawRect(minX, minY, maxX - minX, maxY - minY);

        return bmp;
    }

    public static String getBaseFileName(String fileName) {
        return fileName.substring(0, fileName.indexOf('.'));
    }

    public static String getFileNameExtension(String fileName) {
        return fileName.substring(fileName.indexOf('.') + 1);
    }

    public BufferedImage getProcessedImage() {
        return _input;
    }


    protected class Pixel {
        public int x;
        public int y;
        public int color;

        public Pixel(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

    }


    protected class Label {
        public int name;

        public Label Root;

        public int Rank;

        public Label(int Name) {
            this.name = Name;
            this.Root = this;
            this.Rank = 0;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public Label getRoot() {
            return Root;
        }

        public void setRoot(Label root) {
            Root = root;
        }

        public int getRank() {
            return Rank;
        }

        public void setRank(int rank) {
            Rank = rank;
        }

        Label GetRoot() {
            if (this.Root != this) {
                this.Root = this.Root.GetRoot();
            }

            return this.Root;
        }

        void Join(Label root2) {
            if (root2.Rank < this.Rank)//is the rank of Root2 less than that of Root1 ?
            {
                root2.Root = this;//yes! then Root1 is the parent of Root2 (since it has the higher rank)
            } else //rank of Root2 is greater than or equal to that of Root1
            {
                this.Root = root2;//make Root2 the parent
                if (this.Rank == root2.Rank)//both ranks are equal ?
                {
                    root2.Rank++;//increment Root2, we need to reach a single root for the whole tree
                }
            }
        }
    }


    // Sample usage:
    // java org.ml.ccl.CCL images/one.png
    // java org.ml.ccl.CCL images/two.png -5000269
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: CCL imageFile [bgColor]");
            return;
        }
        CCL ccl = new CCL();
        try {
            int bgColor = 0xFFFFFFFF; // white default background color
            if (args.length == 2) {
                bgColor = Integer.decode(args[1]);
            }
            BufferedImage img = ImageIO.read(new File(args[0]));
            // TODO: Obtain background color.
            // An attempt to obtain bg color automatically: Center of image.
            System.out.println("image bg color: " + img.getRGB(img.getWidth() / 2, img.getHeight() / 2));
            Map<Integer, BufferedImage> components = ccl.Process(img, bgColor);
            String format = getFileNameExtension(args[0]);
            for (Integer c : components.keySet()) {
                //ImageIO.write(components.get(c), format, new File(getBaseFileName(args[0]) + "-component-" + c + "."  + format));
            }
            ImageIO.write(ccl.getProcessedImage(), format, new File(getBaseFileName(args[0]) + "-processed" + "." + format));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}