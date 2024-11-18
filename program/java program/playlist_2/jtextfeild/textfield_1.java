import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class textfield_1 extends JFrame{

    private Container c;
    private JTextField text1 , text2;


    textfield_1(){

        initcomponent();
    }

    public void initcomponent(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        text1 = new JTextField();
        text1.setText("enter your user name : ");
        text1.setBounds(50,50,500,50);
        c.add(text1);


        text2 = new JTextField("enter your password");
        text2.setBounds(50,110,500,50);
        c.add(text2);





    }
    public static void main(String[] args) {

        textfield_1 frame = new  textfield_1();
        frame. setVisible(true);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        frame.setBounds(5,5,500,500);
        frame.setTitle(" romjan ali ");


        
    }
}
