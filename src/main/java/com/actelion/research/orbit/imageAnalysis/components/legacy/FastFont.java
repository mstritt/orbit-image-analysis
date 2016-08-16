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

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Class used to cache fonts, thus avoiding the repetitive use of constructors
 * (don't abuse it with as it can create memory leaks)
 * <p>
 * Use getFont to retrieve the font from the cache
 */
public class FastFont extends Font {

    public static final Map<String, FastFont> fonts = new HashMap<String, FastFont>();
    public static final FastFont BIGGER = FastFont.getFont(Font.SANS_SERIF, Font.BOLD, 14);
    public static final FastFont REGULAR = FastFont.getFont(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final FastFont MEDIUM = FastFont.getFont(Font.SANS_SERIF, Font.PLAIN, 11);
    public static final FastFont SMALL = FastFont.getFont(Font.SANS_SERIF, Font.PLAIN, 10);
    public static final FastFont SMALLER = FastFont.getFont(Font.SANS_SERIF, Font.PLAIN, 9);
    public static final FastFont BOLD = FastFont.getFont(Font.SANS_SERIF, Font.BOLD, 12);
    public static final FastFont MONO = FastFont.getFont(Font.DIALOG_INPUT, Font.PLAIN, 12);
    public static final FastFont REGULAR_CONDENSED = FastFont.getFont("Arial Narrow", Font.PLAIN, 12);
    public static final FastFont MEDIUM_CONDENSED = FastFont.getFont("Arial Narrow", Font.PLAIN, 11);
    public static final FastFont BOLD_CONDENSED = FastFont.getFont("Arial Narrow Bold", Font.PLAIN, 12);
    public static final FastFont SMALL_CONDENSED = FastFont.getFont("Arial Narrow", Font.PLAIN, 10);
    public static final FastFont SMALLER_CONDENSED = FastFont.getFont("Arial Narrow", Font.PLAIN, 9);

    private FastFont(String name, int style, int size) {
        super(name, style, size);
        fonts.put(getKey(name, style, size), this);
    }

    public static FastFont getFont(String name, int style, int size) {
        String key = getKey(name, style, size);
        FastFont font = fonts.get(key);
        if (font != null) return font;

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
        if (increment == 0) return this;
        return getFont(name, style, size + increment);
    }

    private static String getKey(String name, int style, int size) {
        return name + "_" + style + "_" + size;
    }


}
