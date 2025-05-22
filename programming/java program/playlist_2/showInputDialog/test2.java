import javax.swing.JOptionPane;

public class test2 {
    public static void main(String[] args) {
        // by useing four paramitar (message & initialSelectionValue)
            /* 
            String F_name = JOptionPane.showInputDialog("Enter your fast name : ", "MD ROMJAN");
            JOptionPane.showMessageDialog(null,F_name);
            */
        // by useing four paramitar (position & message & title & message type)

        String fast_name = JOptionPane.showInputDialog(null, " enter your fast name: ", " colect data : " ,3);
        String last_name = JOptionPane.showInputDialog("enter your last name : ");
        String full_name = fast_name + last_name;
        JOptionPane.showMessageDialog(null,full_name,"preview",JOptionPane.INFORMATION_MESSAGE);



    }
}
