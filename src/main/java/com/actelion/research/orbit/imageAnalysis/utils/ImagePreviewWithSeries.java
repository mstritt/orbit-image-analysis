/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.gui.IntInputVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;
import java.io.File;


public class ImagePreviewWithSeries extends JPanel  {
    private static final Logger logger = LoggerFactory.getLogger(ImagePreviewWithSeries.class);
    private final ChangeListener seriesChangeListner;

    public ImagePreviewWithSeries(final JFileChooser fc, final ChangeListener seriesChangeListner) {
          ImagePreview imagePreview = new ImagePreview(fc);
          final JSpinner seriesSpinner;
          SpinnerNumberModel spinnerModel;
          Integer current = new Integer(0);
          Integer min = new Integer(0);
          Integer max = new Integer(9999);
          Integer step = new Integer(1);
          spinnerModel = new SpinnerNumberModel(current, min, max, step);
          seriesSpinner = new JSpinner(spinnerModel);
          JFormattedTextField tf = ((JSpinner.DefaultEditor) seriesSpinner.getEditor()).getTextField();
          tf.setInputVerifier(new IntInputVerifier(0,min,max));
          ((NumberFormatter) tf.getFormatter()).setAllowsInvalid(false);

          JLabel label = new JLabel("Series / Scene:");
          setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
          JPanel seriesPanel = new JPanel();
          seriesPanel.add(label);
          seriesPanel.add(seriesSpinner);
          add(seriesPanel);
          add(imagePreview);

          this.seriesChangeListner = seriesChangeListner;
          
         seriesSpinner.addChangeListener(new ChangeListener() {
             @Override
             public void stateChanged(ChangeEvent e) {
                 int series = (Integer)seriesSpinner.getValue();
                 logger.debug("selected series: "+series);
                 if (ImagePreviewWithSeries.this.seriesChangeListner!=null) {
                     ImagePreviewWithSeries.this.seriesChangeListner.stateChanged(new ChangeEvent(new Integer(series)));
                 }
                 File[] files = fc.getSelectedFiles();
                 fc.setSelectedFiles(null);
                 fc.setSelectedFiles(files);
             }
         });

      }

}
