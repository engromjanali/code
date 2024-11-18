/*
 create JReadioButton
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Container;

public class JRadioButton_1 extends JFrame{

    private Container c ;
    private JLabel jl1;
    private JRadioButton jrb1, jrb2, jrb3;

    JRadioButton_1(){
        initCompnents();

        setVisible(true);
        setTitle("J Radio Button");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,400,500);
        setResizable(false);
    }
    private void initCompnents(){
        c =this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        jl1 = new JLabel();
        jl1.setText("hay gays please... choise 1!");
        jl1.setForeground(Color.white);
        jl1.setBounds(20,20,200,100);
        c.add(jl1); 

        jrb1 = new JRadioButton("family");
        jrb1.setBounds(50,120,100,30);
        c.add(jrb1);

        jrb2 = new JRadioButton("Gril friend");
        jrb2.setBounds(160,120,100,30);
        c.add(jrb2);

        jrb3 = new JRadioButton("best friends");
        jrb3.setBounds(270,120,100,30);
        c.add(jrb3);

    }
    public static void main(String[] args) {
        JRadioButton_1 frame = new JRadioButton_1();

    }
}