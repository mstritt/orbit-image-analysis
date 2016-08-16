/* Created by JReleaseInfo AntTask from Open Source Competence Group */
/* Creation date Sun Sep 18 17:46:30 CEST 2005 */
package com.l2fprod.common;

import java.util.Date;

/**
 * This class provides information gathered from the build environment.
 * 
 * @author JReleaseInfo AntTask
 */
public class Version {


   /** buildDate (set during build process to 1127058390131L). */
   private static Date buildDate = new Date(1127058390131L);

   /**
    * Get buildDate (set during build process to Sun Sep 18 17:46:30 CEST 2005).
    * @return Date buildDate
    */
   public static final Date getBuildDate() { return buildDate; }


   /** buildTimestamp (set during build process to "09/18/2005 05:46 PM"). */
   private static String buildTimestamp = new String("09/18/2005 05:46 PM");

   /**
    * Get buildTimestamp (set during build process to "09/18/2005 05:46 PM").
    * @return String buildTimestamp
    */
   public static final String getBuildTimestamp() { return buildTimestamp; }


   /** year (set during build process to "2005"). */
   private static String year = new String("2005");

   /**
    * Get year (set during build process to "2005").
    * @return String year
    */
   public static final String getYear() { return year; }


   /** version (set during build process to "0.2-dev"). */
   private static String version = new String("0.2-dev");

   /**
    * Get version (set during build process to "0.2-dev").
    * @return String version
    */
   public static final String getVersion() { return version; }


   /** project (set during build process to "l2fprod-common"). */
   private static String project = new String("l2fprod-common");

   /**
    * Get project (set during build process to "l2fprod-common").
    * @return String project
    */
   public static final String getProject() { return project; }

}
