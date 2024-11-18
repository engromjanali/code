/*
    #FlowLayout // FlowLayout default in JPanel.

    how to declear BoxLayout.
    1.    BL = new BoxLayout(c,BoxLayout.X_AXIS);  // horizontal
    2.    BL = new BoxLayout(c,BoxLayout.Y_AXIS);  //virtical


    gap in layout-----------------


    change alignment!-----------------

        
 */

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;

public class BoxLayout_1 extends JFrame{
    private BoxLayout  BL;
    private JButton JB1,JB2,JB3,JB4,JB5;
    private Container c;

    BoxLayout_1(){
        initCompon();

        this.setVisible(true);
        setBounds(100,100,500,500);

    }

    public void initCompon(){
        
        

        c  = this.getContentPane();
        BL = new BoxLayout(c,BoxLayout.X_AXIS);
        c.setLayout(BL);

    JB1 = new JButton("b1");
    JB2 = new JButton("b1");
    JB3 = new JButton("b1");
    JB4 = new JButton("b1");
    JB5 = new JButton("b1");
    c.add(JB1);
    c.add(JB2);
    c.add(JB3);
    c.add(JB4);
    c.add(JB5);

/* 
        buttons = new JButton[15];
        for (int i =0; i<=14; i++){

            buttons[i] = new JButton("button"+i);   
            c.add(buttons[i]);
            c.add(BL.creareHorizontalStrut(5));

            }
            */

    }
    
    public static void main(String[] args) {
        BoxLayout_1 frame = new BoxLayout_1();
         
    }
    
}
