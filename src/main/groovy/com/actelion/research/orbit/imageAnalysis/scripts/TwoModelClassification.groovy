/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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
package com.actelion.research.orbit.imageAnalysis.scripts
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.tasks.ClassificationTaskTiled
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender
import com.actelion.research.orbit.imageAnalysis.utils.TiledImageWriter
import groovyx.gpars.GParsPool

import java.awt.image.Raster
import java.util.concurrent.atomic.AtomicLong

/**
 * Two model classification. First classification with model1, then classification of model2 inside a specific class of model 1.
 * Here model2 has exactly three classes -> modify c0..c2 for a different number of classes.
 */

OrbitLogAppender.GUI_APPENDER = false;   // no GUI (error) popups
DALConfig.getImageProvider().authenticateUser("root", "omero"); // optional: otherwise the scaleout user defined in OrbitOmero.conf is used

def rdfID = 4955249; // image id
def model1 = OrbitModel.LoadFromOrbit(2212863); // e.g. brown staining model
def model2 = OrbitModel.LoadFromOrbit(2212867); // e.g. red staining model
def resultFile = "/home/result.csv";
def activeClass = 1;

final def results = new StringBuffer("filename\tratio\n");
def rdf = DALConfig.imageProvider.LoadRawDataFile(rdfID);
def rf1 = new RecognitionFrame(rdf);
def rf2 = new RecognitionFrame(rdf);

rf1.setClassShapes(model1.getClassShapes());
rf2.setClassShapes(model2.getClassShapes());
rf1.initializeClassColors();
rf2.initializeClassColors();
rf1.loadAnnotationROI(rdfID,model1.annotationGroup);
rf2.loadAnnotationROI(rdfID,model1.annotationGroup);
def tiles = rf1.bimg.image.getTileIndices(rf1.getROI().getBounds());
final AtomicLong c0 = new AtomicLong(0);
final AtomicLong c1 = new AtomicLong(0);
final AtomicLong c2 = new AtomicLong(0);
GParsPool.withPool {
    tiles.eachParallel {
        rf1.setClassImage(new TiledImageWriter(rf1.bimg.getWidth(), rf1.bimg.getHeight(), rf1.bimg.getTileWidth(), rf1.bimg.getTileHeight()));
        rf2.setClassImage(new TiledImageWriter(rf2.bimg.getWidth(), rf2.bimg.getHeight(), rf2.bimg.getTileWidth(), rf2.bimg.getTileHeight()));
        ClassificationTaskTiled ctt1 = new ClassificationTaskTiled(new OrbitModel(model1), rf1.ROI, rf1.bimg, rf1.classImage, [it].asList(), true);
        def r1 = ctt1.call();
        ClassificationTaskTiled ctt2 = new ClassificationTaskTiled(new OrbitModel(model2), rf2.ROI, rf2.bimg, rf2.classImage, [it].asList(), true);
        def r2 = ctt2.call();
        Raster raster1 = rf1.classImage.getImage().getTile((int) it.x, (int) it.y);
        Raster raster2 = rf2.classImage.getImage().getTile((int) it.x, (int) it.y);
        for (int x = raster1.minX; x < raster1.minX + raster1.width; x++)
            for (int y = raster1.minY; y < raster1.minY + raster1.height; y++) {
                Byte clazz = rf1.getClass(x, y, raster1);
                if (clazz != null) {
                    if (clazz == activeClass) {  // "active class"
                        Byte clazz2 = rf2.getClass(x, y, raster2);
                        if (clazz2!=null)
                            if (clazz2==0) c0.incrementAndGet();
                            else if (clazz2==1) c1.incrementAndGet();
                            else if (clazz2==2) c2.incrementAndGet();
                    }
                }
            }
    }
}

double ratio = c1.get()/(c0.get()+c1.get()+c2.get());
println(rdf.getFileName()+"\t"+ratio+"\n");
results.append(rdf.fileName + "\t" + ratio + "\n");

new File(resultFile).text = results.toString();
println(results.toString());



