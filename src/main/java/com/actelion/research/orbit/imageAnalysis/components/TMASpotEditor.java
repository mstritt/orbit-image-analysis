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

import com.actelion.research.orbit.imageAnalysis.models.SpotPos;
import com.actelion.research.orbit.imageAnalysis.utils.TiledImagePainter;
import com.actelion.research.orbit.utils.RawUtilsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.media.jai.PlanarImage;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TMASpotEditor extends JDialog {

    private static final long serialVersionUID = 1L;
    protected final Logger logger = LoggerFactory.getLogger(TMASpotEditor.class);
    protected List<SpotPos> spotPosList = null;
    protected SpotImagePanel imagePanel = null;
    protected int startRadius = 7;
    private final JButton btnAccept = new JButton("Accept & Close    ");

    public TMASpotEditor(final Map<Point, Point> spotMap, double radius, final TiledImagePainter image, boolean editable) {
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(OrbitImageAnalysis.class.getResource(OrbitImageAnalysis.LOGO_NAME)).getImage());
        setTitle("TMA Spot Editor");
        this.startRadius = (int) radius;
        this.spotPosList = new ArrayList<SpotPos>();
        for (Point pos : spotMap.keySet()) {
            spotPosList.add(new SpotPos(pos, spotMap.get(pos)));
        }
        imagePanel = new SpotImagePanel(spotPosList, startRadius, editable);
        imagePanel.setFullImage(image);

        // menu
        JMenuBar menuBar = new JMenuBar();

        JMenu info = new JMenu("Info");
        JMenuItem item = new JMenuItem("Show Info");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TMASpotEditor.this, "TMA Spot Editor\n\nMove spots to correct positions,\nuse right-click to add new spots or to remove spots.", "TMA Spot Editor", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        info.add(item);
        menuBar.add(info);

        // toolbar
        JToolBar toolBar = new JToolBar("TMA Spot Editor Toolbar", JToolBar.HORIZONTAL);
        toolBar.setFloatable(false);
        JButton btnSetImage = new JButton("Set Image");
        btnSetImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCurrentImage();
            }
        });
        toolBar.add(btnSetImage);

//		toolBar.addSeparator();
//		JButton btnGridDims = new JButton("Grid Dimensions");
//		btnGridDims.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setupGridDimensions();
//			}
//		});
//		toolBar.add(btnGridDims);
        toolBar.addSeparator();

        final JLabel spinnerLab = new JLabel("Radius:");
        toolBar.add(spinnerLab);

        final JSpinner spinner = new JSpinner();
        spinner.setToolTipText("Spot Radius");
        spinner.setValue(startRadius);
        spinner.setPreferredSize(new Dimension((int) (spinner.getPreferredSize().width * 1.5), spinner.getPreferredSize().height));
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                imagePanel.setRadius((Integer) (spinner.getValue()));
                imagePanel.repaint();
            }
        });
        toolBar.add(spinner);

        btnAccept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                setVisible(false);
            }
        });
        toolBar.add(Box.createHorizontalGlue());
        toolBar.add(btnAccept);


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(imagePanel, BorderLayout.CENTER);


        //table = new TMAExcelTable<Object[]>();

        JButton assignBtn = new JButton("Assign");
        assignBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(TMASpotEditor.this, "This functionality is in the current version not supported.", "Feature not supported", JOptionPane.WARNING_MESSAGE);
                //assignNames();
            }
        });
//		JPanel assignPanel = new JPanel(new BorderLayout());
//		assignPanel.add(assignBtn,BorderLayout.NORTH);
//		assignPanel.add(new JScrollPane(table),BorderLayout.CENTER);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Spots", panel);
        //tabs.add("Assignment",assignPanel);

        setSize(new Dimension(400, 600));
        setLayout(new BorderLayout());
        setJMenuBar(menuBar);
        add(tabs, BorderLayout.CENTER);
    }

	/*
    private void assignNames() {
		ExcelTableModel<Object[]> model = table.getModel();
		if (model.getRowCount()<1) {
			JOptionPane.showMessageDialog(this, "Please insert some data rows first.", "No data rows awailable", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// mark all as "not found"
		for (int rowIdx=0; rowIdx<model.getRowCount(); rowIdx++) {
			Object[] row = model.getRows().get(rowIdx);
			JLabel pos = (JLabel)row[0]; // first column defines spotPos
			pos.setForeground(Color.black);
			pos.setFont(pos.getFont().deriveFont(Font.PLAIN));
		}

		for (SpotPos spotPos : spotPosList) {
			String search1 = AparUtils.getWellName(spotPos.getSpot().x, spotPos.getSpot().y);
			String search2 = AparUtils.getWellNameShort(spotPos.getSpot().x, spotPos.getSpot().y);
			if (logger.isTraceEnabled()) logger.trace("search: "+search1+"/"+search2+" spot:"+spotPos.getSpot());

			for (int rowIdx=0; rowIdx<model.getRowCount(); rowIdx++) {
				Object[] row = model.getRows().get(rowIdx);
				JLabel pos = (JLabel)row[0]; // first column defines spotPos
				if (pos!=null && pos.getText()!=null && pos.getText().length()>0) {
					String posTxt = pos.getText().toUpperCase().trim();
					if ((RawUtils.findRegex(search1+"[^0-9]", posTxt+" ")!=null) || (RawUtils.findRegex(search2+"[^0-9]", posTxt+" ")!=null)) {
						pos.setForeground(Color.blue);
						pos.setFont(pos.getFont().deriveFont(Font.BOLD));
						StringBuilder sb = new StringBuilder();
						for (int col=1; col<model.getColumnCount(); col++) {
							String s = (String)model.getValueAt(rowIdx, col);
							if (s!=null && s.length()>0) {
								sb.append(s.replaceAll("\\|", "-")+"|");
							}
						}
						if (sb.length()>0) sb.deleteCharAt(sb.length()-1);
						spotPos.setName(sb.toString());
						if (logger.isTraceEnabled()) logger.trace(""+spotPos);
					}
				}

			}
		}
		table.repaint();
	}
	*/

    private void setCurrentImage() {
        ImageFrame iFrame = OrbitImageAnalysis.getInstance().getIFrame();
        if (iFrame != null) {
            imagePanel.setFullImage(iFrame.recognitionFrame.bimg);
        }
        repaint();
    }

    private void setupGridDimensions() {

    }


    public SpotImagePanel getImagePanel() {
        return imagePanel;
    }


    public void setImagePanel(SpotImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }


    public List<SpotPos> getSpotPosList() {
        return spotPosList;
    }


    public void setSpotPosList(List<SpotPos> spotPosList) {
        this.spotPosList = spotPosList;
    }


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        BufferedImage img = new BufferedImage(300, 500, BufferedImage.TYPE_INT_RGB);
        img.getGraphics().setColor(Color.white);
        img.getGraphics().fillRect(0, 0, img.getWidth(), img.getHeight());

        TiledImagePainter dummy = new TiledImagePainter(PlanarImage.wrapRenderedImage(img), "Dummy");
        Map<Point, Point> spotMap = new HashMap<Point, Point>();
        spotMap.put(new Point(20, 20), new Point(0, 0));
        spotMap.put(new Point(20, 100), new Point(0, 1));
        spotMap.put(new Point(20, 180), new Point(0, 2));
        spotMap.put(new Point(20, 260), new Point(0, 3));
        spotMap.put(new Point(20, 340), new Point(0, 4));

        spotMap.put(new Point(80, 20), new Point(1, 0));
        spotMap.put(new Point(80, 100), new Point(1, 1));
        spotMap.put(new Point(80, 180), new Point(1, 2));
        spotMap.put(new Point(80, 260), new Point(1, 3));
        spotMap.put(new Point(80, 340), new Point(1, 4));

        spotMap.put(new Point(140, 20), new Point(2, 0));
        spotMap.put(new Point(140, 100), new Point(2, 1));
        spotMap.put(new Point(140, 180), new Point(2, 2));
        spotMap.put(new Point(140, 260), new Point(2, 3));
        spotMap.put(new Point(140, 340), new Point(2, 4));


        TMASpotEditor editor = new TMASpotEditor(spotMap, 18, dummy, true);
        editor.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        RawUtilsCommon.centerComponent(editor);
        editor.setVisible(true);
    }


}
