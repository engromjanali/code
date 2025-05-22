import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class MessageDialog3{
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon ("download.png");
        JOptionPane.showMessageDialog(null,"password!","wrning", 3,image);
    }
}