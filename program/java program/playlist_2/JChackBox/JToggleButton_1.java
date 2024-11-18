/*
constractor of JToggleButton();
JToggleButton();
JToggleButton(String text);
JToggleButton(String text, Boolean Selectred);
JToggleButton(Icon icon);
JToggleButton(Icon icon , Boolean Selected);
JToggleButton(String text, Icon icon);
JToggleButton(String text, Icon icon, boolean selecred);
*/

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JToggleButton_1 extends JFrame {
    private JToggleButton jtb1;
    private JLabel jl1;
    private Container c;
    private ImageIcon Icon;
    JToggleButton_1(){
        initCo();

        setVisible(true);
        setBounds(100,100,500,500);
        setTitle("JToggleButton creating..");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
private void initCo(){

    c= this.getContentPane();
    Icon = new ImageIcon("asd.png");
    c.setLayout(null);

    jtb1 = new JToggleButton(Icon);
    jtb1.setBounds(100,100,200,200);
    c.add(jtb1);



    jl1 = new JLabel();
    jl1.setText("" );
    jl1.setBounds(10,400,180,30);
    c.add(jl1);

    Handler handler = new Handler();
    jtb1.addActionListener(handler);

}


class Handler implements ActionListener {
    public void actionPerformed(ActionEvent e){
        if (jtb1.isSelected()){
            jl1.setText("on");

        }
        else{
            jl1.setVisible(false);
        }

    }

}
     public static void main(String[] args) {
        JToggleButton_1 frame = new JToggleButton_1();
        
     }

}