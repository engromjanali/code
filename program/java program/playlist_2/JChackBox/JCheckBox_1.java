/*
    JCheckBox()
    ItemListener()

*/
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBox_1 extends JFrame{

    private Container c ;
    private JLabel jl1;
    private JCheckBox jrb1, jrb2, jrb3;
    private ButtonGroup bg1;
    private JTextArea ta;
    private JScrollPane js;


    JCheckBox_1(){
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

        jrb1 = new JCheckBox("Python");
        jrb1.setBounds(50,120,100,30);
        //jrb1.setSelected(true);
        c.add(jrb1);

        jrb2 = new JCheckBox("Java");
        jrb2.setBounds(160,120,100,30);
        c.add(jrb2);

        jrb3 = new JCheckBox("HTML");
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



        Handler handler = new Handler();
        jrb1.addItemListener(handler);
        jrb2.addItemListener(handler);
        jrb3.addItemListener(handler);
    }

    class Handler implements ItemListener{
        
        public void itemStateChanged (ItemEvent e){

            //if (e.getSource()==jrb1){ //fast method 

            if (jrb1.isSelected()){  //2nd method 
                ta.append("you have selected python as a favorite language!\n");
            }
            else if (jrb2.isSelected()){
                ta.append("you have selected java as a favorite language!\n");
            }
            else if (jrb3.isSelected()) {
               ta.append("you have selected HTML as a favorite language!\n");
            }
            

            }
        }
    
    public static void main(String[] args) {
        JCheckBox_1 frame = new JCheckBox_1();

    }
}

