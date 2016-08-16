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

package com.actelion.research.orbit.imageAnalysis.cp;

import com.actelion.research.orbit.imageAnalysis.modules.CellProfilerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class CpExecutor {

    private static final Logger log = LoggerFactory.getLogger(CpExecutor.class);
    private static boolean win_ = System.getProperty("os.name").toLowerCase().startsWith("windows");
    private static boolean linux_ = System.getProperty("os.name").toLowerCase().startsWith("linux");
    private String cpExe = null;
    private final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    public void startAllDirs(final File dir, final String pipeline) throws InterruptedException, ExecutionException, IOException {
        log.info("starting cp main executor for dir: " + dir);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " is not a directory");
        }
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<Callable<Boolean>> taskList = new ArrayList<>();
        for (final File subdir : dir.listFiles()) {
            if (subdir.isDirectory()) {
                taskList.add(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        log.info("starting cp executor for dir: " + subdir);
                        return startOneDir(subdir, pipeline);
                    }
                });
            }
        }
        List<Future<Boolean>> res = executor.invokeAll(taskList);
        for (Future<Boolean> execOk : res) {
            boolean ok = execOk.get();
            if (!ok) throw new ExecutionException(new Throwable("error in cp execution thread"));
        }
        executor.shutdownNow();
        log.info("cp executors finished");
        mergeFiles(dir);
    }

    private boolean startOneDir(final File dir, final String pipeline) throws IOException, InterruptedException {
        boolean exec = executeCP(dir.getAbsolutePath(), dir.getAbsolutePath(), pipeline);
        //System.out.println("cp exec ok: "+exec);
        log.info("single cp executor finished with result: " + exec);
        return exec;
    }

    private boolean executeCP(final String inDir, final String outDir, final String cpPipe) throws IOException, InterruptedException {
        // -c -r -i ~/my_image_directory -o ~/my_output_directory -p ~/my_pipe.mat
        //	return RawUtils.execute(new String[]{cpExe,"-c","-r","-i",inDir,"-o",outDir,"-p",cpPipe});

        if (cpExe == null || cpExe.length() == 0) {
            cpExe = CellProfilerModule.getCellProfilerCmd();
        }
        String cmd;
        if (win_) cmd = "\"" + cpExe + "\"";
        else
            cmd = cpExe;
        if (win_) cmd += " -c -r ";
        cmd += " -i " + inDir + " -o " + outDir + " -p " + cpPipe;
        System.out.println("cmd: " + cmd);
        //return RawUtils.execute(cmd);

        Process p = Runtime.getRuntime().exec(cmd);

        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while ((line = error.readLine()) != null) {
            System.out.println(line);
        }
        error.close();
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        p.getInputStream().close();
        p.getOutputStream().close();
        p.waitFor();
        return (p.exitValue() == 0); // closed correctly

    }


    private void mergeFiles(final File dir) throws IOException {
        log.info("start merging files for dir: " + dir);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " is not a directory");
        }
        String header = null;
        File[] subFiles = dir.listFiles();
        List<File> subdirList = new ArrayList<File>(Arrays.asList(subFiles));
        Collections.sort(subdirList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (final File subdir : subdirList) {
            if (subdir.isDirectory()) {
                for (File file : subdir.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().toLowerCase().endsWith(CpParser.ending);
                    }
                })) {
                    int batchNr = Integer.parseInt(subdir.getName());
                    //System.out.println("subsir: "+subdir.getName()+"  batchNr: "+batchNr);
                    if (batchNr == 0) {
                        File target = new File(dir.getAbsolutePath() + File.separator + file.getName());
                        if (target.exists() && !target.delete()) log.info("Cannot delete target file: " + target);
                    }
                    try (BufferedReader br = new BufferedReader(new FileReader(file));
                         BufferedWriter writer = new BufferedWriter(new FileWriter(dir.getAbsolutePath() + File.separator + file.getName(), true))) {
                        header = br.readLine(); // same for all files
                        if (batchNr == 0) {
                            writer.write(header + "\n");
                        }
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] split = line.split(CpParser.sep, 2);
                            int imgNum = Integer.parseInt(split[0]);
                            imgNum = batchNr * 1000000 + imgNum;
                            line = line.replaceFirst(split[0], imgNum + "");
                            writer.write(line + "\n");
                            //writer.newLine();
                        }
                        writer.flush();
                    }
                }
            }
        }
        log.info("end merging files");
    }

    public String getCpExe() {
        return cpExe;
    }

    public void setCpExe(String cpExe) {
        this.cpExe = cpExe;
    }


}
