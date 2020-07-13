package com.actelion.research.orbit.imageAnalysis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Tensor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.nio.FloatBuffer;

public class TensorflowUtils {

    protected static final Logger logger = LoggerFactory.getLogger(TensorflowUtils.class);

    public static Tensor<Float> imageToTensor(BufferedImage image) {
        logger.debug("Convert image  to tensor. Image: (" + image + ")");
        Tensor<Float> returnedTensor = null;
        int pixelFormat = image.getType();
        switch (pixelFormat) {
            case BufferedImage.TYPE_3BYTE_BGR:
            case BufferedImage.TYPE_INT_RGB: {
                final long channels = 3;
                final long batchSize = 1;
                long[] shape = new long[]{batchSize, image.getHeight(), image.getWidth(), channels};
                byte[] rawPixels = ((DataBufferByte) image.getData().getDataBuffer()).getData();
                FloatBuffer floatBuffer = FloatBuffer.allocate(rawPixels.length);
                for (int i_pixel = 0; i_pixel < rawPixels.length; i_pixel += channels) {
                    if (BufferedImage.TYPE_3BYTE_BGR == pixelFormat) {
                        floatBuffer.put((rawPixels[i_pixel + 2] & 0xFF) / 255.0f);
                        floatBuffer.put((rawPixels[i_pixel + 1] & 0xFF) / 255.0f);
                        floatBuffer.put((rawPixels[i_pixel] & 0xFF) / 255.0f);
                    } else {
                        floatBuffer.put((rawPixels[i_pixel] & 0xFF) / 255.0f);
                        floatBuffer.put((rawPixels[i_pixel + 1] & 0xFF) / 255.0f);
                        floatBuffer.put((rawPixels[i_pixel + 2] & 0xFF) / 255.0f);
                    }
                }
                floatBuffer.rewind();
                returnedTensor = Tensor.create(shape, floatBuffer);
            }
            default:
                logger.error("Pixel format not implemented for BufferedImage.getType() == " + pixelFormat);

        }
        return returnedTensor;
    }

    public static BufferedImage tensorToImage(Tensor<Float> tensor) {
        BufferedImage returnedImage = null;

        long[] shape = tensor.shape();

        if (4 == shape.length || 3 == shape.length) {
            if (4 == shape.length && shape[0] > 1) {
                logger.error("Expected Tensor with a single image, take first image instead");
            }

            int batch_size = 1;
            int height = (int) shape[shape.length - 3];
            int width = (int) shape[shape.length - 2];
            int channels = (int) shape[shape.length - 1];
            logger.debug("Convert tensor (" + tensor.toString() + ") to image");

            float[][][] outputFloatArray = tensor.copyTo(new float[batch_size][height][width][channels])[0];
            int[] rgbArray = new int[height * width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    float[] rgb = outputFloatArray[y][x];
                    rgbArray[y * height + x] = new Color(floatToInt(rgb[0]),
                            floatToInt(rgb[1]),
                            floatToInt(rgb[2])).getRGB();
                }
            }
            returnedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            returnedImage.getRaster().setDataElements(0, 0, width, height, rgbArray);
        }
        else {
            logger.error("Unhandled tensor shape: " + shape);
        }

        return returnedImage;
    }

    public static int floatToInt(float channelValue) {
        return (int) Math.max(0.0, Math.min(255.0, (channelValue * 255.0)));
    }
}
