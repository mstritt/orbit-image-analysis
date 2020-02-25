/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.beans.RawAnnotation
import com.actelion.research.orbit.beans.RawDataFile
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig
import com.actelion.research.orbit.utils.RawUtils
import groovy.io.FileType

// This script reads all annotations from an image and outputs the points. Can be used to convert the annotations to s.th. else, e.g. Omero annotations.

// instead of loading a RDF by id you can use the current selected image from the UI
//final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance(); // get the current (running) Orbit instance
//final ImageFrame iFrame = OIA.getIFrame();  // get selected image
//RawDataFile rdf = iFrame.rdf;

// alternatively, you can load an image by id

def fileList = []
def imageTmp = new File("/media/fullejo1/DATA/Christen_Frankfurt/Insulin")
imageTmp.eachFileRecurse (FileType.FILES) { file ->
    fileList << file
}

println "Number of files: "+fileList.size()
//fileList.each {
//    println it.path
//}

if(DALConfig.isLocalImageProvider()) {

    for(int i=1; i<81; i++) {
        RawDataFile rdf = DALConfig.imageProvider.LoadRawDataFile(i)
        if (rdf==null) throw new Exception("Image not found!");

        List<RawAnnotation> annotations =  DALConfig.getImageProvider().LoadRawAnnotationsByRawDataFile(rdf.rawDataFileId,RawAnnotation.ANNOTATION_TYPE_IMAGE);
        println(annotations.toString())

        try {
            FileOutputStream fileOut = new FileOutputStream("/home/fullejo1/annotations/annotation"+rdf.getFileName()+".anno")
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)
            objectOut.writeObject(annotations)
            objectOut.close()
        } catch (Exception ignore ) {}
    }
} else {
    rdfRemote = DALConfig.getImageProvider().LoadRawDataFilesSearchFast("ELB0666-0002", 1000, [RawUtils.DATA_TYPE_IMAGE_NDPI]);

    // Test reading annotations back in...
//    processed = 0
//    for (RawDataFile rdf : rdfRemote) {
//        if (rdf.getFileName().equals("Insulin_#012 - 2019-11-08 17.57.44.ndpi")
//        || rdf.getFileName().equals("Insulin_#285 - 2019-11-08 16.21.13.ndpi")) {
//            continue
//        } else {
//            FileInputStream fis = new FileInputStream("/home/fullejo1/annotations/annotation"+rdf.getFileName()+".anno")
//            ObjectInputStream ois = new ObjectInputStream(fis)
//            List<RawAnnotation> anno = ois.readObject()
//            println(rdf.getFileName())
//            println(anno.toString())
//            //println("rawAnnotation: "+anno.get(0).rawAnnotationId)
//
//            for(RawAnnotation annotation : anno) {
//                println("fileId: "+rdf.rawDataFileId)
//                annotation.setRawDataFileId(rdf.rawDataFileId)
//                println("rawAnnotation: "+annotation.rawAnnotationId + "rawFileId: "+annotation.rawDataFileId)
//            }
//            processed+=1
//        }
//    }
//    println("Processed: "+processed)


    // Publish annotations
    // !!! WRITES TO DB !!!
    for (RawDataFile rdf : rdfRemote) {
        if (rdf.getFileName().equals("Insulin_#012 - 2019-11-08 17.57.44.ndpi")
                || rdf.getFileName().equals("Insulin_#285 - 2019-11-08 16.21.13.ndpi")) {
            continue
        } else {
            FileInputStream fis = new FileInputStream("/home/fullejo1/annotations/annotation"+rdf.getFileName()+".anno")
            ObjectInputStream ois = new ObjectInputStream(fis)
            List<RawAnnotation> anno = ois.readObject()
            println(rdf.getFileName())
            println(anno.toString())

            // Test on one file
//            anno.get(0).setRawDataFileId(rdf.rawDataFileId)
//            DALConfig.getImageProvider().InsertRawAnnotation(anno.get(0))
//            break
            for(RawAnnotation annotation : anno) {
                annotation.setRawDataFileId(rdf.rawDataFileId)
                DALConfig.getImageProvider().InsertRawAnnotation(annotation)
            }

        }
    }


//    String user = "username";
//    String pw = "password";
//
//    DALConfig.getImageProvider().authenticateUser(user,pw);
//
//    RawAnnotation rawAnnotation = new RawAnnotation();
//    rawAnnotation.setData(annotation.getData());
//    rawAnnotation.setDescription(annotation.getDescription());
//    rawAnnotation.setUserId(user);
//    rawAnnotation.setModifyDate(new Date());
//
//    // store in DB
//    DALConfig.getImageProvider().InsertRawAnnotation(rawAnnotation);
//    // insert further annotations...
//    DALConfig.getImageProvider().close();

}


