/*
            //if (e.getSource()==jrb1){ //fast method 
            if (jrb1.isSelected()){  //2nd method 
 # how use class by implements ActionListener. 
 */
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButton_4 extends JFrame{

    private Container c ;
    private JLabel jl1;
    private JRadioButton jrb1, jrb2, jrb3;
    private ButtonGroup bg1;
    private JTextArea ta;
    private JScrollPane js;



    JRadioButton_4(){
        initCompnents();
    
        setVisible(true);
        setTitle("J Radio Button");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,400,500);
        setResizable(false);
    }
    private void initCompnents(){
        c =this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        bg1 = new ButtonGroup();

        jl1 = new JLabel();
        jl1.setText("hay gays please... choice 1!");
        jl1.setForeground(Color.white);
        jl1.setBounds(20,20,200,100);
        c.add(jl1); 

        jrb1 = new JRadioButton("family");
        jrb1.setBounds(50,120,100,30);
        c.add(jrb1);

        jrb2 = new JRadioButton("career");
        jrb2.setBounds(160,120,100,30);
        c.add(jrb2);

        jrb3 = new JRadioButton("best friends");
        jrb3.setBounds(270,120,100,30);
        c.add(jrb3);

        bg1.add(jrb1);
        bg1.add(jrb2);
        bg1.add(jrb3);



        ta= new JTextArea();
        //ta.setBounds(40,190,300,200);
        ta.setBackground(Color.pink);
        //c.add(ta);

        js = new JScrollPane(ta);
        js.setBounds(40,190,300,200);
        c.add(js);



        Handlers handler = new Handlers();
        jrb1.addActionListener(handler);
        jrb2.addActionListener(handler);
        jrb3.addActionListener(handler);
    }

    class Handlers implements ActionListener{

        public void actionPerformed (ActionEvent e){
            //if (e.getSource()==jrb1){ //fast method 
            if (jrb1.isSelected()){  //2nd method 
                ta.append("you have selected family!\n");
            }
            else if (jrb2.isSelected()){
                ta.append("you have selected career!\n");
            }
            else {
                ta.append("you have selected best friends!\n");
            }

            }
        }
    
    public static void main(String[] args) {
        JRadioButton_4 frame = new JRadioButton_4();

    }
}