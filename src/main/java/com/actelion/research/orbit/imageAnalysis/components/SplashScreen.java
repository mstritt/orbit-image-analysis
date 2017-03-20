/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

/**
 * Present a simple graphic to the user upon launch of the application, to
 * provide a faster initial response than is possible with the main window.
 * <p>
 * <p>
 * <P>Adapted from an
 * <a href=http://developer.java.sun.com/developer/qow/archive/24/index.html>item</a>
 * on Sun's Java Developer Connection.
 * <p>
 * <P>This splash screen appears within about 2.5 seconds on a development
 * machine. The main screen takes about 6.0 seconds to load, so use of a splash
 * screen cuts down the initial display delay by about 55 percent.
 * <p>
 * <P>When JDK 6+ is available, its java.awt.SplashScreen class should be used instead
 * of this class.
 */
final class SplashScreen extends Frame {

    /**
     * Construct using an image for the splash screen.
     *
     * @param aImageId must have content, and is used by
     *                 {@link Class#getResource(java.lang.String)} to retrieve the splash screen image.
     */
    SplashScreen(String aImageId) {
    /*
    * Implementation Note
    * Args.checkForContent is not called here, in an attempt to minimize
    * class loading.
    */
        if (aImageId == null || aImageId.trim().length() == 0) {
            throw new IllegalArgumentException("Image Id does not have content.");
        }
        fImageId = aImageId;
    }

    /**
     * Show the splash screen to the end user.
     * <p>
     * <P>Once this method returns, the splash screen is realized, which means
     * that almost all work on the splash screen should proceed through the event
     * dispatch thread. In particular, any call to <tt>dispose</tt> for the
     * splash screen must be performed in the event dispatch thread.
     */
    void splash() {
        initImageAndTracker();
        //setSize(fImage.getWidth(NO_OBSERVER), fImage.getHeight(NO_OBSERVER));
        Dimension dimImageSize = new Dimension(800, 533);
        setLocation((getToolkit().getScreenSize().width - dimImageSize.width) / 2,
                (getToolkit().getScreenSize().height - dimImageSize.height) / 2);
        setSize(dimImageSize);


        fMediaTracker.addImage(fImage, 0);
        try {
            //fMediaTracker.waitForID(IMAGE_ID);
            fMediaTracker.waitForAll();
        } catch (InterruptedException ex) {
            System.out.println("Cannot track image load.");
        }

        SplashWindow splashWindow = new SplashWindow(this, fImage);
    }

    // PRIVATE
    private final String fImageId;
    private MediaTracker fMediaTracker;

    private Image fImage;
    private static final ImageObserver NO_OBSERVER = null;
    private static final int IMAGE_ID = 0;

    private void initImageAndTracker() {
        fMediaTracker = new MediaTracker(this);
        URL imageURL = SplashScreen.class.getResource(fImageId);
        fImage = Toolkit.getDefaultToolkit().getImage(imageURL);
    }


    private final class SplashWindow extends Window {
        SplashWindow(Frame aParent, Image aImage) {
            super(aParent);
            this.fImage = aImage;
            setSize(fImage.getWidth(NO_OBSERVER), fImage.getHeight(NO_OBSERVER));
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle window = getBounds();
            setLocation((screen.width - window.width) / 2, (screen.height - window.height) / 2);
            setVisible(true);
        }

        @Override
        public void paint(Graphics graphics) {
            if (fImage != null) {
                //graphics.drawImage(fImage,0,0,this);
                Image imgTemp = createImage(fImage.getWidth(this), fImage.getHeight(this));
                Graphics gfxTemp = imgTemp.getGraphics();
                gfxTemp.drawImage(fImage, 0, 0, fImage.getWidth(this), fImage.getHeight(this), this);
                graphics.drawImage(imgTemp, 0, 0, imgTemp.getWidth(this), imgTemp.getHeight(this), this);
            }
        }

        private Image fImage;
    }

    /**
     * Developer test harness shows the splash screen for a fixed length of
     * time, without launching the full application.
     */
    public static void main(String... aArgs) {
        SplashScreen splashScreen = new SplashScreen("/resource/orbit_splash2.jpg");
        splashScreen.splash();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.exit(0);
    }
}


