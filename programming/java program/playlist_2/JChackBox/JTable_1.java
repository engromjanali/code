

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTable_1 extends JFrame {
    private JLabel label;
    private ImageIcon icon;
    private Container c;
    private JTable table;
    private JScrollPane Scroll;
    private Font font;
    private String[] col = {"name", "age", "ID number"};
    private String [][] row = {

                                {"MD ROMJAN ALI", "19", "677844"},
                                {"KAPIL UDDIN", "17", "677829"},
                                {"SAKIB MIA", "18", "677845"},
                                {"MD JAHIDUL ISLAM", "19", "677828"},
                                {"KOMOLASH MOHANTHA", "19", "677819"},
                                {"NOR  ALAM SARKAR", "16", "984903"},

                                {"MD ROMJAN ALI karim mst rasheda akter ", "19", "677844"},
                                {"KAPIL UDDIN", "17", "677829"},
                                {"SAKIB MIA", "18", "677845"},
                                {"MD JAHIDUL ISLAM", "19", "677828"},
                                {"KOMOLASH MOHANTHA", "19", "677819"},
                                {"NOR  ALAM SARKAR", "16", "984903"},

                                };

    
    

    JTable_1 (){
        initcom();
        setVisible(true);
        setBounds(100,100,500,500);
        setTitle(" table data ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initcom(){
        icon = new ImageIcon("WhatsApp Image 2024-02-05 at 11.57.54_bf0679d8.jpg");
        this.setIconImage(icon.getImage());

        font = new Font("arial",Font.BOLD,16);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        label = new JLabel();
        label.setText("student Details");
        label.setFont(font);
        label.setForeground(Color.pink);
        label.setBounds(170,20,200,30);
        c.add(label);

        table = new JTable(row,col);
        table.setSelectionBackground(Color.MAGENTA);
        //table.setEnabled(false);
        Scroll = new JScrollPane(table);
        Scroll.setBounds(50,70,400,350);
        c.add(Scroll);

    }
    public static void main(String[] args) {
        JTable_1 frame = new JTable_1();



    }
}
