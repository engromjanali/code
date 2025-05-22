import javax.swing.JOptionPane;

public class test1 {
    public static void main(String[] args) {
        int s = JOptionPane.showConfirmDialog(null," do you want to exit? ","confirmation message", JOptionPane.YES_NO_CANCEL_OPTION);
        if ( s == JOptionPane.YES_OPTION){
            System.out.println("you have clicked YES");
            System.out.println(s);
        }
        else if (s == JOptionPane.NO_OPTION){
            System.out.println("you have clicked NO");
            System.out.println(s);
        }
        else {
            System.out.println("you have clicked CANCEL");
            System.out.println(s);
        }
}
}