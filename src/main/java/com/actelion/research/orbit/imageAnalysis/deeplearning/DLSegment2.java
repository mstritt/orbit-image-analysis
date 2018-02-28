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

package com.actelion.research.orbit.imageAnalysis.deeplearning;

import com.actelion.research.orbit.utils.RawUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DLSegment2 {

	//private static final String MODEL_NAME = "D:\\data\\glomeruli\\frozen_model.pb";
	private static final String MODEL_NAME = "D:\\data\\glomeruli\\20180202_glomeruli_detection_noquant.pb";

	//	private static final String INPUT_IMAGE = "D:\\data\\glomeruli\\4730025_tile27x18.jpg";
//  private static final String OUTPUT_IMAGE = "D:\\data\\glomeruli\\4730025_tile27x18_seg.jpg";
	private static final String INPUT_IMAGE = "D:\\data\\glomeruli\\input5c.jpg";
	private static final String OUTPUT_IMAGE = INPUT_IMAGE.replaceAll(".jpg","_seg.jpg");

	private static final int DESIRED_SIZE = 512;


	public static void main3(String[] args) throws IOException {
		DLSegment2 segment = new DLSegment2();
		Session s = segment.buildSession(MODEL_NAME);

		BufferedImage sourceImage = ImageIO.read(new File(INPUT_IMAGE));
		BufferedImage bi1 = new BufferedImage(1024,1024,BufferedImage.TYPE_INT_RGB);
		bi1.getGraphics().drawImage(sourceImage,0,0,null);
		bi1.getGraphics().drawImage(sourceImage,512,0,null);
		bi1.getGraphics().drawImage(sourceImage,0,512,null);
		bi1.getGraphics().drawImage(sourceImage,512,512,null);
		BufferedImage bi2 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
		bi2.getGraphics().drawImage(bi1,0,0,512,512,null);
		sourceImage = bi2;

		Tensor<Float> inputTensor = convertBufferedImageToTensor(sourceImage);
		BufferedImage bufferedImage =  segment.segmentInput(inputTensor,s, Color.black, Color.green);
		s.close();

		BufferedImage bi3 = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
		bi3.getGraphics().drawImage(bufferedImage,0,0,1024,1024,null);

		ImageIO.write(bi3, "jpg", new File(OUTPUT_IMAGE));
	}


	public static void main(String[] args) throws IOException {
		DLSegment2 segment = new DLSegment2();
		Session s = segment.buildSession(MODEL_NAME);
		//byte[] image = readAllBytesOrExit(Paths.get(INPUT_IMAGE));
		BufferedImage inputImage = ImageIO.read(new File(INPUT_IMAGE));
		Tensor<Float> inputTensor = convertBufferedImageToTensor(inputImage);
		BufferedImage bufferedImage =  segment.segmentInput(inputTensor,s, Color.black, Color.green);
		s.close();
		ImageIO.write(bufferedImage, "jpg", new File(OUTPUT_IMAGE));
	}



	private static BufferedImage decodeLabels(long[] mask, Color bg, Color fg) {
//		int[][] label_colours = {
//				new int[] { 0, 0, 0 },
//				new int[] { 255, 255, 255 } //Glomeruli
//				};
		int[][] label_mask = convert1DVectorTo2D(mask, DESIRED_SIZE, DESIRED_SIZE);
		BufferedImage image = new BufferedImage(DESIRED_SIZE, DESIRED_SIZE, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < image.getWidth(); y++) {
			for (int x = 0; x < image.getHeight(); x++) {
//				Color color = new Color(label_colours[label_mask[y][x]][0],
//						label_colours[label_mask[y][x]][1],
//						label_colours[label_mask[y][x]][2]);
				Color color = label_mask[y][x]==0? bg : fg;
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

	public static Tensor<Float> convertBufferedImageToTensor(BufferedImage image) {
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

	public Session buildSession(String fileName) {
		byte[] graphDef = readAllBytesOrExit(Paths.get(fileName));
		return buildSessionBytes(graphDef);
	}

	public Session buildSession(URL modelUrl) {
		byte[] graphDef = RawUtils.getContentBytes(modelUrl);
		return buildSessionBytes(graphDef);
	}

	public Session buildSessionBytes(byte[] graphDef) {
		Graph g = new Graph();
		g.importGraphDef(graphDef);
		Session s = new Session(g);
		return s;
	}


	public BufferedImage segmentInput(final Tensor<Float> inputTensor, Session s, Color bg, Color fg) {
		Tensor<Long> outputTensor = s
				.runner()
				.feed("image_batch", inputTensor)
				.fetch("predictions")
				.run().get(0).expect(Long.class);

		long[] mask = outputTensor.copyTo(new long[outputTensor.numElements()]);
		BufferedImage bufferedImage = decodeLabels(mask,bg,fg);
		return bufferedImage;
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
