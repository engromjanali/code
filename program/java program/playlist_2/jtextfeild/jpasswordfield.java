/*
    JPasswordFeild()
    setEchoChar()
*/

import javax.swing.JFrame;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Container;

public class jpasswordfield  extends JFrame {
    private JPasswordField pass1;
    private Container c;
    jpasswordfield(){
        initcomponents();
    }

    private void initcomponents(){
        c = this.getContentPane();
        c.setBackground(Color.ORANGE   );
        c.setLayout(null);

        pass1 = new JPasswordField();
        pass1.setBounds(10,10,150,50);
        pass1.setEchoChar('#');
        c.add(pass1);





    }
    public static void main(String[] args) {
        jpasswordfield frame = new jpasswordfield();
        frame.setVisible(true);
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE);
        frame.setBounds(100,100,500,500);
        frame.setTitle("romjan e-book");

    }
    

}
