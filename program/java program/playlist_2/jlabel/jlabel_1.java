import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class jlabel_1 extends JFrame {
    private Container c;
    private JLabel userlavel;
    

    jlabel_1(){
        initcomponent();
    }
    private void initcomponent(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);
        
        userlavel = new JLabel();
        userlavel.setText("enter your userneme : ");
        userlavel.setBounds(5, 5, 500,20);

        c.add(userlavel);
   
    }
    public static void main(String[] args) {
        jlabel_1 frame = new jlabel_1();
        frame.setVisible(true);
        frame.setBounds(120,128,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setTitle("E-Book");

        
    }
}
