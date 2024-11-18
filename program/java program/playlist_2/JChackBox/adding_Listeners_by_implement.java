/*
    implement the Listener enterface.
    override all of it's method
    add the listener with the component
    
*/
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class adding_Listeners_by_implement extends JFrame implements ActionListener{

    private Container c;
    private JComboBox jcb1;
    private JButton jb1;
    private Font f;
    private JLabel jl1, jl2;
    private String[] list = {"romjan","akhi","jamshed","sakib","jahid"}; //list 


    adding_Listeners_by_implement(){
        initCompnents();
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,400,500);
        setResizable(false);
        this.setResizable(true);


    }
    private void initCompnents(){

        setTitle("J Radio Button");
        setResizable(true);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        jl2 = new JLabel();
        jl2.setText("change background color as red color.");
        jl2.setBounds(10,30,250,30);
        jl2.setForeground(Color.white);
        c.add(jl2);

        jb1 = new JButton("black");
        jb1.setBounds(290,30,80,30);
        c.add(jb1);

        jcb1 = new JComboBox(list);
        jcb1.setBounds(280,120,80,30);
        jcb1.setBackground(Color.pink);
        jcb1.setForeground(Color.red);
        jcb1.setEditable(true);
        c.add(jcb1);

        jl1 = new JLabel();
        jl1.setText("hay kapil , who is your best friend !");
        jl1.setBounds(10,120,300,30);
        jl1.setForeground(Color.green);
        c.add(jl1);

        jb1.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        c.setBackground(Color.RED);
    }
    public static void main(String[] args) {
        adding_Listeners_by_implement frame = new adding_Listeners_by_implement();
    }
    
}

