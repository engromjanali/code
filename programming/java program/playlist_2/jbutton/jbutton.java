import javax.swing.JButton;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;

public class jbutton extends JFrame{

    private Container c;
    private Font f;
    private JButton b1,b2;


    jbutton(){
        initcomponents();
    }
    public void initcomponents(){


        f = new Font("arial", Font.BOLD,18);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.red);

        b1 = new JButton("button 1 ");
        b1.setBounds(100,100,100,50);
        b1.setFont(f);
        c.add(b1);

        b2 = new JButton(" button 2");
        b2.setBounds(210,100,100,50);
        b2.setBackground(Color.pink);
        b2.setForeground(Color.green);
        c.add(b2);
        }
    public static void main(String[] args) {
        jbutton frame = new jbutton();
        frame.setVisible(true);
        frame.setBounds(10,10,500,500);
        frame.setTitle("button make : ");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
