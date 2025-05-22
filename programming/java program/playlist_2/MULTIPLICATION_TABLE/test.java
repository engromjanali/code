/*
 string to integer

    int num = Integer.parseInt(tf1.getText());

 int to string 

    String.valueof(xyz);

 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class test extends JFrame {

    private Container c ;
    private Font f;
    private JLabel image , jl1, jl2;
    private ImageIcon img;
    private JButton clear;
    private JTextField tf1;
    private JTextArea ta1;

    test(){
        initcomponent ();
    }

    private void initcomponent () {
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        clear =new JButton("clear");
        clear.setBounds(200,210,100,30);
        clear.setBackground(Color.ORANGE);
        c.add(clear);

        img = new ImageIcon(getClass().getResource("multiplication_table.jpeg"));

        image = new JLabel(img);
        image.setBounds(2,0, img.getIconWidth(), img.getIconHeight());
        //image.setHorizontalAlignment(JLabel.CENTER);
        c.add(image);

        f = new Font("arial",Font.ITALIC,16);
        
        jl1 = new JLabel();
        jl1.setText("Enter any number : ");
        jl1.setBounds(20,170,200,30);
        jl1.setFont(f);
        c.add(jl1);

        tf1 = new JTextField("");
        tf1.setBounds(200,175,100,30);
        c.add(tf1);

        ta1 = new JTextArea();
        ta1.setBounds(25,250,250,250);
        ta1.setText(" ");
        c.add(ta1);

        tf1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e ){
                String value = tf1.getText();
                if (value.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You didn't put eny number!");
                }
                else{

                int num = Integer.parseInt(tf1.getText());
                ta1.setText("");
                for ( int i = 1 ; i<=10; i++){
                    int result = num * i;

                    String r = String.valueOf(result);
                    String n = String.valueOf(num);
                    String inc = String.valueOf(i);

                    ta1.append(n+" X "+ inc +" = "+ r + "\n");

                }
            }
        }
        } );
    

        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf1.setText("");
                
            }
        });
    }
    public static void main(String[] args) {
        test frame = new test();
        frame.setVisible(true);
        frame.setBounds(100,100,320,550);
        frame.setTitle("Multiplication Table");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

