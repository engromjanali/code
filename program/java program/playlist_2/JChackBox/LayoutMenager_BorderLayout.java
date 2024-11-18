/*
    #LayoutMenager

    1. BorderLayout // default Layout for JFrame
    2. FlowLayout
    3. BoxLayout
    4. GridLayout
    5. CardLayout
    6. GirdBagLayout
    7. GroupLayout
    8. SpringLayout
    9. ETC

    gap in layout..
    1. bl1 = new BorderLayout(50,50);  //fast way

        bl1 = new BorderLayout();  // 2nd way
        bl1.setHgap(20);
        bl1.setVgap(20);

 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;

public class LayoutMenager_BorderLayout extends JFrame{
    private BorderLayout bl1;
    private JButton b1,b2,b3,b4,b5;
    private Container c;

    LayoutMenager_BorderLayout(){
        initCompon();

        this.setVisible(true);
        setBounds(100,100,500,500);

    }

    public void initCompon(){
        
        bl1 = new BorderLayout();
        bl1.setHgap(20);
        bl1.setVgap(20);

        c  = this.getContentPane();
        c.setLayout(bl1);

       b1 = new JButton("bitton 1");
       b2 = new JButton("bitton 2");
       b3 = new JButton("bitton 3");
       b4 = new JButton("bitton 4");
       b5 = new JButton("bitton 5");

       c.add(b1,bl1.EAST);
       c.add(b2, bl1.WEST);
       c.add(b3,bl1.NORTH);
       c.add(b4,bl1.SOUTH);
       c.add(b5,bl1.CENTER);
    }
    
    public static void main(String[] args) {
        LayoutMenager_BorderLayout frame = new LayoutMenager_BorderLayout();
         
    }
    
}
