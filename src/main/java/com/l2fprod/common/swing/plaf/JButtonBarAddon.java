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

import com.l2fprod.common.swing.JButtonBar;
import com.l2fprod.common.swing.plaf.basic.BasicLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.metal.MetalLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;

/**
 * Addon for <code>JButtonBar</code>.<br>
 *
 */
public class JButtonBarAddon implements ComponentAddon {

  public String getName() {
    return "JButtonBar";
  }

  public void initialize(LookAndFeelAddons addon) {
    if (addon instanceof BasicLookAndFeelAddons) {
      addon.loadDefaults(new Object[]{
        JButtonBar.UI_CLASS_ID,
        "com.l2fprod.common.swing.plaf.basic.BasicButtonBarUI"
      });
    }        

    if (addon instanceof MetalLookAndFeelAddons) {
      addon.loadDefaults(new Object[]{
        JButtonBar.UI_CLASS_ID,
        "com.l2fprod.common.swing.plaf.blue.BlueishButtonBarUI"
      });
    }
    
    if (addon instanceof WindowsLookAndFeelAddons) {
      addon.loadDefaults(new Object[]{
        JButtonBar.UI_CLASS_ID,
        "com.l2fprod.common.swing.plaf.blue.BlueishButtonBarUI"
      });
    }
  }

  public void uninitialize(LookAndFeelAddons addon) {
  }

}
