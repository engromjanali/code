/*
jPanel like a Frame.
we can use everything in Jpanel without Frame.

*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;

public class JPanel_1 extends JFrame{
    private JPanel jp1, jp2;
    private Container c;
    private JButton b1, b2;

    JPanel_1(){
        initCompo();
        setVisible(true);
        setBounds(10,10,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    private void initCompo(){
        c =  this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        jp1 = new JPanel();
        jp1.setBounds(10,10,200,300);
        c.add(jp1);

        jp2 = new JPanel();
        jp2.setBounds(220 ,10, 200,300);
        c.add(jp2);

        b1 = new JButton("xyz") ;
        jp1.add(b1);

        b2 = new JButton("yxz");
        jp2.add(b2);

    }
    public static void main(String[] args) {
        JPanel_1 frame = new JPanel_1();

    }
}
