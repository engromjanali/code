import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javafx.scene.image.Image;
public class test1 {
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("C:/Users/romja/Desktop/MD ROMJAN ALI .jpg");
        
        String name  = JOptionPane.showInputDialog("enter your name : ");
        JOptionPane.showMessageDialog(null, name+ " welcome to swing! ", " WRNING", 3,image);


        
    }
}
