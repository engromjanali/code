import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class Jcombobox extends JFrame {
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;

    public Jcombobox() {
        setTitle("Date of Birth Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new SpringLayout());

        // Day ComboBox
        dayComboBox = new JComboBox<>();
        for (int day = 1; day <= 31; day++) {
            dayComboBox.addItem(day);
        }
        add(new JLabel("Day:"));
        add(dayComboBox);

        // Month ComboBox
        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        add(new JLabel("Month:"));
        add(monthComboBox);

        // Year ComboBox
        yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int year = currentYear; year >= 1900; year--) {
            yearComboBox.addItem(year);
        }
        add(new JLabel("Year:"));
        add(yearComboBox);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = (int) dayComboBox.getSelectedItem();
                String month = (String) monthComboBox.getSelectedItem();
                int year = (int) yearComboBox.getSelectedItem();

                JOptionPane.showMessageDialog(Jcombobox.this, "Selected Date of Birth: " + day + " " + month + " " + year);
            }
        });
        add(new JLabel()); // Empty label for formatting
        add(submitButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Jcombobox());
    }
}
