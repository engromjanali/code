import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class fast_page extends JFrame{
    private Container c;
    private JLabel jl1;
    private Font f;

    fast_page(){

        initcomponent();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//dispose fast page and stil open login page.
        setTitle("romjanali01673");
        setBounds(100,100,500,500);

    }
    public void initcomponent(){

        
//  container --------------------------------
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

//  font ------------------------------------------------
        f = new Font("arial",Font.BOLD,14);

//  JLabel------------------------------------------------------
        jl1 = new JLabel();
        jl1.setText("welcome to blackRA");
        jl1.setBounds(10,10,300,20);
        jl1.setForeground(Color.WHITE);
        jl1.setFont(f);
        c.add(jl1);
    }
    public static void main(String[] args) {
        fast_page frame =new fast_page();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("romjanali01673");
        frame.setBounds(100,100,500,500);

    }
}
