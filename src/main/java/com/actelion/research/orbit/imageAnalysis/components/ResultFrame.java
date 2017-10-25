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

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class ResultFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ResultFrame.class);
    private JEditorPane textArea = null;

    public ResultFrame(String text, String title) {
        //textArea = new JTextArea(text);
        if (text != null && (text.startsWith("<html") || text.startsWith("<HTML")))
            textArea = new JEditorPane("text/html", text);
        else textArea = new JTextPane();

        if (textArea instanceof JTextPane) {
            AttributeSet attributes = ((JTextPane) textArea).getParagraphAttributes();
            try {
                textArea.getDocument().insertString(0, text, attributes);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        textArea.setEditable(false);
        textArea.setCaretPosition(0);
        if (OrbitUtils.DARKUI) {
            textArea.setForeground(Color.white);
            textArea.setBackground(Color.darkGray);
        }
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane);
        setSize(600, 600);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height - getHeight()) / 2);
        setTitle(title);

        java.net.URL imgURL = this.getClass().getResource(OrbitImageAnalysis.LOGO_NAME);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setFrameIcon(icon);
        }
    }

    public synchronized void updateText(String text) {
        textArea.setText(text);
    }

    public synchronized void appendText(String text) {
        //textArea.append(text);
        if (textArea instanceof JTextPane) {
            try {
                textArea.getDocument().insertString(textArea.getDocument().getLength(), text, ((JTextPane) textArea).getParagraphAttributes());
                textArea.setCaretPosition(textArea.getDocument().getLength());
            } catch (BadLocationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else
            logger.error("appendText is not supported for JEditorPanes (only for JTextPanes which are used if the text starts with <html)");
    }


}
