/* 

Alignment setup
    ext1box.setHorizontalAlignment(JTextField.CENTER);
    ext1box.setHorizontalAlignment(JTextField.RIGHT);
    ext1box.setHorizontalAlignment(JTextField.LEFT);

*/ import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class textfield_3 extends JFrame{

    private Container c;
    private JTextField text1box , text2box;
    private Font f;


    textfield_3(){

        initcomponent();
    }

    public void initcomponent(){
        f = new Font("castellar",Font.BOLD,14);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        text1box = new JTextField();
        text1box.setFont(f);
        text1box.setText("enter your user name : ");
        text1box.setBounds(50,50,500,50);
        c.add(text1box);
        text1box.setBackground(Color.orange);
        text1box.setForeground(Color.magenta);
        text1box.setHorizontalAlignment(JTextField.CENTER);


        text2box = new JTextField("enter your password");
        text2box.setBounds(50,110,500,50);
        c.add(text2box);
        text2box.setBackground(Color.PINK);





    }
    public static void main(String[] args) {

        textfield_3 frame = new  textfield_3();
        frame. setVisible(true);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        frame.setBounds(5,5,500,500);
        frame.setTitle(" romjan ali ");


        
    }
}
