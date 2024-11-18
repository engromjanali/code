import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slaideshow_1 extends JFrame {
    private Container c;
    private CardLayout CLayout;
    private JLabel JL;
    private JPanel JP;
    private JButton jb1,jb2;
    private ImageIcon img;
    
    Slaideshow_1(){
        initComponents();
        inages();
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,300,400);
        setTitle("romjan ali-1");

    }
    public void inages(){
        String [] image = {"1.JPG","2.JPG","3.JPG","4.JPG","5.JPG","6.JPG"};
        for(String n: image) {
            img = new ImageIcon("E:/java program/playlist_2/slaidShow/photos/"+n);

            // resize Image 
                Image im = img.getImage();
                Image new_img = im.getScaledInstance(JP.getWidth(),JP.getHeight(),  Image.SCALE_SMOOTH);
                img = new ImageIcon(new_img);

                JL = new JLabel(img);
                JP.add(JL);
        }

    }


    public void initComponents(){
        CLayout = new CardLayout();

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        JP = new JPanel(CLayout); // add CardLayout in JPanel.
        JP.setBounds(2,0,280,300);
        c.add(JP);

        jb1 = new JButton();
        jb1.setText("previous");
        jb1.setBounds(5,310,100,30);
        c.add(jb1);

        jb2 = new JButton("next");
        jb2.setBounds(180,310,100,30);
        c.add(jb2);

        Handler handler = new Handler();
        jb1.addActionListener(handler);
        jb2.addActionListener(handler);

    }
class Handler implements ActionListener{

    public void actionPerformed(ActionEvent e){
          if (jb1==e.getSource()){
            CLayout.previous(JP);
        }
        else if (jb2==e.getSource()){
            CLayout.next(JP);
        }
    }
}

    public static void main(String[] args) {

        Slaideshow_1 frame = new Slaideshow_1();
    }
}

