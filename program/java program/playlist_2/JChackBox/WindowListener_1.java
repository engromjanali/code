/*
    # WindowListener

    1. WindowOpen()
    2. WindowClosing()
    3. WindowClosed()
    4. WondowIconifid()
    5. WindowDeiconifid()
    6. WindowActivated()
    7. WindowDeactivate()

*/

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowListener_1 extends JFrame {
    private Container c;
         
    
    WindowListener_1(){
        initcomponent();
        setVisible(true);
        setBounds(100,100,400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    private void initcomponent(){

        c = this.getContentPane();
        c.setBackground(Color.pink);
        


        Handler handler = new Handler();
        this.addWindowListener( handler);

    }

    class Handler implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("window opened");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println(" window Closing");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            System.out.println(" window Closed");//it won't work becouse we was use (EXIT_ON_CLOSE) that's why!
        }

        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println(" window Iconifid");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println("Windown Deicnifid");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println(" Window Activated" );
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("window Deactivated");
        }


    }
    public static void main(String[] args) {
        WindowListener_1 frame = new WindowListener_1();

    }
}
