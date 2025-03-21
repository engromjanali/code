 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe.moderator_file;


import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import jframe.method_romjanali01673.DB_connection;
import jframe.home_page;
import jframe.method_romjanali01673.necessaryMethod;
import jframe.moderator_login;

public class approve_student extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    int id;
    String Student_pass = "";
    
    public approve_student(int id){
        this.id=id;
        initComponents();// main function always fast compile korta hoiba
        set_profile();  
        set_table();
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



    public boolean confirm_approve(){
        boolean result = true;

        Connection con = DB_connection.getConnection();
        try{
        String sql1 = "delete from registaed_student_data where nid_birth = ? ";
        String sql = "insert into student_data(fast_name, last_name, phone, email, gender, dob , nid_birth, institute_office, ins_office_id, full_address, pass, s_status) values(?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement pst = con.prepareStatement(sql);
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setLong(1, Long.parseLong(nid_birth.getText()));
        
        pst.setString(1,fast_name.getText());
        pst.setString(2,last_name.getText());
        pst.setString(3,phone.getText());
        pst.setString(4,email.getText());
        pst.setString(5,gender.getText());
        pst.setDate(6, nm.stringToDate(dob.getText()));
        pst.setLong(7,nm.stringToLong(nid_birth.getText()));
        pst.setString(8,institute_office.getText());
        pst.setString(9,ins_office_id.getText());
        pst.setString(10,full_address.getText());
        pst.setString(11,Student_pass);
        pst.setString(12,"REGULER");
    


        int rs = pst.executeUpdate();
                pst.close();
        
        pst1.executeUpdate();
                pst1.close();
        
        if(rs>0){
            update2();
            update1();
        }else{
            result = false;
        }
        }catch (Exception e){
            e.printStackTrace();
            result = false;
            JOptionPane.showMessageDialog(this,"server Disconnected!");
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public int get_studentID(){
        int res = 0;
            Connection con = DB_connection.getConnection();
        try{
            String sql = "select * from student_data where nid_birth = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1,nm.stringToLong(nid_birth.getText()));
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                res = rs.getInt("user_id");
            }        pst.close();
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
        return res;
    }
    public void update1(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(user_id,T_status,by_who,employee_id,T_time, T_date) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, get_studentID());
            
            pst.setString(2, "ADDED");
            pst.setString(3, "MODERATOR");
            pst.setInt(4,id);
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());


            int updatedRowCount = pst.executeUpdate();
       
           
            if ( updatedRowCount > 0){
               JOptionPane.showMessageDialog(this, "Account ADDED!.");
           }
           else{
               JOptionPane.showMessageDialog(this, "record Insarte faled!"); 
           }           pst.close();
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"somthing wrong!");
            e.printStackTrace();
       
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    
    public void update2(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(user_id,T_status,by_who,employee_id,T_time, T_date) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, get_studentID());
            
            pst.setString(2, "REGISTATION");
            pst.setString(3, "STUDENT");
            pst.setInt(4,id);
            pst.setTime(5, nm.stringToTime(registed_time.getText()) );
            pst.setDate(6, nm.stringToDate(registed_date.getText()));


            int updatedRowCount = pst.executeUpdate();
       
           
            if ( updatedRowCount > 0){
               JOptionPane.showMessageDialog(this, "Account ADDED!.");
           }
           else{
               JOptionPane.showMessageDialog(this, "record Insarte faled!"); 
           }           pst.close();
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"somthing wrong!");
            e.printStackTrace();
       
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    
    // the method help to find someone by any type of spacific data.
    public void find_by_id(){

        String query = String.valueOf(info.getText()).toUpperCase();
        
        DefaultTableModel model = (DefaultTableModel) table_data.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_data.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(query));
    }
        
    public long get_nid_birth_from_table(){
        DefaultTableModel model = (DefaultTableModel)table_data.getModel();
        //get row Number as index number;
        int row = table_data.getSelectedRow();
        long nid_birth = (long) model.getValueAt(row,1);//nid_birth column index is : 1
        return nid_birth;
    }
    public void set_data_in_textfield(){
        Connection con = DB_connection.getConnection();
        try{
            
        String sql = "select * from registaed_student_data where nid_birth = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1,get_nid_birth_from_table());
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
                String fast_name = rs.getString("fast_name");
                String last_name = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                java.sql.Date dob = rs.getDate("dob");
                Long nid_birth = rs.getLong("nid_birth");
                String institute_office = rs.getString("institute_office");
                String ins_office_id = rs.getString("ins_office_id");
                String full_address = rs.getString("full_address");
                Student_pass = rs.getString("pass");
                java.sql.Time registation_time = rs.getTime("registation_time");
                java.sql.Date registation_date = rs.getDate("registation_date");
                
                //set data in TextField
                this.fast_name.setText(fast_name);
                this.last_name.setText(last_name);
                this.phone.setText(phone);
                this.email.setText(email);
                this.gender.setText(gender);
                this.dob.setText(dob.toString());
                this.nid_birth.setText(nid_birth.toString());
                this.institute_office.setText(institute_office);
                this.ins_office_id.setText(ins_office_id);
                this.full_address.setText(full_address);
                this.registed_date.setText(registation_date.toString());
                this.registed_time.setText(registation_time.toString());
        }
                pst.close();
        rs.close();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"server Disconnected!");

        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
  public void set_table(){
            Connection con = DB_connection.getConnection();
       try{
            Statement st = con.createStatement();
            String sql = "select * from registaed_student_data";
            ResultSet rs = st.executeQuery(sql);
            // the while loop will add a row by eatch 1 looping.
            while(rs.next()){
                String fast_name = rs.getString("fast_name");
                String last_name = rs.getString("last_name");
                String phone = rs.getString("phone");
                //String email = rs.getString("email");
                //String gender = rs.getString("gender");
                //java.sql.Date dob = rs.getDate("dob");
                Long nid_birth = rs.getLong("nid_birth");
                //String institute_office = rs.getString("institute_office");
                //String ins_office_id = rs.getString("ins_office_id");
                //String fill_address = rs.getString("full_address");
                //String pass = rs.getString("pass");
                //java.sql.Time registation_time = rs.getTime("registation_time");
                java.sql.Date registation_date = rs.getDate("registation_date");
                //set data in table
                Object[] obj = {fast_name+" "+last_name,nid_birth,registation_date,phone};
                DefaultTableModel model = (DefaultTableModel) table_data.getModel();
                model.addRow(obj);
            }        st.close();
        rs.close();
       }catch(Exception E){
           System.out.println("erroes");
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

        jPanel2 = new javax.swing.JPanel();
        approve_student = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        approve_changes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        contact_with_student = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        contact_with_boss = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        welcome = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        WELCOME = new javax.swing.JPanel();
        fast_name = new app.bolivia.swing.JCTextField();
        phone = new app.bolivia.swing.JCTextField();
        APPROVE = new rojerusan.RSMaterialButtonCircle();
        last_name = new app.bolivia.swing.JCTextField();
        institute_office = new app.bolivia.swing.JCTextField();
        ins_office_id = new app.bolivia.swing.JCTextField();
        nid_birth = new app.bolivia.swing.JCTextField();
        email = new app.bolivia.swing.JCTextField();
        full_address = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        info = new app.bolivia.swing.JCTextField();
        dob = new app.bolivia.swing.JCTextField();
        gender = new app.bolivia.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_data = new rojeru_san.complementos.RSTableMetro();
        registed_date = new app.bolivia.swing.JCTextField();
        registed_time = new app.bolivia.swing.JCTextField();
        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        approve_student.setBackground(new java.awt.Color(251, 0, 0));
        approve_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                approve_studentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                approve_studentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                approve_studentMouseExited(evt);
            }
        });
        approve_student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Approve Student");
        approve_student.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(approve_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        approve_changes.setBackground(new java.awt.Color(0, 0, 0));
        approve_changes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                approve_changesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                approve_changesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                approve_changesMouseExited(evt);
            }
        });
        approve_changes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Approve Changes");
        approve_changes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(approve_changes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 40));

        contact_with_student.setBackground(new java.awt.Color(0, 0, 0));
        contact_with_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_with_studentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contact_with_studentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contact_with_studentMouseExited(evt);
            }
        });
        contact_with_student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact With Student");
        contact_with_student.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(contact_with_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 40));

        contact_with_boss.setBackground(new java.awt.Color(0, 0, 0));
        contact_with_boss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_with_bossMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contact_with_bossMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contact_with_bossMouseExited(evt);
            }
        });
        contact_with_boss.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contact Employee");
        contact_with_boss.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(contact_with_boss, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 40));

        welcome.setBackground(new java.awt.Color(0, 0, 0));
        welcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                welcomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                welcomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                welcomeMouseExited(evt);
            }
        });
        welcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("welcome");
        welcome.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 40));

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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_1.png"))); // NOI18N
        jLabel18.setText("Logout");
        LOGOUT.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 670));

        WELCOME.setBackground(new java.awt.Color(0, 0, 0));

        fast_name.setEditable(false);
        fast_name.setToolTipText("");
        fast_name.setPlaceholder("Fast Name");
        fast_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fast_nameActionPerformed(evt);
            }
        });

        phone.setEditable(false);
        phone.setToolTipText("Enter your Phone Number with Country code.");
        phone.setPlaceholder("phone");
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        APPROVE.setText("APPROVE ");
        APPROVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                APPROVEMouseClicked(evt);
            }
        });
        APPROVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APPROVEActionPerformed(evt);
            }
        });

        last_name.setEditable(false);
        last_name.setPlaceholder("Last Name");

        institute_office.setEditable(false);
        institute_office.setPlaceholder("Institute/ Office Name");
        institute_office.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institute_officeActionPerformed(evt);
            }
        });

        ins_office_id.setEditable(false);
        ins_office_id.setPlaceholder("ID number of institute/office");

        nid_birth.setEditable(false);
        nid_birth.setToolTipText("nid -10,13,17 digit and birth 16,17 digit");
        nid_birth.setPlaceholder("NID/Birth number ");
        nid_birth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_birthActionPerformed(evt);
            }
        });

        email.setEditable(false);
        email.setPlaceholder("Email Address");

        full_address.setEditable(false);
        full_address.setPlaceholder("Full Address");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setText("Gender-");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 255));
        jLabel10.setText("FAST NAME");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 255));
        jLabel12.setText("LAST NAME");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 255));
        jLabel13.setText("PHONE");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 255));
        jLabel14.setText("FULL ADDRESS");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 255, 255));
        jLabel15.setText("INSTITUTE OR OFFICE  NAME");

        jLabel23.setForeground(new java.awt.Color(102, 255, 255));
        jLabel23.setText("ID OF INSTITUTE/OFFICE");

        jLabel25.setForeground(new java.awt.Color(102, 255, 255));
        jLabel25.setText("NID/BIRTH NUMBER");

        jLabel26.setForeground(new java.awt.Color(102, 255, 255));
        jLabel26.setText("DATE OF BIRTH");

        jLabel28.setForeground(new java.awt.Color(102, 255, 255));
        jLabel28.setText("EMAIL ADDRESS");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 255, 255));
        jLabel30.setText("Applyed Student Info");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 255));
        jLabel9.setText("Registation Time");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Select Student from Here.");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 255));
        jLabel11.setText("Registation Date");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 255, 255));
        jLabel16.setText("Find Student By Any Type of Data -");

        info.setPlaceholder("Find by Any Type of Data : ");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        info.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                infoKeyReleased(evt);
            }
        });

        dob.setEditable(false);
        dob.setPlaceholder("Date of birth");
        dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobActionPerformed(evt);
            }
        });

        gender.setEditable(false);
        gender.setPlaceholder("Gender");

        table_data.setAutoCreateRowSorter(true);
        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "NID_birth No", "Regidted Date", "Phone"
            }
        ));
        table_data.setColorBackgoundHead(new java.awt.Color(255, 102, 102));
        table_data.setColorBordeFilas(new java.awt.Color(51, 0, 255));
        table_data.setColorBordeHead(new java.awt.Color(0, 204, 204));
        table_data.setColorFilasBackgound1(new java.awt.Color(204, 204, 255));
        table_data.setColorFilasBackgound2(new java.awt.Color(255, 204, 204));
        table_data.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        table_data.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        table_data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_data.setRowHeight(30);
        table_data.setRowMargin(1);
        table_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_data);
        if (table_data.getColumnModel().getColumnCount() > 0) {
            table_data.getColumnModel().getColumn(0).setMinWidth(200);
            table_data.getColumnModel().getColumn(1).setMinWidth(120);
        }

        registed_date.setEditable(false);
        registed_date.setPlaceholder("Registation Date");
        registed_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registed_dateActionPerformed(evt);
            }
        });

        registed_time.setEditable(false);
        registed_time.setPlaceholder("Registation Time");

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(ins_office_id, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registed_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registed_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(full_address, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel15)
                                            .addGroup(WELCOMELayout.createSequentialGroup()
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel28)
                                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel25)
                                                    .addComponent(jLabel26)
                                                    .addComponent(nid_birth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(196, 196, 196))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                        .addGap(130, 130, 130))
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(APPROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(jLabel30)))
                .addContainerGap())
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel30)
                .addGap(29, 29, 29)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nid_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(4, 4, 4)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registed_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registed_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 75, Short.MAX_VALUE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ins_office_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(APPROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19))))))
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1150, 670));

        MENU_BAR.setBackground(new java.awt.Color(0, 102, 102));
        MENU_BAR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        name.setText("Modarator");
        MENU_BAR.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 280, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Modarator Portal");
        MENU_BAR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel31.setText("NOTIFICATION");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        MENU_BAR.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 170, 50));

        minimize.setBackground(new java.awt.Color(255, 255, 255));
        minimize.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
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
        MENU_BAR.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1323, 32, 40, 17));

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
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

    private void approve_studentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approve_studentMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        approve_student.setBackground(mousein);
    }//GEN-LAST:event_approve_studentMouseEntered

    private void approve_studentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approve_studentMouseExited
        // TODO add your handling code here:
        Color mousein = new Color(251,0,0);
        approve_student.setBackground(mousein);
    }//GEN-LAST:event_approve_studentMouseExited

    private void approve_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approve_studentMouseClicked
           approve_student as = new approve_student(id);
           as.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_approve_studentMouseClicked

    private void approve_changesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approve_changesMouseClicked
           approve_changes ac = new approve_changes(id);
           ac.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_approve_changesMouseClicked

    private void approve_changesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approve_changesMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        approve_changes.setBackground(mousein);
    }//GEN-LAST:event_approve_changesMouseEntered

    private void approve_changesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approve_changesMouseExited
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        approve_changes.setBackground(mousein);
    }//GEN-LAST:event_approve_changesMouseExited

    private void contact_with_bossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_bossMouseClicked
        contact_employee cob = new contact_employee(id);
        cob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_contact_with_bossMouseClicked

    private void contact_with_bossMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_bossMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        contact_with_boss.setBackground(mousein);
    }//GEN-LAST:event_contact_with_bossMouseEntered

    private void contact_with_bossMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_bossMouseExited
        // TODO add your handling code here:
        Color mouseout = new Color(0,0,0);
        contact_with_boss.setBackground(mouseout);
    }//GEN-LAST:event_contact_with_bossMouseExited

    private void contact_with_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_studentMouseClicked
        contact_with_student cos = new contact_with_student(id);
        cos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_contact_with_studentMouseClicked

    private void contact_with_studentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_studentMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        contact_with_student.setBackground(mousein);
    }//GEN-LAST:event_contact_with_studentMouseEntered

    private void contact_with_studentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_studentMouseExited
        // TODO add your handling code here:
        Color mouseout = new Color(0,0,0);
        contact_with_student.setBackground(mouseout);
    }//GEN-LAST:event_contact_with_studentMouseExited

    private void welcomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_welcomeMouseClicked
          moderator_portal mp = new moderator_portal(id);
          mp.setVisible(true);
          this.dispose();
          
    }//GEN-LAST:event_welcomeMouseClicked

    private void welcomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_welcomeMouseEntered
        Color mousein = new Color(51,51,51);
        welcome.setBackground(mousein);
    }//GEN-LAST:event_welcomeMouseEntered

    private void welcomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_welcomeMouseExited
        Color mouseout = new Color(0,0,0);
        welcome.setBackground(mouseout);
    }//GEN-LAST:event_welcomeMouseExited

    private void dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_infoActionPerformed

    private void nid_birthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birthActionPerformed

    private void institute_officeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute_officeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute_officeActionPerformed

    private void APPROVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APPROVEActionPerformed

    }//GEN-LAST:event_APPROVEActionPerformed

    private void APPROVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APPROVEMouseClicked

        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,"Do you want Approve.","Confirmation",JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            if(confirm_approve()){
                approve_student aps= new approve_student(id);
                aps.setVisible(true);
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_APPROVEMouseClicked

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void fast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_nameActionPerformed

    }//GEN-LAST:event_fast_nameActionPerformed

    private void table_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataMouseClicked
        set_data_in_textfield();
    }//GEN-LAST:event_table_dataMouseClicked

    private void registed_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registed_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registed_dateActionPerformed

    private void infoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_infoKeyReleased
       find_by_id();
    }//GEN-LAST:event_infoKeyReleased

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
        int a = JOptionPane.showConfirmDialog(this,"Do you want to Logout?","woring",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            moderator_login al = new moderator_login();
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

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
        notification n = new notification(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

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

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        approve_changes ac = new approve_changes(id);
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        approve_student ap = new approve_student(324);
        ap.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle APPROVE;
    private javax.swing.JPanel LOGOUT;
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel WELCOME;
    private javax.swing.JPanel approve_changes;
    private javax.swing.JPanel approve_student;
    private javax.swing.JLabel close;
    private javax.swing.JPanel contact_with_boss;
    private javax.swing.JPanel contact_with_student;
    private app.bolivia.swing.JCTextField dob;
    private app.bolivia.swing.JCTextField email;
    private app.bolivia.swing.JCTextField fast_name;
    private app.bolivia.swing.JCTextField full_address;
    private app.bolivia.swing.JCTextField gender;
    private javax.swing.JLabel home;
    private app.bolivia.swing.JCTextField info;
    private app.bolivia.swing.JCTextField ins_office_id;
    private app.bolivia.swing.JCTextField institute_office;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private app.bolivia.swing.JCTextField last_name;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField nid_birth;
    private app.bolivia.swing.JCTextField phone;
    private app.bolivia.swing.JCTextField registed_date;
    private app.bolivia.swing.JCTextField registed_time;
    private rojeru_san.complementos.RSTableMetro table_data;
    private javax.swing.JPanel welcome;
    // End of variables declaration//GEN-END:variables
}
