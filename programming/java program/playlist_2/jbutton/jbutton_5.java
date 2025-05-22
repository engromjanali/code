/*
1. acction licener

*/

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class jbutton_5 extends JFrame{
    private Container c;
    private JButton button_1, button_2; 
    private JTextField tf1;



    jbutton_5(){
        initcomponent();

    }
    public void initcomponent(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        tf1 = new JTextField("enter your user_name! & hit the submit button.");
        tf1.setBounds(100,10,300,40);
        c.add(tf1);

        button_1 = new JButton("clear");
        button_1.setBounds(100,200,100,20);
        c.add(button_1);

        button_2 = new JButton("Submit");
        button_2. setBounds(210,200,100,20);
        c.add(button_2);


        button_1.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e){
                tf1.setText(" ");
            }
        });

        button_2.addActionListener(new  ActionListener(){
            public void actionPerformed(ActionEvent e ){
                tf1.setText("you have successfully submited your info!");

        }
        });
    }

    public static void main(String[] args) {
        jbutton_5 frame =new jbutton_5();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("romjanali01673");
        frame.setBounds(100,100,500,500);

    }
}