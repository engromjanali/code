import javax.swing.*;

public class CustomConfirmDialog extends JOptionPane {

    public static int showCustomConfirmDialog(String message, String[] options) {
        int result = JOptionPane.CLOSED_OPTION;

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();

        // Create buttons based on the options array
        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(e -> {
                // Set the result based on the button clicked
                result = Integer.parseInt(getActionCommand());
                // Close the dialog
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(buttonPanel);
                dialog.dispose();
            });
            buttonPanel.add(button);
        }

        // Create the custom confirmation dialog
        JOptionPane.showOptionDialog(null, message, "Custom Confirmation", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, new Object[]{buttonPanel}, null);

        return result;
    }

    public static void main(String[] args) {
        // Test the custom confirmation dialog
        String[] options = {"Yes", "No", "Cancel"};
        int choice = showCustomConfirmDialog("Do you want to proceed?", options);
        System.out.println("Choice: " + choice);
    }
}
