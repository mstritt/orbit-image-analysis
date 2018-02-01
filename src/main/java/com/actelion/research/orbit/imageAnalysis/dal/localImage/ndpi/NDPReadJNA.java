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

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * JNA Interface for the libNDPread2.so / libNDPread2.dll C++ library.
 * <p/>
 * NOTE Set the library path - e.g. {@code -Djna.library.path=<path to lib>}
 * <p/>
 * NOTE Set encoding {@code System.setProperty("jna.encoding","UTF-8")}
 */
public interface NDPReadJNA extends Library
{
    // INNER CLASSES / INTERFACES / ENUMS =====================================
    // JAVA CLASSES FOR C++ ENUMS ---------------------------------------------

    public static class NdprRequestType
    {
        public static final int InitFileImage = 0;
        public static final int InitTestImage = 1;
        public static final int CloseImage = 2;
        public static final int GetImageInfo = 3;
        public static final int GetMetadata = 4;
        public static final int GetRegion = 5;
        public static final int ConvertUnits = 6;
        public static final int GetMetaImage = 7;
        public static final int InitCallbackImage = 8;
    }

    public static class NdprError
    {
        public static final int Success = 0;
        public static final int ExceptionDetected = -1;
        public static final int InvalidRequestType = -2;
        public static final int InvalidImageID = -3;
        public static final int InvalidRequestID = -4;
        public static final int MissingParameter = -5;
        public static final int InvalidParameter = -6;
        public static final int ParameterNotFound = -7;
        public static final int RequestNotExecuted = -8;
        public static final int ImageInUse = -9;
        public static final int ImageNotInUse = -10;
        public static final int MetaImageNotPresent = -11;
        public static final int UnsupportedFiletype = -12;
        public static final int BufferNotFilled = -13;
    }

    public static class NdprOption
    {
        public static final int TextEncoding = 0;
    }

    public static class NdprEncoding
    {
        public static final int UCS2 = 0;
        public static final int UTF8 = 1;
        public static final int ANSI = 2;
    }

    // CONSTANTS ==============================================================

    // NOTE Skip prefix "lib" and extension ".so" / ".dll"
    public final NDPReadJNA INSTANCE = Native.loadLibrary("NDPread2", NDPReadJNA.class);

    // METHODS ================================================================

    int ndprSetOption(int i_nOptionID, int i_nValue);

    int ndprCreateRequest(int i_nRequestType);

    int ndprExecuteRequest(int i_nRequestID);

    int ndprFreeRequest(int i_nRequestID);

    int ndprGetLastErrorCode(int i_nRequestID);

    // NARROW STRING METHODS --------------------------------------------------

    /* char* */ Pointer ndprGetLastErrorString(int i_nRequestID);

    int ndprSetRequestInt(int i_nRequestID, /* char* */ Pointer i_strParamID, int i_nValue);

    int ndprSetRequestInt64(int i_nRequestID, /* char* */ Pointer i_strParamID, /* long long */ long i_nValue);

    int ndprSetRequestFloat(int i_nRequestID, /* char* */ Pointer i_strParamID, float i_fValue);

    int ndprSetRequestString(int i_nRequestID, /* char* */ Pointer i_strParamID, /* char* */ Pointer i_strValue);

    int ndprSetRequestPointer(int i_nRequestID, /* char* */ Pointer i_strParamID, /* void* */ Pointer i_pValue);

    int ndprGetRequestInt(int i_nRequestID, /* char* */ Pointer i_strParamID);

    /* long long */ long ndprGetRequestInt64(int i_nRequestID, /* char* */ Pointer i_strParamID);

    float ndprGetRequestFloat(int i_nRequestID, /* char* */ Pointer i_strParamID);

    /* char* */ Pointer ndprGetRequestString(int i_nRequestID, /* char* */ Pointer i_strParamID);

    /* void* */ Pointer ndprGetRequestPointer(int i_nRequestID, /* char* */ Pointer i_strParamID);

    // STATIC METHODS =========================================================
}
