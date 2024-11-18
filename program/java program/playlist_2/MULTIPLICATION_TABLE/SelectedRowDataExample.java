import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectedRowDataExample extends JFrame {
    private JTable table;
    private JLabel selectedRowDataLabel;

    public SelectedRowDataExample() {
        setTitle("Selected Row Data Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Sample data for the table
        Object[][] data = {
                {"John", 25, "Male"},
                {"Alice", 30, "Female"},
                {"Bob", 35, "Male"}
        };

        // Column names
        String[] columnNames = {"Name", "Age", "Gender"};

        // Create a table with sample data
        table = new JTable(data, columnNames);

        // Add a ListSelectionListener to the table
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // Check if a row is selected
                        Object name = table.getValueAt(selectedRow, 0);
                        Object age = table.getValueAt(selectedRow, 1);
                        Object gender = table.getValueAt(selectedRow, 2);

                        // Display selected row data
                        selectedRowDataLabel.setText("Selected Row Data: Name=" + name + ", Age=" + age + ", Gender=" + gender);
                    }
                }
            }
        });

        // Create a label to display selected row data
        selectedRowDataLabel = new JLabel("Selected Row Data:");

        // Add components to the frame
        getContentPane().add(new JScrollPane(table));
        getContentPane().add(selectedRowDataLabel, "South");

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelectedRowDataExample();
            }
        });
    }
}
