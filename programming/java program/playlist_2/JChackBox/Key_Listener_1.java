/*
    # keyListener---

    1. keyPressed();
    2. keyTyped();
    3. keyReleased();
    
*/
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Key_Listener_1 extends JFrame implements KeyListener{

    private Container c;
    private JTextField jtf1;
    private JLabel jl2;
    private JTextArea jta1;
    
    Key_Listener_1(){
        initCompnents();
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,400,500);
        setResizable(false);
        this.setResizable(true);

    }
    private void initCompnents(){

        setTitle("J Radio Button");
        setResizable(true);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        jl2 = new JLabel();
        jl2.setText("write somting on the textFeild: ");
        jl2.setBounds(10,30,250,30);
        jl2.setForeground(Color.white);
        c.add(jl2);

        jtf1 = new JTextField();
        jtf1.setBounds(280,30,80,30);
        jtf1.setBackground(Color.green);
        c.add(jtf1);

        jta1 = new JTextArea();
        jta1.setBounds(40,100,300,300);
        c.add(jta1);

    jtf1.addKeyListener(this);
}

    public void keyTyped(KeyEvent e){
        jta1.append("you have typed : "+e.getKeyChar()+"\n");
    }
    
    public void keyPressed(KeyEvent e){
        jta1.append("you have pressed: "+e.getKeyChar()+"\n");
    }
    public void keyReleased(KeyEvent e){
        jta1.append("you have released : "+e.getKeyChar()+"\n");
    }

    public static void main(String[] args) {
        Key_Listener_1 frame = new Key_Listener_1();
    }
}