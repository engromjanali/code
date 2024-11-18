import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class jlabel_2 extends JFrame  {
    private static jlabel_2 frame;
    private ImageIcon icon;
    private JLabel userlabel;
    private JLabel passlabel;
    Container c ;

    jlabel_2(){

        initromjan();
    }

    private void initromjan(){

        icon = new ImageIcon(getClass().getResource("facebookIcon.png"));
        this.setIconImage(icon.getImage());

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);


        userlabel = new JLabel();
        userlabel.setText("enter your user neme : ");
        userlabel.setBounds(5,5,500,20);
        c.add(userlabel);

        passlabel = new JLabel();
        passlabel.setText("enter your password : ");
        passlabel.setBounds(5, 20,500,20);
        c.add(passlabel);

    }
    public static void main(String[] args) {

            frame = new jlabel_2();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
            frame.setBounds(100,100,500,500);
            frame.setTitle("https://www.facebook.com/romjanali01673");

        
    }
}
