/*
# JTextArea
*/

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class jtextarea_1 extends JFrame {

    private Container c ;
    private JTextArea ta1;
    private Font f;

    jtextarea_1(){
        initcomponent ();
        setVisible(true);
        setBounds(100,100,500,500);
        setTitle("Romjan E-book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void initcomponent () {
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.black);

        f = new Font("arial",Font.ITALIC,10);
        
        ta1 = new JTextArea("write somthing...");
        ta1.setBounds(10,10,100,100);
        ta1.setFont(f);
        ta1.setBackground(Color.ORANGE);
        ta1.setForeground(Color.black);
        c.add(ta1);
    }
    public static void main(String[] args) {
        jtextarea_1 frame = new jtextarea_1();
        
    }
}