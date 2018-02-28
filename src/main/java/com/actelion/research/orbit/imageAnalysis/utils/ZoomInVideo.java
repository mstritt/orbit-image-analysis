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

package com.actelion.research.orbit.imageAnalysis.utils;

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.ImageAnnotation;
import com.actelion.research.orbit.imageAnalysis.models.PolygonExt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * Creates images (frames) from overview to detail view of the center of an annotation.
 * Usage: create exactly one annotation on the image. The center of this annotation will be used for zoomin.
 * Can be used to create a movie out of the frames using e.g. ffmpeg.
 */
public class ZoomInVideo {
    public static void main(String[] args) throws Exception {
        RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(1821676);
        List<RawAnnotation> raList = DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.getRawDataFileId());
        RawAnnotation ra = raList.get(0);
        ImageAnnotation ia = new ImageAnnotation(ra);
        PolygonExt poly = ((PolygonExt) ia.getFirstShape()).getScaledInstance(100d,new Point(0,0));

        PolygonMetrics pm = new PolygonMetrics(poly);
        Point2D center = pm.getCenter();
        System.out.println("center: "+center);

        TiledImagePainter tip = new TiledImagePainter(true);
        tip.loadImage(rdf);

        int vpWidth = 1024;
        int vpHeight = 1024;

        double startScale = 0.65d;
        double endScale = 2000d;
        double delta = 0.001d;

        double scale = startScale;
        int cnt=0;
        //int cnt=439;
        while (scale<=endScale) {
        //for (int i=0; i<100; i++) {
            cnt++;
            //double factor = -OrbitUtils.log2(scale + 1d) - 1;
            //factor /= 1d / (OrbitUtils.log2(scale+1d + 1d) / 10d);
            scale += delta;
            delta *= 1.025;
            //scale = 2041.581302711063;
            System.out.println(cnt+": "+scale);

            BufferedImage bi = getViewportImage(tip, scale, center, vpWidth, vpHeight);
            ImageIO.write(bi,"png",new File("d:/pic/zoomin/"+String.format("%03d", cnt)+".png"));
        }

        TiledImagePainter.executorService.shutdownNow();
        System.out.println("done");
    }

    public static BufferedImage getViewportImage(TiledImagePainter tip, double scale, Point2D center, int vpWidth, int vpHeight) throws Exception {

        double vpX = -(vpWidth/2d);
        double vpY = -(vpHeight/2d);
        BufferedImage bi = new BufferedImage(vpWidth,vpHeight,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) bi.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        double sc = scale / 100d;
        double vpOffsX = center.getX()*sc +vpX;
        double vpOffsY = center.getY()*sc +vpY;
        g2d.translate(-vpOffsX,-vpOffsY);
        g2d.scale(sc, sc);

        tip.drawImage(g2d,vpOffsX,vpOffsY,vpWidth,vpHeight,scale,0);
        bi.flush();
        return bi;
    }
}
