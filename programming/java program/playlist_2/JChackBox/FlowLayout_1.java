/*
    #FlowLayout // FlowLayout default in JPanel.

    gap in layout-----------------

        bl1 = new BorderLayout();
        bl1.setHgap(20);
        bl1.setVgap(20);

    change alignment!-----------------

        FL = new FlowLayout(FlowLayout.LEFT);
        
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;

public class FlowLayout_1 extends JFrame{
    private FlowLayout  FL;
    private JButton buttons [];
    private Container c;

    FlowLayout_1(){
        initCompon();

        this.setVisible(true);
        setBounds(100,100,500,500);

    }

    public void initCompon(){
        
        FL = new FlowLayout(FlowLayout.LEFT);
        FL.setHgap(50);
        FL.setVgap(50);

        

        c  = this.getContentPane();
        c.setLayout(FL);

        buttons = new JButton[15];
        for (int i =0; i<=14; i++){

            buttons[i] = new JButton("button"+i);   
            c.add(buttons[i]);

            }

        
       
    }
    
    public static void main(String[] args) {
        FlowLayout_1 frame = new FlowLayout_1();
         
    }
    
}
