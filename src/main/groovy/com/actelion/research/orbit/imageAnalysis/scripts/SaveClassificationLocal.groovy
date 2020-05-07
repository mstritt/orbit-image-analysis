// load a local image, apply a model (from local file) and save a low-res classification image to disk

// for load image
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.imageAnalysis.dal.ImageProviderLocal;

// for model
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel
import com.actelion.research.orbit.imageAnalysis.utils.OrbitHelper

import com.actelion.research.mapReduceGeneric.utils.KeyValue
import com.actelion.research.orbit.imageAnalysis.utils.ClassificationResult

// for saving
import com.actelion.research.orbit.imageAnalysis.utils.ClassImageRenderer
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter

import javax.media.jai.TiledImage
import java.awt.image.BufferedImage


RawDataFile rdf = ((ImageProviderLocal)DALConfig.imageProvider).registerFile(new File("C:/images/test.jpg"),0)
OrbitModel model = OrbitModel.LoadFromFile("c:/orbitModels/test.omo")

// classify the image
RecognitionFrame rf = new RecognitionFrame(rdf)
ClassificationResult res = OrbitHelper.Classify(rdf, rf, null, model, null, -1, null, true) // last boolean parameter indicates to stare the classification map

// saves a downscaled classification image to disk. Similar to "Tools->Save classification image" functionality.

int width = 2000;
def fn = "c:/temp/test-classification.jpg";

final TiledImage classImg = rf.getClassImage().getImage();
OrbitTiledImage2 mainImgTmp = rf.bimg.getImage();
for (TiledImagePainter tip: rf.bimg.getMipMaps()) {
    // find a good resolution size
    if (tip.getWidth()>width)
        mainImgTmp = tip.getImage();
}
final OrbitTiledImage2 mainImg = mainImgTmp;
ClassImageRenderer renderer = new ClassImageRenderer();
int height = (int) (classImg.getHeight() * (width / (double) classImg.getWidth()));
println("start saving classification image to disk");
BufferedImage bi = renderer.downsample(classImg, mainImg, width, height);
renderer.saveToDisk(bi, fn);
println("classification image saved");

// and (optional) output the results
String resStr = rdf.fileName;
List<KeyValue<String, Double>> norm = res.normalizeRatio();
(0..model.getClassShapes().size()-1).each {
    resStr += "\t" + norm.get(it).value;
}
println resStr;
DALConfig.getImageProvider().close();  // only close if not executed within Orbit
