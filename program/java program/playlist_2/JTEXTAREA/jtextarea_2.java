/*
1. setWrapStyleWord()//Defult close 
2. setLineWrap(true)//Defult close

*/

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class jtextarea_2 extends JFrame {

    private Container c ;
    private JTextArea ta1;
    private Font f;

    jtextarea_2(){
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

        f = new Font("arial",Font.ITALIC,18);
        
        ta1 = new JTextArea("write somthing...");
        ta1.setBounds(10,10,100,100);
        ta1.setFont(f);
        ta1.setBackground(Color.ORANGE);
        ta1.setForeground(Color.black);
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        c.add(ta1);
    }
    public static void main(String[] args) {
        jtextarea_2 frame = new jtextarea_2();
        
    }
}

