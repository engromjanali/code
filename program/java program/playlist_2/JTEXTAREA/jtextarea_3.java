/*
# JScrollPane metod. // when we use JScrollPane we have to use setBounds. and remove setBounds from textarea.
       
        js = new JScrollPane(ta1);
        js.setBounds(10,10,100,100);
        c.add(js);
*/

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class jtextarea_3 extends JFrame {

    private Container c ;
    private JTextArea ta1;
    private Font f;
    private JScrollPane js;

    jtextarea_3(){
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
        //.setBounds(10,10,100,100);
        ta1.setFont(f);
        ta1.setBackground(Color.ORANGE);
        ta1.setForeground(Color.black);
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        //c.add(ta1);
        
        js = new JScrollPane(ta1);
        js.setBounds(10,10,100,100);
        c.add(js);
    }
    public static void main(String[] args) {
        jtextarea_3 frame = new jtextarea_3();
        
    }
}