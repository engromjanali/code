/*
    mouse motion

    e.getX();
    e.getY();
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListener_1 extends JFrame {
    private Container c;
    private JLabel jl1;
    private JTextArea jta1;
    private JTextField jtf1;

    MouseMotionListener_1(){
        initcomponent();
    }
    private void initcomponent(){
        c =  this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        jl1 = new JLabel() ;
        jl1.setBounds(10,10,100,30);
        jl1.setText("go to JTextArea");
        jl1.setForeground(Color.white);
        c.add(jl1);

        jta1 = new JTextArea();
        jta1.setBounds(50,100,300,200);
        c.add(jta1);

        jtf1 = new JTextField();
        jtf1.setBounds(200,10,150,40);
        c.add(jtf1);

        Handler handler = new Handler();
        jta1.addMouseMotionListener(handler);
    }
    
    class Handler implements MouseMotionListener{

        public void mouseMoved(MouseEvent e){
            jtf1.setText("mouse moved! "+e.getX()+" "+e.getY());

        }
        public void mouseDragged(MouseEvent e ){
            jtf1.setText("mouse dragged "+e.getX()+" "+e.getY());
            
        }
    }

    public static void main(String[] args) {
        MouseMotionListener_1 frame = new MouseMotionListener_1();
        frame.setVisible(true);
        frame.setBounds(10,10,400,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}