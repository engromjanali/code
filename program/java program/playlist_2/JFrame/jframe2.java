/*
import javax.swing.JFrame;

public class jframe2 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(123,112,342,355);
        frame.setTitle("E-Book");
        

        
    }

}
*/

//   # ----------       another way  ------------------  


import javax.swing.JFrame;
public class jframe2 extends JFrame{

    jframe2(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50,500,400);
        setTitle("E_book");

    }
    public static void main ( String[]args){
        jframe2 frame = new jframe2();
        frame.setVisible( true );


    }
}
 

