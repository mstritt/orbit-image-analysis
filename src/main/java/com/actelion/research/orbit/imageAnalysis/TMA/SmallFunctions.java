package com.actelion.research.orbit.imageAnalysis.TMA;

import com.actelion.research.orbit.imageAnalysis.TMA.TMAData.Spot;
import ij.blob.Blob;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmallFunctions {
    private BufferedImage copyImage(BufferedImage source) {
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    public List<Spot> getRectangleSpots(int[] rowSeperatorList, int[] colSeperatorList, BufferedImage originalImage) {
        List<TMAData.Spot> spots = new ArrayList<>();
        for (int i = 0; i <= rowSeperatorList.length; i++) {
            for (int j = 0; j <= colSeperatorList.length; j++) {
                String spotName = getCharForNumber(i + 1) + String.format("%02d", (j + 1));
                double x = j == 0 ? 0 : colSeperatorList[j - 1];
                double y = i == 0 ? 0 : rowSeperatorList[i - 1];
                double recWidth = j == 0 ? colSeperatorList[j] : j < colSeperatorList.length ? colSeperatorList[j] - x : originalImage.getWidth() - x - 1;
                double recHeight = i == 0 ? rowSeperatorList[i] : i < rowSeperatorList.length ? rowSeperatorList[i] - y : originalImage.getHeight() - y - 1;
                Rectangle2D spotRoi = new Rectangle2D.Double(x, y, recWidth, recHeight);
                Spot spot = new Spot(spotName, spotRoi);
                spots.add(spot);
            }
        }
        return spots;
    }

    public int[] getRowSums(BufferedImage bim) {
        int[] rowSums = new int[bim.getHeight()];
        for (int y = 0; y < bim.getHeight(); y++) {
            int rowSum = 0;
            for (int x = 0; x < bim.getWidth(); x++) {
                int p = bim.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                rowSum += r; //red value, green and blue should be the same
            }
            rowSums[y] = rowSum;
        }
        return rowSums;
    }

    public int[] getColSums(BufferedImage bim) {
        int[] colSums = new int[bim.getWidth()];
        for (int x = 0; x < bim.getWidth(); x++) {
            int colSum = 0;
            for (int y = 0; y < bim.getHeight(); y++) {
                int p = bim.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                colSum += r; //red value, green and blue should be the same
            }
            colSums[x] = colSum;
        }
        return colSums;
    }

    private int[] getSeperators(int count, int[] sums, int size) {
        int[] listMids = new int[count];
        int[] listSeperators = new int[count - 1];

        int delta = size / count;
        int range = 50; //(int)(delta/20);

        int[] rowRangeSums = new int[sums.length - range];
        for (int i = 10; i < rowRangeSums.length - 10; i++) {
            rowRangeSums[i] = 0;
            for (int j = 0; j < range; j++) {
                rowRangeSums[i] += sums[i + j];
            }
        }

        for (int i = 0; i < count; i++) {
            int start = i * delta;
            int end = i * delta + delta - range;
            int max = 0;
            int indexMaxFirst = start;
            int indexMaxLast = start;
            for (int j = start; j < end; j++) {
                if (rowRangeSums[j] > max) {
                    indexMaxFirst = j;
                    max = rowRangeSums[j];
                }
                if (rowRangeSums[j] >= max) {
                    indexMaxLast = j;
                }
            }

            listMids[i] = indexMaxFirst + (int) ((indexMaxLast - indexMaxFirst) / 2) + (int) (range / 2);

        }
        for (int i = 0; i < listMids.length - 1; i++) {
            int curRange = listMids[i + 1] - listMids[i];
            int start = listMids[i] + curRange / 5;
            int end = listMids[i + 1] - curRange / 5;
            int min = Integer.MAX_VALUE;
            int indexMinFirst = start;
            int indexMinLast = start;
            for (int j = start; j < end; j++) {
                if (rowRangeSums[j] < min) {
                    indexMinFirst = j;
                    min = rowRangeSums[j];
                }
                if (rowRangeSums[j] >= min) {
                    indexMinLast = j;
                }
            }
            listSeperators[i] = indexMinFirst + (int) ((indexMinLast - indexMinFirst) / 2);
        }
        return listSeperators;
    }

    public int[] getRowMids(int rowCount, BufferedImage bim) {
        int[] rowSums = getRowSums(bim);
        return getSeperators(rowCount, rowSums, bim.getHeight());
    }

    public int[] getColMids(int colCount, BufferedImage bim) {
        int[] colSums = getColSums(bim);
        return getSeperators(colCount, colSums, bim.getWidth());
    }

    public String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

    public Point2D getMiddle(List<Blob> input) {
        int xSum = 0;
        int ySum = 0;
        Iterator<Blob> it = input.iterator();
        int devider = 0;
        while (it.hasNext()) {
            Blob b = it.next();
            xSum += b.getCenterOfGravity().getX() * b.getEnclosedArea();
            ySum += b.getCenterOfGravity().getY() * b.getEnclosedArea();
            devider += b.getEnclosedArea();
        }
        return new Point2D.Double(xSum / devider, ySum / devider);
    }
}
