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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.mapReduceGeneric.IMapReduce;
import com.actelion.research.mapReduceGeneric.IRemoteContextStore;
import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;
import com.actelion.research.orbit.imageAnalysis.tasks.SambaMRResultsView;
import com.actelion.research.orbit.imageAnalysis.utils.SmbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Scaleout Spark implementation.
 * Requires the dependency com.actelion.research:mapReduceExecSpark.
 * However, everything is programed using reflection so that no concrete Spark classes are imported. This allows the deployment
 * of this class even without the Spark dependencies. (But then it should be disabled in the config.properties.)
 */
public class ScaleoutSpark implements IScaleout {

    private static Logger logger = LoggerFactory.getLogger(ScaleoutSpark.class);
    private IRemoteContextStore remoteContextStore = null;

    private String sparkPropertiesFilename = "SparkConf.properties";
    private String sparkPropertiesKey = "Orbit.samba.share";
    private String sparkDefaultParallelism = "spark.default.parallelism";
    private String appName = "MapReduceExecutorSpark";
    private String master = "local[*]";    // overwritten by config.properties


    /**
     * parses property: Orbit.samba.share=domain/user:password@smb://server/share
     * 1st priority: use home / SparkConf.properties
     * 2nd priority: execution folder / SparkConf.properties
     * 3rd priority: resources/config_custom.properties
     * 4th priority: resources/config.properties
     * <p>
     * key: Orbit.samba.share
     */
    protected IRemoteContextStore createContextStore() {
        try {
            String user = "";
            String password = "";
            String domain = "";
            String share = "";
            String[] smbArr = new String[4];
            Properties sparkConfProps = getProperties();
            String smb = sparkConfProps.getProperty(sparkPropertiesKey);
            if (smb != null && smb.length() > 0)
                smbArr = parseSMBurl(smb);

            domain = smbArr[0];
            user = smbArr[1];
            password = smbArr[2];
            share = smbArr[3];
            if (password == null || password.length() == 0) password = null;
            if (domain == null || domain.length() == 0) domain = null;

            return new SmbUtils(user, password, domain, share);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties getProperties() throws IOException {
        Properties sparkConfProps = new Properties();
        File sparkConfPropsFile = new File(getSparkConfFilename());
        if (sparkConfPropsFile.exists()) {
            sparkConfProps.load(new FileReader(sparkConfPropsFile));
        } else {
            DALConfig.readConfigProperties(sparkConfProps);
        }
        return sparkConfProps;
    }

    /**
     * At least a share must be specified. Domain and user and password are optional.
     *
     * @param SMBurl, e.g. domain/user:password@smb://server/share
     * @return [domain, user, password, smb share]
     */
    public String[] parseSMBurl(String SMBurl) {
        try {
            String user = "";
            String password = "";
            String domain = "";
            String share = "";
            String[] split = SMBurl.split("@");
            if (split.length == 1) {   // no domain,user,password
                return new String[]{null, null, null, SMBurl.trim()};
            }

            share = split[1].trim();
            if (split[0].contains(":")) {
                split = split[0].split(":");
                password = split[1].trim();
            }
            if (split[0].contains("/")) {
                split = split[0].split("/");
                domain = split[0].trim();
                user = split[1].trim();
            } else {
                user = split[0].trim();
            }
            return new String[]{domain, user, password, share};
        } catch (Exception e) {
            throw new IllegalArgumentException("SMBurl is nto in the form 'domain/user:password@smb://server/share'");
        }
    }

    @Override
    public IMapReduceExecutor createMapReduceExecutor(IMapReduce mapReduce) {
        try {
            // String[] jars = new String[]{};
            String[] jars = buildJarList(DALConfig.getLibDir());

            Class[] paramString = new Class[]{String.class};
            Class[] paramStringArr = new Class[]{String[].class};

            IMapReduceExecutor executor = (IMapReduceExecutor) Class.forName("com.actelion.research.mapReduceExecSpark.executors.MapReduceExecutorSpark").newInstance();
            Object sparkConf = createSparkConf();
            if (sparkConf != null) {
                executor.getClass().getDeclaredMethod("setSparkConf", Class.forName("org.apache.spark.SparkConf")).invoke(executor, sparkConf);
                executor.getClass().getDeclaredMethod("setJars", paramStringArr).invoke(executor, new Object[]{jars});
                executor.getClass().getDeclaredMethod("setResultSaver", IRemoteContextStore.class, String.class).invoke(executor, getRemoteContextStore(), "spark");
            } else {
                String userDir = System.getProperty("user.dir");
                logger.info("no " + userDir + File.separator + "SparkConf.properties found. However, master and appName will be set.");
                logger.info("To define more specific SparkConf parameters, please create a SparkConf.properties file. The parameters are documented here: http://spark.apache.org/docs/latest/configuration.html");
                logger.info("Spark master: " + master);
                logger.info("Spark appName: " + appName);
                executor.getClass().getDeclaredMethod("setMaster", paramString).invoke(executor, new String(master));
                executor.getClass().getDeclaredMethod("setAppName", paramString).invoke(executor, new String(appName));
                executor.getClass().getDeclaredMethod("setJars", paramStringArr).invoke(executor, new Object[]{jars});
                executor.getClass().getDeclaredMethod("setResultSaver", IRemoteContextStore.class, String.class).invoke(executor, getRemoteContextStore(), "spark");
            }
            return executor;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("class com.actelion.research.mapReduceExecSpark.executors.MapReduceExecutorSpark not found");
        }
    }

    private Object createSparkConf() throws Exception {
        // trying to read SparkConf.properties in execution directory
        File sparkConfPropsFile = new File(getSparkConfFilename());
        if (sparkConfPropsFile.exists()) {
            logger.info("using Spark config properties from " + sparkConfPropsFile.getAbsolutePath() + " (JARs will be set in addition)");
            Object sparkConf = Class.forName("org.apache.spark.SparkConf").newInstance();
            Properties sparkConfProps = new Properties();
            sparkConfProps.load(new FileReader(sparkConfPropsFile));
            for (Object key : sparkConfProps.keySet()) {
                String keyStr = String.valueOf(key);
                if (keyStr != null) {
                    String val = sparkConfProps.getProperty(keyStr);
                    if (val != null) {
                        if (!keyStr.toLowerCase().startsWith("orbit")) {  // e.g. samba configuration starts with Orbit
                            logger.info("setting Spark config property: " + keyStr + ": " + val);
                            sparkConf.getClass().getDeclaredMethod("set", String.class, String.class).invoke(sparkConf, keyStr, val);
                        }
                    }
                }
            }
            return sparkConf;
        }
        return null;
    }

    private String getSparkConfFilename() {
        File sparkConfPropsFile = new File(sparkPropertiesFilename);
        if (sparkConfPropsFile.exists()) return sparkConfPropsFile.getAbsolutePath();

        sparkConfPropsFile = new File(System.getProperty("user.home") + File.separator + sparkPropertiesFilename);
        if (sparkConfPropsFile.exists()) return sparkConfPropsFile.getAbsolutePath();

        return sparkPropertiesFilename;
    }

    @Override
    public IRemoteContextStore getRemoteContextStore() {
        if (remoteContextStore == null) {
            remoteContextStore = createContextStore();
        }
        return remoteContextStore;
    }

    @Override
    public int getParallelism() {
        Properties props = null;
        try {
            props = getProperties();
            String p = props.getProperty(sparkDefaultParallelism);
            if (p != null && p.length() > 0) {
                int parallelism = Integer.parseInt(p.trim());
                logger.info("orbit scaleout parallelism: " + parallelism);
                return parallelism;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 100;
    }

    @Override
    public JInternalFrame createExistingResultView() throws Exception {
        /*
        JInternalFrame frame = new JInternalFrame("Existing Results");
        JLabel label = new JLabel("Not implemented for this Scaleout implementation.\nPlease use the Spark web frontend to view and manage running tasks.");
        label.setFont(label.getFont().deriveFont(32));
        frame.add(label);
        frame.pack();
        return frame;
        */
        return new SambaMRResultsView();
    }


    /**
     * lists all jars in /lib but excludes some (hopefully) not needed jars
     */
    public String[] buildJarList(String libDir) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String n = name.toLowerCase();
                if (n.startsWith("hadoop")) return false;
                if (n.startsWith("spark")) return false;
                if (n.startsWith("javax")) return false;
                if (n.startsWith("spring")) return false;
                if (n.startsWith("akka")) return false;
                if (n.startsWith("jersey")) return false;
                if (n.startsWith("asm-")) return false;
                if (n.startsWith("hibernate")) return false;
                if (n.startsWith("zookeeper")) return false;
                if (n.startsWith("substance")) return false;
                if (n.startsWith("trident")) return false;
                if (n.startsWith("scala")) return false;
                if (n.startsWith("jackson")) return false;
                if (n.startsWith("pdfbox")) return false;
                if (n.startsWith("tachyon")) return false;
                if (n.startsWith("velocity")) return false;
                if (n.startsWith("jhdf5")) return false;
                if (n.startsWith("xalan")) return false;
                if (n.startsWith("netty")) return false;
                return n.endsWith(".jar");
            }
        };

        List<String> strList = new ArrayList<>();
        File dir = new File(libDir);
        for (File f : dir.listFiles(filter)) {
            strList.add(f.getAbsolutePath());
        }

        File orbitFile1 = new File(libDir + "/../orbit-image-analysis.jar");
        if (orbitFile1.exists()) {
            strList.add(orbitFile1.getAbsolutePath());
        }

        File orbitFile2 = new File(libDir + "/../OrbitImageAnalysis.jar");
        if (orbitFile2.exists()) {
            strList.add(orbitFile2.getAbsolutePath());
        }

        return strList.toArray(new String[0]);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
        ScaleoutSpark so = new ScaleoutSpark();
        for (String s : so.buildJarList(DALConfig.getLibDir())) {
            System.out.println(s);
        }

    }
}
