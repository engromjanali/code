/*
# MouseListener 

 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseLIstener_1 extends JFrame {
    private Container c;
    private JLabel jl1;
    private JTextArea jta1;
    private JTextField jtf1;

    mouseLIstener_1(){
        initcomponent();
    }
    private void initcomponent(){
        c =  this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        jl1 = new JLabel() ;
        jl1.setBounds(10,10,100,30);
        jl1.setText("go to JTextFeild");
        jl1.setForeground(Color.white);
        c.add(jl1);

        jta1 = new JTextArea();
        jta1.setBounds(50,100,300,200);
        c.add(jta1);

        jtf1 = new JTextField();
        jtf1.setBounds(200,10,100,40);
        c.add(jtf1);

        Handler handler = new Handler();
        jtf1.addMouseListener(handler);

    }
    class Handler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            jta1.append("you have clicked \n");
            }

        @Override
        public void mousePressed(MouseEvent e) {
            jta1.append("you have pressed \n");
             }

        @Override
        public void mouseReleased(MouseEvent e) {
            jta1.append("you have Release the mouse. \n");
           }

        @Override
        public void mouseEntered(MouseEvent e) {
            jta1.append("you have entered the mouse. \n");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jta1.append("you have Exied the mouse. \n");
        }

    }

    public static void main(String[] args) {
        mouseLIstener_1 frame = new mouseLIstener_1();
        frame.setVisible(true);
        frame.setBounds(10,10,400,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

}