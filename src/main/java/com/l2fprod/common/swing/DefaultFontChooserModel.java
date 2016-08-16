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
package com.l2fprod.common.swing;

import java.awt.GraphicsEnvironment;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.SortedMap;

import com.l2fprod.common.swing.plaf.FontChooserUI;

/**
 * Default implementation of the FontChooserModel. It returns all
 * available fonts and commonly used font sizes.
 */
public class DefaultFontChooserModel implements FontChooserModel {

  private static final int[] DEFAULT_FONT_SIZES = {6, 8, 10, 11, 12, 14, 16,
      18, 20, 22, 24, 26, 28, 32, 40, 48, 56, 64, 72};

  private final String[] fontFamilies;
  private final String[] charSets;
  private final String previewMessage;
  
  public DefaultFontChooserModel() {
    fontFamilies = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getAvailableFontFamilyNames();
    Arrays.sort(fontFamilies);

    SortedMap map = Charset.availableCharsets();
    charSets = new String[map.size()];
    int i = 0;
    for (Iterator iter = map.keySet().iterator(); iter.hasNext(); i++) {
      charSets[i] = (String)iter.next();
    }
    
    ResourceBundle bundle =
      ResourceBundle.getBundle(FontChooserUI.class.getName() + "RB");
    previewMessage = bundle.getString("FontChooserUI.previewText");
  }

  public String[] getFontFamilies(String charSetName) {
    return fontFamilies;
  }

  public int[] getDefaultSizes() {
    return DEFAULT_FONT_SIZES;
  }

  public String[] getCharSets() {
    return charSets;
  }

  public String getPreviewMessage(String charSetName) {
    return previewMessage;
  }

}