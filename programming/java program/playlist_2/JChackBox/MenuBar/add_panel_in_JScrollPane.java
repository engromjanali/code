import javax.swing.*;
import java.awt.*;

public class add_panel_in_JScrollPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrollable Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a JPanel with a layout
        JPanel panel = new JPanel(new GridLayout(20, 1)); // Example grid layout

        // Add some components to the panel (just for demonstration purposes)
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Label " + (i + 1));
            panel.add(label);
        }

        // Create a JScrollPane and add the panel to it
        JScrollPane scrollPane = new JScrollPane(panel);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
