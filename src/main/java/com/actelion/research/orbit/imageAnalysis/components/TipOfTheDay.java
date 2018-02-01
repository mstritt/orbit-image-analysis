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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.jdesktop.swingx.JXTipOfTheDay;
import org.jdesktop.swingx.tips.TipLoader;
import org.jdesktop.swingx.tips.TipOfTheDayModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.InputStream;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class TipOfTheDay {

    private JXTipOfTheDay tipOfTheDay = null;
    private Logger logger = LoggerFactory.getLogger(TipOfTheDay.class);
    private Component parentCompo = null;
    private Preferences prefs = null;
    private final static String PREF_SHOWTIPS = "showTipOfTheDay";
    private final static String PREF_TIPNUM = "tipOfTheDayNum";

    public TipOfTheDay(Component parentCompo) {
        prefs = Preferences.userNodeForPackage(OrbitImageAnalysis.class);
        try {
            this.parentCompo = parentCompo;
            tipOfTheDay = new JXTipOfTheDay(loadModel());
            tipOfTheDay.setCurrentTip(getStartingTipLocation());

        } catch (Exception e) {
            logger.error("error loading tips.properties", e);
        }
    }

    public void showDialog(final boolean forceShow) {
        if (tipOfTheDay != null) {
            tipOfTheDay.showDialog(parentCompo, new JXTipOfTheDay.ShowOnStartupChoice() {
                public boolean isShowingOnStartup() {
                    if (forceShow) return true;
                    else return isStartupChoiceOption();
                }

                public void setShowingOnStartup(boolean showOnStartup) {
                    setStartupChoiceOption(showOnStartup);
                    setNextStartingTipLocation(tipOfTheDay.getCurrentTip());
                }
            });
        } else {
            logger.error("tip of the day has not been loaded correctly. Does the tips.properties file exist?");
        }
    }

    private TipOfTheDayModel loadModel() throws Exception {
        Properties properties = new Properties();
        InputStream propertiesIn = OrbitUtils.DARKUI ? OrbitImageAnalysis.class.getResourceAsStream("/resource/tips.properties") : OrbitImageAnalysis.class.getResourceAsStream("/resource/tipsold.properties");
        properties.load(propertiesIn);
        return TipLoader.load(properties);
    }

    private boolean isStartupChoiceOption() {
        return prefs.getBoolean(PREF_SHOWTIPS, true);
    }

    private void setStartupChoiceOption(boolean val) {
        prefs.putBoolean(PREF_SHOWTIPS, val);
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            logger.error("error presisting preferences (show tip of the day)", e);
        }
    }

    private int getStartingTipLocation() {
        return prefs.getInt(PREF_TIPNUM, 0);
    }

    private void setNextStartingTipLocation(int loc) {
        int num = loc;
        if (tipOfTheDay != null && tipOfTheDay.getModel() != null) {
            num++;
            if (num > tipOfTheDay.getModel().getTipCount() - 1)
                num = 0;
        }
        prefs.putInt(PREF_TIPNUM, num);
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            logger.error("error presisting preferences (show tip of the day)", e);
        }
    }

}
