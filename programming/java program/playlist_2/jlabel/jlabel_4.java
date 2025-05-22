/*
setOpaque()
setBackground()
setForeground()  //mean text color!
*/


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class jlabel_4  extends JFrame{
    private static jlabel_4 frame;
    private ImageIcon icon;
    private JLabel userlabel;
    private JLabel passlabel;
    Container c ;
    private Font f;

    jlabel_4(){

        initromjan();
    }

    private void initromjan(){

        icon = new ImageIcon(getClass().getResource("facebookIcon.png"));
        this.setIconImage(icon.getImage());

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        f = new Font("arial",Font.ITALIC,24);// how to creat Font ?

        userlabel = new JLabel();
        userlabel.setText("enter your user neme : ");
        userlabel.setBounds(5,5,300,40);

        c.add(userlabel);//added to container.
        userlabel.setFont(f);//setFont Font.
        userlabel.setForeground(Color.red);// set text color.
        userlabel.setOpaque(true);//mean we want to change Text background color.
        userlabel.setBackground(Color.yellow);// set text background color.


        passlabel = new JLabel("enter your password : ");
        //passlabel.setText("enter your password : ");
        passlabel.setBounds(5, 20,500,80);
        c.add(passlabel);

    }
    public static void main(String[] args) {

            frame = new jlabel_4();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
            frame.setBounds(100,100,500,500);
            frame.setTitle("https://www.facebook.com/romjanali01673");

        
    }
}
