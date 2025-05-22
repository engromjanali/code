import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class JColorChooser_1 extends JFrame implements ActionListener {
    private Container C;
    private JButton Button;
    private ImageIcon icon;
    JColorChooser_1(){
        initComponent();
        setVisible(true);
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ColorChooser Frame....");
        setResizable(true);

    } 
    public void initComponent(){
        C = this.getContentPane();
        C.setLayout(null);

        icon = new ImageIcon(getClass().getResource("Icon.JPG"));
        this.setIconImage(icon.getImage());
        Button = new JButton("pick a color");
        Button.setBounds(100,100,100,30);
        C.add(Button);

        Button.addActionListener(this);

    }
            public void actionPerformed(ActionEvent e )
            {
                Color color = JColorChooser.showDialog(null,"pick a color" ,Color.YELLOW);
                C.setBackground(color);
            }

    public static void main(String[] args) {
        JColorChooser_1 frame = new JColorChooser_1();
    }

}
