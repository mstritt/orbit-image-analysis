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

import com.actelion.research.orbit.beans.RawAnnotation;
import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * DAO for class RawAnnotation, SQLLite version.
 *
 */
public class DAORawAnnotationSQLite {
    private static final Logger logger = LoggerFactory.getLogger(DAORawAnnotationSQLite.class);

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
        return DALConfig.getLocalDBFile();
    }


    public static boolean createTable() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE RAW_ANNOTATION" +
                    " (" +
                    "  RAW_ANNOTATION_ID INTEGER PRIMARY KEY NOT NULL," +
                    "  RAW_DATA_FILE_ID INTEGER," +
                    "  RAW_ANNOTATION_TYPE INTEGER," +
                    "  DESCRIPTION TEXT," +
                    "  DATA BLOB," +
                    "  USER_ID TEXT NOT NULL," +
                    "  MODIFY_DATE DATE NOT NULL" +
                    ")";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = conn.createStatement();
            sql = "CREATE INDEX RAW_ANNOTATION_RD_FILE_ID ON RAW_ANNOTATION (RAW_DATA_FILE_ID) ";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = conn.createStatement();
            sql = " CREATE INDEX RAW_ANNOTATION_TYPE ON RAW_ANNOTATION (RAW_ANNOTATION_TYPE) ";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = conn.createStatement();
            sql = "CREATE INDEX RAW_ANNOTATION_RDF_TYPE ON RAW_ANNOTATION (RAW_DATA_FILE_ID,RAW_ANNOTATION_TYPE) ";
            stmt.executeUpdate(sql);
            stmt.close();

            logger.info("local RawAnnotation table created");
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


    public static int InsertRawAnnotation(RawAnnotation rawAnnotation) throws SQLException {
        int rawDataFileId = rawAnnotation.getRawDataFileId();
        if (rawDataFileId < 0)
            rawDataFileId = 0; // non file specific annotations are attached to dummy rdf with id 0 (e.g. models)
        int newId = -1;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("insert into raw_annotation " +
                    "(RAW_DATA_FILE_ID,RAW_ANNOTATION_TYPE,DESCRIPTION,DATA,USER_ID,MODIFY_DATE) " +
                    "values (?,?,?,?,?,?)");

            ps.setInt(1, rawDataFileId);
            ps.setInt(2, rawAnnotation.getRawAnnotationType());
            ps.setString(3, rawAnnotation.getDescription());
            ps.setBytes(4, rawAnnotation.getData());
            ps.setString(5, rawAnnotation.getUserId());
            ps.setTimestamp(6, new java.sql.Timestamp(rawAnnotation.getModifyDate().getTime()));

            ps.executeUpdate();
            ps.close();
            //conn.commit();

            // get new id
            //ps = conn.prepareStatement("SELECT last_insert_rowid() AS new_id FROM UGYFEL");
            ps = conn.prepareStatement("SELECT last_insert_rowid() AS new_id FROM raw_annotation");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newId = rs.getInt("new_id");
                rawAnnotation.setRawAnnotationId(newId);
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


    /**
     * Updates a RawAnnotation object.
     *
     * @param rawAnnotation
     * @return
     * @throws SQLException
     */
    public static boolean UpdateRawAnnotation(RawAnnotation rawAnnotation) throws SQLException {
        int rowcnt = 0;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("update raw_annotation set " +
                    "RAW_DATA_FILE_ID=?,RAW_ANNOTATION_TYPE=?,DESCRIPTION=?,DATA=?,USER_ID=?,MODIFY_DATE=? " +
                    "where raw_annotation_ID=? ");

            ps.setInt(1, rawAnnotation.getRawDataFileId());
            ps.setInt(2, rawAnnotation.getRawAnnotationType());
            ps.setString(3, rawAnnotation.getDescription());
            ps.setBytes(4, rawAnnotation.getData());
            ps.setString(5, rawAnnotation.getUserId());
            ps.setTimestamp(6, new java.sql.Timestamp(rawAnnotation.getModifyDate().getTime()));
            ps.setInt(7, rawAnnotation.getRawAnnotationId());

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
     * Deletes a RawData object.
     *
     * @param rawAnnotationId
     * @return
     * @throws SQLException
     */
    public static boolean DeleteRawAnnotation(int rawAnnotationId) throws SQLException {
        int rowcnt = 0;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("delete from raw_annotation " +
                    "where raw_annotation_ID=? ");

            ps.setInt(1, rawAnnotationId);
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

    public static boolean DeleteRawAnnotationsByRDF(int rdfId) throws SQLException {
        int rowcnt = 0;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("delete from raw_annotation where RAW_DATA_FILE_ID=? ");

            ps.setInt(1, rdfId);
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
     * Deletes a RawData object.
     *
     * @return
     * @throws SQLException
     */
    public static boolean DeleteRawAnnotationAllWithType(int rawDataFileId, int annotationType) throws SQLException {
        int rowcnt = 0;
        Connection conn = getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement("delete from raw_annotation where RAW_DATA_FILE_ID=? and RAW_ANNOTATION_TYPE=?");

            ps.setInt(1, rawDataFileId);
            ps.setInt(2, annotationType);
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
     * loads one specific RawAnnotation object.
     *
     * @param rawAnnotationId
     * @return
     * @throws SQLException
     */
    public static RawAnnotation LoadRawAnnotation(int rawAnnotationId) throws SQLException {
        Connection conn = getConnection();
        RawAnnotation rawAnnotation = null;
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from raw_annotation where raw_annotation_ID=?");
            ps.setInt(1, rawAnnotationId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rawAnnotation = RawAnnotationFromRS(rs);
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
        return rawAnnotation;
    }


    /**
     * loads *all* RawAnnotation objects.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawAnnotation> LoadRawAnnotations() throws SQLException {
        Connection conn = getConnection();
        List<RawAnnotation> rawAnnotations = new ArrayList<RawAnnotation>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from raw_annotation order by DESCRIPTION asc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawAnnotations.add(RawAnnotationFromRS(rs));
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
        return rawAnnotations;
    }


    /**
     * loads RawAnnotation objects by rawDataFileId. Adds all RawAnnotations from loadRawAnnotationOfRawDataFile additionally.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawAnnotation> LoadRawAnnotationsByRawDataFile(int rawDataFileId) throws SQLException {
        Connection conn = getConnection();
        List<RawAnnotation> rawAnnotations = new ArrayList<RawAnnotation>(6);
        try {
            String sql = "select * from raw_annotation where RAW_DATA_FILE_ID=? order by DESCRIPTION asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rawDataFileId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawAnnotations.add(RawAnnotationFromRS(rs));
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
        return rawAnnotations;
    }


    /**
     * loads RawAnnotation objects by rawDataFileId filtered by rawAnnotationType.
     *
     * @return
     * @throws SQLException
     */
    public static List<RawAnnotation> LoadRawAnnotationsByRawDataFile(int rawDataFileId, int rawAnnotationType) throws SQLException {
        Connection conn = getConnection();
        List<RawAnnotation> rawAnnotations = new ArrayList<RawAnnotation>(6);
        try {
            String sql = "select * from raw_annotation where RAW_DATA_FILE_ID=? and RAW_ANNOTATION_TYPE=? order by DESCRIPTION asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rawDataFileId);
            ps.setInt(2, rawAnnotationType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawAnnotations.add(RawAnnotationFromRS(rs));
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
        return rawAnnotations;
    }


    /**
     * loads RawAnnotation objects filtered by rawAnnotationType.
     *
     * @param rawAnnotationType
     * @return
     * @throws SQLException
     */
    public static List<RawAnnotation> LoadRawAnnotationsByType(int rawAnnotationType) throws SQLException {
        Connection conn = getConnection();
        List<RawAnnotation> rawAnnotations = new ArrayList<RawAnnotation>(6);
        try {
            String sql = "select * from raw_annotation where RAW_ANNOTATION_TYPE=? order by DESCRIPTION asc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rawAnnotationType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rawAnnotations.add(RawAnnotationFromRS(rs));
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
        return rawAnnotations;
    }

    private static RawAnnotation RawAnnotationFromRS(ResultSet rs) throws SQLException {
        RawAnnotation rawAnnotation = new RawAnnotation();
        rawAnnotation.setRawAnnotationId(rs.getInt("RAW_ANNOTATION_ID"));
        rawAnnotation.setRawDataFileId(rs.getInt("RAW_DATA_FILE_ID"));
        rawAnnotation.setRawAnnotationType(rs.getInt("RAW_ANNOTATION_TYPE"));
        rawAnnotation.setDescription(rs.getString("DESCRIPTION"));
        rawAnnotation.setUserId(rs.getString("USER_ID"));
        java.sql.Timestamp modDate = rs.getTimestamp("MODIFY_DATE");
        if (modDate != null)
            rawAnnotation.setModifyDate(modDate);
        rawAnnotation.setData(rs.getBytes("DATA"));
        return rawAnnotation;
    }



}
