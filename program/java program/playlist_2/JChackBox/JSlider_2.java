/*
creat rgb color
    Color color = new Color(red,green,blue); // every color limitation(0-255)
        */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Container;

public class JSlider_2 extends JFrame implements ChangeListener{
    private Container c;
    private JSlider Jsgreen, Jsred, Jsblue;
    private JPanel JPANEL;
    private JLabel preview, jlGreen, jlred, jlblue;
    private JTextField green, red, blue;
    

    JSlider_2(){
        initCompo();
        setVisible(true);
        setBounds(10,10,700,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("color macker ");

    }
    private void initCompo(){
        
        c =  this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        JPANEL = new JPanel();
        JPANEL.setBounds(460,100,200,200);
        JPANEL.setBackground(Color.WHITE);
        c.add(JPANEL);

        preview = new JLabel();
        preview.setText("preview");
        preview.setForeground(Color.WHITE);
        preview.setBounds(530,310,100,20);
        c.add(preview);

        jlred = new JLabel();
        jlred.setBounds(10,50,80,20);
        jlred.setText("Red Color");
        jlred.setForeground(Color.white);
        c.add(jlred);

        jlGreen = new JLabel();
        jlGreen.setBounds(10,110,80,20);
        jlGreen.setText("Green Color");
        jlGreen.setForeground(Color.white);
        c.add(jlGreen);

        jlblue = new JLabel();
        jlblue.setBounds(10,170,80,20);
        jlblue.setText("Blue Color");
        jlblue.setForeground(Color.white);
        c.add(jlblue);

        Jsred = new JSlider(0,255,0);
        Jsred.setBounds(100,40,250,40);
        Jsred.setMajorTickSpacing(85);
        Jsred.setMinorTickSpacing(5);
        Jsred.setPaintTicks(true);
        Jsred.setPaintLabels(true);
        c.add(Jsred);

        Jsgreen = new JSlider(0,255,0);
        Jsgreen .setBounds(100,100,250,40);
        Jsgreen .setMajorTickSpacing(85);
        Jsgreen .setMinorTickSpacing(5);
        Jsgreen .setPaintTicks(true);
        Jsgreen .setPaintLabels(true);
        c.add(Jsgreen );

        Jsblue = new JSlider(0,255,0);
        Jsblue.setBounds(100,160,250,40);
        Jsblue.setMajorTickSpacing(85);
        Jsblue.setMinorTickSpacing(5);
        Jsblue.setPaintTicks(true);
        Jsblue.setPaintLabels(true);
        c.add(Jsblue);

        green = new JTextField();
        green .setBounds( 360,40,80,40);
        c.add(green);

        red = new JTextField();
        red .setBounds( 360,100,80,40);
        c.add(red);

        blue = new JTextField();
        blue .setBounds( 360,160,80,40);
        c.add(blue);

        Jsgreen.addChangeListener(this);
        Jsred.addChangeListener(this);
        Jsblue.addChangeListener(this);
    } 
    public void stateChanged(ChangeEvent e ){

        int greenValue = Jsgreen.getValue();
        int redValue = Jsred.getValue();
        int blueValue = Jsblue.getValue();

        green.setText(""+greenValue);
        red.setText(""+redValue);
        blue.setText(""+blueValue);

        Color color = new Color(redValue,greenValue,blueValue);
        JPANEL.setBackground(color);
    }
    public static void main(String[] args) {
        JSlider_2 frame = new JSlider_2();
    }
}
