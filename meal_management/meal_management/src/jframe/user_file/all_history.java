/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe.user_file;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jframe.admin_file.Admin_home;
import jframe.method_romjanali01673.DB_connection;
import jframe.home_page;


public class all_history extends javax.swing.JFrame {
    int id;

    public all_history(int id) {
        this.id = id;
        initComponents();
        set_profile();
        set_table1();
        set_table2();
    }
    public void set_profile(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "select fast_name,last_name from student_data where user_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String a = rs.getString("fast_name");
                String b = rs.getString("last_name");
                
                name.setText(a+ " "+ b+ " - "+ id);                
            }
            
            pst.close();
            rs.close();
        }catch(Exception e ){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    

   public void set_table1(){
            Connection con = DB_connection.getConnection();
       try{
            Statement st = con.createStatement();
            String sql = "select * from book_history inner join book_data on book_history.book_id=book_data.book_id where book_history.student_id = "+id;
            ResultSet rs = st.executeQuery(sql);
            // the while loop will add a row by eatch 1 looping.
            while(rs.next()){
                
                String book_id = rs.getString("book_id");
                String book_name = rs.getString("book_name");
                String book_author = rs.getString("author");
                String book_type = rs.getString("book_type");
                String book_part = rs.getString("book_part");
                String time = rs.getString("T_time");
                String date = rs.getString("T_date");
                String book_status = rs.getString("T_status");

                Object[] obj = {book_id,book_name,book_author,book_type,book_part,time,date,book_status};
                DefaultTableModel model = (DefaultTableModel) table_data.getModel();
                model.addRow(obj);
            }        st.close();
        rs.close();
       }catch(Exception E){
           E.printStackTrace();
       }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
   }
  public void set_table2(){
            Connection con = DB_connection.getConnection();
       try{
            Statement st = con.createStatement();
            String sql = "select * from student_history where user_id = "+id;
            ResultSet rs = st.executeQuery(sql);
            // the while loop will add a row by eatch 1 looping.
            while(rs.next()){
                String date = rs.getString("T_date");
                String time = rs.getString("T_time");
                String status = rs.getString("T_status");

                Object[] obj = {null,null,null,null,null,time,date,status};
                DefaultTableModel model = (DefaultTableModel) table_data.getModel();
                model.addRow(obj);
            }        st.close();
        rs.close();
       }catch(Exception E){
           E.printStackTrace();
       }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        WELCOME = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_data = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MENU_BAR.setBackground(new java.awt.Color(0, 102, 102));
        MENU_BAR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        name.setText("User");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        MENU_BAR.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 280, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("User Portal");
        MENU_BAR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        home.setToolTipText("GO TO HOME");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        MENU_BAR.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel10.setText("NOTIFICATION");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        MENU_BAR.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 170, 50));

        minimize.setBackground(new java.awt.Color(255, 255, 255));
        minimize.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setToolTipText("Click For Minimize.");
        minimize.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        MENU_BAR.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1323, 30, 40, 17));

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
        close.setToolTipText("Click For Exit.");
        close.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        MENU_BAR.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1323, 0, 40, 30));

        getContentPane().add(MENU_BAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 50));

        WELCOME.setBackground(new java.awt.Color(0, 0, 0));
        WELCOME.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("your read/returned books.");

        table_data.setBackground(new java.awt.Color(204, 255, 204));
        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Book Author", "Book Type", "Part", "Time", "Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_data.setColorBackgoundHead(new java.awt.Color(255, 0, 0));
        table_data.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        table_data.setColorBordeHead(new java.awt.Color(0, 0, 255));
        table_data.setColorFilasBackgound1(new java.awt.Color(204, 204, 255));
        table_data.setColorFilasBackgound2(new java.awt.Color(153, 255, 153));
        table_data.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        table_data.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        table_data.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        table_data.setColorSelForeground(new java.awt.Color(0, 0, 0));
        table_data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_data.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_data.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_data.setRowHeight(30);
        table_data.setShowHorizontalLines(true);
        table_data.setShowVerticalLines(true);
        jScrollPane4.setViewportView(table_data);
        if (table_data.getColumnModel().getColumnCount() > 0) {
            table_data.getColumnModel().getColumn(0).setMaxWidth(90);
            table_data.getColumnModel().getColumn(4).setMinWidth(50);
            table_data.getColumnModel().getColumn(4).setMaxWidth(50);
            table_data.getColumnModel().getColumn(5).setMinWidth(65);
            table_data.getColumnModel().getColumn(5).setMaxWidth(65);
            table_data.getColumnModel().getColumn(6).setMinWidth(100);
            table_data.getColumnModel().getColumn(6).setMaxWidth(100);
            table_data.getColumnModel().getColumn(7).setMinWidth(120);
            table_data.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(553, 553, 553)
                .addComponent(jLabel1)
                .addContainerGap(598, Short.MAX_VALUE))
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1360, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        book_issue hp = new book_issue(id);
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked

        int s = JOptionPane.showConfirmDialog(null,"Do you want to change your info?","confirmation message", JOptionPane.YES_NO_CANCEL_OPTION);
        if ( s == JOptionPane.YES_OPTION){
            change_info ci = new change_info(id);
            ci.setVisible(true);
            this.dispose();
        }
        else {
            System.out.println("you have clicked CANCEL");
        }
    }//GEN-LAST:event_nameMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        notification n = new notification(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(this.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        Color mouseout = new Color(255,0,0);
        minimize.setBackground(mouseout);        // TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        Color mouseout = new Color(255,255,255);
        minimize.setBackground(mouseout); // TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        Color mouseout = new Color(255,0,0);
        close.setBackground(mouseout);       // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        Color mouseout = new Color(255,255,255);
        close.setBackground(mouseout);           // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel WELCOME;
    private javax.swing.JLabel close;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private rojeru_san.complementos.RSTableMetro table_data;
    // End of variables declaration//GEN-END:variables
public static void main(String [] args){
all_history ah = new all_history(101);
ah.setVisible(true);
}}
