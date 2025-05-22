import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample extends JFrame {

    private JTextField textField;

    public KeyListenerExample() {
        setTitle("KeyListener Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a JTextField
        textField = new JTextField();
        getContentPane().add(textField);

        // Add a KeyListener to the text field
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Handle key press events
                System.out.println("Key pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Handle key release events
                System.out.println("Key released: " + e.getKeyChar());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyListenerExample();
    }
}
