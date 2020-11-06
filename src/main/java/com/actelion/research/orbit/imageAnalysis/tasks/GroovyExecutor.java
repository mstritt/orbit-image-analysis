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
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GroovyExecutor {
    private static final Logger logger = LoggerFactory.getLogger(GroovyExecutor.class);

    private static void help() {
        System.out.println("GroovyExecutor (orbitimageanalysisact-groovy-0.x.y.jar)" //
                + "\nTool to run Orbit Image Analysis Groovy scripts from the command line" //
                + "\n" //
                + "\nGroovy Script local file:" //
                + "\n  orbitimageanalysisact-groovy-0.x.y.jar -f <local-script-file>" //
                + "\n" //
                + "\nGroovy Script remote url:" //
                + "\n  orbitimageanalysisact-groovy-0.x.y.jar -u <remote-script-url>" //
                + "\n" //
                + "\nOPTIONS:" //
                + "\n  -h, --help               : Just show this help text (all other arguments are ignored)" //
                + "\n  -v, --version            : Just prints out the version (all other arguments are ignored)" //
                + "\n  -f                       : Path to local file" //
                + "\n  -u                       : URL of remote file");
    }

    private static void version ()
    {
        System.out.println("orbitimageanalysisact-groovy-0.x.y.jar -v" + OrbitUtils.VERSION_STR);
    }

    public static void main(String[] args) throws Exception {
        OrbitLogAppender.GUI_APPENDER = false;

        Predicate<String> h = s -> s.contains("-h");
        Predicate<String> help = s -> s.contains("--help");
        Predicate<String> v = s -> s.contains("-v");
        Predicate<String> version = s -> s.contains("--version");
        if (Arrays.stream(args).anyMatch(h.and(help))) {
            help();
            System.exit(0);
        } else if (Arrays.stream(args).anyMatch(v.and(version))) {
            version();
            System.exit(0);
        } else if (args.length < 2) {
            System.err.println("Missing arguments");
            System.exit(1);
        }

        // Exit with code 1 if no script is read in.
        String content = "exit(2)";

        if (args[0].equals("-f")) {
            // Read from file
            content = FileUtils.readFileToString(new File(args[1]));
        } else if (args[0].equals("-u")) {
            // Read from URL
            try {
                URL url = new URL(args[1]);
                InputStream in = url.openStream();
                try {
                    //System.out.println( IOUtils.toString( in ) );
                    content = IOUtils.toString( in );
                } finally {
                    IOUtils.closeQuietly(in);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        logger.info("executing code:\n" + content);
        logger.info("start executing groovy code");

        // Get rid of the script name and type flag, and pass the remaining args to the script.
        Stream<String> stream = Arrays.stream(args);
        String[] argSlice = stream.skip(2).toArray(String[]::new);
        Binding sharedArgs = new Binding();
        sharedArgs.setProperty("args", argSlice);

        GroovyShell shell = new GroovyShell(sharedArgs);
        shell.evaluate(content);
        logger.info("finished");
    }
}
