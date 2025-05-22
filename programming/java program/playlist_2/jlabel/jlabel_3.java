import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class jlabel_3 extends JFrame {
    private static jlabel_3 frame;
    private ImageIcon icon;
    private JLabel userlabel;
    private JLabel passlabel;
    Container c ;
    private Font f;

    jlabel_3(){

        initromjan();
    }

    private void initromjan(){

        icon = new ImageIcon(getClass().getResource("facebookIcon.png"));
        this.setIconImage(icon.getImage());

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        f = new Font("arial",Font.ITALIC,14);// how to creat Font ?

        userlabel = new JLabel();
        userlabel.setText("enter your user neme : ");
        userlabel.setBounds(5,5,500,20);
        c.add(userlabel);
        userlabel.setFont(f);

        passlabel = new JLabel();
        passlabel.setText("enter your password : ");
        passlabel.setBounds(5, 20,500,20);
        c.add(passlabel);

    }
    public static void main(String[] args) {

            frame = new jlabel_3();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
            frame.setBounds(100,100,500,500);
            frame.setTitle("https://www.facebook.com/romjanali01673");

        
    }
}
