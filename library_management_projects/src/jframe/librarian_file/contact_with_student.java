
package jframe.librarian_file;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jframe.Help;
import jframe.method_romjanali01673.DB_connection;
import jframe.home_page;
import jframe.librarian_login;
import jframe.method_romjanali01673.necessaryMethod;

public class contact_with_student extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    
    int id ;
    
    
    contact_with_student(int id){
        this.id = id;
        initComponents();
        set_profile();
        
    }
    public void set_profile(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "select fast_name,last_name from employee_data where user_id = ?";
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
    
    public boolean valid(){
        boolean res = true;
        if(nm.remove_white_space(subject.getText()).equals("")){
            JOptionPane.showMessageDialog(this, "Write subject");
            return false;
        }
        else if(nm.remove_white_space(message.getText()).equals("")){
            JOptionPane.showMessageDialog(this, "Write message");
            return false;
        }
        else if(nm.remove_white_space(description.getText()).equals("")){
            JOptionPane.showMessageDialog(this, "Write description");
            return false;
        }
        else if(nm.stringToint(student_id.getText())==0){
            JOptionPane.showMessageDialog(this, "Write student ID");
            return false;
        }
        return res;
    }
    public void send(){
        Connection con = DB_connection.getConnection();
    try{
        String str = "insert into notification(subject,student_id,A_E_ID ,T_time,T_date,message,description,From_who) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(str);    
        pst.setString(1, nm.remove_white_space(subject.getText()));
        pst.setInt(2, nm.stringToint(student_id.getText()));
        pst.setInt(3,id);
        pst.setTime(4, nm.getNowTime());
        pst.setDate(5, nm.getTodayDate());
        pst.setString(6, nm.remove_white_space(message.getText()));
        pst.setString(7, nm.remove_white_space(description.getText()));
        pst.setString(8, "LIBRARIAN");
        
        int rs = pst.executeUpdate();
        if(rs>0){
            JOptionPane.showMessageDialog(this, "message send!");

        }
        else{
            JOptionPane.showMessageDialog(this, "Student Dose Not Exist!");
                    
        }        pst.close();
       
    }catch(Exception e){
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Server Error!");
    
    }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void getData(){
        Connection con = DB_connection.getConnection();
    try{
        String str = "select * from student_data where user_id=?";
        PreparedStatement pst = con.prepareStatement(str);    
        pst.setInt(1, nm.stringToint(student_id.getText()));
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            String phone= rs.getString("phone");
            String f_name= rs.getString("fast_name");
            String l_name= rs.getString("last_name");
            
            this.phone.setText(phone);
            this.fname.setText(f_name+" "+l_name);
        }
        else{
            JOptionPane.showMessageDialog(this, "Student Dose Not Exist!");
                    
        }        pst.close();
        rs.close();
    }catch(Exception e){
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Server Error!");
    
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

        jPanel3 = new javax.swing.JPanel();
        Notification = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        subject = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        submit = new rojerusan.RSMaterialButtonCircle();
        fname = new app.bolivia.swing.JCTextField();
        phone = new app.bolivia.swing.JCTextField();
        student_id = new app.bolivia.swing.JCTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        add_book = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        book_receive = new javax.swing.JPanel();
        receive_book = new javax.swing.JLabel();
        update_book = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        book_issue = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        contact_employee = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        contact_student = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        MENU_BAR = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Notification.setBackground(new java.awt.Color(0, 0, 0));
        Notification.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Send Notifocation.");
        Notification.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel3.add(Notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));
        jPanel3.add(subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 255));
        jLabel10.setText("Description");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 255));
        jLabel11.setText("Subject");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 255));
        jLabel13.setText("Message");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Student Full Name  - ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setText("Student Phone Number  -  ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, -1, -1));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 750, 440));

        message.setColumns(20);
        message.setRows(5);
        jScrollPane2.setViewportView(message);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 280, 260));

        submit.setText("send");
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel3.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 220, 80));

        fname.setEditable(false);
        fname.setPlaceholder("Full Name :   auto insart.");
        jPanel3.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 390, -1));

        phone.setEditable(false);
        phone.setPlaceholder("Phone number");
        jPanel3.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, 250, -1));

        student_id.setPlaceholder("Find Student by  Student ID");
        jPanel3.add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, -1, -1));

        jButton1.setText("Find");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1140, 670));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_book.setBackground(new java.awt.Color(0, 0, 0));
        add_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_bookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_bookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_bookMouseExited(evt);
            }
        });
        add_book.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add New Book");
        add_book.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(add_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        book_receive.setBackground(new java.awt.Color(0, 0, 0));
        book_receive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_receiveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_receiveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_receiveMouseExited(evt);
            }
        });
        book_receive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receive_book.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        receive_book.setForeground(new java.awt.Color(255, 255, 255));
        receive_book.setText("Book Receive(Returned)");
        book_receive.add(receive_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(book_receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 40));

        update_book.setBackground(new java.awt.Color(0, 0, 0));
        update_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_bookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                update_bookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                update_bookMouseExited(evt);
            }
        });
        update_book.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Update Book");
        update_book.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(update_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 40));

        book_issue.setBackground(new java.awt.Color(0, 0, 0));
        book_issue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_issueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_issueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_issueMouseExited(evt);
            }
        });
        book_issue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Issue Book");
        book_issue.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, -1));

        jPanel2.add(book_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 40));

        contact_employee.setBackground(new java.awt.Color(0, 0, 0));
        contact_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_employeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contact_employeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contact_employeeMouseExited(evt);
            }
        });
        contact_employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contact with Employee");
        contact_employee.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel2.add(contact_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, 40));

        contact_student.setBackground(new java.awt.Color(255, 0, 0));
        contact_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_studentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contact_studentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contact_studentMouseExited(evt);
            }
        });
        contact_student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Contact With Student");
        contact_student.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel2.add(contact_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 40));

        LOGOUT.setBackground(new java.awt.Color(0, 0, 0));
        LOGOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGOUTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGOUTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGOUTMouseExited(evt);
            }
        });
        LOGOUT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_1.png"))); // NOI18N
        jLabel22.setText("Logout");
        LOGOUT.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 200, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 670));

        MENU_BAR.setBackground(new java.awt.Color(0, 102, 102));
        MENU_BAR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Librarian Portal");
        MENU_BAR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel17.setText("NOTIFICATION");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        MENU_BAR.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 170, 50));

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        name.setText("Librarian");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        MENU_BAR.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 280, -1));

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

        minimize.setBackground(new java.awt.Color(255, 255, 255));
        minimize.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setToolTipText("Click For Minimize.\n");
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

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/home_24px.png"))); // NOI18N
        home.setToolTipText("GO TO HOME");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        MENU_BAR.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        getContentPane().add(MENU_BAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
       if(valid()){
           send();
       }

    }//GEN-LAST:event_submitMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
if(nm.stringToint(student_id.getText())!=0)  {
    getData();
}      

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void add_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_bookMouseClicked

    }//GEN-LAST:event_add_bookMouseClicked

    private void add_bookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_bookMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        add_book.setBackground(mousein);
    }//GEN-LAST:event_add_bookMouseEntered

    private void add_bookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_bookMouseExited
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        add_book.setBackground(mousein);
    }//GEN-LAST:event_add_bookMouseExited

    private void book_receiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_receiveMouseClicked
        book_add ac = new book_add(id);
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_book_receiveMouseClicked

    private void book_receiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_receiveMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        book_receive.setBackground(mousein);
    }//GEN-LAST:event_book_receiveMouseEntered

    private void book_receiveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_receiveMouseExited
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        book_receive.setBackground(mousein);
    }//GEN-LAST:event_book_receiveMouseExited

    private void update_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bookMouseClicked

    }//GEN-LAST:event_update_bookMouseClicked

    private void update_bookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bookMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        update_book.setBackground(mousein);
    }//GEN-LAST:event_update_bookMouseEntered

    private void update_bookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bookMouseExited
        // TODO add your handling code here:
        Color mouseout = new Color(0,0,0);
        update_book.setBackground(mouseout);
    }//GEN-LAST:event_update_bookMouseExited

    private void book_issueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_issueMouseClicked
        book_give mp = new book_give(id );
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_book_issueMouseClicked

    private void book_issueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_issueMouseEntered
        Color mousein = new Color(51,51,51);
        book_issue.setBackground(mousein);
    }//GEN-LAST:event_book_issueMouseEntered

    private void book_issueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_issueMouseExited
        Color mouseout = new Color(0,0,0);
        book_issue.setBackground(mouseout);
    }//GEN-LAST:event_book_issueMouseExited

    private void contact_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_employeeMouseClicked
contact_employee cmpdata = new contact_employee(id);
cmpdata.setVisible(true);
this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_contact_employeeMouseClicked

    private void contact_employeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_employeeMouseEntered
                Color mousein = new Color(51,51,51);
        contact_employee.setBackground(mousein);        // TODO add your handling code here:
    }//GEN-LAST:event_contact_employeeMouseEntered

    private void contact_employeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_employeeMouseExited
                Color mousein = new Color(0,0,0);
        contact_student.setBackground(mousein);        
// TODO add your handling code here:
    }//GEN-LAST:event_contact_employeeMouseExited

    private void contact_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_studentMouseClicked
        contact_with_student cws = new contact_with_student(id);
        cws.setVisible(true);
    }//GEN-LAST:event_contact_studentMouseClicked

    private void contact_studentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_studentMouseEntered
        // TODO add your handling code here:
                Color mousein = new Color(0,0,0);
        contact_student.setBackground(mousein);
    }//GEN-LAST:event_contact_studentMouseEntered

    private void contact_studentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_studentMouseExited
        // TODO add your handling code here:
                Color mousein = new Color(255,0,0);
        contact_student.setBackground(mousein);
    }//GEN-LAST:event_contact_studentMouseExited

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
        int a = JOptionPane.showConfirmDialog(this,"Do you want to Logout?","woring",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            librarian_login al = new librarian_login();
            al.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LOGOUTMouseClicked

    private void LOGOUTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseEntered
        Color mousein = new Color(51,51,51);
        LOGOUT.setBackground(mousein);
    }//GEN-LAST:event_LOGOUTMouseEntered

    private void LOGOUTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseExited
        Color mousein = new Color(0,0,0);
        LOGOUT.setBackground(mousein);
    }//GEN-LAST:event_LOGOUTMouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        Notify n = new Notify(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked

    }//GEN-LAST:event_nameMouseClicked

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

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        home_page hp = new home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        contact_with_student cws = new contact_with_student(3456);
        cws.setVisible(true);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(contact_with_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(contact_with_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(contact_with_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(contact_with_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LOGOUT;
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel Notification;
    private javax.swing.JPanel add_book;
    private javax.swing.JPanel book_issue;
    private javax.swing.JPanel book_receive;
    private javax.swing.JLabel close;
    private javax.swing.JPanel contact_employee;
    private javax.swing.JPanel contact_student;
    private javax.swing.JTextArea description;
    private app.bolivia.swing.JCTextField fname;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea message;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField phone;
    private javax.swing.JLabel receive_book;
    private app.bolivia.swing.JCTextField student_id;
    private app.bolivia.swing.JCTextField subject;
    private rojerusan.RSMaterialButtonCircle submit;
    private javax.swing.JPanel update_book;
    // End of variables declaration//GEN-END:variables
}
