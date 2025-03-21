/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe.moderator_file;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jframe.method_romjanali01673.DB_connection;
import jframe.home_page;
import jframe.method_romjanali01673.necessaryMethod;
import jframe.moderator_login;

public class approve_changes extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    int id;
    
        String fast_namer ="";
        String last_namer ="";
        String phoner ="";
        String emailr="";
        String genderr="";
        Long nid_birth_numberr =0L;
        java.sql.Date Date_of_birthr;
        String institute_officer ="";
        String id_numberr ="";
        String full_addressr="";
        String remarkr="";
        
        String fast_namerc ="";
        String last_namerc ="";
        String phonerc ="";
        String emailrc ="";
        String genderrc ="";
        Long nid_birth_numberrc ; 
        java.sql.Date Date_of_birthrc ; 
        String institute_officerc ="";
        String id_numberrc ="";
        String full_addressrc ="";
        
        int student_id=0;
        
        
        
    public approve_changes(int id) {
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
    
    public void set_info(){
        fast_name.setText(fast_namer);
        last_name.setText(last_namer);
        phone .setText(phoner);
        email .setText(emailr);
        gender.setText(genderr);
        nid_birth_number.setText(String.valueOf(nid_birth_numberr));
        dob.setText(Date_of_birthr.toString());
        institute_office .setText(institute_officer);
        id_of_institute_office.setText(id_numberr);
        full_address .setText(full_addressr);
        remark.setText(remarkr);

        fast_name1.setText(fast_namerc);
        last_name1.setText(last_namerc);
        phone1 .setText(phonerc);
        email1 .setText(emailrc);
        gender1.setText(genderrc);
        nid_birth_number1.setText(String.valueOf(nid_birth_numberrc));
        dob1.setText(Date_of_birthrc.toString());
        institute_office1 .setText(institute_officerc);
        id_of_institute_office1.setText(id_numberrc);
        full_address1 .setText(full_addressrc);

    }

    public void get_info(int student_id){  
        this.student_id = student_id;
    Connection con = DB_connection.getConnection();
    try {
        //wanted data
    
    String sql = "SELECT * FROM changes_student_data WHERE user_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1,student_id);

    ResultSet rs = pst.executeQuery(); // Changed executeUpdate() to executeQuery()

    if (rs.next()) {
       
        fast_namer = rs.getString("fast_name");
        last_namer = rs.getString("last_name"); 
        phoner = rs.getString("phone"); 
        emailr = rs.getString("email"); 
        genderr = rs.getString("gender"); 
        nid_birth_numberr = rs.getLong("nid_birth"); 
        Date_of_birthr = rs.getDate("dob"); 
        institute_officer = rs.getString("institute_office"); 
        id_numberr = rs.getString("ins_office_id"); // 
        full_addressr = rs.getString("full_address");
        remarkr = rs.getString("remark");    
    }        pst.close();
        rs.close();
    // current data
    String sql1 = "select * from student_data where user_id =? ";
         PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setInt(1,student_id);

    ResultSet rs1 = pst1.executeQuery(); // Changed executeUpdate() to executeQuery()

    if (rs1.next()) {
       
        fast_namerc = rs1.getString("fast_name");
        last_namerc = rs1.getString("last_name"); 
        phonerc = rs1.getString("phone"); 
        emailrc = rs1.getString("email"); 
        genderrc = rs1.getString("gender"); 
        nid_birth_numberrc = rs1.getLong("nid_birth"); 
        Date_of_birthrc = rs1.getDate("dob"); 
        institute_officerc = rs1.getString("institute_office"); 
        id_numberrc = rs1.getString("ins_office_id"); // 
        full_addressrc = rs1.getString("full_address");
        
    } else {
        JOptionPane.showMessageDialog(this, "Targeted Student  Not Found!"); 
        
    }        pst1.close();
        rs1.close();
} catch (Exception e) {
    e.printStackTrace();

}finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}

    public void update(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "update student_data set fast_name =?, last_name  =?,phone=? , email =?, gender =?, nid_birth=? , dob =?, institute_office=? , ins_office_id =?, full_address =? where user_id=?";
            String sql1 = "delete from changes_student_data where user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1);
            
            pst1.setInt(1, student_id);
            
            pst.setString(1, fast_namer);
            pst.setString(2, last_namer);
            pst.setString(3, phoner);
            pst.setString(4, emailr);
            pst.setString(5, genderr);
            pst.setLong(6, nid_birth_numberr);
            pst.setDate(7, Date_of_birthr);
            pst.setString(8, institute_officer);
            pst.setString(9, id_numberr);
            pst.setString(10, full_addressr);
            pst.setInt(11, student_id);

            int updatedRowCount = pst.executeUpdate();
            int updatedRowCount1 = pst1.executeUpdate();
       
           
            if ( updatedRowCount > 0 && updatedRowCount1>0){
               update1();
           }
           else{
               JOptionPane.showMessageDialog(this, "record Insarte faled!"); 
           }        pst.close();
                pst1.close();
          
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
    public void update1(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(user_id,T_status,by_who,employee_id,T_time, T_date) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, student_id);
            
            pst.setString(2, "APPROVED");
            pst.setString(3, "MODERATOR");
            pst.setInt(4,id);
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());


            int updatedRowCount = pst.executeUpdate();
       
           
            if ( updatedRowCount > 0){
               JOptionPane.showMessageDialog(this, "Account Updated.");
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
        LOGOUT2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        WELCOME = new javax.swing.JPanel();
        fast_name = new app.bolivia.swing.JCTextField();
        phone = new app.bolivia.swing.JCTextField();
        APPROVE = new rojerusan.RSMaterialButtonCircle();
        last_name = new app.bolivia.swing.JCTextField();
        institute_office = new app.bolivia.swing.JCTextField();
        id_of_institute_office = new app.bolivia.swing.JCTextField();
        nid_birth_number = new app.bolivia.swing.JCTextField();
        email = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        full_address = new app.bolivia.swing.JCTextField();
        jPanel1 = new javax.swing.JPanel();
        institute_office1 = new app.bolivia.swing.JCTextField();
        id_of_institute_office1 = new app.bolivia.swing.JCTextField();
        full_address1 = new app.bolivia.swing.JCTextField();
        email1 = new app.bolivia.swing.JCTextField();
        nid_birth_number1 = new app.bolivia.swing.JCTextField();
        phone1 = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        last_name1 = new app.bolivia.swing.JCTextField();
        fast_name1 = new app.bolivia.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remark = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        student_id_number = new app.bolivia.swing.JCTextField();
        jButton1 = new javax.swing.JButton();
        dob = new app.bolivia.swing.JCTextField();
        dob1 = new app.bolivia.swing.JCTextField();
        gender = new app.bolivia.swing.JCTextField();
        gender1 = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        approve_student.setBackground(new java.awt.Color(0, 0, 0));
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

        approve_changes.setBackground(new java.awt.Color(251, 0, 0));
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
        jLabel6.setText("Contact Employee ");
        contact_with_boss.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

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

        LOGOUT2.setBackground(new java.awt.Color(0, 0, 0));
        LOGOUT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGOUT2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGOUT2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGOUT2MouseExited(evt);
            }
        });
        LOGOUT2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_1.png"))); // NOI18N
        jLabel34.setText("Logout");
        LOGOUT2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(LOGOUT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 670));

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

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/home_24px.png"))); // NOI18N
        home.setToolTipText("GO TO HOME");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        MENU_BAR.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

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

        getContentPane().add(MENU_BAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 50));

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

        id_of_institute_office.setEditable(false);
        id_of_institute_office.setPlaceholder("ID number of institute/office");

        nid_birth_number.setEditable(false);
        nid_birth_number.setToolTipText("nid -10,13,17 digit and birth 16,17 digit");
        nid_birth_number.setPlaceholder("NID/Birth number ");
        nid_birth_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_birth_numberActionPerformed(evt);
            }
        });

        email.setEditable(false);
        email.setPlaceholder("Email Address");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("hes/her Gender-");

        full_address.setEditable(false);
        full_address.setPlaceholder("Full Address");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        institute_office1.setEditable(false);
        institute_office1.setPlaceholder("Institute/ Office Name");
        institute_office1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institute_office1ActionPerformed(evt);
            }
        });

        id_of_institute_office1.setEditable(false);
        id_of_institute_office1.setPlaceholder("ID number of institute/office");

        full_address1.setEditable(false);
        full_address1.setPlaceholder("Full Address");

        email1.setEditable(false);
        email1.setPlaceholder("Email Address");

        nid_birth_number1.setEditable(false);
        nid_birth_number1.setToolTipText("nid -10,13,17 digit and birth 16,17 digit");
        nid_birth_number1.setPlaceholder("NID/Birth number ");
        nid_birth_number1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_birth_number1ActionPerformed(evt);
            }
        });

        phone1.setEditable(false);
        phone1.setToolTipText("Enter your Phone Number with Country code.");
        phone1.setPlaceholder("phone");
        phone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 102));
        jLabel9.setText("hes/her Gender-");

        last_name1.setEditable(false);
        last_name1.setPlaceholder("Last Name");

        fast_name1.setEditable(false);
        fast_name1.setToolTipText("");
        fast_name1.setPlaceholder("Fast Name");
        fast_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fast_name1ActionPerformed(evt);
            }
        });

        remark.setEditable(false);
        remark.setColumns(20);
        remark.setRows(5);
        jScrollPane1.setViewportView(remark);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 102));
        jLabel10.setText("FAST NAME");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 102));
        jLabel12.setText("LAST NAME");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 102));
        jLabel13.setText("PHONE");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 102));
        jLabel14.setText("FULL ADDRESS");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 255, 102));
        jLabel15.setText("INSTITUTE OR OFFICE  NAME");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 255, 102));
        jLabel16.setText("FAST NAME");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 255, 102));
        jLabel17.setText("LAST NAME");

        jLabel18.setForeground(new java.awt.Color(102, 255, 102));
        jLabel18.setText("PHONE");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 255, 102));
        jLabel19.setText("EMAIL ADDRESS");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 255, 102));
        jLabel20.setText("FULL ADDRESS");

        jLabel21.setForeground(new java.awt.Color(102, 255, 102));
        jLabel21.setText("INSTITUTE/OFFICE NAME");

        jLabel22.setForeground(new java.awt.Color(102, 255, 102));
        jLabel22.setText("ID OF INSTITUTE/OFFICE");

        jLabel23.setForeground(new java.awt.Color(102, 255, 102));
        jLabel23.setText("ID OF INSATITUTE  OR OFFICE");

        jLabel24.setForeground(new java.awt.Color(102, 255, 102));
        jLabel24.setText("NID/BIRTH NUMBER");

        jLabel25.setForeground(new java.awt.Color(102, 255, 102));
        jLabel25.setText("DATE OF BIRTH");

        jLabel26.setForeground(new java.awt.Color(102, 255, 102));
        jLabel26.setText("DATE OF BIRTH");

        jLabel27.setForeground(new java.awt.Color(102, 255, 102));
        jLabel27.setText("EMAIL ADDRESS");

        jLabel28.setForeground(new java.awt.Color(102, 255, 102));
        jLabel28.setText("NID/BIRTH NUMBER");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 255, 102));
        jLabel29.setText("Wanted Info");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 255, 102));
        jLabel30.setText("Current Info");

        student_id_number.setPlaceholder("Find by Student NID/Birth NO :");
        student_id_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_id_numberActionPerformed(evt);
            }
        });

        jButton1.setText("Find");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        dob.setEditable(false);
        dob.setPlaceholder("Date of birth");
        dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobActionPerformed(evt);
            }
        });

        dob1.setEditable(false);
        dob1.setPlaceholder("Date of birth");
        dob1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dob1ActionPerformed(evt);
            }
        });

        gender.setEditable(false);
        gender.setPlaceholder("Gender");

        gender1.setEditable(false);
        gender1.setPlaceholder("Gender");
        gender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel27))
                                    .addGap(57, 57, 57)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nid_birth_number, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel24)
                                            .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(full_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(id_of_institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel14)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel29)))
                        .addGap(38, 38, 38)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addGap(144, 144, 144))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fast_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(last_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(59, 59, 59)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(gender1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(26, 26, 26))))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(institute_office1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(WELCOMELayout.createSequentialGroup()
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jLabel19))
                                                .addGap(59, 59, 59)
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dob1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(nid_birth_number1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel26)
                                                            .addComponent(jLabel28))
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                            .addGroup(WELCOMELayout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(202, 202, 202)
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(id_of_institute_office1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addComponent(full_address1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(APPROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(student_id_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(12, 12, 12)
                                        .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel25)
                                        .addGap(9, 9, 9)))
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel22))
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_of_institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(fast_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(last_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(dob1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nid_birth_number1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(full_address1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(institute_office1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_of_institute_office1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(student_id_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(APPROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1140, 670));

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
        Color mousein = new Color(0,0,0);
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
        Color mousein = new Color(251,0,0);
        approve_changes.setBackground(mousein);
    }//GEN-LAST:event_approve_changesMouseExited

    private void contact_with_bossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_with_bossMouseClicked
        contact_employee cwb =  new contact_employee(id);
        cwb.setVisible(true);
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
        contact_with_student cws = new contact_with_student(id);
        cws.setVisible(true);
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
          moderator_portal mp = new moderator_portal(id );
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

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        approve_changes ac = new approve_changes(id);
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void fast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_nameActionPerformed

    }//GEN-LAST:event_fast_nameActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void APPROVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APPROVEMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,"Do you want Approve.","Confirm",JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
           update();
        }
    }//GEN-LAST:event_APPROVEMouseClicked

    private void APPROVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APPROVEActionPerformed

    }//GEN-LAST:event_APPROVEActionPerformed

    private void institute_officeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute_officeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute_officeActionPerformed

    private void nid_birth_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birth_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birth_numberActionPerformed

    private void institute_office1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute_office1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute_office1ActionPerformed

    private void nid_birth_number1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birth_number1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birth_number1ActionPerformed

    private void phone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone1ActionPerformed

    private void fast_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fast_name1ActionPerformed

    private void student_id_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_id_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_id_numberActionPerformed

    private void dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobActionPerformed

    private void dob1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dob1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dob1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
int s_id=000;
try{
     s_id= Integer.parseInt(student_id_number.getText());

}catch(Exception e){
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "search by Valid Info");
}
if(s_id!=0){
        get_info(s_id);
        set_info();
}
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
        notification n = new notification(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void gender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender1ActionPerformed

    private void LOGOUT2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUT2MouseExited
        Color mousein = new Color(0,0,0);
        LOGOUT2.setBackground(mousein);
    }//GEN-LAST:event_LOGOUT2MouseExited

    private void LOGOUT2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUT2MouseEntered
        Color mousein = new Color(51,51,51);
        LOGOUT2.setBackground(mousein);
    }//GEN-LAST:event_LOGOUT2MouseEntered

    private void LOGOUT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUT2MouseClicked
        int a = JOptionPane.showConfirmDialog(this,"Do you want to Logout?","woring",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            moderator_login al = new moderator_login();
            al.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LOGOUT2MouseClicked

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
    private rojerusan.RSMaterialButtonCircle APPROVE;
    private javax.swing.JPanel LOGOUT2;
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel WELCOME;
    private javax.swing.JPanel approve_changes;
    private javax.swing.JPanel approve_student;
    private javax.swing.JLabel close;
    private javax.swing.JPanel contact_with_boss;
    private javax.swing.JPanel contact_with_student;
    private app.bolivia.swing.JCTextField dob;
    private app.bolivia.swing.JCTextField dob1;
    private app.bolivia.swing.JCTextField email;
    private app.bolivia.swing.JCTextField email1;
    private app.bolivia.swing.JCTextField fast_name;
    private app.bolivia.swing.JCTextField fast_name1;
    private app.bolivia.swing.JCTextField full_address;
    private app.bolivia.swing.JCTextField full_address1;
    private app.bolivia.swing.JCTextField gender;
    private app.bolivia.swing.JCTextField gender1;
    private javax.swing.JLabel home;
    private app.bolivia.swing.JCTextField id_of_institute_office;
    private app.bolivia.swing.JCTextField id_of_institute_office1;
    private app.bolivia.swing.JCTextField institute_office;
    private app.bolivia.swing.JCTextField institute_office1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private app.bolivia.swing.JCTextField last_name;
    private app.bolivia.swing.JCTextField last_name1;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField nid_birth_number;
    private app.bolivia.swing.JCTextField nid_birth_number1;
    private app.bolivia.swing.JCTextField phone;
    private app.bolivia.swing.JCTextField phone1;
    private javax.swing.JTextArea remark;
    private app.bolivia.swing.JCTextField student_id_number;
    private javax.swing.JPanel welcome;
    // End of variables declaration//GEN-END:variables
public static void main(String[]args){
approve_changes ac;
        ac = new approve_changes(56);

ac.setVisible(true);
}}
