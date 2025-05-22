import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class textfield_5 extends JFrame{

    private Container c;
    public JTextField text1box , text2box;
    private Font f;


    textfield_5(){

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
        text2box.setBackground(Color.PINK);
        c.add(text2box);

        Handler handler = new Handler();//we can use any name 
        text1box.addActionListener(handler);
        text2box.addActionListener(handler);


    }

    class Handler implements ActionListener{//we can use any name as class name: Handler/test
        public void actionPerformed(ActionEvent e ){

            String s1 = text1box.getText();
            String s2 = text2box.getText();

            if (e.getSource()==text1box){
                if ( s1.isEmpty()){
                JOptionPane.showMessageDialog(null,"you have did not enter anything !");
                }

                else {
                JOptionPane.showMessageDialog(null, "text1bos = "+ s1);
                }
            }

            else if (e.getSource()==text2box){
                if(s2.isEmpty()){
                JOptionPane.showMessageDialog(null,"you have did not enter anything !");
                }

                else {
                JOptionPane.showMessageDialog(null, "text2bos = "+ s2);
                }
            }
        }
    }
    public static void main(String[] args) {

        textfield_5 frame = new  textfield_5();
        frame. setVisible(true);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        frame.setBounds(5,5,500,500);
        frame.setTitle(" romjan ali ");
    }
}
