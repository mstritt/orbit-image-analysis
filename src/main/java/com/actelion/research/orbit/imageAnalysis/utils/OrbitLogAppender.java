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

package com.actelion.research.orbit.imageAnalysis.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.actelion.research.orbit.imageAnalysis.components.OrbitImageAnalysis;

import java.awt.*;

public class OrbitLogAppender<E> extends AppenderBase<E> {

    private PatternLayoutEncoder encoder;
    public static boolean GUI_APPENDER = true;

    @Override
    public void start() {
        if (this.encoder == null) {
            addError("No encoder set for the appender named [" + name + "].");
            return;
        }
        super.start();
    }


    @Override
    protected void append(E e) {
        if (!ScaleoutMode.SCALEOUTMODE.get() && GUI_APPENDER) {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            if (!GraphicsEnvironment.isHeadless() && (OrbitImageAnalysis.logFrame != null)) {
                if (e != null && (e instanceof LoggingEvent)) {
                    appendInOrbit((LoggingEvent) e);
                }
            }
        }
    }

    private void appendInOrbit(final LoggingEvent event) {
        // append log
        String mes = encoder.getLayout().doLayout(event);
        OrbitImageAnalysis.logFrame.appendText(mes);

        // handle exceptions
        if (event.getLevel().isGreaterOrEqual(Level.ERROR)) {
            final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();
            final String s = event.getMessage();
            if (OrbitImageAnalysis.popupErrors && !(s != null && (s.contains("InterruptedException") || s.contains("AbstractExecutorService") || s.contains("StackOverflowError") || s.contains("OutOfMemoryError")))) {
                OIA.showErrorMessage(s);
            }
        }
    }

    public PatternLayoutEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(PatternLayoutEncoder encoder) {
        this.encoder = encoder;
    }

}
