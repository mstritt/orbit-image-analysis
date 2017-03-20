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

package com.actelion.research.orbit.imageAnalysis.components.legacy;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class JComboCheckBox extends JCustomTextField {

    private List<String> choices;
    private String separator = "; ";

    public JComboCheckBox() {
        this(new ArrayList<String>());
    }

    /**
     * Simulates a JComboBox, where more than 1 value can be selected.
     *
     * The choices should not have ';'
     * If the choices are labeled like 'key - value', we use the key to populate the textfield
     */
    public JComboCheckBox(List<String> choices) {
        super(JCustomTextField.ALPHANUMERIC);
        this.choices = choices;
        init();
    }

    public JComboCheckBox(String[] choices) {
        this(Arrays.asList(choices));
    }

    private void init() {
        setChoices(choices);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isEnabled())return;
                showPopup();
            }
        });
        addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                hidePopup();
            }
            @Override
            public void focusGained(FocusEvent e) {
            }
        });

        addAncestorListener(new AncestorListener(){
            @Override
            public void ancestorAdded(AncestorEvent event){ hidePopup();}
            @Override
            public void ancestorRemoved(AncestorEvent event){ hidePopup();}
            @Override
            public void ancestorMoved(AncestorEvent event){
                if (event.getSource() != JComboCheckBox.this) hidePopup();
            }});

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if((event instanceof MouseEvent ) && ((MouseEvent)event).getID()==MouseEvent.MOUSE_CLICKED) {
                    if(frame!=null && (event.getSource() instanceof Component) && SwingUtilities.getWindowAncestor((Component) event.getSource())!=frame &&  event.getSource()!=JComboCheckBox.this) {
                        hidePopup();
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        setEditable(true);
        setMargin(new Insets(0, 0, 0, 12));

    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
    public String getSeparator() {
        return separator;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    private JDialog frame;
    public void hidePopup() {
        if(frame!=null) {
            frame.dispose();
            frame = null;
            repaint();
        }
    }

    public void showPopup() {

        if(!isShowing() || frame!=null || choices==null) return;
        final Point p = JComboCheckBox.this.getLocationOnScreen();

        List<String> allChoices = new ArrayList<String>(choices);
        for (String string : getCheckedItems()) {
            if(string.length()>0 && !allChoices.contains(string)) {
                allChoices.add(string);
            }
        }
        final JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        int count = 0;
        int byRow = allChoices.size()>30? 4: allChoices.size()>6? 3: 1;
        int byCol = allChoices.size() / byRow;
        for (final String item : allChoices) {
            final JCheckBox cb = new JCheckBox(item);
            cb.setSelected(isChecked(item));
            cb.setFocusable(false);
            cb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String val = extractKey(item);
                    if(val.length()==0) return;

                    String[] alreadyChecked = getCheckedItems();

                    Set<String> sel = new TreeSet<>();
                    sel.addAll(Arrays.asList(alreadyChecked));
                    if(cb.isSelected()) sel.add(val);
                    else sel.remove(val);

                    StringBuilder sb = new StringBuilder();
                    for (String s : sel) {
                        sb.append((sb.length()>0? separator: "") + s);
                    }
                    setText(sb.toString());
                }
            });
            c.gridx = count / byCol;
            c.gridy = count % byCol;
            panel.add(cb, c);
            count++;
        }

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.WHITE);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(frame!=null) frame.dispose();
                if(JComboCheckBox.this.getTopLevelAncestor() instanceof JDialog) {
                    frame = new JDialog((JDialog)JComboCheckBox.this.getTopLevelAncestor(), false);
                } else if(JComboCheckBox.this.getTopLevelAncestor() instanceof JFrame) {
                    frame = new JDialog((JFrame)JComboCheckBox.this.getTopLevelAncestor(), false);
                } else {
                    System.err.println("Invalid topparent: "+JComboCheckBox.this.getTopLevelAncestor());
                    return;
                }
                frame.setUndecorated(true);
                frame.setContentPane(panel);
                frame.setAlwaysOnTop(true);
                frame.pack();
                int x = p.x;
                int y = p.y+getBounds().height;
                if(y+frame.getHeight()>Toolkit.getDefaultToolkit().getScreenSize().height) {
                    x = p.x+getBounds().width;
                    y = Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight();
                }
                if(x+frame.getWidth()>Toolkit.getDefaultToolkit().getScreenSize().width) {
                    x = Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth();
                }
                frame.setFocusableWindowState(false);
                frame.setLocation(x, y);
                frame.setVisible(true);
                repaint();
            }
        });

    }

    private String extractKey(String v) {
        if(v.indexOf(" - ")>0) v = v.substring(0, v.indexOf(" - "));
        return v.trim();
    }
    public String[] getCheckedItems() {
        String sel = (String) getText();
        String[] res = sel.split("\\"+separator);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i].trim();
        }
        Arrays.sort(res);
        return res;
    }
    public boolean isChecked(String v) {
        v = extractKey(v);
        for(String s: getCheckedItems()) {
            if(s.equals(v)) return true;
        }
        return false;
    }

    /**
     * Draw with a Nimbus style
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paint(g);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color fg = Color.BLACK;
        if(UIManager.getLookAndFeel().getName().contains("!!Nimbus")) {
            Color bg0 = getColor(246, 248, 250);
            Color bg1 = getColor(170, 190, 207);
            Color bg2 = getColor(187, 208, 227);
            if(!isEnabled()) {
                bg0 = bg0.darker();
                bg1 = bg1.darker();
                bg2 = bg2.darker();
            } else if(frame!=null && frame.isShowing()) {
                bg0 = getColor(143, 169, 192);
                bg1 = getColor(63, 108, 147);
                bg2 = getColor(90, 139, 182);
                fg = Color.WHITE;
            }
            Insets insets = getInsets();
            g.setPaint(new GradientPaint(0, 0, bg0, 0, getHeight()/2, bg1));
            g.fillRect(getWidth()-(insets.right-3), insets.top-3,  (insets.right-6), getHeight()/2-(insets.top-3));

            g.setPaint(new GradientPaint(0, getHeight()/2, bg1, 0, getHeight()-2, bg2));
            g.fillRect(getWidth()-(insets.right-3), getHeight()/2, (insets.right-6), getHeight()/2-(insets.bottom-4));
            g.setColor(getColor(139,160,179));
            g.drawLine(getWidth()-(insets.right-3)-1, insets.top-3+1, getWidth()-(insets.right-3)-1, getHeight()-(insets.bottom-3)-1);
            g.setColor(fg);
        }
        g.setFont(FastFont.BIGGEST);
        g.drawString("*", getWidth()-9-g.getFontMetrics().stringWidth("*")/2, getHeight()/2+5);
        g.fillPolygon(new int[] {getWidth()-12, getWidth()-6, getWidth()-9}, new int[] {getHeight()/2, getHeight()/2, getHeight()/2+6}, 3 );

//		g.fillPolygon(new int[] {getWidth()-12, getWidth()-6, getWidth()-9}, new int[] {getHeight()/2-6, getHeight()/2-6, getHeight()/2}, 3 );
//		g.fillPolygon(new int[] {getWidth()-12, getWidth()-6, getWidth()-9}, new int[] {getHeight()/2, getHeight()/2, getHeight()/2+6}, 3 );


    }


    /**
     * Get Colors from (small) cache
     */
    public static Color getColor(int r, int g, int b) {
        return getColor(r, g, b, 255);
    }
    public static Color getColor(Color color, int alpha) {
        return getColor(color.getRed(),color.getGreen(), color.getBlue(), alpha);
    }
    public static Color getColor(int r, int g, int b, int alpha) {
        int rgb =  ((alpha & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8)  | ((b & 0xFF) << 0);
        return getColor(rgb);
    }

    public static Color getColor(int rgb) {
        Color res = colorMap.get(rgb);
        if(res==null) {
            if(colorMap.size()>1000) colorMap.clear();
            res = new Color(rgb, true);
            colorMap.put(rgb, res);
        }
        return res;

    }

    private static Map<Integer, Color> colorMap = new HashMap<Integer, Color>();


}