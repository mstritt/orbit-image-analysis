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

import com.actelion.research.orbit.imageAnalysis.models.SpotPos;
import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class SpotImagePanel extends JComponent {
    private static final long serialVersionUID = 1L;
    protected int iOffsX = 0;
    protected int iOffsY = 0;
    private int oldWidth = 0;
    private int oldHeight = 0;
    private Dimension originalDimension = new Dimension(0, 0);
    protected int thumbWidth = 0;
    protected int thumbHeight = 0;
    protected double scale = 1d;
    protected int radius = 7;
    protected List<SpotPos> spotPosList = null;
    protected boolean editable = true;
    protected BufferedImage image = null;
    protected TiledImagePainter fullImage = null;
    protected final Font font = new Font("System", Font.PLAIN, 8);


    public SpotImagePanel(final List<SpotPos> spotPosList, int radius, boolean editable) {
        this.editable = editable;
        this.radius = radius;
        this.spotPosList = spotPosList;
        MouseInputAdapter mouseInputAdapter = new MouseInputAdapter() {
            SpotPos selectedSpot;

            @Override
            public void mousePressed(MouseEvent e) {
                if (selectedSpot != null) return;
                if (e.getButton() == MouseEvent.BUTTON1)  // left mouse button
                {
                    SpotPos sp = detectSpot(e.getX(), e.getY());
                    if (sp != null) {
                        selectedSpot = sp;
                        selectedSpot.setSelected(true);
                        SpotImagePanel.this.repaint();
                    }

                } // right mouse button
                else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (!SpotImagePanel.this.editable) return;
                    JPopupMenu menu = new JPopupMenu("Spot Options");
                    final int mx = e.getX();
                    final int my = e.getY();

                    // remove spot
                    JMenuItem item = new JMenuItem("remove");
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) { // remove
                            SpotPos sp = detectSpot(mx, my);
                            if (sp != null) {
                                SpotImagePanel.this.spotPosList.remove(sp);
                                SpotImagePanel.this.repaint();
                            }
                        }
                    });
                    menu.add(item);

                    // add spot
                    item = new JMenuItem("add spot");
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) { // remove
                            SpotPos sp = detectSpot(mx, my);
                            if (sp != null) {
                                JOptionPane.showMessageDialog(SpotImagePanel.this, "New spot can only be created where no spot exists already.", "Cannot create a new spot here.", JOptionPane.ERROR_MESSAGE);
                            } else { // free space
                                Point pos = getRelativeCoords(new Point(mx, my));
                                SpotPos nearest = detectNearestSpot(mx, my, true);
                                if (nearest != null) {
                                    Point spot = nearest.getSpot();
                                    SpotPos spNew = new SpotPos(pos, spot);
                                    SpotImagePanel.this.spotPosList.add(spNew);
                                    SpotImagePanel.this.repaint();
                                }
                            }
                        }
                    });
                    menu.add(item);


                    Point location = e.getPoint();
                    menu.show(SpotImagePanel.this, location.x, location.y);
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedSpot != null)
                    selectedSpot.setSelected(false);
                selectedSpot = null;
                SpotImagePanel.this.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (!SpotImagePanel.this.editable) return;
                if (selectedSpot == null) return;
                Point mp = e.getPoint();
                mp.x -= iOffsX;
                mp.y -= iOffsY;
                mp.x /= scale;
                mp.y /= scale;
                if (selectedSpot != null) {
                    selectedSpot.setPos(mp);
                }
                SpotImagePanel.this.repaint();
            }
        };

        addMouseListener(mouseInputAdapter);
        addMouseMotionListener(mouseInputAdapter);

    }

    protected Point getRelativeCoords(Point p) {
        int x = p.x;
        int y = p.y;
        x -= iOffsX;
        y -= iOffsY;
        x /= scale;
        y /= scale;
        return new Point(x, y);
    }

    protected SpotPos detectSpot(double x, double y) {
        Arc2D.Double arc;
        x -= iOffsX;
        y -= iOffsY;
        x /= scale;
        y /= scale;
        Point p;

        if (SpotImagePanel.this.spotPosList != null && SpotImagePanel.this.spotPosList.size() > 0) {
            for (SpotPos sp : SpotImagePanel.this.spotPosList) {
                p = sp.getPos();
                arc = new Arc2D.Double(p.x - SpotImagePanel.this.radius, p.y - SpotImagePanel.this.radius, SpotImagePanel.this.radius * 2, SpotImagePanel.this.radius * 2, 0, 360, Arc2D.CHORD);
                if (arc.contains(new Point((int) x, (int) y))) {
                    return sp;
                }

            }
        }
        return null;
    }


    protected SpotPos detectNearestSpot(int x, int y, boolean guessNewSpot) {
        x -= iOffsX;
        y -= iOffsY;
        x /= scale;
        y /= scale;
        Point p;
        SpotPos nearest = null;
        if (SpotImagePanel.this.spotPosList != null && SpotImagePanel.this.spotPosList.size() > 0) {
            nearest = (SpotPos) SpotImagePanel.this.spotPosList.get(0).clone();
            double dist = nearest.getPos().distance(x, y);
            double test;
            for (SpotPos sp : SpotImagePanel.this.spotPosList) {
                p = sp.getPos();
                test = p.distance(x, y);
                if (test < dist) {
                    nearest = (SpotPos) sp.clone();
                    dist = test;
                }
            }

            if (guessNewSpot) {
                SpotPos sp = (SpotPos) nearest.clone();
                p = sp.getPos();
                double xd = Math.abs(x - sp.getPos().x);
                double yd = Math.abs(y - sp.getPos().y);
                nearest.setSpot(null);
                if (xd > yd) {
                    if (x >= p.x && !available(sp.getSpot().x + 1, sp.getSpot().y)) {
                        nearest.setSpot(new Point(sp.getSpot().x + 1, sp.getSpot().y));
                    } else if (x < p.x && sp.getSpot().x > 0 && !available(sp.getSpot().x - 1, sp.getSpot().y)) {
                        nearest.setSpot(new Point(sp.getSpot().x - 1, sp.getSpot().y));
                    }
                }
                if (nearest.getSpot() == null) {
                    if (y >= p.y && !available(sp.getSpot().x, sp.getSpot().y + 1)) {
                        nearest.setSpot(new Point(sp.getSpot().x, sp.getSpot().y + 1));
                    } else if (y < p.y && sp.getSpot().y > 0 && !available(sp.getSpot().x, sp.getSpot().y - 1)) {
                        nearest.setSpot(new Point(sp.getSpot().x, sp.getSpot().y - 1));
                    }
                }

                if (nearest.getSpot() == null) { // nothing found
                    if (x >= p.x && y >= p.y && !available(sp.getSpot().x + 1, sp.getSpot().y + 1)) {
                        nearest.setSpot(new Point(sp.getSpot().x + 1, sp.getSpot().y + 1));
                    } else if (x <= p.x && y <= p.y && sp.getSpot().x > 0 && sp.getSpot().y > 0 && !available(sp.getSpot().x - 1, sp.getSpot().y - 1)) {
                        nearest.setSpot(new Point(sp.getSpot().x - 1, sp.getSpot().y - 1));
                    }
                }

                if (nearest.getSpot() == null /*|| available(nearest.spot.x,nearest.spot.y)*/) {
                    JOptionPane.showMessageDialog(SpotImagePanel.this, "No possible spot position found.", "Cannot add spot here", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }

        }


        return nearest;
    }

    protected boolean available(int x, int y) {
        for (SpotPos sp : SpotImagePanel.this.spotPosList) {
            if (sp.getSpot().x == x && sp.getSpot().y == y) return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics gc) {
        // draw image
        if ((image == null) || (image.getWidth() != this.thumbWidth) || (image.getHeight() != this.thumbHeight) || (thumbWidth == 0) || (thumbHeight == 0) || (oldHeight != getHeight()) || (oldWidth != getWidth()) || fullImage.getWidth() <= 0 || fullImage.getHeight() <= 0) {
            oldWidth = getWidth();
            oldHeight = getHeight();
            //if (width>0 && height>0)
            {
                // image = new BufferedImage(width, height, fullImage.getType());
                // image.getGraphics().drawImage(fullImage,0,0,width, height,this);
                Runnable makeMap = new Runnable() {
                    private boolean creating = false;

                    public void run() {
                        if (creating) return;
                        if (fullImage == null) return;
                        creating = true;
                        if (fullImage == null) return;
                        int w = fullImage.getWidth();
                        int h = fullImage.getHeight();
                        if (w > 2000) {
                            w = 2000;
                            h = (int) (w * ((double) fullImage.getHeight() / fullImage.getWidth()));
                        }
                        if (h > 2000) {
                            h = 2000;
                            w = (int) (w * ((double) fullImage.getWidth() / fullImage.getHeight()));
                        }
                        image = fullImage.getPreviewImage(w, h);

                        // create scaled image with correct aspect ratio
                        w = SpotImagePanel.this.getVisibleRect().width;
                        h = SpotImagePanel.this.getVisibleRect().height;
                        w = SpotImagePanel.this.getBounds().width;
                        h = SpotImagePanel.this.getBounds().height;
                        int iw = w;
                        int ih = h;
                        if (image.getWidth() > image.getHeight()) {
                            ih = (int) (w * ((double) image.getHeight() / image.getWidth()));
                        } else {
                            iw = (int) (h * ((double) image.getWidth() / image.getHeight()));
                        }

                        if (ih > h) {
                            ih = h;
                            iw = (int) (ih * ((double) image.getWidth() / image.getHeight()));
                        }
                        if (iw > w) {
                            iw = w;
                            ih = (int) (iw * ((double) image.getHeight() / image.getWidth()));
                        }

                        iOffsX = 0;
                        iOffsY = 0;
                        if (iw < w) {
                            iOffsX = (w - iw) / 2;
                        }
                        if (ih < h) {
                            iOffsY = (h - ih) / 2;
                        }
                        thumbWidth = iw;
                        thumbHeight = ih;

                        scale = thumbWidth / (double) fullImage.getWidth();

                        if (thumbWidth > 0 && thumbHeight > 0) {
                            BufferedImage img = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
                            img.getGraphics().drawImage(image, 0, 0, thumbWidth, thumbHeight, SpotImagePanel.this);
                            image = img;
                        }
                        revalidate();
                        repaint();
                        creating = false;
                    }
                };
                SwingUtilities.invokeLater(makeMap);
            }
        }

        Rectangle bounds = this.getBounds();
        Graphics2D g = (Graphics2D) gc;
        g.setColor((Color) UIManager.get("Panel.background"));
        //thumbWidth = bounds.width;
        //thumbHeight =bounds.height;
        g.fillRect(0, 0, bounds.width, bounds.height);

        if (image != null && fullImage != null)
            g.drawImage(image, iOffsX, iOffsY, this);
        drawSpots(gc, iOffsX, iOffsY, scale);

    } // paintComponent

    public void drawSpots(Graphics gc, int iOffsX, int iOffsY, double scale) {
        Graphics2D g = (Graphics2D) gc;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        g.translate(iOffsX, iOffsY);
        g.scale(scale, scale);
        g.setFont(font);

        double fontScale = 16d / ((double) radius * 2d * 0.75d);
        //System.out.println("fontScale="+fontScale+" scale:"+scale+" radius:"+radius);

        String s;
        //g.setFont(font.deriveFont(AffineTransform.getScaleInstance(1d/scale, 1d/scale)));
        // draw spots
        if (spotPosList != null && spotPosList.size() > 0) {
            for (SpotPos sp : spotPosList.toArray(new SpotPos[0])) {
                Point spot = sp.getSpot();
                Point p = sp.getPos();
                if (spot == null) continue;
                //s = spot.x+"/"+spot.y;
                s = OrbitUtils.getWellName(spot.x, spot.y);
                g.setColor(Color.darkGray);
                g.scale(1d / fontScale, 1d / fontScale);
                //drawStringCentered(s,p.x,p.y,g);
                drawStringCentered(s, (int) (p.x * fontScale), (int) (p.y * fontScale), g);
                g.scale(fontScale, fontScale);
                //System.out.println("r: "+radius+" scale:"+scale);
                if (sp.isSelected()) g.setColor(Color.green);
                else g.setColor(Color.blue);
                g.drawArc(p.x - radius, p.y - radius, radius * 2, radius * 2, 0, 360);

            }
        }
    }


    private void drawStringCentered(String s, int px, int py, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = px - (fm.stringWidth(s) / 2);
        int y = py - (fm.getMaxDescent() / 2) + (fm.getMaxAscent() / 2);
        g.drawString(s, x, y);
    }

    public int getRadius() {
        return radius;
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public TiledImagePainter getFullImage() {
        return fullImage;
    }

    public void setFullImage(TiledImagePainter fullImage) {
        this.fullImage = fullImage;
        if (fullImage != null) {
            originalDimension = new Dimension(fullImage.getWidth(), fullImage.getHeight());
        }
    }

    public Dimension getOriginalDimension() {
        return originalDimension;
    }

    public void setOriginalDimension(Dimension originalDimension) {
        this.originalDimension = originalDimension;
    }


}