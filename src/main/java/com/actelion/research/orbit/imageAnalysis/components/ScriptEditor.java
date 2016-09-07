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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitCompletionProvider;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ScriptEditor extends JInternalFrame {

    public ScriptEditor() {
        super("Script Editor",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setFrameIcon(icon);
        }

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        final JTabbedPane tabOutPane = new JClosableTabbedPane();

        final RSyntaxTextArea scriptArea = new RSyntaxTextArea(20, 60);
        scriptArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GROOVY);
        scriptArea.setCodeFoldingEnabled(true);
        scriptArea.setCloseCurlyBraces(true);
        scriptArea.setMarkOccurrences(true);

//		LanguageSupportFactory.get().register(scriptArea);
//		scriptArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);

        CompletionProvider provider = new OrbitCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(scriptArea);

        Theme theme = null;
        try {
            theme = Theme.load(getClass().getResourceAsStream("/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
            theme.apply(scriptArea);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final RTextScrollPane scriptAreaScrollPane = new RTextScrollPane(scriptArea);

        final JButton runBtn = new JButton("run");
        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JTextArea outArea = new JTextArea();
                outArea.setEditable(false);
                DefaultCaret caret = (DefaultCaret) outArea.getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                ThreadPane threadPane = new ThreadPane(outArea);
                tabOutPane.add("Groovy " + (tabOutPane.getTabCount() + 1), threadPane);
                //tabOutPane.setSelectedComponent(threadPane);


                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // disabled due to groovy dependency

                        Binding binding = new Binding();
                        StreamCapturer streamCapturer = new StreamCapturer(outArea);
                        PrintStream ps = new PrintStream(streamCapturer, true);
                        binding.setProperty("out", ps);
                        binding.setProperty("stderr", ps);
                        binding.setProperty("stdout", ps);

                        GroovyShell shell = new GroovyShell(binding);
                        //shell.setVariable("model", OrbitImageAnalysis.getInstance().getModel());
                        Object result = null;
                        try {
                            String text = scriptArea.getSelectedText();
                            if (text == null || text.trim().length() == 0) text = scriptArea.getText();
                            result = shell.evaluate(text);
                        } catch (Exception e) {
                            e.printStackTrace();
                            e.printStackTrace(ps);
                        }
                        if (result != null) {
                            ps.println(result);
                        }
                        streamCapturer.flush();

                    }
                });
                threadPane.setThread(thread);
                thread.start();

            }
        });

        final JButton stopBtn = new JButton("stop");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThreadPane threadPane = (ThreadPane) tabOutPane.getSelectedComponent();
                if (threadPane != null) {
                    threadPane.getThread().stop();
                }
            }
        });


        final JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(runBtn);
        topPanel.add(stopBtn);

        final JSplitPane splitPaneMain = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scriptAreaScrollPane, tabOutPane);
        //scriptArea.setBackground(Color.white);


        scriptArea.setText("import com.actelion.research.orbit.imageAnalysis.components.*\n" +
                "import com.actelion.research.orbit.imageAnalysis.models.*\n" +
                "\n" +
                "final OrbitImageAnalysis OIA = OrbitImageAnalysis.getInstance();\n" +
                "ImageFrame iFrame = OIA.getIFrame();\n" +
                "println(\"selected image: \"+iFrame);\n" +
                "\n" +
                "OrbitModel model = OIA.getModel();\n" +
                "println(\"active model: \"+model);");


        splitPaneMain.setResizeWeight(1);
        splitPaneMain.setDividerLocation(700);
        //splitPaneMain.setDividerLocation(0.7);
        splitPaneMain.setOneTouchExpandable(true);

        add(topPanel, BorderLayout.NORTH);
        add(splitPaneMain, BorderLayout.CENTER);

        //RawUtilsCommon.centerComponent(frame);
        //frame.setVisible(true);

    }


    class StreamCapturer extends OutputStream {

        private ByteArrayOutputStream buffer = new ByteArrayOutputStream(128);
        private JTextArea textArea;

        public StreamCapturer(final JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            char c = (char) b;
            String value = Character.toString(c);
            buffer.write(b);
            if (value.equals("\n")) {
                flush();
            }
        }

        public void flush() {
            final String s = new String(buffer.toByteArray());
            buffer.reset();
            textArea.append(s);
            //	textArea.setCaretPosition(textArea.get);
//			SwingUtilities.invokeLater(new Runnable() {
//				@Override
//				public void run() {
//					textArea.append(s);
//				}
//			});
        }
    }

    class ThreadPane extends JScrollPane {
        Thread thread;

        public ThreadPane(Component view) {
            super(view);
        }

        public Thread getThread() {
            return thread;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }
    }


    public static void main(String[] args) {
        //  ScriptEditor scriptEditor = new ScriptEditor();
        //  scriptEditor.showScriptEditor(null);
    }

}
