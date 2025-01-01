


package jframe;

import jframe.method_romjanali01673.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import jframe.moderator_file.approve_student;
/**
 *
 * @author romja
 */
public class moderator_login extends javax.swing.JFrame {
// verify Moderator start -----
public boolean bod_date_valid=false;

int user_id; 
String fast_name;
String last_name ;
String phone ;
String email ;
String gender ;
long nid_birth_number ;
java.sql.Date Date_of_birth ; 
String Position ;
String full_address ;
String status;
// verify Moderator end-------
    
// login start -----
    int id = 0;
    necessaryMethod nm = new necessaryMethod();
    
    String user_names;
    String passwd;
    String position = "MODERATOR";
// login end ------
    
    public moderator_login() {
        initComponents();
    }
    
// verify Moderator start -----
    public void showoutput(){
         useridtf.setText(String.format("%08d", user_id));
         fullnametf.setText(fast_name+" "+last_name);
         phonetf.setText(phone);
         emailtf.setText(email);
         gendertf.setText(gender);
         nidbirthtf.setText(Long.toString(nid_birth_number));
         dobtf.setText(Date_of_birth.toString());
         positiontf.setText(Position);
         f_addresstf.setText(full_address);
         student_type.setText(status);

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
    String sql = "SELECT * FROM employee_data WHERE employee_data.nid = ? and employee_data.dob = ?;";
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
        nid_birth_number = rs.getLong("nid"); 
        Date_of_birth = rs.getDate("dob"); 
        Position = rs.getString("position"); 
        full_address = rs.getString("full_address");
        status = rs.getString("e_status");
    } else {
        JOptionPane.showMessageDialog(this, "The Moderator does not exist!"); 

        
        
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
// verify Moderator end
    
    
// login start -----
    public void updatepass(String U_name, String newpass){
        if(newpass.equals("")){
            JOptionPane.showMessageDialog(this,"password forgotten failed!");
        }
        else{
            Connection con = DB_connection.getConnection();
            try{
            //method 1: 
            String sql = "update employee_data set pass = ? where user_id = ? and position = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1,newpass);
            pst.setString(2,U_name);
            pst.setString(3,position);
            
            pst.executeUpdate();
            
                        pst.close();
            
            }catch (Exception e){
            JOptionPane.showMessageDialog(this, "server error");
            }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
            JOptionPane.showMessageDialog(this,"password updated.");
        }
    }
      public void valid(){
          id = nm.stringToint(user_name.getText());
        if(validity()){
        Connection con = DB_connection.getConnection();
        try{
        String sql = "select * from employee_data where user_id =? and pass = ? and position = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, user_names);
        pst.setString(2,passwd);
        pst.setString(3,position);
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(this,"You have successfully Logined");
            approve_student as = new approve_student(id);
            as.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"User not found!");
        }
                    pst.close();
            rs.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"server error!");
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        }
    }
    public boolean forgotten_pass(int id, String name){
        boolean result = false;
        Connection con = DB_connection.getConnection();
        try{
        String sql = "select * from employee_data where user_id = ? and last_name = ? and position = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(2,name);
        pst.setInt(1, id);
        pst.setString(3,position);
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            result = true;
        }
                    pst.close();
            rs.close();
        }catch (Exception e ){
            e.printStackTrace();
            
    }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public boolean validity(){
        get_login_data();
        boolean result= true;
        if(user_names.equals("")){
            JOptionPane.showMessageDialog(this,"Enter username:");
            result = false;
        }   
        else if(passwd.equals("")){
            JOptionPane.showMessageDialog(this,"Enter Password");
            result = false;
        }
        return result;
    }
    
    public boolean get_login_data(){
    boolean result = true;
    try{
    user_names = user_name.getText();
    char [] p = password.getPassword();
    passwd  = String.valueOf(p);
    }catch (Exception e ){
        JOptionPane.showMessageDialog(this, "Enter valid data!");
        result = false;
    }
        return result;
    }
// login end  ------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        password = new rojerusan.RSPasswordTextPlaceHolder();
        login = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        forgot = new javax.swing.JLabel();
        user_name = new app.bolivia.swing.JCTextField();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        verify_nidbirthtf = new app.bolivia.swing.JCTextField();
        verify_bod = new rojeru_san.componentes.RSDateChooser();
        phonel = new javax.swing.JLabel();
        emaill = new javax.swing.JLabel();
        nidl = new javax.swing.JLabel();
        fullnametf = new app.bolivia.swing.JCTextField();
        fullnamel = new javax.swing.JLabel();
        bodl = new javax.swing.JLabel();
        institutel = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        genderl = new javax.swing.JLabel();
        useridl = new javax.swing.JLabel();
        useridtf = new app.bolivia.swing.JCTextField();
        emailtf = new app.bolivia.swing.JCTextField();
        gendertf = new app.bolivia.swing.JCTextField();
        nidbirthtf = new app.bolivia.swing.JCTextField();
        dobtf = new app.bolivia.swing.JCTextField();
        positiontf = new app.bolivia.swing.JCTextField();
        f_addresstf = new app.bolivia.swing.JCTextField();
        phonetf = new app.bolivia.swing.JCTextField();
        student_type = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        Home_Page = new javax.swing.JButton();
        gendertf1 = new app.bolivia.swing.JCTextField();
        genderl1 = new javax.swing.JLabel();
        fulladdressl = new javax.swing.JLabel();
        student_type1 = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setPhColor(new java.awt.Color(0, 0, 0));
        password.setPlaceholder("Enter Your Password");
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 270, 40));

        login.setBackground(new java.awt.Color(153, 153, 153));
        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setText("Login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 280, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("Login Fast");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secure_50px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 50, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 51));
        jLabel4.setText("Welcome To Moderator Login");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 50, 50));

        forgot.setForeground(new java.awt.Color(255, 51, 51));
        forgot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgot.setText("Forgotten password?");
        forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotMouseClicked(evt);
            }
        });
        jPanel1.add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 170, 40));

        user_name.setPlaceholder("Enter your user name : ");
        jPanel1.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 270, 40));

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        close.setForeground(new java.awt.Color(102, 255, 102));
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
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 0, 40, 30));

        minimize.setBackground(new java.awt.Color(255, 255, 255));
        minimize.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        minimize.setForeground(new java.awt.Color(102, 255, 102));
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
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 30, 40, 17));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 675, 720));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("To verify you, you have to provide us some information!");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 350, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 255));
        jLabel6.setText("Varify Moderator.");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 140, 50));

        verify_nidbirthtf.setPlaceholder("Enter Your NID/Birth Number :");
        jPanel2.add(verify_nidbirthtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 250, 40));

        verify_bod.setColorBackground(new java.awt.Color(255, 0, 0));
        verify_bod.setColorButtonHover(new java.awt.Color(0, 0, 255));
        verify_bod.setColorDiaActual(new java.awt.Color(0, 0, 255));
        verify_bod.setColorForeground(new java.awt.Color(255, 0, 0));
        verify_bod.setPlaceholder("Date Of Birth");
        jPanel2.add(verify_bod, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 250, -1));

        phonel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phonel.setForeground(new java.awt.Color(102, 255, 255));
        phonel.setText("Phone :");
        jPanel2.add(phonel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 100, 30));

        emaill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emaill.setForeground(new java.awt.Color(102, 255, 255));
        emaill.setText("Email :");
        jPanel2.add(emaill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 100, 30));

        nidl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nidl.setForeground(new java.awt.Color(102, 255, 255));
        nidl.setText("Nid/Birth No: ");
        jPanel2.add(nidl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 100, 30));

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
        jPanel2.add(fullnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 460, 30));

        fullnamel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fullnamel.setForeground(new java.awt.Color(102, 255, 255));
        fullnamel.setText("Full Name :");
        jPanel2.add(fullnamel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 100, 30));

        bodl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bodl.setForeground(new java.awt.Color(102, 255, 255));
        bodl.setText("Date of birth :");
        jPanel2.add(bodl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 100, 30));

        institutel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        institutel.setForeground(new java.awt.Color(102, 255, 255));
        institutel.setText("Position");
        jPanel2.add(institutel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 100, 30));

        type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        type.setForeground(new java.awt.Color(102, 255, 255));
        type.setText("Moderator Status :");
        jPanel2.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 120, 30));

        genderl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderl.setForeground(new java.awt.Color(102, 255, 255));
        genderl.setText("Gender :");
        jPanel2.add(genderl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 100, 30));

        useridl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        useridl.setForeground(new java.awt.Color(102, 255, 255));
        useridl.setText("User ID :");
        jPanel2.add(useridl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 100, 30));

        useridtf.setEditable(false);
        useridtf.setBackground(new java.awt.Color(0, 0, 0));
        useridtf.setBorder(null);
        useridtf.setForeground(new java.awt.Color(51, 255, 51));
        useridtf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        useridtf.setPlaceholder("hii");
        useridtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridtfActionPerformed(evt);
            }
        });
        jPanel2.add(useridtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 460, 30));

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
        jPanel2.add(emailtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 460, 30));

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
        jPanel2.add(gendertf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 460, 30));

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
        jPanel2.add(nidbirthtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 460, 30));

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
        jPanel2.add(dobtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 460, 30));

        positiontf.setEditable(false);
        positiontf.setBackground(new java.awt.Color(0, 0, 0));
        positiontf.setBorder(null);
        positiontf.setForeground(new java.awt.Color(51, 255, 51));
        positiontf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        positiontf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positiontfActionPerformed(evt);
            }
        });
        jPanel2.add(positiontf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 460, 30));

        f_addresstf.setEditable(false);
        f_addresstf.setBackground(new java.awt.Color(0, 0, 0));
        f_addresstf.setBorder(null);
        f_addresstf.setForeground(new java.awt.Color(51, 255, 51));
        f_addresstf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        f_addresstf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_addresstfActionPerformed(evt);
            }
        });
        jPanel2.add(f_addresstf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 460, 30));

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
        jPanel2.add(phonetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 460, 30));

        student_type.setEditable(false);
        student_type.setBackground(new java.awt.Color(0, 0, 0));
        student_type.setBorder(null);
        student_type.setForeground(new java.awt.Color(51, 255, 51));
        student_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        student_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_typeActionPerformed(evt);
            }
        });
        jPanel2.add(student_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, 140, 30));

        rSMaterialButtonCircle1.setText("verify");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, 50));

        Home_Page.setBackground(new java.awt.Color(255, 204, 255));
        Home_Page.setForeground(new java.awt.Color(204, 0, 0));
        Home_Page.setText("Home Page");
        Home_Page.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Home_Page.setPreferredSize(new java.awt.Dimension(666, 18));
        Home_Page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_PageActionPerformed(evt);
            }
        });
        jPanel2.add(Home_Page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        gendertf1.setEditable(false);
        gendertf1.setBackground(new java.awt.Color(0, 0, 0));
        gendertf1.setBorder(null);
        gendertf1.setForeground(new java.awt.Color(51, 255, 51));
        gendertf1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gendertf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gendertf1ActionPerformed(evt);
            }
        });
        jPanel2.add(gendertf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 460, 30));

        genderl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genderl1.setForeground(new java.awt.Color(102, 255, 255));
        genderl1.setText("Gender :");
        jPanel2.add(genderl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 100, 30));

        fulladdressl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fulladdressl.setForeground(new java.awt.Color(102, 255, 255));
        fulladdressl.setText("Full Address :");
        jPanel2.add(fulladdressl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 100, 30));

        student_type1.setEditable(false);
        student_type1.setBackground(new java.awt.Color(0, 0, 0));
        student_type1.setBorder(null);
        student_type1.setForeground(new java.awt.Color(51, 255, 51));
        student_type1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        student_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_type1ActionPerformed(evt);
            }
        });
        jPanel2.add(student_type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 670, 140, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameActionPerformed

    private void Home_PageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_PageActionPerformed
        home_page hp = new home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home_PageActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loginActionPerformed

    private void forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseClicked
        // TODO add your handling code here:
        String U_name =JOptionPane.showInputDialog(this, "what is user_id?");
        U_name = nm.remove_white_space(U_name);
        int user_id = Integer.parseInt(U_name);
        String A_name = JOptionPane.showInputDialog(this, "What is your \"Last Name\" name?");
        A_name = nm.remove_white_space(A_name);
        if(forgotten_pass(user_id,A_name)){
            String pass = JOptionPane.showInputDialog(this, "Enter new password:");
            updatepass(U_name, pass);
        }
        else{
            JOptionPane.showMessageDialog(this,"user not found!");
                    
        }
    }//GEN-LAST:event_forgotMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
valid();
// TODO add your handling code here:
    }//GEN-LAST:event_loginMouseClicked

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

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

        if (data_valid()){
            if(verify_user()){
                JOptionPane.showMessageDialog(this,"Moderator Verifyed!");
                showoutput();
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void student_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_typeActionPerformed

    private void positiontfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positiontfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positiontfActionPerformed

    private void dobtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobtfActionPerformed

    private void nidbirthtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nidbirthtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nidbirthtfActionPerformed

    private void gendertfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gendertfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gendertfActionPerformed

    private void emailtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtfActionPerformed

    private void phonetfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetfActionPerformed

    private void fullnametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnametfActionPerformed

    private void useridtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridtfActionPerformed

    private void gendertf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gendertf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gendertf1ActionPerformed

    private void student_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_type1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_type1ActionPerformed

    private void f_addresstfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_addresstfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_addresstfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(moderator_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(moderator_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(moderator_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(moderator_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new moderator_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home_Page;
    private javax.swing.JLabel bodl;
    private javax.swing.JLabel close;
    private app.bolivia.swing.JCTextField dobtf;
    private javax.swing.JLabel emaill;
    private app.bolivia.swing.JCTextField emailtf;
    private app.bolivia.swing.JCTextField f_addresstf;
    private javax.swing.JLabel forgot;
    private javax.swing.JLabel fulladdressl;
    private javax.swing.JLabel fullnamel;
    private app.bolivia.swing.JCTextField fullnametf;
    private javax.swing.JLabel genderl;
    private javax.swing.JLabel genderl1;
    private app.bolivia.swing.JCTextField gendertf;
    private app.bolivia.swing.JCTextField gendertf1;
    private javax.swing.JLabel institutel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle login;
    private javax.swing.JLabel minimize;
    private app.bolivia.swing.JCTextField nidbirthtf;
    private javax.swing.JLabel nidl;
    private rojerusan.RSPasswordTextPlaceHolder password;
    private javax.swing.JLabel phonel;
    private app.bolivia.swing.JCTextField phonetf;
    private app.bolivia.swing.JCTextField positiontf;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField student_type;
    private app.bolivia.swing.JCTextField student_type1;
    private javax.swing.JLabel type;
    private app.bolivia.swing.JCTextField user_name;
    private javax.swing.JLabel useridl;
    private app.bolivia.swing.JCTextField useridtf;
    private rojeru_san.componentes.RSDateChooser verify_bod;
    private app.bolivia.swing.JCTextField verify_nidbirthtf;
    // End of variables declaration//GEN-END:variables
}
