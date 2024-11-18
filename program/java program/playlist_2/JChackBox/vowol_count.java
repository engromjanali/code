/*
            if (ke.VK_A ==ke.getKeyCode()){
                total_vowol ++;
                total_a ++;
            }

*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class vowol_count extends JFrame implements KeyListener{

    int total_vowol = 0;
    int total_a = 0;
    int total_i = 0;
    int total_o = 0;
    int total_u = 0;
    int total_e = 0;
    int typed = 0;

    private Container c;
    private JLabel a,i,o,u,e,total,jl1,co;
    private JTextArea ta;

    vowol_count(){
        initcomponent();
        setVisible(true);
        setTitle("vowol counting frame");
        setBounds(100,100,400,500);

    }
    public void initcomponent(){
        c= this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.gray);
        c.setForeground(Color.green);

        ta = new JTextArea();
        ta.setBounds(100,20,150,80);
        c.add(ta);

        jl1 = new JLabel();
        jl1.setText("write somthing..... ");
        jl1.setBounds(10,20,100,30);
        c.add(jl1);

        total = new JLabel();
        total.setText("");
        total.setBounds(100,100,100,30);
        c.add(total);

        a = new JLabel();
        a.setText("");
        a.setBounds(100,140,100,30);
        c.add(a);

        i = new JLabel();
        i.setText("");
        i.setBounds(100,180,100,30);
        c.add(i);

        o = new JLabel();
        o.setText("");
        o.setBounds(100,220,100,30);
        c.add(o);
        
        u = new JLabel();
        u.setText("");
        u.setBounds(100,260,100,30);
        c.add(u);

        e = new JLabel();
        e.setText("");
        e.setBounds(100,300,100,30);
        c.add(e);

        co = new JLabel();
        co.setBounds(100,340,150,30);
        c.add(co);

        ta.addKeyListener(this);
    }
    public void keyTyped(KeyEvent ke){
       
        total.setText("total vowol : "+ total_vowol);
        a.setText("total vowol : "+ total_a);
        i.setText("total vowol : "+ total_i);
        o.setText("total vowol : "+ total_o);
        u.setText("total vowol : "+ total_u);
        e.setText("total vowol : "+ total_e);
        co.setText("total typed : "+ typed);
    }
    public void keyPressed(KeyEvent ke){
        System.out.println(ke.getKeyCode());
        if (ke.getSource() == ta){
            if (ke.VK_A ==ke.getKeyCode()){
                total_vowol ++;
                total_a ++;
                
            }
            
            else if (ke.VK_I ==ke.getKeyCode()){
                total_vowol ++;
                total_i ++;
            }
            else if (ke.VK_O ==ke.getKeyCode()){
                total_vowol ++;
                total_o ++;
            }
            else if (ke.VK_U ==ke.getKeyCode()){
                total_vowol ++;
                total_u ++;
            }
            else if (ke.VK_E ==ke.getKeyCode()){
                total_vowol ++;
                total_e ++;
            }
            else {
                typed ++;
            }
}

    }
    public void keyReleased(KeyEvent ke){

    }


    public static void main(String[] args) {
        vowol_count frame = new vowol_count();
    }
}
