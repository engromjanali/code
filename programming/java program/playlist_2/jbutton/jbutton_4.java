/*
1. set image in button.

*/


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;


public class jbutton_4 extends JFrame {


    private Container c;
    private Font f;
    private JButton b1,b2;
    private Cursor cursor;
    private ImageIcon Image_1 ,Image_2;
 




    jbutton_4(){

        initcomponents();
    }
    public void initcomponents(){

        Image_1 = new ImageIcon(getClass().getResource("yes.png"));
        Image_2 = new ImageIcon(getClass().getResource("no.png"));

        cursor = new Cursor(Cursor.HAND_CURSOR);//Cursor

        f = new Font("arial", Font.BOLD,18);
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.red);

        b1 = new JButton(Image_1);
        b1.setBounds(100,100,100,50);
        b1.setFont(f);
        b1.setCursor(cursor);//setCursor
        c.add(b1);

        b2 = new JButton(Image_2);
        b2.setBounds(210,100,100,50);
        b2.setBackground(Color.pink);
        b2.setForeground(Color.green);
        c.add(b2);
        }
    public static void main(String[] args) {
        jbutton_4 frame = new jbutton_4();
        frame.setVisible(true);
        frame.setBounds(10,10,500,500);
        frame.setTitle("button make : ");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
