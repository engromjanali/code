import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonExample {
    int selectedCount;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Select 2 out of 3 RadioButtons");
        JPanel panel = new JPanel();

        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        JRadioButton radioButton3 = new JRadioButton("Option 3");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        // Counter to keep track of selected radio buttons
        int selectedCount = 0;

        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JRadioButton) e.getSource()).isSelected()) {
                    selectedCount++;

                    // Check if more than 2 radio buttons are selected, then deselect the last one
                    if (selectedCount > 2) {
                        ((JRadioButton) e.getSource()).setSelected(false);
                        selectedCount--;
                    }
                } else {
                    selectedCount--;
                }
            }
        };

        radioButton1.addActionListener(radioListener);
        radioButton2.addActionListener(radioListener);
        radioButton3.addActionListener(radioListener);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
