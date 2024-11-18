/*
how to add image on jlavel.

1. name.getIconWidth(); // to get image width
2. naem.getIconHeight();  // to get image height
*/
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class jlabel_7 extends JFrame{
    private ImageIcon icon;
    private ImageIcon image;

    private JLabel userlabel;
    private JLabel passlabel;
    private JLabel ImageLabel;
    Container c ;
    private Font f;

    jlabel_7(){

        initromjan();
    }

    private void initromjan(){

        icon = new ImageIcon(getClass().getResource("facebookIcon.png"));
        this.setIconImage(icon.getImage());

        image = new ImageIcon(getClass().getResource("profosonal image.png"));
        ImageLabel = new JLabel( image );
        // ImageLabel.setBounds(50,50,10,10);//fast way 
        ImageLabel.setBounds(50,50,image.getIconWidth(),image.getIconHeight());// 2nd way 

        
        

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
        String x = passlabel.getText();// use of getText method
        passlabel.setToolTipText("enter a strong password!");//setToolTipText()
        String y =passlabel.getToolTipText();//getToolTipText

        c.add(ImageLabel);


        int i = image.getIconWidth();
        int j = image.getIconHeight();
        System.out.println(x);
        System.out.println(y);
        System.out.println(i + " "+ j );

    }
    public static void main(String[] args) {

            jlabel_7 frame = new jlabel_7();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
            frame.setBounds(100,100,500,500);
            frame.setTitle("https://www.facebook.com/romjanali01673");

        
    }
}
