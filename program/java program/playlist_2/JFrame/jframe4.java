import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Container;

public class jframe4 extends JFrame{
    private ImageIcon icon;
    private Container c ;

    jframe4(){
        initcomponents();

    }
    public void initcomponents(){

        //icon = new ImageIcon(getClass().getResource("facebookIcon.png"));
        //icon = new ImageIcon("facebookIcon.png");
        //this.setIconImage(icon.getImage()); // this mean 
        //c= this.getContentPane();
        //c.setBackground(Color.BLACK);

    }
    public static void main(String[] args) {
        jframe4 frame = new jframe4();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,199,500,300);
        frame.setTitle("romjan ali E - book");
        frame.setResizable(true);
        
    }
}
