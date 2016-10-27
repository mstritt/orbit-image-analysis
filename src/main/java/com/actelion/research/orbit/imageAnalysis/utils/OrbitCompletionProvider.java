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

package com.actelion.research.orbit.imageAnalysis.utils;

import org.fife.ui.autocomplete.*;

public class OrbitCompletionProvider extends LanguageAwareCompletionProvider {

    /**
     * Constructor.
     */
    public OrbitCompletionProvider() {
        setDefaultCompletionProvider(createCodeCompletionProvider());
        setStringCompletionProvider(createStringCompletionProvider());
        setCommentCompletionProvider(createCommentCompletionProvider());
    }


    /**
     * Adds shorthand completions to the code completion provider.
     *
     * @param codeCP The code completion provider.
     */
    protected void addShorthandCompletions(DefaultCompletionProvider codeCP) {
    }


    /**
     * Returns the provider to use when editing code.
     *
     * @return The provider.
     * @see #createCommentCompletionProvider()
     * @see #createStringCompletionProvider()
     * @see #addShorthandCompletions(DefaultCompletionProvider)
     */
    protected CompletionProvider createCodeCompletionProvider() {
        //DefaultCompletionProvider cp = new GroovySourceCompletionProvider();
        DefaultCompletionProvider cp = new DefaultCompletionProvider();

        String[] orbitExpressions = new String[]{"RawDataFile","DALConfig","DALConfig.imageProvider","LoadRawDataFile","OrbitModel","OrbitModel.LoadFromOrbit","ClassificationResult","OrbitHelper.Classify",
        "getClassShapes()","ClassificationResult","List<KeyValue<String, Double>>","DALConfig.getImageProvider().authenticateUser","OrbitHelper.searchImages","RecognitionFrame","recognitionFrame.bimg.image.tiles.each"};

        cp.addCompletion(new BasicCompletion(cp, "abstract"));
        cp.addCompletion(new BasicCompletion(cp, "assert"));
        cp.addCompletion(new BasicCompletion(cp, "break"));
        cp.addCompletion(new BasicCompletion(cp, "case"));
        // ... etc ...
        cp.addCompletion(new BasicCompletion(cp, "final"));
        cp.addCompletion(new BasicCompletion(cp, "transient"));
        cp.addCompletion(new BasicCompletion(cp, "try"));
        cp.addCompletion(new BasicCompletion(cp, "void"));
        cp.addCompletion(new BasicCompletion(cp, "volatile"));
        cp.addCompletion(new BasicCompletion(cp, "while"));
        cp.addCompletion(new BasicCompletion(cp, "print"));
        cp.addCompletion(new BasicCompletion(cp, "println"));
        cp.addCompletion(new BasicCompletion(cp, "def"));
        cp.addCompletion(new BasicCompletion(cp, "each"));
        cp.addCompletion(new BasicCompletion(cp, "for"));

        for (String expr: orbitExpressions)
            cp.addCompletion(new BasicCompletion(cp, expr));


        // Add a couple of "shorthand" completions. These completions don't
        // require the input text to be the same thing as the replacement text.
        cp.addCompletion(new ShorthandCompletion(cp, "sysout",
                "System.out.println(", "System.out.println("));
        cp.addCompletion(new ShorthandCompletion(cp, "syserr",
                "System.err.println(", "System.err.println("));


        return cp;
    }


    /**
     * Returns the provider to use when in a comment.
     *
     * @return The provider.
     * @see #createCodeCompletionProvider()
     * @see #createStringCompletionProvider()
     */
    protected CompletionProvider createCommentCompletionProvider() {
        DefaultCompletionProvider cp = new DefaultCompletionProvider();
        cp.addCompletion(new BasicCompletion(cp, "TODO:", "A to-do reminder"));
        cp.addCompletion(new BasicCompletion(cp, "FIXME:", "A bug that needs to be fixed"));
        return cp;
    }


    /**
     * Returns the completion provider to use when the caret is in a string.
     *
     * @return The provider.
     * @see #createCodeCompletionProvider()
     * @see #createCommentCompletionProvider()
     */
    protected CompletionProvider createStringCompletionProvider() {
        DefaultCompletionProvider cp = new DefaultCompletionProvider();
        cp.addCompletion(new BasicCompletion(cp, "%c", "char", "Prints a character"));
        cp.addCompletion(new BasicCompletion(cp, "%i", "signed int", "Prints a signed integer"));
        cp.addCompletion(new BasicCompletion(cp, "%f", "float", "Prints a float"));
        cp.addCompletion(new BasicCompletion(cp, "%s", "string", "Prints a string"));
        cp.addCompletion(new BasicCompletion(cp, "%u", "unsigned int", "Prints an unsigned integer"));
        cp.addCompletion(new BasicCompletion(cp, "\\n", "Newline", "Prints a newline"));
        return cp;
    }

}
