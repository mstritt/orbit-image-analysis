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

package com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

/**
 * Static utility methods for JNA
 */
public class JNAUtils
{
    // INNER CLASSES / INTERFACES / ENUMS =====================================

    // CONSTANTS ==============================================================

    // STATIC METHODS =========================================================

    /**
     * Creates a {@link Pointer} to be used for {@code char*} parameters of C/C++ functions/methods.
     * <p/>
     * NOTE Assumes ascii-only string
     */
    public static Pointer toCharPointer (final String str)
    {
        final Pointer pointer = new Memory(str.length() + 1);
        pointer.setString(0, str);
        return pointer;
    }

}
