/*
 * Orbit, a versatile image analysis software for biological image-based quantification.
 * Copyright (C) 2009 - 2020 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitLogAppender;
import groovy.lang.GroovyShell;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URL;

public class GroovyExecutor {
    private static final Logger logger = LoggerFactory.getLogger(GroovyExecutor.class);

    public static void main(String[] args) throws Exception {
        OrbitLogAppender.GUI_APPENDER = false;
        if (args == null || args.length < 1)
            throw new IllegalArgumentException("No URL argument found. Call: GroovyExecutor <URL>");

        URL url = new URL(args[0]);

        InputStream in = url.openStream();
        String content;
        try {
            System.out.println( IOUtils.toString( in ) );
            content = IOUtils.toString( in );
        } finally {
            IOUtils.closeQuietly(in);
        }

        logger.info("executing code:\n" + content);
        logger.info("start executing groovy code");
        GroovyShell shell = new GroovyShell();
        shell.evaluate(content);
        logger.info("finished");
    }
}
