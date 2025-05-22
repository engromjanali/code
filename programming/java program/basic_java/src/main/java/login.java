import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

public class login extends JFrame{
    private ImageIcon background, ICON;
    private Container C;
    private JLabel bg_image, welcome;
    private JTextField username,passwordx;
    private JPasswordField password;
    private Font font;
    private JButton login, register,Forgot;


    login(){
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null); // for center location
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        setTitle("Login Page");

        background  = new ImageIcon(this.getClass().getResource("background.jpg"));
        ICON = new ImageIcon(this.getClass().getResource("RWO_AMS.png"));
        setIconImage(ICON.getImage());
        bg_image = new JLabel(background);
        bg_image.setSize(500,500);

        font = new Font("arial", Font.PLAIN, 20);

        C = this.getContentPane();
        C.setLayout(null);
        C.setBackground(Color.gray);
        //C.add(bg_image);

        welcome= new JLabel();
        welcome.setBounds(100, 50,400,30);
        welcome.setText("Welcome to ROW_AMS Library!");
        welcome.setFont(font);
        C.add(welcome);

        username = new JTextField("Ënter Your User ID");
        username.setBounds(130,120,220,40);
        username.setToolTipText("enter your user ID!");
        C.add(username);



        password = new JPasswordField();
        password.setToolTipText("enter your password!");
        //password.setText("enter your password!");
        password.setVisible(false);
        password.setBounds(130,180,220,40);
        C.add( password);

        passwordx= new JTextField();
        passwordx.setText("enter your password!");
        passwordx.setBounds(130,180,220,40);
        C.add( passwordx);



        login = new JButton();
        login.setText("Login");
        login.setBounds(100, 350, 100,30);
        C.add(login);

        register = new JButton();
        register.setText("register");
        register.setBounds(300, 370, 100,30);
        C.add(register);

        Forgot = new JButton();
        Forgot.setText("Forgot");
        Forgot.setBounds(300, 300, 100,30);
        C.add(Forgot);

    }

    public static void main(String[] args) {
        login frame = new login();
    }
}