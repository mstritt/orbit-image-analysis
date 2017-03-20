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

package com.actelion.research.orbit.imageAnalysis.cp;

import ch.qos.logback.classic.Level;
import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.imageAnalysis.models.OrbitModel;
import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import com.actelion.research.orbit.imageAnalysis.tasks.OrbitWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Cell Profiler pipeline
 */
public class CpStarter extends OrbitWorker {

    private static final Logger log = LoggerFactory.getLogger(CpStarter.class);
    private List<RawDataFile> rdfList;
    private OrbitModel exclModel;
    private String pipeline;
    private String workDir;
    private String cpExe;
    private boolean storeAnnotations;
    private String orbitUser = "";


    public CpStarter(String orbitUser) {
        this.orbitUser = orbitUser;
    }

    public CpStarter(String cpExe, OrbitModel exclModel, String pipeline, List<RawDataFile> rdfList, String workDir, boolean storeAnnotations, String orbitUser) {
        this.cpExe = cpExe;
        this.exclModel = exclModel;
        this.pipeline = pipeline;
        this.rdfList = rdfList;
        this.workDir = workDir;
        this.storeAnnotations = storeAnnotations;
        this.orbitUser = orbitUser;
    }

    @Override
    protected void doWork() throws Exception {
        System.out.println("rdfList size: " + rdfList.size());
        System.out.println("exclusion model: " + exclModel);
        System.out.println("pipeline: " + pipeline);
        System.out.println("working directory: " + workDir);

        log.info("download tiles start");
        CpExportTiles exportTiles = new CpExportTiles();
        exportTiles.downloadTiles(rdfList, workDir, exclModel);
        log.info("download tiles end");
        setProgress(30);

        log.info("cp executor start");
        CpExecutor executor = new CpExecutor();
        if (cpExe != null) executor.setCpExe(cpExe);
        executor.startAllDirs(new File(workDir), pipeline);
        log.info("cp executor end");
        setProgress(70);

        log.info("cp parser start");
        CpParser cpParser = new CpParser(orbitUser);
        cpParser.processObjects(workDir, pipeline, exclModel, storeAnnotations);
        log.info("cp parser end");
        setProgress(98);

        StringBuilder sb = new StringBuilder();
        try (BufferedReader inStream = new BufferedReader(new FileReader(workDir + File.separator + "objectcounts.csv"))) {
            String line;
            while ((line = inStream.readLine()) != null) {
                sb.append(line + "\n");
            }
        }


        taskResult = new TaskResult("Cell Profiler Results", sb.toString());
        setProgress(100);
    }

    /**
     * cpExe can be null
     *
     * @param searchStr
     * @param pipeline
     * @param workDir
     * @param cpExe
     */
    public void start(String searchStr, String exclModel, String pipeline, String workDir, String cpExe) throws Exception {

        System.out.println("searchStr: " + searchStr);
        System.out.println("exclusion model: " + exclModel);
        System.out.println("pipeline: " + pipeline);
        System.out.println("working directory: " + workDir);

        log.info("download tiles start");
        CpExportTiles exportTiles = new CpExportTiles();
        exportTiles.downloadTiles(searchStr, workDir, exclModel);
        log.info("download tiles end");

        log.info("cp executor start");
        CpExecutor executor = new CpExecutor();
        if (cpExe != null) executor.setCpExe(cpExe);
        executor.startAllDirs(new File(workDir), pipeline);
        log.info("cp executor end");

        log.info("cp parser start");
        CpParser cpParser = new CpParser(orbitUser);
        cpParser.processObjects(workDir, pipeline, exclModel, true);
        log.info("cp parser end");
    }

    public static void main(String[] args) throws Exception {
        Logger root = LoggerFactory.getLogger(CpStarter.class);
        if (root instanceof ch.qos.logback.classic.Logger)   // can only set if logback implementation
            ((ch.qos.logback.classic.Logger) root).setLevel(Level.TRACE);

        System.out.println("CpStarter <searchStr> <exclusionModel> <pipeline> <workDir>");
        if (args == null || args.length < 4) throw new IllegalArgumentException("wrong number of arguments");
        String searchStr = args[0];
        String exclModel = args[1];
        String pipeline = args[2];
        String workDir = args[3];

        CpStarter starter = new CpStarter("root");
        starter.start(searchStr, exclModel, pipeline, workDir, null);

    }


}
