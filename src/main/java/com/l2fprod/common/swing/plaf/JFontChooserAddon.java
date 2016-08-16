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
package com.l2fprod.common.swing.plaf;

import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;

/**
 * Addon for the <code>JFontChooser</code>.<br>
 *
 */
public class JFontChooserAddon implements ComponentAddon {

  public String getName() {
    return "JFontChooser";
  }

  public void initialize(LookAndFeelAddons addon) {
    // for basic
  	if (addon instanceof WindowsLookAndFeelAddons) {
      Object[] defaults = new Object[] {
        "FontChooserUI",
        "com.l2fprod.common.swing.plaf.windows.WindowsFontChooserUI",
      };
      addon.loadDefaults(defaults);
  	} else {
      Object[] defaults = new Object[] {
        "FontChooserUI",
        "com.l2fprod.common.swing.plaf.basic.BasicFontChooserUI"
      };
      addon.loadDefaults(defaults);
  	}    
  }

  public void uninitialize(LookAndFeelAddons addon) {
  }

}
