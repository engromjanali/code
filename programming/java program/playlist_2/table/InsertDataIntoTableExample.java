import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDataIntoTableExample extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public InsertDataIntoTableExample() {
        setTitle("Insert Data Into Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Initialize table model with column names
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");      
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");

        // Create a table with the initialized table model
        table = new JTable(tableModel);

        // Create a button to add new data
        JButton addButton = new JButton("Add Data");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a new row with sample data
                Object[] rowData = {"New Person", 40, "Unknown"};
                tableModel.addRow(rowData);
            }
        });

        // Add components to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        getContentPane().add(addButton, BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InsertDataIntoTableExample();
            }
        });
    }
}
