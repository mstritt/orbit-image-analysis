/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
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

import com.actelion.research.orbit.gui.RdfSearchBox;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RdfSearchBoxExtended extends RdfSearchBox {

    private static final long serialVersionUID = 1L;

    public RdfSearchBoxExtended() {
    }

    public RdfSearchBoxExtended(boolean showViewModeButtons) {
        super(showViewModeButtons);
    }

    public RdfSearchBoxExtended(boolean showViewModeButtons, boolean showConcatMode) {
        super(showViewModeButtons, showConcatMode,true);
    }

    public RdfSearchBoxExtended(boolean showViewModeButtons, boolean showConcatMode, boolean showFileFilter) {
        super(showViewModeButtons, showConcatMode, showFileFilter);
    }

    public void setEnabled(boolean enabled) {
        _searchField.setEnabled(enabled);
        this.getOkButton().setEnabled(enabled);
    }

    @Override
    protected JTextField getSearchField() {
        if (_searchField == null) {
            _searchField = new JTextField("search files...");
            getOkButton().setIcon(new ImageIcon(this.getClass().getResource("/resource/view.png")));
            getOkButton().setText("");

            _searchField.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    _searchField.select(0, _searchField.getText().length());
                }

                @Override
                public void focusLost(FocusEvent e) {
                    _searchField.select(0, 0);
                }
            });

            _searchField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        firePropertyChange(RDF_SEARCH, null, ((JTextField) e.getSource()).getText());
                    }
                }
            });
        }
        return _searchField;
    }

}
