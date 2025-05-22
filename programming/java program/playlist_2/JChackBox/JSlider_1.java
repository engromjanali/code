/*
    1. JSlider();  // default Constrtactor 
    2. JSlider(min , max, nob_initial_Value);  
    3. JSlider(position, min , max, nob_initial_Value);  
        Js1 = new JSlider(JSlider.VERTICAL, 0, 50, 20);

        */

import javax.swing.JFrame;
import javax.swing.JSlider;

import java.awt.Color;
import java.awt.Container;

public class JSlider_1 extends JFrame{
    private Container c;
    private JSlider Js1;

    JSlider_1(){
        initCompo();
        setVisible(true);
        setBounds(10,10,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    private void initCompo(){
        c =  this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        Js1 = new JSlider(JSlider.VERTICAL,0,50,20);
        Js1.setBounds(100,100,300,80);
        Js1.setMajorTickSpacing(5);
        Js1.setMinorTickSpacing(1);
        Js1.setPaintTicks(true);  // SHOW MEJOR AND MINOR LAVEL
        Js1.setPaintLabels(true);  //SHOW MEJOR NUMBER 
        c.add(Js1);

    } 
    public static void main(String[] args) {
        JSlider_1 frame = new JSlider_1();
    }
}
