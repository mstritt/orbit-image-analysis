/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.deeplearning.playground;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class TFDetectTest {

    private static final String MODEL_DIR = "D:\\data\\glomeruli\\";
    private static final String MODEL_NAME = "20180202_glomeruli_detection.pb";
    private static final String INPUT_IMAGE = "D:\\data\\glomeruli\\4730025_tile27x18.jpg";
    private static final String OUTPUT_IMAGE = "D:\\data\\glomeruli\\out.jpg";

    private static final int DESIRED_SIZE = 512;

    public static void main(String[] args) throws IOException {

        Date startDate = new Date();

        byte[] graphDef = readAllBytesOrExit(Paths.get(MODEL_DIR, MODEL_NAME));

		/*
		 * Create Tensor with Tensorflow
		byte[] image = readAllBytesOrExit(Paths.get(INPUT_IMAGE));
		Tensor<Float> input = constructAndExecuteGraphToNormalizeImage(image);
		*/

        /* Create Tensor from BufferedImage */
        BufferedImage bufferdImage = ImageIO.read(new File(INPUT_IMAGE));
        Tensor<Float> input = convertBufferedImageToTensor(bufferdImage);

        if(input != null) {
            long[] mask = executeInceptionGraph(graphDef, input);
            BufferedImage bufferedImage = decodeLabels(mask);
            ImageIO.write(bufferedImage, "jpg", new File(OUTPUT_IMAGE));
        }

        long elapsedTimeInSec = (new Date().getTime() - startDate.getTime()) / 1000;
        System.out.println(String.format("Ended in %ds .", elapsedTimeInSec));
    }

    private static BufferedImage decodeLabels(long[] mask) {
        int[][] label_colours = {
                new int[] { 0, 0, 0 },
                new int[] { 255, 255, 255 } //Glomeruli
        };
        int[][] label_mask = convert1DVectorTo2D(mask, DESIRED_SIZE, DESIRED_SIZE);
        BufferedImage image = new BufferedImage(DESIRED_SIZE, DESIRED_SIZE, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getWidth(); y++) {
            for (int x = 0; x < image.getHeight(); x++) {
                Color color = new Color(label_colours[label_mask[y][x]][0],
                        label_colours[label_mask[y][x]][1],
                        label_colours[label_mask[y][x]][2]);
                image.setRGB(x, y, color.getRGB());
            }
        }
        return image;
    }

    public static int[][] convert1DVectorTo2D(long[] values, int rows, int cols) {
        int[][] array = new int[rows][cols];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                array[j][i] = (int) values[j * cols + i];
            }
        }
        return array;
    }

    private static Tensor<Float> convertBufferedImageToTensor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] data = new int[width * height];
        image.getRGB(0, 0, width, height, data, 0, width);
        float[][][][] rgbArray = new float[1][height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = new Color(data[i * width + j]);
                rgbArray[0][i][j][0] = color.getRed();
                rgbArray[0][i][j][1] = color.getGreen();
                rgbArray[0][i][j][2] = color.getBlue();
            }
        }
        return Tensor.create(rgbArray, Float.class);
    }

	/*
	private static Tensor<Float> constructAndExecuteGraphToNormalizeImage(byte[] image) {
		try (Graph g = new Graph()) {
			GraphBuilder b = new GraphBuilder(g);

			final float[] mean = new float[]{104.00698793f,116.66876762f,122.67891434f};
			final float scale = 1f;

			final Output<String> input = b.constant("input", image);
			final Output<Float> output = b.div(b.sub(b.resizeBilinear(
					b.expandDims(b.cast(b.decodeJpeg(input, 3), Float.class),
					b.constant("make_batch", 0)),
					b.constant("size", new int[] { DESIRED_SIZE, DESIRED_SIZE })), b.constant("mean", mean)),
					b.constant("scale", scale));
			try (Session s = new Session(g)) {
				return s.runner().fetch(output.op().name()).run().get(0).expect(Float.class);
			}
		}
	}*/

    private static long[] executeInceptionGraph(byte[] graphDef, Tensor<Float> input) {
        try (Graph g = new Graph()) {
            g.importGraphDef(graphDef);
            try (Session s = new Session(g);
                 Tensor<Long> result = s
                         .runner()
                         .feed("image_batch", input)
                         .fetch("predictions")
                         .run().get(0).expect(Long.class)) {
                return result.copyTo(new long[result.numElements()]);
            }
        }
    }

    private static byte[] readAllBytesOrExit(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }
}
