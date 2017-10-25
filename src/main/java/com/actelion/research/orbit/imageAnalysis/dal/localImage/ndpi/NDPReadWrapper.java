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

package com.actelion.research.orbit.imageAnalysis.dal.localImage.ndpi;

import com.sun.jna.Pointer;

/**
 * Providing a more convenient interface to the methods of the {@link NDPReadJNA} interface.
 * <p/>
 * NOTE Methods could have been also implemented as {@code static} methods, but this way it is
 * possible to assign the/a instance of this wrapper to a very short named variable.
 * <p/>
 * NOTE Set the library path - e.g. {@code -Djava.library.path=<path to lib>}
 * <p/>
 * NOTE Set encoding {@code System.setProperty("jna.encoding","UTF-8")}
 *
 * @see NDPReadJNA
 */
public class NDPReadWrapper
{
    // INNER CLASSES / INTERFACES / ENUMS =====================================
    // JAVA ENUMS FOR C++ ENUMS -----------------------------------------------

    /** @see NdprRequestType */
    public static enum RequestType
    {
        InitFileImage(0),
        InitTestImage(1),
        CloseImage(2),
        GetImageInfo(3),
        GetMetadata(4),
        GetRegion(5),
        ConvertUnits(6),
        GetMetaImage(7),
        InitCallbackImage(8);

        public final int type;

        private RequestType (final int type)
        {
            this.type = type;
        }
    }

    /** @see NdprError */
    public static enum Error
    {
        Success(0),
        ExceptionDetected(-1),
        InvalidRequestType(-2),
        InvalidImageID(-3),
        InvalidRequestID(-4),
        MissingParameter(-5),
        InvalidParameter(-6),
        ParameterNotFound(-7),
        RequestNotExecuted(-8),
        ImageInUse(-9),
        ImageNotInUse(-10),
        MetaImageNotPresent(-11),
        UnsupportedFiletype(-12),
        BufferNotFilled(-13);

        public final int code;

        private Error (final int code)
        {
            this.code = code;
        }

        public static Error valueOf (final int code)
        {
            for (final Error error : Error.values()) {
                if (error.code == code) return error;
            }
            return null;
        }
    }

    /** @see NdprOption */
    public static enum Option
    {
        TextEncoding(0);

        public final int type;

        private Option (final int type)
        {
            this.type = type;
        }
    }

    /** @see NdprEncoding */
    public static enum Encoding
    {
        UCS2(0),
        UTF8(1),
        ANSI(2);

        public final int type;

        private Encoding (final int type)
        {
            this.type = type;
        }
    }

    // EXCEPTIONS -------------------------------------------------------------

    public static class NDPRException extends Exception
    {
        private static final long serialVersionUID = 3947447778159525754L;

        private final Error error;

        public NDPRException ()
        {
            this.error = null;
        }

        public NDPRException (final Error error, final String errorMsg)
        {
            super(errorMsg);
            this.error = error;
        }

        public Error getError ()
        {
            return error;
        }
    }

    // CONSTANTS ==============================================================

    // NOTE Skip prefix "lib" and extension ".so" / ".dll"
    public static final NDPReadWrapper INSTANCE = new NDPReadWrapper();

    private static final NDPReadJNA NDPR = NDPReadJNA.INSTANCE;

    // CONSTRUCTORS ===========================================================

    private NDPReadWrapper ()
    {
    }

    // METHODS ================================================================

    /** @see NDPReadJNA#ndprSetOption(int, int) */
    public void setOption (final Option option, int value)
    {
        NDPR.ndprSetOption(option.type, value);
    }

    /** @see NDPReadJNA#ndprCreateRequest(int) */
    public int createRequest (final RequestType requestType) throws NDPRException
    {
        // TODO Synchronization necessary?
        synchronized (NDPR) {
            return checkRequest(NDPR.ndprCreateRequest(requestType.type));
        }
    }

    /** @see NDPReadJNA#ndprExecuteRequest(int) */
    public int executeRequest (final int requestID) throws NDPRException
    {
        return checkExec(NDPR.ndprExecuteRequest(requestID), requestID);
    }

    /** @see NDPReadJNA#ndprFreeRequest(int) */
    public void freeRequest (final int requestID)
    {
        // NOTE After this we can't get anything for that 'requestID'
        // (including error codes / error messages) - so we don't check!
        NDPR.ndprFreeRequest(requestID);
    }

    /** @see NDPReadJNA#ndprGetLastErrorCode(int) */
    public int getLastErrorCode (final int requestID)
    {
        return NDPR.ndprGetLastErrorCode(requestID);
    }

    // NARROW STRING METHODS --------------------------------------------------

    /** @see NDPReadJNA#ndprGetLastErrorString(int) */
    public String getLastErrorString (final int requestID)
    {
        return NDPR.ndprGetLastErrorString(requestID).getString(0);
    }

    /** @see NDPReadJNA#ndprSetRequestInt(int, Pointer, int) */
    public void setRequestInt (final int requestID, final String paramID, final int value) throws NDPRException
    {
        checkSet(NDPR.ndprSetRequestInt(requestID, JNAUtils.toCharPointer(paramID), value), requestID);
    }

    /** @see NDPReadJNA#ndprSetRequestInt64(int, Pointer, long) */
    public void setRequestInt64 (final int requestID, final String paramID, final long value) throws NDPRException
    {
        checkSet(NDPR.ndprSetRequestInt64(requestID, JNAUtils.toCharPointer(paramID), value), requestID);
    }

    /** @see NDPReadJNA#ndprSetRequestFloat(int, Pointer, float) */
    public void setRequestFloat (final int requestID, final String paramID, final float value) throws NDPRException
    {
        checkSet(NDPR.ndprSetRequestFloat(requestID, JNAUtils.toCharPointer(paramID), value), requestID);
    }

    /** @see NDPReadJNA#ndprSetRequestString(int, Pointer, Pointer) */
    public void setRequestString (final int requestID, final String paramID, final String value) throws NDPRException
    {
        checkSet(NDPR.ndprSetRequestString(requestID, JNAUtils.toCharPointer(paramID), JNAUtils.toCharPointer(value)), requestID);
    }

    /** @see NDPReadJNA#ndprSetRequestPointer(int, Pointer, Pointer) */
    public void setRequestPointer (final int requestID, final String paramID, /* void* */ Pointer value) throws NDPRException
    {
        checkSet(NDPR.ndprSetRequestPointer(requestID, JNAUtils.toCharPointer(paramID), value), requestID);
    }

    /** @see NDPReadJNA#ndprGetRequestInt(int, Pointer) */
    public int getRequestInt (final int requestID, final String paramID) throws NDPRException
    {
        return checkGet(NDPR.ndprGetRequestInt(requestID, JNAUtils.toCharPointer(paramID)), requestID);
    }

    /** @see NDPReadJNA#ndprGetRequestInt64(int, Pointer) */
    public long getRequestInt64 (final int requestID, final String paramID) throws NDPRException
    {
        return checkGet(NDPR.ndprGetRequestInt64(requestID, JNAUtils.toCharPointer(paramID)), requestID);
    }

    /** @see NDPReadJNA#ndprGetRequestFloat(int, Pointer) */
    public float getRequestFloat (final int requestID, final String paramID) throws NDPRException
    {
        return checkGet(NDPR.ndprGetRequestFloat(requestID, JNAUtils.toCharPointer(paramID)), requestID);
    }

    /** @see NDPReadJNA#ndprGetRequestString(int, Pointer) */
    public String getRequestString (final int requestID, final String paramID) throws NDPRException
    {
        return checkGet(NDPR.ndprGetRequestString(requestID, JNAUtils.toCharPointer(paramID)), requestID).getString(0);
    }

    /** @see NDPReadJNA#ndprGetRequestPointer(int, Pointer) */
    public /* void* */ Pointer getRequestPointer (final int requestID, final String paramID) throws NDPRException
    {
        return checkGet(NDPR.ndprGetRequestPointer(requestID, JNAUtils.toCharPointer(paramID)), requestID);
    }

    // CHECK RESULTS ----------------------------------------------------------

    /** Check result of {@link NDPReadJNA#ndprCreateRequest(int)} */
    private int checkRequest (final int requestID) throws NDPRException
    {
        if (requestID < 0) {
            final int errCode = NDPR.ndprGetLastErrorCode(requestID);
            final Error error = Error.valueOf(errCode);
            final String errMsg = NDPR.ndprGetLastErrorString(requestID).getString(0);
            throw new NDPRException(error, errMsg);
        } else {
            return requestID;
        }
    }

    /** Check result of {@link NDPReadJNA#ndprExecuteRequest(int)} */
    private int checkExec (final int result, final int requestID) throws NDPRException
    {
        if (result < 0) {
            final int errCode = NDPR.ndprGetLastErrorCode(requestID);
            final Error error = Error.valueOf(errCode);
            final String errMsg = NDPR.ndprGetLastErrorString(requestID).getString(0);
            throw new NDPRException(error, errMsg);
        } else {
            return result;
        }
    }

    /** Check result of {@code setRequest*(...)} {@link NDPReadJNA} calls */
    private void checkSet (final int result, final int requestID) throws NDPRException
    {
        if (result < 0) {
            final int errCode = NDPR.ndprGetLastErrorCode(requestID);
            final Error error = Error.valueOf(errCode);
            final String errMsg = NDPR.ndprGetLastErrorString(requestID).getString(0);
            throw new NDPRException(error, errMsg);
        }
    }

    /** Check result of {@code getRequest*(...)} {@link NDPReadJNA} calls */
    private <T> T checkGet (final T result, final int requestID) throws NDPRException
    {
        final int errCode = NDPR.ndprGetLastErrorCode(requestID);
        if (errCode < 0) {
            final Error error = Error.valueOf(errCode);
            final String errMsg = NDPR.ndprGetLastErrorString(requestID).getString(0);
            throw new NDPRException(error, errMsg);
        } else {
            return result;
        }
    }

    // STATIC METHODS =========================================================
}