/*
        c  = this.getContentPane();
        CL = new CardLayout();
        c.setLayout(CL);

            CL.previous(c);
            CL.next(c);


        
 */

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayout_1 extends JFrame{
    private CardLayout CL;
    private JButton JB1,JB2,JB3,JB4,JB5;
    private Container c;


    CardLayout_1(){
        initCompon();

        this.setVisible(true);
        setBounds(100,100,500,500);

    }

    public void initCompon(){
        
        

        c  = this.getContentPane();
        CL = new CardLayout();
        c.setLayout(CL);

    JB1 = new JButton("b1");
    JB2 = new JButton("b2");
    JB3 = new JButton("b3");
    JB4 = new JButton("b4");
    JB5 = new JButton("b5");
    c.add(JB1);
    c.add(JB2);
    c.add(JB3);
    c.add(JB4);
    c.add(JB5);
    Handler hand = new Handler();
    JB1.addActionListener(hand);
    JB2.addActionListener(hand);
    JB3.addActionListener(hand);
    JB4.addActionListener(hand);
    JB5.addActionListener(hand);


    }
    class Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CL.previous(c);
        }

    }
    public static void main(String[] args) {
        CardLayout_1 frame = new CardLayout_1();
         
    }
    
}
