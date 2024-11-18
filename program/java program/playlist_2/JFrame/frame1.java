/*
1.  setVisible()
2.  setDefaultCloseOpratrion()
3.  setSize()
4.  setLocation()
5.  setLocationRelativeTo()
6.  setBounds()
7.  setTitle()
8.  setResizable()
*/

import javax.swing.JFrame;

public class frame1 extends JFrame { // by inherit!

    public static void main(String[] args) {
        frame1 fr = new frame1();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the profram by close the frame
        fr.setSize(400, 300); // set size.
        fr.setLocationRelativeTo(null);//set location for medel
        fr.setLocation(500, 50);//set location by custom
        fr.setBounds(500, 100, 500, 500);// set size and location by bounds. 
        fr.setTitle(" romjan e-book" );
        fr.setResizable(true);
    }
}