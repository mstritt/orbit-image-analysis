/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.cp;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.components.RecognitionFrame;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.*;
import com.actelion.research.orbit.imageAnalysis.tasks.ExclusionMapGen;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CpParser {

    private static final Logger log = LoggerFactory.getLogger(CpParser.class);
    public final static String imageName = "Image";
    public final static String ending = ".csv";
    public final static String sep = ",";
    public final static String Data_OUT_IDENTIFIER = "Data to export:";
    private final static int MAX_CNT_WRITEDB = 2000;

    private Map<Integer, CpImage> imageMap;
    public final Map<Integer, Map<String, Integer>> objectCountMap = new ConcurrentHashMap<>();
    public final Map<Integer, OrbitData> orbitDataMap = new ConcurrentHashMap<>();
    private final Random random = new Random();
    private String path;
    private OrbitModel model;
    private String pipeline;
    private String orbitUser = "";

    public CpParser(String orbitUser) {
        this.orbitUser = orbitUser;
    }

    private Map<Integer, CpImage> parseImages() throws Exception {
        Map<Integer, CpImage> imageMap = new ConcurrentHashMap<>();
        //File file = new File(path + File.separator + imageName + ending);
        File file = null;
        for (File f : new File(path).listFiles()) {
            if (f.getName().toLowerCase().endsWith("image.csv")) {
                file = f;
                break;
            }
        }
        if (file == null) {
            throw new Exception("no *Image.csv found. Please configure your CP pipeline so that CP produces an *Image.csv file.");
        }
        try (
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
        ) {
            imageMap.clear();
            String line;
            reader.readLine(); // header
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(sep);
                int id = Integer.parseInt(split[0]);
                CpImage img = new CpImage(id, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                imageMap.put(id, img);
                //System.out.println("img: "+img);
            }
        }
        return imageMap;
    }


    private void parseObject(String objName, boolean writeDB, List<String> objectNames) throws Exception {
        log.info("parseObj " + objName + " start");
        Map<String, Integer> objNameMap = new HashMap<>();
        for (int i = 0; i < objectNames.size(); i++) {
            objNameMap.put(objectNames.get(i), i);
        }
        //if (model.getExclusionModel() == null) throw new Exception("no exclusion model available");
        File file = new File(path + File.separator + objName + ending);
        try (
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
        ) {
            String line;
            reader.readLine(); // header
            int lastImageId = -1;
            int lastOrbitId = -1;
            CpImage img = null;
            OrbitData orbitData = null;
            int cnt = 0;
            while ((line = reader.readLine()) != null) {
                cnt++;
                String[] split = line.split(sep);
                int imgId = Integer.parseInt(split[0]);
                if (imgId != lastImageId) {
                    if (!imageMap.containsKey(imgId))
                        throw new IllegalArgumentException("Image with id " + imgId + " not found in image map");
                    img = imageMap.get(imgId);
                    lastImageId = imgId;
                    if (img.getOrbitId() != lastOrbitId) {
                        if (!orbitDataMap.containsKey(img.getOrbitId())) {
                            RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(img.getOrbitId());
                            RecognitionFrame rf = new RecognitionFrame(rdf);
                            Shape roi = OrbitUtils.loadAnnotationROI(img.getOrbitId(),/*model.getAnnotationGroup()*/0);
                            ExclusionMapGen exMapGen = ExclusionMapGen.constructExclusionMap(rdf, rf, model, (IScaleableShape) roi);
                            if (exMapGen != null)
                                exMapGen.generateMap();
                            OrbitData od = new OrbitData(img.getOrbitId(), exMapGen, rdf, roi, rf.bimg.getTileWidth(), rf.bimg.getTileHeight());
                            orbitDataMap.put(img.getOrbitId(), od);
                        }
                        orbitData = orbitDataMap.get(img.getOrbitId());
                        lastOrbitId = img.getOrbitId();
                        log.trace("cpImgId:" + imgId + ", orbitId:" + img.getOrbitId());
                    }
                }
                double centerX = Double.parseDouble(split[2]);
                double centerY = Double.parseDouble(split[3]);
                int x = (int) (img.getTileX() * orbitData.getTileWidth() + centerX);
                int y = (int) (img.getTileY() * orbitData.getTileHeight() + centerY);
                if (OrbitUtils.isInROI(x, y, orbitData.getRoi(), orbitData.getExMapGen())) {
                    if (!objectCountMap.containsKey(img.orbitId)) {
                        objectCountMap.put(img.getOrbitId(), new ConcurrentHashMap<String, Integer>());
                    }
                    Map<String, Integer> counts = objectCountMap.get(img.getOrbitId());
                    if (!counts.containsKey(objName)) {
                        counts.put(objName, 0);
                    }
                    int objCnt = counts.get(objName);
                    objCnt++;
                    counts.put(objName, objCnt);

                    // save as special annotation  (but not nuclei - too many...)
                    if (writeDB /*&& !objName.equals("Nuclei")*/ && cnt <= MAX_CNT_WRITEDB) {
                        Color col = Color.yellow;
                        int classNum = 0;

                        // different colors per class
//                        switch (objName) {
//							case "FilteredCD4": col=Color.red; classNum=0; break;
//							case "FilteredFoxp3": col=Color.green; classNum=1; break;
//							case "CD4_FOXP3": col=Color.yellow; classNum=2; break;
//						}
                        classNum = objNameMap.get(objName);
                        col = RecognitionFrame.getColorByNum(classNum);

                        final double w = 10d;
                        final double h = 10d;
                        double xj = x + ((random.nextDouble() - 0.5d) * 3d);
                        double yj = y + ((random.nextDouble() - 0.5d) * 3d);
                        ClassShape cs = new ClassShape(objName, col, ClassShape.SHAPETYPE_ARC);
                        cs.getShapeList().add(new Arc2DExt(xj - (w / 2d), yj - (h / 2d), 10, 10, 0, 360, Arc2DFixed.CHORD));
                        CellDetectionAnnotation anno = new CellDetectionAnnotation(objName, cs);
                        anno.setRawDataFileId(img.getOrbitId());
                        anno.setUserId(orbitUser);
                        anno.setClassNum(classNum);
                        DALConfig.getImageProvider().InsertRawAnnotation(anno);
                    }


                }


            }

        }
        log.info("parseObj " + objName + " end");
    }


    public Map<Integer, Map<String, Integer>> processObjects(String path, String pipeline, String exclModelFilename, boolean writeDB) throws Exception {
        final OrbitModel model = exclModelFilename == null ? null : OrbitModel.LoadFromFile(exclModelFilename);
        return processObjects(path, pipeline, model, writeDB);
    }

    public Map<Integer, Map<String, Integer>> processObjects(String path, String pipeline, final OrbitModel exclModel, boolean writeDB) throws Exception {
        this.path = path;
        this.model = exclModel;
        this.imageMap = parseImages();
        this.pipeline = pipeline;

        List<String> objectNames = parseOutputObjects(pipeline);
        for (String objectName : objectNames) {
            parseObject(objectName, writeDB, objectNames);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("OrbitId,ImageName");
        for (String objName : objectNames) sb.append("," + objName);
        sb.append("\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + File.separator + "objectcounts.csv"))) {
            writer.write(sb.toString());
            for (int orbitId : objectCountMap.keySet()) {
                RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(orbitId);
                String s = orbitId + sep + "\"" + rdf.getFileName() + "\"";
                for (String objName : objectNames) {
                    s += sep + objectCountMap.get(orbitId).get(objName);
                }
                s += "\n";
                sb.append(s);
                writer.write(s);
            }
            writer.flush();
        }

        System.out.println("\n" + sb.toString());

        return objectCountMap;
    }


    public List<String> parseOutputObjects(String pipeline) throws IOException {
        List<String> objectNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pipeline))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith(Data_OUT_IDENTIFIER)) {
                    String objectName = line.replaceAll(Data_OUT_IDENTIFIER, "").trim();
                    if (!objectName.equals(imageName)) {
                        log.debug("object name found in pipeline: " + objectName);
                        objectNames.add(objectName);
                    }
                }
            }
        }
        return objectNames;
    }


    class OrbitData {
        private int orbitId;
        private RawDataFile rdf;
        private ExclusionMapGen exMapGen;
        private Shape roi;
        private int tileWidth;
        private int tileHeight;

        public OrbitData(int orbitId, ExclusionMapGen exMapGen, RawDataFile rdf, Shape roi, int tileWidth, int tileHeight) {
            this.orbitId = orbitId;
            this.exMapGen = exMapGen;
            this.rdf = rdf;
            this.roi = roi;
            this.tileWidth = tileWidth;
            this.tileHeight = tileHeight;
        }

        public int getTileHeight() {
            return tileHeight;
        }

        public void setTileHeight(int tileHeight) {
            this.tileHeight = tileHeight;
        }

        public int getTileWidth() {
            return tileWidth;
        }

        public void setTileWidth(int tileWidth) {
            this.tileWidth = tileWidth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            OrbitData orbitData = (OrbitData) o;

            return orbitId == orbitData.orbitId;

        }

        @Override
        public int hashCode() {
            return orbitId;
        }

        @Override
        public String toString() {
            return "OrbitData{" +
                    "orbitId=" + orbitId +
                    ", rdf=" + rdf +
                    ", roi=" + roi +
                    '}';
        }

        public ExclusionMapGen getExMapGen() {
            return exMapGen;
        }

        public void setExMapGen(ExclusionMapGen exMapGen) {
            this.exMapGen = exMapGen;
        }

        public int getOrbitId() {
            return orbitId;
        }

        public void setOrbitId(int orbitId) {
            this.orbitId = orbitId;
        }

        public RawDataFile getRdf() {
            return rdf;
        }

        public void setRdf(RawDataFile rdf) {
            this.rdf = rdf;
        }

        public Shape getRoi() {
            return roi;
        }

        public void setRoi(Shape roi) {
            this.roi = roi;
        }

    }


    class CpImage implements Serializable {
        private int id;
        private int orbitId;
        private int tileX;
        private int tileY;

        public CpImage(int id, int orbitId, int tileX, int tileY) {
            this.id = id;
            this.orbitId = orbitId;
            this.tileX = tileX;
            this.tileY = tileY;
        }

        @Override
        public String toString() {
            return "CpImage{" +
                    "id=" + id +
                    ", orbitId=" + orbitId +
                    ", tileX=" + tileX +
                    ", tileY=" + tileY +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CpImage cpImage = (CpImage) o;

            if (id != cpImage.id) return false;
            if (orbitId != cpImage.orbitId) return false;
            if (tileX != cpImage.tileX) return false;
            return tileY == cpImage.tileY;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + orbitId;
            result = 31 * result + tileX;
            result = 31 * result + tileY;
            return result;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrbitId() {
            return orbitId;
        }

        public void setOrbitId(int orbitId) {
            this.orbitId = orbitId;
        }

        public int getTileX() {
            return tileX;
        }

        public void setTileX(int tileX) {
            this.tileX = tileX;
        }

        public int getTileY() {
            return tileY;
        }

        public void setTileY(int tileY) {
            this.tileY = tileY;
        }
    }

}
