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

package com.actelion.research.orbit.imageAnalysis.imaging;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

public class GBlur {

    public static PlanarImage adjustBlur(PlanarImage srcImg, final int b) {
        final int width = srcImg.getWidth();
        final int height = srcImg.getHeight();
        final int[] src = srcImg.getData().getPixels(0, 0, width, height, new int[width * height * 3]);
        final int[] dest = new int[width * height * 3];

        for (int l = 0; l < b; l++) {
            if (l == 0) {
                int dum;
                for (int i = 0; i < src.length - 3; i += 3) {
                    dum = src[i + 0];
                    src[i + 0] = src[i + 2];
                    src[i + 2] = dum;
                }
            } else {
                for (int i = 0; i < src.length - 3; i += 3) {
                    src[i + 0] = dest[i + 0];
                    src[i + 1] = dest[i + 1];
                    src[i + 2] = dest[i + 2];
                }
            }
            for (int i = width * 3 + 3; i < src.length - 3 - width * 3; i += 3) {
                dest[i + 0] = (src[i + 0] + src[i + 0 + 3] + src[i + 0 - 3] + src[i + 0 - width * 3] + src[i + 0 + 3 - width * 3] + src[i + 0 - 3 - width * 3] + src[i + 0 + width * 3] + src[i + 0 + 3 + width * 3] + src[i + 0 - 3 + width * 3]) / 9;
                dest[i + 1] = (src[i + 1] + src[i + 1 + 3] + src[i + 1 - 3] + src[i + 1 - width * 3] + src[i + 1 + 3 - width * 3] + src[i + 1 - 3 - width * 3] + src[i + 1 + width * 3] + src[i + 1 + 3 + width * 3] + src[i + 1 - 3 + width * 3]) / 9;
                dest[i + 2] = (src[i + 2] + src[i + 2 + 3] + src[i + 2 - 3] + src[i + 2 - width * 3] + src[i + 2 + 3 - width * 3] + src[i + 2 - 3 - width * 3] + src[i + 2 + width * 3] + src[i + 2 + 3 + width * 3] + src[i + 2 - 3 + width * 3]) / 9;
            }
        }

        DataBufferByte db = new DataBufferByte(dest.length);
        for (int i = 0; i < dest.length; i++) {
            db.setElem(i, dest[i]);
        }
        WritableRaster raster = WritableRaster.createWritableRaster(srcImg.getSampleModel(), db, new Point(0, 0));
        BufferedImage bi = new BufferedImage(srcImg.getColorModel(), raster, srcImg.getColorModel().isAlphaPremultiplied(), null);
        return PlanarImage.wrapRenderedImage(bi);
    }

    // GPU version using Aparapi - does not work properly...
    /*
    public static PlanarImage adjustBlurGPU(PlanarImage srcImg, final int b) {
		final int width = srcImg.getWidth();
		final int height = srcImg.getHeight();
		final int[] src = srcImg.getData().getPixels(0, 0, width, height, new int[width*height*3]);
		final int[] dest = new int[width*height*3];
		final int len = src.length;
		
		Kernel kernel = new Kernel() {
			@Override
			public void run() {
				int i = getGlobalId()*3;
				if (getPassId()==0) { // bgr -> rgb
					int dum = src[i+0];
					src[i+0] = src[i+2];
					src[i+2] = dum;
				} else
				if (getPassId()%2==1) { // blur
					if ((i>=width*3+3) && (i<len-3-width*3)) 
					{
						dest[i+0] = (int)((src[i+0]+src[i+0+3]+src[i+0-3] + src[i+0-width*3]+src[i+0+3-width*3]+src[i+0-3-width*3]  + src[i+0+width*3]+src[i+0+3+width*3]+src[i+0-3+width*3])/9);
						dest[i+1] = (int)((src[i+1]+src[i+1+3]+src[i+1-3] + src[i+1-width*3]+src[i+1+3-width*3]+src[i+1-3-width*3]  + src[i+1+width*3]+src[i+1+3+width*3]+src[i+1-3+width*3])/9);
						dest[i+2] = (int)((src[i+2]+src[i+2+3]+src[i+2-3] + src[i+2-width*3]+src[i+2+3-width*3]+src[i+2-3-width*3]  + src[i+2+width*3]+src[i+2+3+width*3]+src[i+2-3+width*3])/9);
					}
				} else { // flip buffers
					src[i+0] = dest[i+0];
					src[i+1] = dest[i+1];
					src[i+2] = dest[i+2];
				}
			}
			
		};
		

		kernel.setExecutionMode(Kernel.EXECUTION_MODE.GPU); // gpu:424, cpu:1049, jtp:7469
	//	long startTime = System.currentTimeMillis();
		kernel.setExplicit(true);
		kernel.put(src);
		kernel.put(dest);
		kernel.execute(src.length/3,b*2+1);
		kernel.get(dest);
//		long used = System.currentTimeMillis()-startTime;
//		System.out.println("blur "+b+": "+used+" ms");

		
		// convert int[] to byteBuffer (unperformant..)
		DataBufferByte db = new DataBufferByte(src.length);
		for (int i=0; i<dest.length; i++) {
			db.setElem(i,(int)dest[i]);
		}
		WritableRaster raster = WritableRaster.createWritableRaster(srcImg.getSampleModel(), db, new Point(0,0));
		BufferedImage bi = new BufferedImage(srcImg.getColorModel(),raster,srcImg.getColorModel().isAlphaPremultiplied(),null);
		return PlanarImage.wrapRenderedImage(bi);
	}
	
	
	public static PlanarImage adjustBlurInline(PlanarImage srcImg, final int b) {
		final int width = srcImg.getWidth();
		final int height = srcImg.getHeight();
		final int[] src = srcImg.getData().getPixels(0, 0, width, height, new int[width*height*3]);
		final int len = src.length;
		
		Kernel kernel = new Kernel() {
			@Override
			public void run() {
				int i = getGlobalId()*3;
				if (getPassId()==0) { // bgr -> rgb
					int dum = src[i+0];
					src[i+0] = src[i+2];
					src[i+2] = dum;
				} else
				if ((i>=width*3+3) && (i<len-3-width*3)) 
				{
					// inline version is not really 'thread-safe' and will not produce always the same result, but works...
					src[i+0] = (int)((src[i+0]+src[i+0+3]+src[i+0-3] + src[i+0-width*3]+src[i+0+3-width*3]+src[i+0-3-width*3]  + src[i+0+width*3]+src[i+0+3+width*3]+src[i+0-3+width*3])/9);
					src[i+1] = (int)((src[i+1]+src[i+1+3]+src[i+1-3] + src[i+1-width*3]+src[i+1+3-width*3]+src[i+1-3-width*3]  + src[i+1+width*3]+src[i+1+3+width*3]+src[i+1-3+width*3])/9);
					src[i+2] = (int)((src[i+2]+src[i+2+3]+src[i+2-3] + src[i+2-width*3]+src[i+2+3-width*3]+src[i+2-3-width*3]  + src[i+2+width*3]+src[i+2+3+width*3]+src[i+2-3+width*3])/9);
				}
			}
		};
		
		
		kernel.setExecutionMode(Kernel.EXECUTION_MODE.GPU); // gpu:424, cpu:1049, jtp:7469
	//	long startTime = System.currentTimeMillis();
		kernel.setExplicit(true);
		kernel.put(src);
		kernel.execute(src.length/3,b*2+1);
		kernel.get(src);
	//	long used = System.currentTimeMillis()-startTime;
	//	System.out.println("blur "+b+": "+used+" ms");

		
		// convert int[] to byteBuffer (unperformant..)
		DataBufferByte db = new DataBufferByte(src.length);
		for (int i=0; i<src.length; i++) {
			db.setElem(i,(int)src[i]);
		}
		WritableRaster raster = WritableRaster.createWritableRaster(srcImg.getSampleModel(), db, new Point(0,0));
		BufferedImage bi = new BufferedImage(srcImg.getColorModel(),raster,srcImg.getColorModel().isAlphaPremultiplied(),null);
		return PlanarImage.wrapRenderedImage(bi);
	}
	*/


}
