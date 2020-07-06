/*
 * Copyright 1997-2016 Actelion Ltd., Inc.
 * Gewerbestrasse 16
 * CH-4123 Allschwil, Switzerland
 *
 * All Rights Reserved.
 * This software is the proprietary information of Actelion Pharmaceuticals, Ltd.
 * Use is subject to license terms.
 *
 * User: stritma1
 * Date: 6/7/16 1:30 PM
 *
 *
 */

package com.actelion.research.orbit.imageAnalysis.test;

import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import com.actelion.research.orbit.imageprovider.ImageProviderOrbit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Properties;


public abstract class OrbitTestOS {

    @BeforeClass
    public static void setUp() {
        OrbitLogAppender.GUI_APPENDER = false;
        DALConfig.setImageProvider(new ImageProviderOrbit());
        Properties sys = new Properties(System.getProperties());
        sys.put("com.sun.media.jai.disableMediaLib", "true");
        System.setProperties(sys);
    }

    @AfterClass
    public static void tearDown() {
        try {
            DALConfig.getImageProvider().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
