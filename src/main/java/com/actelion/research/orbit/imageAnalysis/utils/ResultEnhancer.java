/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2016 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.mapReduceGeneric.executors.MapReduceExecutorLocalMultiCore;
import com.actelion.research.mapReduceGeneric.utils.KeyValue;
import com.actelion.research.orbit.beans.HCSMetaData;
import com.actelion.research.orbit.beans.RawData;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.beans.RawMeta;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.ImageTile;
import com.actelion.research.orbit.imageAnalysis.tasks.ROIArea.ROIAreaMapReduce;
import com.actelion.research.orbit.lims.LIMSBioSample;
import com.actelion.research.orbit.utils.RawDbTypes;
import com.actelion.research.orbit.utils.RawMetaFactoryFile;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ResultEnhancer {

    private static final Logger log = LoggerFactory.getLogger(ResultEnhancer.class);
    private final static String FILENAME = "Filename";
    private final static String SEP = "\t";

    public static final ThreadLocal<SimpleDateFormat> dateFormatHMS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        }
    };


    public static synchronized Map<Integer, List<KeyValue<String, Object>>> enhanceResults(final Map<Integer, List<KeyValue<String, Object>>> rdfResults) throws Exception {
        Map<Integer, List<KeyValue<String, Object>>> resutlMap = new HashMap<Integer, List<KeyValue<String, Object>>>();
        if (rdfResults != null && rdfResults.size() > 0) {
            for (Integer rdfId : rdfResults.keySet()) {
                RawDataFile rdf = DALConfig.getImageProvider().LoadRawDataFile(rdfId);
                RawData rd = DALConfig.getImageProvider().LoadRawData(rdf.getRawDataId());

                List<KeyValue<String, Object>> vals = new ArrayList<KeyValue<String, Object>>();
                vals.add(new KeyValue<String, Object>(FILENAME, rdf.getFileName()));
                vals.add(new KeyValue<String, Object>("OrbitId", rdf.getRawDataFileId()));
                if (rd != null)
                    vals.add(new KeyValue<String, Object>("ELB", rd.getBioLabJournal()));

                // add LIMS meta data (if available)
                if (rdf.getBioSampleId() > 0) {
                    LIMSBioSample bioSample = DALConfig.getImageProvider().getLIMSBiosample(rdf);
                    if (bioSample != null) {
                        vals.add(new KeyValue<String, Object>("Study-IVV", bioSample.getStudyIVV()));  // invivo name
                        vals.add(new KeyValue<String, Object>("Study-ID", bioSample.getStudyId()));
                        vals.add(new KeyValue<String, Object>("Study-Phase", bioSample.getStudyPhase()));
                        vals.add(new KeyValue<String, Object>("Study-Group", bioSample.getStudyGroup()));
                        vals.add(new KeyValue<String, Object>("Biosample", bioSample.getParentName()));
                        //vals.add(new KeyValue<String, Object>("Type", bioSample.getBiotype()));
                    }
                }

                // add well-based data (if available)
                try {
                    HCSMetaData hcsMetaData = DALConfig.getImageProvider().LoadHCSMetaData(rdfId);
                    if (hcsMetaData != null) {     // well-based meta data available
                        vals.add(new KeyValue<String, Object>("BatchNr", hcsMetaData.getBtachNr()));
                        vals.add(new KeyValue<String, Object>("PlateName", hcsMetaData.getPlateName()));
                        vals.add(new KeyValue<String, Object>("WellName", hcsMetaData.getWellName()));
                        vals.add(new KeyValue<String, Object>("SiteX", hcsMetaData.getSiteX()));
                        vals.add(new KeyValue<String, Object>("SiteY", hcsMetaData.getSiteY()));
                        vals.add(new KeyValue<String, Object>("SiteZ", hcsMetaData.getSiteZ()));
                        vals.add(new KeyValue<String, Object>("Channel", hcsMetaData.getChannel()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                vals.addAll(rdfResults.get(rdfId));
                resutlMap.put(rdfId, vals);
            }
        }

        //System.out.println("size rdfresults: "+rdfResults.get(rdfResults.keySet().toArray(new Integer[0])[0]).get(9).getValue());
        return resutlMap;
    }


    public static synchronized Map<Integer, List<KeyValue<String, Object>>> enhanceROIArea(final OrbitModel model, final Map<Integer, List<KeyValue<String, Object>>> rdfResults) throws Exception {
        if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().authenticateUserScaleout();
        try {
            List<RawDataFile> rdfList = new ArrayList<RawDataFile>(rdfResults.size());
            for (Integer rdfId : rdfResults.keySet()) {
                rdfList.add(DALConfig.getImageProvider().LoadRawDataFile(rdfId));
            }
            String modelNew = DALConfig.getScaleOut().getRemoteContextStore().generateUniqueFilename("orbit", OrbitUtils.MODEL_ENDING);
            ImageTile.modelCache.put(modelNew, model); // for local execution we just keep it in memory
            //DALConfig.getScaleOut().getRemoteContextStore().copyToRemote(model.getAsByteArray(), OrbitUtils.remoteNameSpace, modelNew);
            List<String> imageTiles = OrbitHelper.EncodeImageTiles(modelNew, -1, model.getMipLayer(), rdfList);
            ROIAreaMapReduce mr = new ROIAreaMapReduce();
            mr.setModel(new OrbitModel(model));
            Map<Integer, Double> areas = null;
            IMapReduceExecutor<String, Integer, Double> executor = new MapReduceExecutorLocalMultiCore<String, Integer, Double>();
            areas = executor.execute(imageTiles, mr);
            for (Integer rdfId : areas.keySet()) {
                OrbitUtils.ScaleAndUnit scaleAndUnit = OrbitUtils.getImageScaleAndUnit(DALConfig.getImageProvider().LoadRawDataFile(rdfId));
                double area = areas.get(rdfId);
                String unit = scaleAndUnit.getUnit();
                if (scaleAndUnit.getUnit().equals(OrbitUtils.muMeterUnicode)) {
                    unit = "mm" + (char) 178;
                    area /= 1000000d;
                }
                rdfResults.get(rdfId).add(new KeyValue<String, Object>("ROIArea[" + unit + "]", area));
                rdfResults.get(rdfId).add(new KeyValue<String, Object>("ROI-Group", model.getAnnotationGroup()));
            }
        } finally {
            try {
                if (ScaleoutMode.SCALEOUTMODE.get()) DALConfig.getImageProvider().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rdfResults;
    }


    private static void addMeta(List<KeyValue<String, Object>> vals, int rdfId, String metaName, String outName, Object defValue) throws Exception {
        List<RawMeta> rmList = DALConfig.getImageProvider().LoadRawMetasByRawDataFileAndName(rdfId, metaName);
        Object obj = defValue;
        if (rmList != null && rmList.size() > 0) {
            RawMeta rm = rmList.get(0);
            String val = rm.getValue();
            obj = val;
            try {
                if (rm.getRawTypeId() == RawDbTypes.RAW_TYPE_INTEGER)
                    obj = Integer.parseInt(val);
                else if (rm.getRawTypeId() == RawDbTypes.RAW_TYPE_DOUBLE)
                    obj = Double.parseDouble(val);
                else if (rm.getRawTypeId() == RawDbTypes.RAW_TYPE_DATE)
                    obj = RawMetaFactoryFile.dateFormat.parse(val);
            } catch (Exception e) {
                log.warn("ORBITERR00480: error parsing meta data", e);
            }
        }
        vals.add(new KeyValue<String, Object>(outName, obj));
    }



    public static <T> String toString(final Map<Integer, List<KeyValue<String, T>>> result) {
        if (result == null || result.size() == 0) {
            log.warn("ORBITERR00450: no result available (result:{})", result);
        }
        // TODO
        //String hcsResult = DALConfig.getImageProvider().getReplacementMetadata(result);
        //if (hcsResult != null) return hcsResult;


        // generate filename,<values> list
        List<KeyValue<String, List<KeyValue<String, T>>>> imgList = new ArrayList<KeyValue<String, List<KeyValue<String, T>>>>();
        Collection<List<KeyValue<String, T>>> valueList = result.values();
        for (List<KeyValue<String, T>> keyValues : valueList) {
            String filename = "";
            List<KeyValue<String, T>> vals = new ArrayList<KeyValue<String, T>>();
            for (KeyValue<String, T> kv : keyValues) {
                if (kv.getKey().equals(FILENAME)) {
                    filename = obj2str(kv.getValue());
                } else {
                    vals.add(kv);
                }
            }
            imgList.add(new KeyValue<String, List<KeyValue<String, T>>>(filename, vals));
        }

        Collections.sort(imgList, new Comparator<KeyValue<String, List<KeyValue<String, T>>>>() {
            @Override
            public int compare(KeyValue<String, List<KeyValue<String, T>>> o1, KeyValue<String, List<KeyValue<String, T>>> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        // generate output
        StringBuilder sb = new StringBuilder();

        // header
        List<KeyValue<String, T>> firstRow = imgList.get(0).getValue();
        List<String> names = new ArrayList<String>();
        names.add(FILENAME);
        for (KeyValue<String, T> kv : firstRow) {
            names.add(kv.getKey());
        }
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            sb.append(name);
            if (i < names.size() - 1) sb.append(SEP);
        }
        sb.append("\n");

        // add values
        for (KeyValue<String, List<KeyValue<String, T>>> img : imgList) {
            // generate map
            Map<String, T> map = new HashMap<String, T>(img.getValue().size());
            for (KeyValue<String, T> kv : img.getValue()) {
                map.put(kv.getKey(), kv.getValue());
            }

            sb.append(img.getKey() + SEP); // filename
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (!name.equals(FILENAME)) {
                    Object obj = map.get(name);
                    sb.append(obj2str(obj));
                    if (i < names.size() - 1) sb.append(SEP);
                    else sb.append("\n");
                }
            }

        }


        return sb.toString();
    }




    private static String obj2str(final Object obj) {
        String res = "null";
        if (obj != null) {
            if (obj instanceof String) {
                res = "\"" + obj.toString() + "\"";
            } else if (obj instanceof Integer) {
                res = obj.toString();
            } else if (obj instanceof Long) {
                res = obj.toString();
            } else if (obj instanceof Byte) {
                res = obj.toString();
            } else if (obj instanceof Short) {
                res = obj.toString();
            } else if (obj instanceof Number) {
                res = String.format("%1$.6f", (Number) obj);
            } else if (obj instanceof Date) {
                res = dateFormatHMS.get().format((Date) obj);
            } else res = obj.toString();
        }
        return res;
    }

    private static String shortenStr(String str) {
        String s = "";
        if (str != null) {
            s = str.replaceAll("\n", "").trim();
            if (s.length() > 40) s = s.substring(0, 39);
        }
        return s;
    }

    public static <T extends Object> Map<Integer, List<KeyValue<String, Object>>> convertToNamedMeasurement(final Map<Integer, T> measurements, String measurementName) {
        Map<Integer, List<KeyValue<String, Object>>> namedMap = new HashMap<Integer, List<KeyValue<String, Object>>>(measurements.size());
        for (Integer rdfId : measurements.keySet()) {
            List<KeyValue<String, Object>> valList = new ArrayList<KeyValue<String, Object>>(1);
            Object measurement = measurements.get(rdfId);
            if (measurements.get(rdfId) instanceof KeyValue)
                measurement = ((KeyValue) measurements.get(rdfId)).getValue();
            valList.add(new KeyValue<String, Object>(measurementName, measurement));
            namedMap.put(rdfId, valList);
        }
        return namedMap;
    }


    public static void main(String[] args) throws Exception {
        DALConfig.getImageProvider().authenticateUser("user1", "omero");
        List<RawDataFile> rdfList = DALConfig.getImageProvider().LoadRawDataFilesSearchFast("3096-", 1000, Arrays.asList(RawUtilsCommon.DATA_TYPE_IMAGE_JPG));

        Map<Integer, List<KeyValue<String, Object>>> rdfResults = new HashMap<Integer, List<KeyValue<String, Object>>>();

        Map<Integer, Object> counts = new HashMap<Integer, Object>();

        int number = 0;
        for (RawDataFile rdf : rdfList) {
            counts.put(rdf.getRawDataFileId(), number);
            number++;
        }

        rdfResults = convertToNamedMeasurement(counts, "count");

        rdfResults = enhanceResults(rdfResults);
        String res = toString(rdfResults);
        System.out.println("=== results ===");
        System.out.println(res);
        DALConfig.getImageProvider().close();

    }


}
