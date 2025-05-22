/*

Need a icon()
Make an objest of imageIcon class()
getClass()
getResource()
setIconImage() 
getImage()

*/

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;

public class jframe3 extends JFrame{

    private ImageIcon ICON;
    private Container c;

    jframe3(){
        initcomponents();
    }
    public void initcomponents(){

 
        ICON = new ImageIcon(getClass().getResource("RWO_AMS.png"));
        this.setIconImage(ICON.getImage()); // this mean frame
        c = this.getContentPane();
        c.setBackground(Color.BLACK);
    }
    public static void main(String[] args) {
        jframe3 frame = new jframe3();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,199,500,300);
        frame.setTitle("romjan ali E - book");
        frame.setResizable(true);



        
    }
}
