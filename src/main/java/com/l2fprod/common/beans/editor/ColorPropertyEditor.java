/**
 * $ $ License.
 *
 * Copyright $ L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.l2fprod.common.beans.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import com.l2fprod.common.swing.renderer.ColorCellRenderer;
import com.l2fprod.common.util.ResourceManager;

/**
 * ColorPropertyEditor. <br>
 *  
 */
public class ColorPropertyEditor extends AbstractPropertyEditor {

  private ColorCellRenderer label;
  private JButton button;
  private Color color;

  public ColorPropertyEditor() {
    editor = new JPanel(new BorderLayout(0, 0));
    ((JPanel)editor).add("Center", label = new ColorCellRenderer());
    label.setOpaque(false);
    ((JPanel)editor).add("East", button = new FixedButton());
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        selectColor();
      }
    });
    ((JPanel)editor).setOpaque(false);
  }

  public Object getValue() {
    return color;
  }

  public void setValue(Object value) {
    color = (Color)value;
    label.setValue(color);
  }

  protected void selectColor() {
    ResourceManager rm = ResourceManager.all(FilePropertyEditor.class);
    String title = rm.getString("ColorPropertyEditor.title");
    Color selectedColor = JColorChooser.showDialog(editor, title, color);

    if (selectedColor != null) {
      Color oldColor = color;
      Color newColor = selectedColor;
      label.setValue(newColor);
      color = newColor;
      firePropertyChange(oldColor, newColor);
    }
  }

}
