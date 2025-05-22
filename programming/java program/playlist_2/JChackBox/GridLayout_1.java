/*
        c  = this.getContentPane();
        GL = new GridLayout(2,3,5,5);
        c.setLayout(GL);


        
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridLayout;

public class GridLayout_1 extends JFrame{
    private GridLayout  GL;
    private JButton JB1,JB2,JB3,JB4,JB5;
    private Container c;

    GridLayout_1(){
        initCompon();

        this.setVisible(true);
        setBounds(100,100,500,500);

    }

    public void initCompon(){
        
        

        c  = this.getContentPane();
        GL = new GridLayout(2,3,5,5);
        c.setLayout(GL);

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


    }
    
    public static void main(String[] args) {
        GridLayout_1 frame = new GridLayout_1();
         
    }
    
}
