/*
    Font()
    setFont()

*/
import javax.swing.JFrame;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

public class jpasswordfield_2  extends JFrame {
    private JPasswordField pass1;
    private Container c;
    private Font f;
    jpasswordfield_2(){
        initcomponents();
    }

    private void initcomponents(){
        c = this.getContentPane();
        c.setBackground(Color.ORANGE   );
        c.setLayout(null);

        pass1 = new JPasswordField();
        pass1.setBounds(10,10,150,50);
        pass1.setEchoChar('#');
        pass1.setFont(f);
        c.add(pass1);

        f = new Font("Arial",Font.BOLD,24);


    }
    public static void main(String[] args) {
        jpasswordfield_2 frame = new jpasswordfield_2();
        frame.setVisible(true);
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE);
        frame.setBounds(100,100,500,500);
        frame.setTitle("romjan e-book");

    }
    

}
