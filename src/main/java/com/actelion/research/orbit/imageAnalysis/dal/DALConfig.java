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

package com.actelion.research.orbit.imageAnalysis.dal;

import com.actelion.research.orbit.dal.IImageProvider;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.DAODataFileSQLite;
import com.actelion.research.orbit.imageAnalysis.dal.localImage.DAORawAnnotationSQLite;
import com.actelion.research.orbit.imageAnalysis.utils.ICustomMenu;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitTiledImage2;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.ScaleoutMode;
import com.actelion.research.orbit.utils.ChannelToHue;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.prefs.Preferences;

public class DALConfig {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DALConfig.class);

    private static IImageProvider imageProvider;
    private static IScaleout scaleOut;

    private final static List<String> externalRepositoryComputers;
    private final static List<String> temporaryUsers;   // e.g. annotations of those can be modified by others
    private static IImageProvider remoteImageProvider = null; // just for remembering when switching to local filesystem provider
    private static IImageProvider localImageProvider = new ImageProviderLocal();
    private static ICustomMenu customMenu = null;
    private static boolean showLIMSMetas = false;
    private static boolean checkVersion = true;
    private static String explicitLibDir = null;
    private static String localDBFile;
    private static boolean localImageCache = true;

    static {
        try {
            Properties props = new Properties();
            // defaults
            props.put("ImageProvider", "com.actelion.research.orbit.imageprovider.ImageProviderOmero");
            props.put("ScaleOut", "com.actelion.research.orbit.imageAnalysis.dal.ScaleoutNoop");

            // read properties
            readConfigProperties(props);
            logger.info("Configured image provider: " + props.getProperty("ImageProvider"));
            logger.info("Different image providers can be configured in resources/config.properties or resources/config_custom.properties (priority).");

            try {
                // https://docs.oracle.com/javase/9/docs/api/java/lang/Class.html#newInstance--
                imageProvider = (IImageProvider) Class.forName(props.getProperty("ImageProvider")).getDeclaredConstructors()[0].newInstance();
            } catch (Exception e) {
                e.getCause();
                // Note that exceptions not chained with Constructors.newInstance(), so need to extract the cause.
                if (e.getCause() instanceof IllegalStateException) {
                    final String m = e.getCause().getMessage() + "\n\nOrbit will continue with the fallback local filesystem image provider.";
                    logger.warn(m);
                    if (!GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadlessInstance() && !ScaleoutMode.SCALEOUTMODE.get()) {
                        SwingUtilities.invokeLater(() -> {
                            Object[] options = new Object[]{"Continue", "More Information"};
                            if (JOptionPane.showOptionDialog(null, m, "Image provider not available, using local filesystem fallback", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.NO_OPTION) {
                                if (Desktop.isDesktopSupported()) {
                                    try {
                                        Desktop.getDesktop().browse(new URI(OrbitUtils.orbitImageProviderURL));
                                    } catch (Exception e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                    imageProvider = localImageProvider;
                }
            }

            logger.info("scaleout mode: "+ScaleoutMode.SCALEOUTMODE.get());
//            if (localImageCache && ScaleoutMode.SCALEOUTMODE.get()) {
//                File tempDir = new File(OrbitUtils.getCurrentDir()+File.separator+"tempimages");
//                //tempDir.deleteOnExit();
//                logger.info("local file cache temp dir: "+tempDir.getAbsolutePath());
//                ((ImageProviderOrbit) imageProvider).setLocalImageProvider(new ImageProviderLocalCached(tempDir.getAbsolutePath(), imageProvider));
//            }

            scaleOut = (IScaleout) Class.forName(props.getProperty("ScaleOut")).newInstance();
            //scaleOut = new ScaleoutSparkClusterTest2();
            String sparkMaster = props.getProperty("SparkMaster", "local[*]");

            String strTempUsers = props.getProperty("TemporaryUsers");
            temporaryUsers = parseString(strTempUsers);
            String strExtRepComp = props.getProperty("ExternalRepositoryComputers");
            externalRepositoryComputers = parseString(strExtRepComp);

            String strCustomMenu = props.getProperty("CustomMenu");
            if (strCustomMenu != null && strCustomMenu.length() > 0) {
                customMenu = (ICustomMenu) Class.forName(strCustomMenu).newInstance();
                logger.info("Custom Menu: " + customMenu);
            }

            String strLIMSMetas = props.getProperty("ShowLIMSMetas");
            if (strLIMSMetas != null && strLIMSMetas.length() > 0) {
                try {
                    showLIMSMetas = Boolean.parseBoolean(strLIMSMetas);
                } catch (Exception e) {
                    logger.error("cannot parse ShowLIMSMetas value. Should be 'true' or 'false' but is " + strLIMSMetas);
                }
                logger.info("Show LIMS Metadata: " + showLIMSMetas);
            }

            String strCheckVersion = props.getProperty("CheckVersion");
            if (strCheckVersion != null && strCheckVersion.length() > 0) {
                try {
                    checkVersion = Boolean.parseBoolean(strCheckVersion);
                } catch (Exception e) {
                    logger.error("cannot parse CheckVersion value. Should be 'true' or 'false' but is " + strCheckVersion);
                }
                logger.debug("CheckVersion: " + strCheckVersion);
            }

            String explicitLibDirStr = props.getProperty("explicitLibDir");
            if (explicitLibDirStr != null && explicitLibDirStr.length() > 0) {
                explicitLibDir = explicitLibDirStr;
            }

            logger.info("image provider: " + imageProvider);
            logger.info("scaleOut: " + scaleOut);
            if (scaleOut.toString().endsWith("ScaleoutSpark")) {
                Class[] paramString = new Class[]{String.class};
                scaleOut.getClass().getDeclaredMethod("setMaster", paramString).invoke(scaleOut, new String(sparkMaster));
                logger.info("SparkMaster: " + sparkMaster);
            }
            logger.debug("temporary users: " + temporaryUsers);
            logger.debug("external repository computers: " + externalRepositoryComputers);


            try {
                localDBFile = System.getProperty("user.home") + File.separator + "orbit.db";
                String userLocalDB = props.getProperty("localDBFile");
                if (userLocalDB != null && userLocalDB.length() > 0) {
                    localDBFile = userLocalDB;
                }
                logger.info("local db file: " + localDBFile);
                if (!ScaleoutMode.SCALEOUTMODE.get()) {
                    File dbFile = new File(localDBFile);
                    if (!dbFile.exists()) {
                        DAODataFileSQLite.createTable();
                        DAORawAnnotationSQLite.createTable();
                    }
                    // check for column raw_data_dile.series
                    if (!DAODataFileSQLite.ColumnSeriesExist()) {
                       DAODataFileSQLite.createColumnSeries();
                    }
                }
            } catch (Exception ex) {
                logger.error("Could not create the local database file: "+localDBFile, ex);
            }

            // channelNames -> hue values
            String channelHues = props.getProperty("channelHues");   // e.g. channelHues=dapi:203,tritc=50
            if (channelHues!=null) {
                String[] hues= channelHues.split(",");
                if (hues!=null && hues.length>0) {
                    for (String chanHue: hues) {
                        String[] nameHue = chanHue.split(":");
                        if (nameHue!=null && nameHue.length==2) {
                            try {
                                float f = Float.parseFloat(nameHue[1].trim());
                                ChannelToHue.userHueMap.put(nameHue[0].trim().toLowerCase(), f/360f);
                                logger.info("setting custom channel hue: "+nameHue[0]+": "+nameHue[1]);
                            } catch (Exception e) {
                                logger.warn("error parsing hue value "+nameHue[1]+" for channel name "+nameHue[0]);
                            }
                        }
                    }
                }
            }
            // read user channel2hues from preferences
            if (!ScaleoutMode.SCALEOUTMODE.get()) {
                Preferences channelPrefs = Preferences.userNodeForPackage(ChannelToHue.class);
                for (String key: channelPrefs.keys()) {
                    if (key.startsWith(OrbitUtils.CHANNEL_NAME2HUE)) {
                        String channelName = key.replaceFirst(OrbitUtils.CHANNEL_NAME2HUE,"").toLowerCase();
                        float hue = channelPrefs.getFloat(key,-1f);
                        if (hue>=0f) {
                            ChannelToHue.userHueMap.put(channelName, hue);
                            logger.info("setting custom channel hue (preferences): "+channelName+": "+hue);
                        }
                    }
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void readConfigProperties(Properties props) throws IOException {
        InputStream propsStream;
        propsStream = DALConfig.class.getResourceAsStream("/config_custom.properties");
        if (propsStream == null) {
            propsStream = DALConfig.class.getResourceAsStream("/config.properties");
            logger.info("using config file: resources/config.properties ");
        } else {
            logger.info("using config file: resources/config_custom.properties ");
        }

        props.load(propsStream);
        try {
            if (propsStream != null) propsStream.close();
        } catch (Exception e) {
            logger.warn("cannot close properties stream");
        }
    }

    public static String getLibDir() throws URISyntaxException, UnsupportedEncodingException {
        if (explicitLibDir != null) {
            logger.info("using explicit lib dir: " + explicitLibDir);
            return explicitLibDir;
        }
        CodeSource codeSource = OrbitUtils.class.getProtectionDomain().getCodeSource();
        File jarFile;
        if (codeSource.getLocation() != null) {
            jarFile = new File(codeSource.getLocation().toURI());
        } else {
            String path = OrbitUtils.class.getResource(OrbitUtils.class.getSimpleName() + ".class").getPath();
            String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
            jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
            jarFile = new File(jarFilePath);
        }
        String jarDir = jarFile.getParentFile().getAbsolutePath();
        logger.debug("libDir: " + jarDir);
        return jarDir;
    }



    public static IImageProvider getImageProvider() {
        return imageProvider;
    }

    public static void setImageProvider(IImageProvider imageProvider) {
        DALConfig.imageProvider = imageProvider;
    }


    public static IScaleout getScaleOut() {
        return scaleOut;
    }

    public static void setScaleOut(IScaleout scaleOut) {
        DALConfig.scaleOut = scaleOut;
    }

    public static List<String> getExternalRepositoryComputers() {
        return externalRepositoryComputers;
    }

    public static List<String> getTemporaryUsers() {
        return temporaryUsers;
    }

    public static boolean isShowLIMSMetas() {
        return showLIMSMetas;
    }

    public static void setShowLIMSMetas(boolean showLIMSMetas) {
        DALConfig.showLIMSMetas = showLIMSMetas;
    }

    public static boolean isCheckVersion() {
        return checkVersion;
    }

    public static void setCheckVersion(boolean checkVersion) {
        DALConfig.checkVersion = checkVersion;
    }

    public static String getLocalDBFile() {
        return localDBFile;
    }

    /**
     * can be null
     */
    public static ICustomMenu getCustomMenu() {
        return customMenu;
    }

    private static List<String> parseString(String s) {
        List<String> list = new ArrayList<>();
        if (s != null && s.length() > 0) {
            String[] arr = s.split(",");
            if (arr != null && arr.length > 0) {
                for (String s1 : arr) {
                    list.add(s1);
                }
            }
        }
        return list;
    }

    public static boolean isLocalImageProvider() {
        return getImageProvider() instanceof ImageProviderLocal;
    }

    public static boolean onlyLocalImageProviderAvailable() {
        return remoteImageProvider == localImageProvider;
    }

    public static void switchLocalRemoteImageProvider() {
        if (isLocalImageProvider()) {
            setImageProvider(remoteImageProvider);
        } else {
            remoteImageProvider = getImageProvider(); // remember
            setImageProvider(localImageProvider);
        }
        logger.info("image provider switched to " + getImageProvider() + " isLocal: " + isLocalImageProvider());
        if (OrbitTiledImage2.tileCache!=null) {
            OrbitTiledImage2.tileCache.invalidateAll();
        }
    }

}
