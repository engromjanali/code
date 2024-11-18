/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import jframe.method_romjanali01673.DB_connection;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class verify_student extends javax.swing.JFrame {

public boolean bod_date_valid=false;

int user_id; 
String fast_name;
String last_name ;
String phone ;
String email ;
String gender ;
long nid_birth_number ;
java.sql.Date Date_of_birth ; 
String institute_office ;
String id_number;
String full_address ;
String status;

    public verify_student() {
        initComponents();
   
         
    }
    public void showoutput(){
         useridtf.setText(String.format("%08d", user_id));
         fullnametf.setText(fast_name+" "+last_name);
         phonetf.setText(phone);
         emailtf.setText(email);
         gendertf.setText(gender);
         nidbirthtf.setText(Long.toString(nid_birth_number));
         dobtf.setText(Date_of_birth.toString());
         instituteofficetf.setText(institute_office);
         idofinstitute.setText(id_number);
         fulladdresstf.setText(full_address);
         Status.setText(status);
    }
    public long get_nid_or_birth_number(){
        
        long NID_B_Number = 0L;
        String NID_B_number = verify_nidbirthtf.getText();
        try{
            NID_B_Number = Long.parseLong(NID_B_number);
            if(NID_B_number.length()>17){
            JOptionPane.showMessageDialog(this,"you have insert more then 17 digit");
            NID_B_Number = 0L;
                }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Enter valid NID/Birth number:");
        }
        
        return NID_B_Number;
    }
    public java.sql.Date get_Birth_Date(){
        //bod_date_valid = false;// ai method er " bod_date_valid"  er value akbar change hoila joto e event hok na kano er default value asbe na. last changes e takba.
        System.out.println("1");
        java.sql.Date DATE_OF_BIRTH = new java.sql.Date(2004-02-01);
        try{
        // we will get the util-date from the compunents and we have to use the method getDatoFecha()
        // to save the date in database we have to convart in sql-date
        //the process is util-long-sql
        Date DOB = verify_bod.getDatoFecha();//util date
        //DATE_OF_BIRTH = new java.sql.Date(DOB.getTime())// it's valid also
        Long dateofbirth = DOB.getTime();//long date  //but it's standerd
        DATE_OF_BIRTH = new java.sql.Date(dateofbirth);
        }catch (Exception e ){
            JOptionPane.showMessageDialog(this,"Enter your Date of Birth!");
            bod_date_valid = true;
            
        }
            return DATE_OF_BIRTH ;
    }
    public boolean data_valid(){
        get_Birth_Date();
        boolean result = true;
        if (get_nid_or_birth_number()==0){
            result = false;
        }
        else if (bod_date_valid){
            result = false;
        }
        return result; 
    }
    public boolean verify_user(){
        boolean result = true;
    Connection con = DB_connection.getConnection();
    try {
    String sql = "SELECT * FROM student_data WHERE nid_birth = ? AND dob = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setLong(1, get_nid_or_birth_number()); // Assuming 1 is the id you're searching for
    pst.setDate(2, get_Birth_Date());

    ResultSet rs = pst.executeQuery(); // Changed executeUpdate() to executeQuery()

    if (rs.next()) {
        user_id = rs.getInt("user_id");
        fast_name = rs.getString("fast_name");
        last_name = rs.getString("last_name"); 
        phone = rs.getString("phone"); 
        email = rs.getString("email"); 
        gender = rs.getString("gender"); 
        nid_birth_number = rs.getLong("nid_birth"); 
        Date_of_birth = rs.getDate("dob"); 
        institute_office = rs.getString("institute_office"); 
        id_number = rs.getString("ins_office_id"); // 
        full_address = rs.getString("full_address");
        status = rs.getString("S_status");
    } else {
        JOptionPane.showMessageDialog(this, "The student does not exist!"); 
        result = false;
    }            pst.close();
            rs.close();
} catch (Exception e) {
    e.printStackTrace();
    result = false;
}finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    return result;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        verify_nidbirthtf = new app.bolivia.swing.JCTextField();
        verify_bod = new rojeru_san.componentes.RSDateChooser();
        phonel = new javax.swing.JLabel();
        emaill = new javax.swing.JLabel();
        nidl = new javax.swing.JLabel();
        fullnametf = new app.bolivia.swing.JCTextField();
        fullnamel = new javax.swing.JLabel();
        bodl = new javax.swing.JLabel();
        institutel = new javax.swing.JLabel();
        insidl = new javax.swing.JLabel();
        fulladdressl = new javax.swing.JLabel();
        genderl = new javax.swing.JLabel();
        useridl = new javax.swing.JLabel();
        useridtf = new app.bolivia.swing.JCTextField();
        emailtf = new app.bolivia.swing.JCTextField();
        gendertf = new app.bolivia.swing.JCTextField();
        nidbirthtf = new app.bolivia.swing.JCTextField();
        dobtf = new app.bolivia.swing.JCTextField();
        instituteofficetf = new app.bolivia.swing.JCTextField();
        idofinstitute = new app.bolivia.swing.JCTextField();
        phonetf = new app.bolivia.swing.JCTextField();
        Status = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        fulladdressl1 = new javax.swing.JLabel();
        fulladdresstf = new app.bolivia.swing.JCTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        home = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("To verify you, you have to provide us some information!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 350, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("hello dear  student welcome to varify page.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 340, 50));

        verify_nidbirthtf.setPlaceholder("Enter Your NID/Birth Number :");
        jPanel1.add(verify_nidbirthtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 250, 40));

        verify_bod.setColorBackground(new java.awt.Color(255, 0, 0));
        verify_bod.setColorButtonHover(new java.awt.Color(0, 0, 255));
        verify_bod.setColorDiaActual(new java.awt.Color(0, 0, 255));
        verify_bod.setColorForeground(new java.awt.Color(255, 0, 0));
        verify_bod.setPlaceholder("Date Of Birth");
        jPanel1.add(verify_bod, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 250, -1));

        phonel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phonel.setForeground(new java.awt.Color(102, 255, 255));
        phonel.setText("Phone :");
        jPanel1.add(phonel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 100, 30));

        emaill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emaill.setForeground(new java.awt.Color(102, 255, 255));
        emaill.setText("Email :");
        jPanel1.add(emaill, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 100, 30));

        nidl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nidl.setForeground(new java.awt.Color(102, 255, 255));
        nidl.setText("Nid/Birth No: ");
        jPanel1.add(nidl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 100, 30));

        fullnametf.setEditable(false);
        fullnametf.setBackground(new java.awt.Color(0, 0, 0));
        fullnametf.setBorder(null);
        fullnametf.setForeground(new java.awt.Color(51, 255, 51));
        fullnametf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fullnametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnametfActionPerformed(evt);
            }
        });
        jPanel1.add(fullnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 530, 30));

        fullnamel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fullnamel.setForeground(new java.awt.Color(102, 255, 255));
        fullnamel.setText("Full Name :");
        jPanel1.add(fullnamel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 100, 30));

        bodl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bodl.setForeground(new java.awt.Color(102, 255, 255));
        bodl.setText("Date of birth :");
        jPanel1.add(bodl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 100, 30));

        institutel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        institutel.setForeground(new java.awt.Color(102, 255, 255));
        institutel.setText("Institute/Office :");
        jPanel1.add(institutel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 100, 30));

        insidl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        insidl.setForeground(new java.awt.Color(102, 255, 255));
        insidl.setText("ID of institute/office :");
        jPanel1.add(insidl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 130, 30));

        fulladdressl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fulladdressl.setForeground(new java.awt.Color(102, 255, 255));
        fulladdressl.setText("Student Status :");
        jPanel1.add(fulladdressl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, 100, 30));

        genderl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderl.setForeground(new java.awt.Color(102, 255, 255));
        genderl.setText("Gender :");
        jPanel1.add(genderl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 100, 30));

        useridl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        useridl.setForeground(new java.awt.Color(102, 255, 255));
        useridl.setText("User ID :");
        jPanel1.add(useridl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 100, 30));

        useridtf.setEditable(false);
        useridtf.setBackground(new java.awt.Color(0, 0, 0));
        useridtf.setBorder(null);
        useridtf.setForeground(new java.awt.Color(51, 255, 51));
        useridtf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        useridtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridtfActionPerformed(evt);
            }
        });
        jPanel1.add(useridtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 530, 30));

        emailtf.setEditable(false);
        emailtf.setBackground(new java.awt.Color(0, 0, 0));
        emailtf.setBorder(null);
        emailtf.setForeground(new java.awt.Color(51, 255, 51));
        emailtf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtfActionPerformed(evt);
            }
        });
        jPanel1.add(emailtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 530, 30));

        gendertf.setEditable(false);
        gendertf.setBackground(new java.awt.Color(0, 0, 0));
        gendertf.setBorder(null);
        gendertf.setForeground(new java.awt.Color(51, 255, 51));
        gendertf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gendertf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gendertfActionPerformed(evt);
            }
        });
        jPanel1.add(gendertf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 530, 30));

        nidbirthtf.setEditable(false);
        nidbirthtf.setBackground(new java.awt.Color(0, 0, 0));
        nidbirthtf.setBorder(null);
        nidbirthtf.setForeground(new java.awt.Color(51, 255, 51));
        nidbirthtf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nidbirthtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nidbirthtfActionPerformed(evt);
            }
        });
        jPanel1.add(nidbirthtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 530, 30));

        dobtf.setEditable(false);
        dobtf.setBackground(new java.awt.Color(0, 0, 0));
        dobtf.setBorder(null);
        dobtf.setForeground(new java.awt.Color(51, 255, 51));
        dobtf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dobtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobtfActionPerformed(evt);
            }
        });
        jPanel1.add(dobtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 530, 30));

        instituteofficetf.setEditable(false);
        instituteofficetf.setBackground(new java.awt.Color(0, 0, 0));
        instituteofficetf.setBorder(null);
        instituteofficetf.setForeground(new java.awt.Color(51, 255, 51));
        instituteofficetf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        instituteofficetf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instituteofficetfActionPerformed(evt);
            }
        });
        jPanel1.add(instituteofficetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 530, 30));

        idofinstitute.setEditable(false);
        idofinstitute.setBackground(new java.awt.Color(0, 0, 0));
        idofinstitute.setBorder(null);
        idofinstitute.setForeground(new java.awt.Color(51, 255, 51));
        idofinstitute.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idofinstitute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idofinstituteActionPerformed(evt);
            }
        });
        jPanel1.add(idofinstitute, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 500, 30));

        phonetf.setEditable(false);
        phonetf.setBackground(new java.awt.Color(0, 0, 0));
        phonetf.setBorder(null);
        phonetf.setForeground(new java.awt.Color(51, 255, 51));
        phonetf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phonetf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetfActionPerformed(evt);
            }
        });
        jPanel1.add(phonetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 530, 30));

        Status.setEditable(false);
        Status.setBackground(new java.awt.Color(0, 0, 0));
        Status.setBorder(null);
        Status.setForeground(new java.awt.Color(51, 255, 51));
        Status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });
        jPanel1.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 530, 30));

        rSMaterialButtonCircle1.setText("verify");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, 50));

        fulladdressl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fulladdressl1.setForeground(new java.awt.Color(102, 255, 255));
        fulladdressl1.setText("Full Address :");
        jPanel1.add(fulladdressl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 100, 30));

        fulladdresstf.setEditable(false);
        fulladdresstf.setBackground(new java.awt.Color(0, 0, 0));
        fulladdresstf.setBorder(null);
        fulladdresstf.setForeground(new java.awt.Color(51, 255, 51));
        fulladdresstf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fulladdresstf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fulladdresstfActionPerformed(evt);
            }
        });
        jPanel1.add(fulladdresstf, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 530, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 720));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 255));
        jMenuBar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        home.setBackground(new java.awt.Color(204, 0, 0));
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jMenuBar1.add(home);

        jMenu1.setText("Registation");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Login");

        jMenuItem1.setBackground(new java.awt.Color(204, 255, 204));
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItem1.setText("Student Login");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem4.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItem4.setText("Librarian Login");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem2.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItem2.setText("Moderator Login");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setForeground(new java.awt.Color(0, 0, 255));
        jMenuItem3.setText("Admin Login");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Choice Book");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        help.setText("Help");
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
        });
        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fullnametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnametfActionPerformed

    private void useridtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridtfActionPerformed

    private void emailtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtfActionPerformed

    private void gendertfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gendertfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gendertfActionPerformed

    private void nidbirthtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nidbirthtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nidbirthtfActionPerformed

    private void dobtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobtfActionPerformed

    private void instituteofficetfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instituteofficetfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instituteofficetfActionPerformed

    private void idofinstituteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idofinstituteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idofinstituteActionPerformed

    private void phonetfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetfActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

        if (data_valid()){
            if(verify_user()){
                JOptionPane.showMessageDialog(this,"Student verifyed!");
                showoutput();
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        home_page p = new home_page();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

    }//GEN-LAST:event_homeActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        registation s = new registation();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        moderator_login ml = new moderator_login();
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        admin_login al = new admin_login();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        Choice_book cb = new Choice_book();
        cb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        // TODO add your handling code here:
        Help hp = new Help();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_helpMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
            librarian_login al = new librarian_login();
            al.setVisible(true);
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void fulladdresstfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fulladdresstfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fulladdresstfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField Status;
    private javax.swing.JLabel bodl;
    private app.bolivia.swing.JCTextField dobtf;
    private javax.swing.JLabel emaill;
    private app.bolivia.swing.JCTextField emailtf;
    private javax.swing.JLabel fulladdressl;
    private javax.swing.JLabel fulladdressl1;
    private app.bolivia.swing.JCTextField fulladdresstf;
    private javax.swing.JLabel fullnamel;
    private app.bolivia.swing.JCTextField fullnametf;
    private javax.swing.JLabel genderl;
    private app.bolivia.swing.JCTextField gendertf;
    private javax.swing.JMenu help;
    private javax.swing.JMenu home;
    private app.bolivia.swing.JCTextField idofinstitute;
    private javax.swing.JLabel insidl;
    private javax.swing.JLabel institutel;
    private app.bolivia.swing.JCTextField instituteofficetf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private app.bolivia.swing.JCTextField nidbirthtf;
    private javax.swing.JLabel nidl;
    private javax.swing.JLabel phonel;
    private app.bolivia.swing.JCTextField phonetf;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JLabel useridl;
    private app.bolivia.swing.JCTextField useridtf;
    private rojeru_san.componentes.RSDateChooser verify_bod;
    private app.bolivia.swing.JCTextField verify_nidbirthtf;
    // End of variables declaration//GEN-END:variables
}
