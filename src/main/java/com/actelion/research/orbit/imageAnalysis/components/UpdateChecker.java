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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateChecker {
    private static final Logger logger = LoggerFactory.getLogger(UpdateChecker.class);
    private Preferences prefs = Preferences.userNodeForPackage(this.getClass());
    private String instTimeKey = "com.actelion.research.orbit.imageAnalysis.instTime";
    private String checkUpdateKey = "com.actelion.research.orbit.imageAnalysis.checkUpdate";
    private String downloadUrl = "http://www.orbit.bio/download";

    public void checkUpdate() {
        boolean doCheck = prefs.getBoolean(checkUpdateKey, true);
        if (!doCheck) return;

        try {
            URL checkURL = new URL("http://www.orbit.bio/currentversion/" + getProps());
            String content = RawUtilsCommon.getContentStr(checkURL);
            // String content = "<p>###orbitversion=2.26###</p>";
            Pattern p = Pattern.compile("###orbitversion=\\d+.\\d+.\\d*###");
            Matcher m = p.matcher(content);
            if (m.find()) {
                String match = m.group();
                match = match.replaceAll("###", "").replaceAll("orbitversion", "").replaceAll("=", "").trim();
                logger.trace("match: " + match);
                double version = Double.parseDouble(match);
                logger.debug("latest version: " + version);

                double currentVersion = OrbitUtils.getVersion();
                if (version > currentVersion) {
                    logger.info("new version found: " + version);
                    showUpdateNotification();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isChecksEnabled() {
        return prefs.getBoolean(checkUpdateKey, true);
    }

    public void setChecksEnabled(boolean enabled) {
        prefs.putBoolean(checkUpdateKey, enabled);
    }

    private void showUpdateNotification() throws Exception {
        if (JOptionPane.showConfirmDialog(null, "A new Orbit version is available.\nDo you want to download and install the new verison?", "Update available", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(downloadUrl));
            } else {
                logger.error("Cannot open download URL. Please download the new version manually from " + downloadUrl);
            }
        }
    }

    private long getInstTime() {
        long val = prefs.getLong(instTimeKey, 0);
        if (val == 0) {
            prefs.putLong(instTimeKey, new Date().getTime());
        }
        val = prefs.getLong(instTimeKey, 0);
        return val;
    }

    private String getProps() {
        return "?time=" + getInstTime()
                + "&os=" + System.getProperty("os.name").replaceAll(" ", "")
                + "&javaVersion=" + Runtime.class.getPackage().getImplementationVersion()
                + "&mem=" + (int) (Runtime.getRuntime().maxMemory() / (1024L * 1024L))
                + "&cores=" + Runtime.getRuntime().availableProcessors()
                ;
    }


    public static void main(String[] args) {
        UpdateChecker checker = new UpdateChecker();
        checker.checkUpdate();
    }

}
