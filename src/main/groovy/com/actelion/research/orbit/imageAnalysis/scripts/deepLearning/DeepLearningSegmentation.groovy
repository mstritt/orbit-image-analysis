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

/**
 * Uses a Tensorflow deep learning model to segment objects and optionally stores them as spot annotations in
 * the database.
 * A segmentation model is needed which simply detects white objects on black background.
 * 
 * Use Tools -> Rare Object Detection, then click in 'load' to load the stored object annotations.
 * Can be used to e.g. perform a classification inside objects, area measurement of objects or manual classification of objects
 * (see help in rare object detection module).
 */

import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegment2
import com.actelion.research.orbit.imageAnalysis.deeplearning.DLSegmentUtils
import com.actelion.research.orbit.imageAnalysis.imaging.TileSizeWrapper
import com.actelion.research.orbit.imageAnalysis.models.*
import com.actelion.research.orbit.imageAnalysis.utils.OrbitImagePlanar
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImageIOrbitImage
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils
import com.actelion.research.orbit.imageAnalysis.utils.PolygonMetrics
import org.tensorflow.Session
import org.tensorflow.TensorFlow

import java.awt.*
import java.awt.geom.Point2D
import java.awt.image.Raster
import java.util.List


images = [5483211, 5483217]
storeAnnotations = true

DLSegment2 segment = new DLSegment2()
// load the segmentation model, either via file, or url (useful if you want to run it on a server / cluster)
Session s = segment.buildSession("models/20180202_glomeruli_detection_noquant.pb")
//Session s = segment.buildSession(new URL("http://myserver/20180202_glomeruli_detection_noquant.pb"))

// segmentation model, white objects an black background. You can use the dlsegmentsplit.omo in the resources/testmodels folder.
//OrbitModel segModel = OrbitModel.LoadFromOrbit(2318975)
OrbitModel model = OrbitModel.LoadFromInputStream(this.getClass().getResourceAsStream("/resource/testmodels/dlsegmentsplit.omo"))
println "using Tensorflow "+TensorFlow.version()
images.each {
    long startt = System.currentTimeMillis()
    long total = 0
    int rdfId = it
    println "rdfid: " + rdfId
    RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(rdfId)
    List<Shape> shapesToStore = new ArrayList<>()
    List<RawAnnotation> annotations = DALConfig.imageProvider.LoadRawAnnotationsByRawDataFile(rdfId, RawAnnotation.ANNOTATION_TYPE_IMAGE)
    List<ImageAnnotation> rois = new ArrayList<>()
    List<Shape> exclusions = new ArrayList<>()
    List<Shape> inclusions = new ArrayList<>()
    annotations.each {
        ImageAnnotation ia = new ImageAnnotation(it)
        if (ia.subType == ImageAnnotation.SUBTYPE_ROI) rois.add(ia)
        else if (ia.subType == ImageAnnotation.SUBTYPE_EXCLUSION) exclusions.add(ia.getFirstShape())
    }
    RecognitionFrame rf = new RecognitionFrame(rdf)
    println "ROIs: ${rois.size()}"
    TileSizeWrapper tileSizeWrapper = new TileSizeWrapper(new OrbitImagePlanar(rf.bimg.image, ""), 1024, 1024)
    OrbitTiledImageIOrbitImage orbitImage = new OrbitTiledImageIOrbitImage(tileSizeWrapper)
    rois.each {
        ImageAnnotation ia = it
        IScaleableShape shape = it.getFirstShape()
        shape = shape.getScaledInstance(100d, new Point(0, 0))
        ShapeAnnotationList shapeList = new ShapeAnnotationList(inclusions,exclusions,shape,shape.bounds)
        Point[] tiles = orbitImage.getTileIndices(shape.bounds)
        println tiles.length+" tiles"
        tiles
            // .findAll {it.x==35d && it.y==4d}    // for testing: just on one tile
            .each {
            if (OrbitUtils.isTileInROI((int) it.x, (int) it.y, orbitImage, shapeList, null)) {
                // source image
                SegmentationResult segRes =  DLSegmentUtils.segmentTile((int) it.x, (int) it.y, orbitImage, segment,s, segModel, false)
                int minX = orbitImage.tileXToX((int)it.x)
                int minY = orbitImage.tileYToY((int)it.y)
                println segRes.objectCount+"  "+it.x+" x "+it.y

                if (storeAnnotations) {
                    segRes.shapeList.each {
                        Shape segShape = it
                        PolygonExt scaleShape = (PolygonExt) segShape
                        PolygonMetrics polyMetrics = new PolygonMetrics(scaleShape)
                        scaleShape = scaleShape.scale(200d, polyMetrics.getCenter())
                        scaleShape.translate(minX, minY)
                        Point2D center = polyMetrics.getCenter();
                        scaleShape.translate((int) center.getX(), (int) center.getY())

                        PolygonMetrics pm2 = new PolygonMetrics(scaleShape)
                        center = pm2.getCenter()

                        // re-segment
                        int startx = center.x-512
                        int starty = center.y-512
                        if (startx<0) startx = 0
                        if (starty<0) starty = 0
                        if (startx+1024>=orbitImage.getWidth()) startx = orbitImage.getWidth()-1025
                        if (starty+1024>=orbitImage.getHeight()) starty = orbitImage.getHeight()-1025
                        Rectangle rect = new Rectangle(startx,starty,1024,1024)
                        Raster rasterCenter = orbitImage.getData(rect)
                        SegmentationResult segCenter = DLSegmentUtils.segmentRaster(rasterCenter, orbitImage, segment,s, segModel, false)
                        if (segCenter.objectCount>0) {
                            // find center shape
                            Point centerP = new Point(256,256)
                            Shape centerShape = segCenter.shapeList.get(0)
                            double dist = 1024
                            for (Shape shape2: segCenter.shapeList) {
                                PolygonMetrics pm = new PolygonMetrics(shape2)
                                double d = pm.getCenter().distance(centerP)
                                if (d<dist) {
                                    centerShape = shape2
                                    dist = d
                                }
                            }
                            PolygonExt scaleShape2 = (PolygonExt) centerShape
                            PolygonMetrics polyMetrics2 = new PolygonMetrics(scaleShape2)
                            scaleShape2 = scaleShape2.scale(200d, polyMetrics2.getCenter())
                            scaleShape2.translate(startx, starty)
                            Point2D center2 = polyMetrics2.getCenter();
                            scaleShape2.translate((int) center2.getX(), (int) center2.getY())

                            shapesToStore.add(scaleShape2);
                        }
                    }
                }

            }
        }
    }

    println "shapes before filtering: "+shapesToStore.size()
    shapesToStore = DLSegmentUtils.filterShapes(shapesToStore)
    println "shapes after filtering: "+shapesToStore.size()
    DLSegmentUtils.storeShapes(shapesToStore,"Objects",rdfId,"orbit")

    long usedt = System.currentTimeMillis()-startt
    println "used time(h) for image: "+(usedt/60000)/60
}


s.close()
DALConfig.imageProvider.close()
