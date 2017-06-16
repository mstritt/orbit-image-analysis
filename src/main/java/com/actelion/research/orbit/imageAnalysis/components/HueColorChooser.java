package com.actelion.research.orbit.imageAnalysis.components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HueColorChooser extends JDialog implements ChangeListener {

    private float[] hsb = new float[3];   // For holding HSB color components.
    private JSlider hueSlider;
    private JLabel hueLabel, wavelengthLabel;
    private JPanel colorCanvas;  // Color patch for displaying the color.
    private JButton btnOk = new JButton("ok");
    private JButton btnCancel = new JButton("cancel");

    private float selectedHue = 0f;
    private int returnValue = JOptionPane.CANCEL_OPTION;

    public HueColorChooser(float initialHue) {

        setTitle("Hue Chooser");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setModal(true);

        hsb[0] = initialHue;
        hsb[1] = 1f;
        hsb[2] = 1f;
        hueSlider = new JSlider(0,255,(int)(255*hsb[0]));
        hueLabel = new JLabel(String.format(" Hue = %1.5f", hsb[0]));
        wavelengthLabel = new JLabel(String.format(" Wavelength = %1.5f", hsb[1]));
        hueSlider.addChangeListener(this);

        colorCanvas = new JPanel();
        colorCanvas.setBackground(Color.getHSBColor(hsb[0],hsb[1],hsb[2]));
        colorCanvas.setPreferredSize(new Dimension(200,200));

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnValue = JOptionPane.CANCEL_OPTION;
                HueColorChooser.this.setVisible(false);
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnValue = JOptionPane.OK_OPTION;
                HueColorChooser.this.setVisible(false);
            }
        });

        /* Set up the GUI */

        setLayout(new BorderLayout());
        add(colorCanvas,BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new GridLayout(3,1));
        centerPanel.add(hueLabel);
        centerPanel.add(hueSlider);

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(btnOk);
        btnPanel.add(btnCancel);

        centerPanel.add(btnPanel);

        add(centerPanel,BorderLayout.CENTER);

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setLocation( (screensize.width - getWidth()) / 2,
                (screensize.height - getHeight()) / 2);

    }



    public void stateChanged(ChangeEvent evt) {
        JSlider source = (JSlider)evt.getSource();
        if ( ! source.getValueIsAdjusting() ) {
            return;
        }
        hsb[0] = hueSlider.getValue()/255.0F;
        hsb[1] = 1f;
        hsb[2] = 1f;
        selectedHue = hsb[0];
        hueLabel.setText(String.format(" Hue = %1.5f", hsb[0]));
        wavelengthLabel.setText(String.format(" Wavelength = %1.5f", hue2nm(hsb[0])));
        colorCanvas.setBackground(Color.getHSBColor(hsb[0],hsb[1],hsb[2]));
        colorCanvas.repaint();  
    }

    private float hue2nm(float hue) {
        return  (620f - 170f / 270f) * hue;
    }

    private float nm2hue(float wavelength) {
        float Gamma = 0.80f,
                IntensityMax = 255,
                factor, red, green, blue;
        if((wavelength >= 380) && (wavelength<440)){
            red = -(wavelength - 440) / (440 - 380);
            green = 0.0f;
            blue = 1.0f;
        }else if((wavelength >= 440) && (wavelength<490)){
            red = 0.0f;
            green = (wavelength - 440) / (490 - 440);
            blue = 1.0f;
        }else if((wavelength >= 490) && (wavelength<510)){
            red = 0.0f;
            green = 1.0f;
            blue = -(wavelength - 510) / (510 - 490);
        }else if((wavelength >= 510) && (wavelength<580)){
            red = (wavelength - 510) / (580 - 510);
            green = 1.0f;
            blue = 0.0f;
        }else if((wavelength >= 580) && (wavelength<645)){
            red = 1.0f;
            green = -(wavelength - 645) / (645 - 580);
            blue = 0.0f;
        }else if((wavelength >= 645) && (wavelength<781)){
            red = 1.0f;
            green = 0.0f;
            blue = 0.0f;
        }else{
            red = 0.0f;
            green = 0.0f;
            blue = 0.0f;
        };
        // Let the intensity fall off near the vision limits
        if((wavelength >= 380) && (wavelength<420)){
            factor = 0.3f + 0.7f*(wavelength - 380) / (420 - 380);
        }else if((wavelength >= 420) && (wavelength<701)){
            factor = 1.0f;
        }else if((wavelength >= 701) && (wavelength<781)){
            factor = 0.3f + 0.7f*(780 - wavelength) / (780 - 700);
        }else{
            factor = 0.0f;
        };
        if (red != 0f){
            red = Math.round(IntensityMax * Math.pow(red * factor, Gamma));
        }
        if (green != 0f){
            green = Math.round(IntensityMax * Math.pow(green * factor, Gamma));
        }
        if (blue != 0f){
            blue = Math.round(IntensityMax * Math.pow(blue * factor, Gamma));
        }
        return Color.RGBtoHSB((int)red,(int)green,(int)blue,null)[0];
    }

    public float getSelectedHue() {
        return selectedHue;
    }

    public void setSelectedHue(float selectedHue) {
        this.selectedHue = selectedHue;
    }

    public int getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(int returnValue) {
        this.returnValue = returnValue;
    }

    public static void main(String[] args) {
       HueColorChooser hc = new HueColorChooser(0.62f);
       hc.setVisible(true);
    }


}  
