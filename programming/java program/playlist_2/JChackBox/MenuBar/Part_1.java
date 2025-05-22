import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Part_1 extends JFrame implements ActionListener{
    private Container c;
    private JMenu Home,Edit,Help;
    private JMenuBar menubar;
    private JMenuItem Cut, Copy,Paste,Selectall;
    private JMenuItem Contact;
    private JMenuItem New,Open,Save,Exit;
    private ImageIcon CopyIcon, CutIcon, ExitIcon,NewIcon,OpenIcon,PasteIcon,SaveIcon,Select_AllIcon;

    int n = 0;
    Part_1(){
        setTitle("MenuBar");
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initcomponent();
 
    }
public void initcomponent(){
    c = this.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.black);

    menubar = new JMenuBar();
    menubar.setBackground(Color.gray);
    this.setJMenuBar(menubar);

    Home = new JMenu("Home");
    menubar.add(Home);

    Edit = new JMenu("Edit");
    menubar.add(Edit);

    Help = new JMenu();
    Help.setText("Help");
    menubar.add(Help);

    menuItem();
    icon();
    }
public void icon(){
    CutIcon = new ImageIcon("Cut.png");
    CopyIcon = new ImageIcon("Copy.png");
    PasteIcon = new ImageIcon("Paste.png");
    Select_AllIcon = new ImageIcon("Select All.png");
    SaveIcon = new ImageIcon("Save.png");
    NewIcon = new ImageIcon("New.png");
    OpenIcon = new ImageIcon("Open.png");
    ExitIcon = new ImageIcon("Exit.png");

    New .setIcon(NewIcon);
    Open .setIcon(OpenIcon);
    Save .setIcon(SaveIcon);
    Exit .setIcon(ExitIcon);
    Copy .setIcon(CopyIcon);
    Cut.setIcon(CutIcon);
    Paste .setIcon(PasteIcon);
    Selectall .setIcon(Select_AllIcon);
}

private  void menuItem(){
    New = new JMenuItem("New");
    New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));

    Open = new JMenuItem("Open");
    Save = new JMenuItem("Save");
    Exit = new JMenuItem("Exit");

    Copy = new JMenuItem("Copy");
    Cut = new JMenuItem("Cut");
    Paste = new JMenuItem("Paste");
    Selectall =  new JMenuItem(" Select All");

    Contact = new JMenuItem("help");

    Home.add(New);
    Home.add(Open);
    Home.add(Save);
    Home.addSeparator();
    Home.add(Exit);

    Edit.add(Copy);
    Edit.add(Cut);
    Edit.add(Paste);
    Edit.add(Selectall);
    
    Help.add(Contact);

    AddActionlistener();
}
private void AddActionlistener(){

    New.addActionListener(this);
    Open.addActionListener(this);
    Save.addActionListener(this);
    Exit.addActionListener(this);

    Copy.addActionListener(this);
    Cut.addActionListener(this);
    Paste.addActionListener(this);
    Selectall.addActionListener(this);

    Contact.addActionListener(this);
    
}

public void actionPerformed(ActionEvent e){
    if(e.getSource()==New){
        n++;
        JFrame frame2 = new JFrame();
        frame2.setLocation(500,20);
        frame2.setSize(200,200);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame2.setTitle("page"+n);
    }
    else if(e.getSource()==Exit){
        System.exit(0);
    }
}
    public static void main(String[] args) {
        Part_1  frame= new Part_1();
        frame.setVisible(true);
    }
}
