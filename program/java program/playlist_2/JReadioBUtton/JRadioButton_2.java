/*
  creat a method for "we can choice only one button"
  pravate ButtonGroup bg1;

  bg1 = new ButtonGroup();
  xyz
  bg1.add(jrb1);
  bg1.add(jrb2);// we have to use the add method in under of JRadioButton.
 */
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Container;

public class JRadioButton_2 extends JFrame{

    private Container c ;
    private JLabel jl1;
    private JRadioButton jrb1, jrb2, jrb3;
    private ButtonGroup bg1;

    JRadioButton_2(){
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

        bg1 = new ButtonGroup();

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

        bg1.add(jrb1);
        bg1.add(jrb2);
        bg1.add(jrb3);
    }
    public static void main(String[] args) {
        JRadioButton_2 frame = new JRadioButton_2();

    }
}