/*
    # set tabbed location 

        1.  Jtp1 = new JTabbedPane(JTabbedPane.RIGHT);

        2.  Jtp1 = new JTabbedPane();
            Jtp1.setTabPlacement(JTabbedPane.BOTTOM);

    # setIcon with tab

        1. Jtp1.addTab(Title, Jpanel);

        2. tp1.addTab(Title, Icon, Jpanel, ToolTipText);

        3. Jtp1.addTab(Title, Icon, Jpanel);
 */

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPane_1 extends JFrame{
    private JPanel panel1,panel2, panel3;
    private Container c;
    private JTabbedPane Jtp1;
    private JLabel label1, label2, label3;
    private ImageIcon IconHome, IconInfo, IconContact;


    JTabbedPane_1(){
        initComponent();
        setVisible(true);
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("romjan ali 01673 ");
    }
    public void initComponent(){
        IconHome = new ImageIcon("Home.png");
        IconInfo = new ImageIcon("Info.png");
        IconContact = new ImageIcon("Contact.jpg");

        label1 = new JLabel("this is  Home");
        label2 = new JLabel("this is info");
        label3 = new JLabel("this is contact");


        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        Jtp1 = new JTabbedPane(JTabbedPane.RIGHT);
        Jtp1.setBounds(50,50,400,400);
        c.add(Jtp1);

        panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.add(label1);

        panel2 = new JPanel();
        panel2.setBackground(Color.red);
        panel2.add(label2);

        panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.add(label3);

        Jtp1.addTab("Home",IconHome,panel1,"This is home page");
        Jtp1.addTab("info",IconInfo,panel2,"This is info Page ");
        Jtp1.addTab("contact",IconContact, panel3, "this is Contact page ");


    }
    public static void main(String[] args) {
        JTabbedPane_1 frame = new JTabbedPane_1();
    }
}
