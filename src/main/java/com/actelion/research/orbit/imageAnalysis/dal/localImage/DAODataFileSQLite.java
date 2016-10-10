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

package com.actelion.research.orbit.imageAnalysis.dal.localImage;

import com.actelion.research.orbit.beans.RawDataFile;
import com.actelion.research.orbit.utils.Logger;
import com.actelion.research.orbit.utils.RawUtilsCommon;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DAODataFileSQLite {

    public static Logger logger = Logger.getLogger(DAODataFileSQLite.class);

    protected static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:"+getTableFilename());
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

    public static String getTableFilename() {
        return "d:/test.db";
    }




    private static final String searchQueryFilename =
            "select * from raw_data_file rdf where UPPER(rdf.filename) like ";


    public static boolean createTable() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE RAW_DATA_FILE" +
                    "(" +
                    "  RAW_DATA_FILE_ID INTEGER PRIMARY KEY NOT NULL," +
                    "  RAW_DATA_ID INTEGER NOT NULL," +
                    "  BIOSAMPLE_ID INTEGER DEFAULT 0," +
                    "  PATH TEXT," +
                    "  FILENAME TEXT NOT NULL," +
                    "  FILESIZE INTEGER," +
                    "  FILETYPE TEXT," +
                    "  IMAGE_THN_ID INTEGER," +
                    "  IMAGE_PREVIEW_ID INTEGER," +
                    "  FLAGS INTEGER," +
                    "  REFERENCE_DATE DATE, " +
                    "  MODIFY_DATE DATE, " +
                    "  USER_ID TEXT " +
                    ")";
            stmt.executeUpdate(sql);
            stmt.close();

            execStmt("CREATE INDEX RAW_DATA_FILE_DATA ON RAW_DATA_FILE (RAW_DATA_ID) TABLESPACE RAWDB_IDX",conn);
            execStmt("CREATE INDEX RAW_DATA_FILE_FILENAME ON RAW_DATA_FILE (FILENAME) TABLESPACE RAWDB_IDX",conn);
            execStmt("CREATE INDEX RAW_DATA_FILE_PATH_NAME ON RAW_DATA_FILE (PATH, FILENAME) TABLESPACE RAWDB_IDX",conn);
            execStmt("CREATE INDEX RAW_DATA_FILE_TYPE ON RAW_DATA_FILE (FILETYPE) TABLESPACE RAWDB_IDX",conn);
            execStmt("CREATE INDEX RAW_DATA_FILE_BIOSAMP ON RAW_DATA_FILE (BIOSAMPLE_ID) TABLESPACE RAWDB_IDX",conn);

            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    private static void execStmt(String sql, Connection conn) throws SQLException {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }


    public static int InsertRawDataFile(RawDataFile dataFile) throws SQLException {
        int newId = -1;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("insert into raw_data_file " +
                    "(raw_data_id,path,filename,filesize,filetype,flags,REFERENCE_DATE,MODIFY_DATE,USER_ID,BIOSAMPLE_ID) " +
                    "values (?,?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, dataFile.getRawDataId());
            ps.setString(2, dataFile.getDataPath());
            ps.setString(3, dataFile.getFileName());
            ps.setLong(4, dataFile.getFileSize());
            ps.setString(5, dataFile.getFileType());
            ps.setInt(6, dataFile.getFlags());
            if (dataFile.getReferenceDate() != null) {
                java.sql.Timestamp refDate = new java.sql.Timestamp(dataFile.getReferenceDate().getTime());
                ps.setTimestamp(7, refDate);
            } else ps.setNull(7, java.sql.Types.TIMESTAMP);

            if (dataFile.getModifyDate() != null)
                ps.setTimestamp(8, new java.sql.Timestamp(dataFile.getModifyDate().getTime()));
            else ps.setNull(8, java.sql.Types.TIMESTAMP);
            ps.setString(9, dataFile.getUserId());
            ps.setInt(10, dataFile.getBioSampleId());

            ps.executeUpdate();
            ps.close();
            //conn.commit();

            // get new id

            ps = conn.prepareStatement("SELECT last_insert_rowid() AS new_id FROM raw_data_file");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newId = rs.getInt("new_id");
                dataFile.setRawDataFileId(newId);
            }
            ps.close();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }


        return newId;
    }


    public static boolean UpdateRawDataFile(RawDataFile dataFile) throws SQLException {
        int rowcnt = 0;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("update raw_data_file set " +
                    "raw_data_id=?,path=?,filename=?,filesize=?,filetype=?,flags=?,REFERENCE_DATE=?,MODIFY_DATE=?,USER_ID=?,BIOSAMPLE_ID=? " +
                    "where raw_data_file_id = ?");

            ps.setInt(1, dataFile.getRawDataId());
            ps.setString(2, dataFile.getDataPath());
            ps.setString(3, dataFile.getFileName());
            ps.setLong(4, dataFile.getFileSize());
            ps.setString(5, dataFile.getFileType());
            ps.setInt(6, dataFile.getFlags());
            if (dataFile.getReferenceDate() != null)
                ps.setTimestamp(7, new java.sql.Timestamp(dataFile.getReferenceDate().getTime()));
            else ps.setNull(7, java.sql.Types.TIMESTAMP);
            ps.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.setString(9, dataFile.getUserId());
            ps.setInt(10, dataFile.getBioSampleId());
            ps.setInt(11, dataFile.getRawDataFileId());

            rowcnt = ps.executeUpdate();
            ps.close();
            //conn.commit();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return (rowcnt > 0);
    }


    public static boolean DeleteRawDataFile(int dataFileId) throws SQLException {
        if (dataFileId <= 0) return false;
        int rowcnt = 0;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("delete from raw_data_file " +
                    "where raw_data_file_id = ?");

            ps.setInt(1, dataFileId);
            rowcnt = ps.executeUpdate();
            ps.close();
            //conn.commit();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return (rowcnt > 0);
    }

    /**
     * loads one specific RawDataFile.
     *
     * @param rawDataFileId
     * @return
     * @throws SQLException
     */
    public static RawDataFile LoadRawDataFile(int rawDataFileId) throws SQLException {
        Connection conn = getConnection();
        RawDataFile rawDataFile = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from raw_data_file where RAW_DATA_FILE_ID=?");
            ps.setInt(1, rawDataFileId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rawDataFile = RawDataFileFromRS(rs);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFile;
    }

    /**
     * Counts the number of RawDataFiles given a RawDataId.
     *
     * @return
     * @throws SQLException
     */
    public static int CountRawDataFile(int rawDataId) throws SQLException {
        Connection conn = getConnection();
        int cntRdf = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select count(*) from raw_data_file where RAW_DATA_ID=?");
            ps.setInt(1, rawDataId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cntRdf = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return cntRdf;
    }


    /**
     * Loads RawDataFiles filtered by RawDataId.
     *
     * @param rawDataId
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFiles(int rawDataId) throws SQLException {
        return LoadRawDataFiles(rawDataId, -1);
    }

    /**
     * Loads RawDataFiles filtered by RawDataId and fileType. Returns max limit results. Set limit to -1 for no limit.
     *
     * @param rawDataId
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFiles(int rawDataId, int limit) throws SQLException {
        return LoadRawDataFiles(rawDataId, null, limit);
    }

    /**
     * Loads RawDataFiles filtered by RawDataId and fileType. Returns max limit results. Set limit to -1 for no limit.
     *
     * @param rawDataId
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFiles(int rawDataId, List<String> fileTypes, int limit) throws SQLException {
        Connection conn = getConnection();
        List<RawDataFile> rawDataFiles = new ArrayList<RawDataFile>();
        try {
            StringBuilder sql = new StringBuilder("select * from raw_data_file where RAW_DATA_ID=? ");
            if (fileTypes != null && fileTypes.size() > 0) { // only according to specific filetypes
                sql.append(" and (");
                for (int j = 0; j < fileTypes.size(); j++) {
                    sql.append("filetype='" + fileTypes.get(j) + "'");
                    if (j < fileTypes.size() - 1) sql.append(" or ");
                }
                sql.append(")");
            }
            sql.append(" order by filename asc ");
            if (limit > 0) {
                sql.append(" limit " + limit);
            }
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, rawDataId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawDataFiles.add(RawDataFileFromRS(rs));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFiles;
    }



    /**
     * Checks if the raw data file with a given id exists in the orbit database.
     *
     * @return
     * @throws SQLException
     */
    public static boolean ExistRawDataFile(int id) throws SQLException {
        boolean res = false;
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select raw_data_file_id from raw_data_file where raw_data_file_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = true;
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    /**
     * Checks if the raw data file with a given path/filename exists in the orbit database.
     * Based on folder and filename.
     *
     * @return rdfId if exists, -1 otherwise
     * @throws SQLException
     */
    public static int ExistRawDataFile(String absolutepath) throws SQLException {
        int id = -1;
        Connection conn = getConnection();
        try {
            File file = new File(absolutepath);
            String filename = file.getName();
            String path = file.getParentFile().getAbsolutePath();
            PreparedStatement ps = conn.prepareStatement(
                    "select raw_data_file_id from raw_data_file where FILENAME=? and PATH=?");
            ps.setString(1, filename);
            ps.setString(2, path);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("RAW_DATA_FILE_ID");
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return id;
    }


    /**
     * loads RawDataFiles filtered by a set of BioSampleId.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFilesByFileNameUser(String fileName, String userId) throws SQLException {
        List<RawDataFile> rawDataFiles = new ArrayList<RawDataFile>();

        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from raw_data_file where filename = ? and upper(user_Id)=?");
            ps.setString(1, fileName);
            ps.setString(2, userId.toUpperCase());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawDataFiles.add(RawDataFileFromRS(rs));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFiles;
    }


    /**
     * Loads *all* raw data files for a list of file types.
     *
     * @param fileTypes
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFilesByType(List<String> fileTypes) throws SQLException {
        Connection conn = getConnection();
        List<RawDataFile> rawDataFiles = new ArrayList<RawDataFile>();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select * from raw_data_file where 1=1 ");
            if (fileTypes != null && fileTypes.size() > 0) { // only according to specific filetypes
                sb.append(" and (");
                for (int j = 0; j < fileTypes.size(); j++) {
                    sb.append("filetype='" + fileTypes.get(j) + "'");
                    if (j < fileTypes.size() - 1) sb.append(" or ");
                }
                sb.append(")");
            }
            sb.append(" order by filename asc, modify_date desc ");
            logger.trace("sql: " + sb.toString());

            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawDataFiles.add(RawDataFileFromRS(rs));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFiles;
    }


    /**
     * calls LoadRawDataFilesSearch with default search limit
     *
     * @param searchStr
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFilesSearch(String searchStr) throws SQLException {
        return LoadRawDataFilesSearch(searchStr, RawUtilsCommon.SEARCH_LIMIT);
    }

    /**
     * Loads RawDataFiles based on a search query.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFilesSearch(String searchStr, int searchLimit) throws SQLException {
        return LoadRawDataFilesSearch(searchStr, searchLimit, null);
    }

    /**
     * Loads RawDataFiles based on a search query. Returns only RDFs according to specific filetypes.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFilesSearch(String searchStr, int searchLimit, List<String> fileTypes) throws SQLException {
        return LoadRawDataFilesSearchFast(searchStr,searchLimit,fileTypes);
    }


    /**
     * Loads RawDataFiles based on a search query. Returns only RDFs according to specific filetypes.
     * This is the fast version of LoadRawDataFilesSearch which ignores search tokens (splitted by space) and just replaces all
     * spaces by '%'.
     * If this search does not return any results LoadRawDataFilesSearch might be considered.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFilesSearchFast(String searchStr, int searchLimit, List<String> fileTypes) throws SQLException {
        String searchStr2 = searchStr==null?"":searchStr.toUpperCase();

        Connection conn = getConnection();
        List<RawDataFile> rawDataFiles = new ArrayList<RawDataFile>();
        try {
            StringBuilder sb = new StringBuilder(searchQueryFilename);
            sb.append(" '%"+searchStr2+"%' ");

            if (fileTypes != null && fileTypes.size() > 0) { // only specific filetypes
                sb.append(" and (");
                for (int j = 0; j < fileTypes.size(); j++) {
                    sb.append("rdf.filetype='" + fileTypes.get(j) + "'");
                    if (j < fileTypes.size() - 1) sb.append(" or ");
                }
                sb.append(")");
            }
            sb.append(" order by rdf.filename asc, rdf.modify_date desc ");
            sb.append(" limit "+searchLimit);

            System.out.println("searchFast: "+sb.toString());

            PreparedStatement ps = conn.prepareStatement(sb.toString());
          //  ps.setString(1, searchStr2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawDataFiles.add(RawDataFileFromRS(rs));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFiles;
    }


    public static List<RawDataFile> LoadRawDataFilesByFilenameStart(String searchStr, boolean andMode, int searchLimit, List<String> fileTypes) throws SQLException {
        return LoadRawDataFilesByFilenameStart(searchStr, andMode, searchLimit, fileTypes, "modify_date desc, filename asc");
    }

    public static List<RawDataFile> LoadRawDataFilesByFilenameStart(String searchStr, boolean andMode, int searchLimit, List<String> fileTypes, String orderBy) throws SQLException {
        Connection conn = getConnection();
        List<RawDataFile> rawDataFiles = new ArrayList<RawDataFile>();
        try {
            String concatMode = " intersect ";
            if (!andMode) concatMode = " union ";
            String[] searchArr = searchStr.trim().toUpperCase().split(" ");
            if (searchArr != null && searchArr.length > 0) {

                StringBuilder sb = new StringBuilder();
                sb.append("select * from ( ");
                for (int i = 0; i < searchArr.length; i++) {
                    sb.append(searchQueryFilename);
                    sb.append(" ? ");
                    if (i < searchArr.length - 1) sb.append(concatMode);
                }
                sb.append(") where 1=1 " );
                if (fileTypes != null && fileTypes.size() > 0) { // only according to specific filetypes
                    sb.append(" and (");
                    for (int j = 0; j < fileTypes.size(); j++) {
                        sb.append("filetype='" + fileTypes.get(j) + "'");
                        if (j < fileTypes.size() - 1) sb.append(" or ");
                    }
                    sb.append(")");
                }
                sb.append(" order by " + orderBy + " ");
                if (searchLimit > 0) {
                    sb.append(" limit " + searchLimit);
                }

                logger.trace("sql: " + sb.toString());
                PreparedStatement ps = conn.prepareStatement(sb.toString());
                //String search = searchStr.trim().toUpperCase();
                for (int i = 0; i < searchArr.length; i++) {
                    String search = searchArr[i].trim();
                    String searchFuzzy = "%" + search + "%";
                    ps.setString((i * 1) + 1, searchFuzzy);
                }

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    rawDataFiles.add(RawDataFileFromRS(rs));
                }
                rs.close();
                ps.close();
            } // if
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFiles;
    }


    /**
     * loads *all* RawDataFiles.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawDataFile> LoadRawDataFiles() throws SQLException {
        Connection conn = getConnection();
        List<RawDataFile> rawDataFiles = new ArrayList<RawDataFile>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from raw_data_file order by filename asc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawDataFiles.add(RawDataFileFromRS(rs));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return rawDataFiles;
    }

    public static RawDataFile RawDataFileFromRS(ResultSet rs) throws SQLException {
        RawDataFile rawDataFile = new RawDataFile();
        rawDataFile.setRawDataFileId(rs.getInt("RAW_DATA_FILE_ID"));
        rawDataFile.setRawDataId(rs.getInt("RAW_DATA_ID"));
        rawDataFile.setDataPath(rs.getString("PATH"));
        rawDataFile.setFileName(rs.getString("FILENAME"));
        rawDataFile.setFileSize(rs.getLong("FILESIZE"));
        rawDataFile.setFileType(rs.getString("FILETYPE"));
        rawDataFile.setFlags(rs.getInt("FLAGS"));
        rawDataFile.setReferenceDate(rs.getTimestamp("REFERENCE_DATE"));
        rawDataFile.setModifyDate(rs.getTimestamp("MODIFY_DATE"));
        rawDataFile.setUserId(rs.getString("USER_ID"));
        //rawDataFile.setBioSampleId(rs.getInt("BIOSAMPLE_ID"));
        return rawDataFile;
    }


    public static void main(String[] args) throws Exception {
       // DAODataFileSQLite.createTable();

//        RawDataFile rdf = new RawDataFile();
//        rdf.setRawDataId(1);
//        rdf.setUserId("orbit");
//        rdf.setModifyDate(new Date());
//        rdf.setReferenceDate(new Date());
//        rdf.setDataPath("d:/");
//        rdf.setFileName("test.jpg");
//        rdf.setFileType(RawUtilsCommon.DATA_TYPE_IMAGE_JPG);
//        rdf.setFileSize(1000l);
//
//        int id = DAODataFileSQLite.InsertRawDataFile(rdf);
//        System.out.println("id: "+id);

        RawDataFile rdf = DAODataFileSQLite.LoadRawDataFilesSearchFast("test",1000, Arrays.asList(RawUtilsCommon.fileTypesImage)).get(0);
        System.out.println(rdf.toStringDetail());


    }

}
