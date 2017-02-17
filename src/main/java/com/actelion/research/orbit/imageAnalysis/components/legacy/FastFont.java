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

package com.actelion.research.orbit.imageAnalysis.components.legacy;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FastFont extends Font {
    public static String defaultFontFamily = "Segoe UI";
    public static int defaultFontSize = 12;

    public static Map<String, FastFont> fonts = new HashMap<>();
    public static FastFont BIGGEST;
    public static FastFont BIGGER;
    public static FastFont REGULAR;
    public static FastFont BOLD;
    public static FastFont MONO;
    public static FastFont MEDIUM;
    public static FastFont SMALL;
    public static FastFont SMALLER;
    public static FastFont SMALLEST;

    static {
        init();
    }

    private static void init() {
        BIGGEST = FastFont.getFont(defaultFontFamily, Font.BOLD, defaultFontSize*16/12);
        BIGGER = FastFont.getFont(defaultFontFamily, Font.BOLD, defaultFontSize*14/12);
        BOLD = FastFont.getFont(defaultFontFamily, Font.BOLD, defaultFontSize);
        REGULAR = FastFont.getFont(defaultFontFamily, Font.PLAIN, defaultFontSize);
        MONO = FastFont.getFont(Font.DIALOG_INPUT, Font.PLAIN, defaultFontSize);
        MEDIUM = FastFont.getFont(defaultFontFamily, Font.PLAIN, defaultFontSize*11/12);
        SMALL = FastFont.getFont(defaultFontFamily, Font.PLAIN, defaultFontSize*10/12);
        SMALLER = FastFont.getFont(defaultFontFamily, Font.PLAIN, defaultFontSize*9/12);
        SMALLEST = FastFont.getFont(defaultFontFamily, Font.PLAIN, defaultFontSize*7/12);

        Set<Object> keySet = UIManager.getLookAndFeelDefaults().keySet();
        Object[] keys = keySet.toArray(new Object[keySet.size()]);
        for (Object key : keys) {
            if (key != null && key.toString().toLowerCase().contains("font")) {
                Font font = UIManager.getDefaults().getFont(key);
                if (font != null) {
                    font = new Font(defaultFontFamily, font.getStyle(), defaultFontSize);
                    UIManager.put(key, font);
//                    System.out.println("FastFont.init() "+key+" > "+font);
                }
            }
        }
    }



    /**
     * Sets the default font size
     * @param size
     */
    public static void setDefaultFontSize(int size) {
        FastFont.defaultFontSize = size;
        init();
    }

    public static int getDefaultFontSize() {
        return defaultFontSize;
    }

    public static void setDefaultFontFamily(String defaultFont) {
        FastFont.defaultFontFamily = defaultFont;
        init();
    }

    public static String getDefaultFontFamily() {
        return defaultFontFamily;
    }

    public static int getAdaptedSize(int size) {
        return size * defaultFontSize / 12;
    }

    private FastFont(String name, int style, int size) {
        super(name, style, size);
        fonts.put(getKey(name, style, size), this);
    }

    public static FastFont getFont(String name, int style, int size) {
        String key = getKey(name, style, size);
        FastFont font = fonts.get(key);
        if(font!=null) return font;

        return new FastFont(name, style, size);
    }

    @Override
    public FastFont deriveFont(float size) {
        return getFont(name, style, (int) size);
    }

    @Override
    public FastFont deriveFont(int style) {
        return getFont(name, style, size);
    }

    public FastFont deriveSize(int size) {
        return getFont(name, style, size);
    }

    public FastFont increaseSize(int increment) {
        if(increment==0) return this;
        return getFont(name, style, size + increment);
    }

    private static String getKey(String name, int style, int size) {
        return name+"_"+style+"_"+size;
    }


}