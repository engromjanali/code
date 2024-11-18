/*
    # FocusListener

    1. Focus gain 
    2. Focus lost
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;


public class FocusListener_1 extends JFrame {
    private Container c;
    private JTextArea jta1,jta2;
    private JButton jb1;

    FocusListener_1(){
        initcomponent();
    }
    private void initcomponent(){
        c =  this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
 
        jta2 = new JTextArea() ;
        jta2.setBounds(10,10,100,30);
        jta2.setText("go to JTextArea");
        c.add(jta2);

        jta1 = new JTextArea();
        jta1.setBounds(50,100,300,200);
        c.add(jta1);

        jb1 = new JButton("button");
        jb1.setBounds(200,10,150,40);
        c.add(jb1);

        jb1.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent ef){
            jta1.setText("focus gained! ");
            

        }
        @Override
        public void focusLost(FocusEvent ef ){
            jta1.setText("focus lost");
            
        }
        });
    }

    public static void main(String[] args) {
        FocusListener_1 frame = new FocusListener_1();
        frame.setVisible(true);
        frame.setBounds(10,10,400,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}