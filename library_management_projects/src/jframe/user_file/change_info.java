package jframe.user_file;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import jframe.method_romjanali01673.DB_connection;
import jframe.home_page;
import jframe.method_romjanali01673.necessaryMethod;

public class change_info extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    int id;
    public String Gender = "Male";
    public boolean bod_date_valid = false;
    String passwd ;
    
String fast_namer = "";
String last_namer = "";
String phoner  = "";
String emailr  = "";
String genderr  = "";
long nid_birth_numberr = 0l ;
java.sql.Date Date_of_birthr=null ; 
String institute_officer  = "";
String id_numberr = "";
String full_addressr  = "";
String passr = "";

    public change_info(int id) {
        this.id = id;
        initComponents();
        set_profile();
        get_pastdata(id);
        set_user_data();
        
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
        public String remove_white_space(String str){
        // Remove leading whitespaces
        int start = 0;
        while (start < str.length() && Character.isWhitespace(str.charAt(start))) {
            start++;
        }

        // Remove trailing whitespaces
        int end = str.length() - 1;
        while (end >= 0 && Character.isWhitespace(str.charAt(end))) {
            end--;
        }
        String sub_string = str.substring(start, end+1);

        // Return the substring without leading and trailing whitespaces
        return sub_string;
    }
public void set_user_data(){
fast_name.setText(fast_namer);
 last_name.setText(last_namer);
 phone .setText(phoner);
 email .setText(emailr);
if(genderr.equals("Male")){
    male.setSelected(true);
}
else if(genderr.equals("Female")){
    female.setSelected(true);
}
else{
    custom.setSelected(true);
}
 nid_birth_number.setText(String.valueOf(nid_birth_numberr));
 date_of_birth.setDatoFecha(Date_of_birthr);
 institute_office .setText(institute_officer);
 id_of_institute_office.setText(id_numberr);
 full_address .setText(full_addressr);
 password.setText(passr);
 confirm_password.setText(passr);
    }
    
    public void get_pastdata(int id){     
    Connection con = DB_connection.getConnection();
    try {
    String sql = "SELECT * FROM student_data WHERE user_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1,id);

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
        passr = rs.getString("pass");
    } else {
        JOptionPane.showMessageDialog(this, "The student does not exist!"); 
        
    }
    //System.out.println(Date_of_birth);
            pst.close();
        rs.close();
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

    // creating a mehod for gender 

    public void getGender(String gender){
        Gender = gender;
    }
    
    public long get_nid_or_birth_number(){
        
        long NID_B_Number = 0L;
        String NID_B_number = nid_birth_number.getText();
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
        bod_date_valid = false;// ai method er " bod_date_valid"  er value akbar change hoila joto e event hok na kano er default value asbe na. last changes e takba.
        
        java.sql.Date DATE_OF_BIRTH = new java.sql.Date(2004-02-01);
        try{
        // we will get the util-date from the compunents and we have to use the method getDatoFecha()
        // to save the date in database we have to convart in sql-date
        //the process is util-long-sql
        Date DOB = date_of_birth.getDatoFecha();//util date
        Long dateofbirth = DOB.getTime();//long date
        DATE_OF_BIRTH = new java.sql.Date(dateofbirth);//sql date 
        }catch (Exception e ){
            JOptionPane.showMessageDialog(this,"Enter your Date of Birth!");
            bod_date_valid = true;
        }
            return DATE_OF_BIRTH ;
    }
    
    public String pass(){
        
        char[] Password = password.getPassword();
        char[] C_Password = confirm_password.getPassword();
        String Pass1 = String.valueOf(Password);//fast way
        String Pass2 = String.valueOf(C_Password);
        //System.out.println(Password);
        if (Pass1.equals(Pass2)){
           passwd =Pass2; 
           
        }
        else{
            JOptionPane.showMessageDialog(this, "Confirm password doesn't matched");

        }
        return passwd;
    }

    public boolean  necessary_data_insarted(){
        
        boolean res = true;
        get_Birth_Date();
        
        String F_name  = fast_name.getText();
        String L_name = last_name.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        String Institute_Office = institute_office.getText();
        String ID_Of_Institute_Office = id_of_institute_office.getText();
        String F_address  = full_address.getText();
        
        
        if (F_name.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your Fast Namae: ");
     
            res =  false;
        }
        
        else if (L_name.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your Last Namae: ");
           
            res =  false;
        }
        else if (Phone.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your phone number: ");
           
            res =  false;
        }
        else if (Email.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your Email Address: ");
           
            res =  false;
        }
        else if(get_nid_or_birth_number()==0L){
            res =  false;
        }
        else if(bod_date_valid){
            res =  false;
        }       
        else if (Institute_Office.equals("") ){
            JOptionPane.showMessageDialog(this,  "Enter Institute of Office Name: ");

            res =  false;
        }
        else if (ID_Of_Institute_Office.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your ID number of \"institute or Office:\" ");

            res =  false;
        }
        else if (F_address.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your Full Address: ");

            res =  false;
        }
        else if(pass().equals("")){
            JOptionPane.showMessageDialog(this, "Enter password");

            res = false;
        }
        return res ;
    }
    

    
    // method insart  new values into user table 
    public void update(){
        
        String F_name  = fast_name.getText().toUpperCase();
        String L_name = last_name.getText().toUpperCase();
        String Phone = phone.getText().toUpperCase();
        String Email = email.getText().toUpperCase();
        String Institute_Office = institute_office.getText().toUpperCase();
        String ID_Of_Institute_Office = id_of_institute_office.getText().toUpperCase();
        String F_address  = full_address.getText().toUpperCase();

        
        
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into changes_student_data (fast_name , last_name  ,phone , email , gender , nid_birth , dob , institute_office , ins_office_id , full_address , remark,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql1 = "update student_data set pass = ? where user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1);
            
            pst1.setString(1, pass());
            pst1.setInt(2, id);
            
            pst.setString(1, remove_white_space(F_name));
            pst.setString(2, remove_white_space(L_name));
            pst.setString(3, remove_white_space(Phone));
            pst.setString(4, remove_white_space(Email));
            pst.setString(5, Gender);
            pst.setLong(6, get_nid_or_birth_number());
            pst.setDate(7, get_Birth_Date());
            pst.setString(8, remove_white_space(Institute_Office));
            pst.setString(9, remove_white_space(ID_Of_Institute_Office));
            pst.setString(10, remove_white_space(F_address));
            pst.setString(11,remove_white_space(remarktf.getText()));
            pst.setInt(12,id);

            int updatedRowCount = pst.executeUpdate();
            int updatedRowCount1 = pst1.executeUpdate();
       
           
            if ( updatedRowCount > 0 && updatedRowCount1>0){
                requested1();

           }
           else{
               JOptionPane.showMessageDialog(this, "record Insarte faled!"); 
           }           pst.close();
                       pst1.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Already Change");
            e.printStackTrace();
       
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void requested1(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "insert into student_history ( T_status, T_date, T_time, user_id,by_who) values(?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"CHANGE");
            pst.setDate(2,nm.getTodayDate());
            pst.setTime(3,nm.getNowTime());
            pst.setInt(4, id);
            pst.setString(5,"STUDENT");
            
            int rs = pst.executeUpdate();
            if(rs>0){
               JOptionPane.showMessageDialog(this, "Account Update request was send");
               JOptionPane.showMessageDialog(this, "visit our office with all necesary document..");
               JOptionPane.showMessageDialog(this, "Remamber, Password has been updated");
            }
                pst.close();
        }catch(Exception e ){
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        institutecb = new javax.swing.JCheckBox();
        ins_idcb = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        last_namecb = new javax.swing.JCheckBox();
        fast_namecb = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        passcb = new javax.swing.JCheckBox();
        nidorbirthcb = new javax.swing.JCheckBox();
        full_addresscb = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        emailcb = new javax.swing.JCheckBox();
        phonecb = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        gendercb = new javax.swing.JCheckBox();
        dobcb = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        WELCOME = new javax.swing.JPanel();
        fast_name = new app.bolivia.swing.JCTextField();
        phone = new app.bolivia.swing.JCTextField();
        date_of_birth = new rojeru_san.componentes.RSDateChooser();
        male = new javax.swing.JRadioButton();
        submit = new rojerusan.RSMaterialButtonCircle();
        last_name = new app.bolivia.swing.JCTextField();
        institute_office = new app.bolivia.swing.JCTextField();
        female = new javax.swing.JRadioButton();
        id_of_institute_office = new app.bolivia.swing.JCTextField();
        nid_birth_number = new app.bolivia.swing.JCTextField();
        password = new rojerusan.RSPasswordTextPlaceHolder();
        confirm_password = new rojerusan.RSPasswordTextPlaceHolder();
        email = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        full_address = new app.bolivia.swing.JCTextField();
        custom = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarktf = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        institutecb.setText("Institute or Office Name");
        institutecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                institutecbItemStateChanged(evt);
            }
        });
        jPanel2.add(institutecb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        ins_idcb.setText("Institute Or Office id");
        ins_idcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ins_idcbItemStateChanged(evt);
            }
        });
        jPanel2.add(ins_idcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("INSTITUTE OR OFFICE INFO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        last_namecb.setText("last name");
        last_namecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                last_namecbItemStateChanged(evt);
            }
        });
        jPanel2.add(last_namecb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        fast_namecb.setText("fast name");
        fast_namecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fast_namecbItemStateChanged(evt);
            }
        });
        jPanel2.add(fast_namecb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("NAME ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        passcb.setText("Password");
        passcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                passcbItemStateChanged(evt);
            }
        });
        passcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passcbActionPerformed(evt);
            }
        });
        jPanel2.add(passcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        nidorbirthcb.setText("NID/Birth Number");
        nidorbirthcb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nidorbirthcbStateChanged(evt);
            }
        });
        nidorbirthcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nidorbirthcbActionPerformed(evt);
            }
        });
        jPanel2.add(nidorbirthcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        full_addresscb.setText("Full Address");
        jPanel2.add(full_addresscb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("OTHER INFO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        emailcb.setText("email");
        emailcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                emailcbItemStateChanged(evt);
            }
        });
        jPanel2.add(emailcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        phonecb.setText("phone");
        phonecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                phonecbItemStateChanged(evt);
            }
        });
        jPanel2.add(phonecb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("CONTACT");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        gendercb.setText("Gender");
        gendercb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gendercbItemStateChanged(evt);
            }
        });
        gendercb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gendercbActionPerformed(evt);
            }
        });
        jPanel2.add(gendercb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        dobcb.setText("Date Of Birth");
        dobcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dobcbItemStateChanged(evt);
            }
        });
        dobcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobcbActionPerformed(evt);
            }
        });
        jPanel2.add(dobcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Check For Edit");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 7));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 670));

        WELCOME.setBackground(new java.awt.Color(0, 0, 0));

        fast_name.setEditable(false);
        fast_name.setToolTipText("");
        fast_name.setNextFocusableComponent(last_name);
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

        date_of_birth.setColorBackground(new java.awt.Color(255, 0, 0));
        date_of_birth.setColorButtonHover(new java.awt.Color(255, 51, 51));
        date_of_birth.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date_of_birth.setEnabled(false);
        date_of_birth.setFormatoFecha("dd/MM/yyyy");
        date_of_birth.setName(""); // NOI18N
        date_of_birth.setOpaque(true);
        date_of_birth.setPlaceholder("Date of Birth");

        buttonGroup1.add(male);
        male.setSelected(true);
        male.setText("male");
        male.setEnabled(false);
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        submit.setText("submit");
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

        last_name.setEditable(false);
        last_name.setPlaceholder("Last Name");

        institute_office.setEditable(false);
        institute_office.setPlaceholder("Institute/ Office Name");
        institute_office.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institute_officeActionPerformed(evt);
            }
        });

        buttonGroup1.add(female);
        female.setText("female");
        female.setEnabled(false);
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        id_of_institute_office.setEditable(false);
        id_of_institute_office.setPlaceholder("ID number of institute/office");
        id_of_institute_office.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_of_institute_officeActionPerformed(evt);
            }
        });

        nid_birth_number.setEditable(false);
        nid_birth_number.setToolTipText("nid -10,13,17 digit and birth 16,17 digit");
        nid_birth_number.setPlaceholder("NID/Birth number ");
        nid_birth_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_birth_numberActionPerformed(evt);
            }
        });

        password.setEditable(false);
        password.setPlaceholder("New Password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        confirm_password.setEditable(false);
        confirm_password.setPlaceholder("Confirm Password");

        email.setEditable(false);
        email.setPlaceholder("Email Address");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Select Your Gender-");

        full_address.setEditable(false);
        full_address.setPlaceholder("Full Address");

        buttonGroup1.add(custom);
        custom.setText("custom");
        custom.setEnabled(false);
        custom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Edit From The TextFeild");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("why do you want to change your information?");

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusTraversalPolicyProvider(true);

        remarktf.setColumns(15);
        remarktf.setLineWrap(true);
        remarktf.setRows(4);
        remarktf.setTabSize(4);
        remarktf.setText("Remark Here...");
        remarktf.setToolTipText("More Details = More Possiblity To Approve Your Request.");
        remarktf.setWrapStyleWord(true);
        remarktf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        remarktf.setPreferredSize(new java.awt.Dimension(0, 0));
        remarktf.setSelectedTextColor(new java.awt.Color(51, 0, 255));
        remarktf.setSelectionColor(new java.awt.Color(153, 153, 255));
        jScrollPane1.setViewportView(remarktf);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("New Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fast Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Last Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Full Address");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Institute or Office Name");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Email Address");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Password*");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("NID or Birth Number");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Date of Birth");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Institute or Office ID");

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20)
                                        .addComponent(date_of_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(custom)
                                                .addComponent(female)
                                                .addComponent(male))
                                            .addComponent(jLabel21))))
                                .addComponent(full_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel16))
                                    .addGap(44, 44, 44)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(id_of_institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(272, 272, 272))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                        .addGap(51, 51, 51))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(61, Short.MAX_VALUE))))
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(custom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date_of_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id_of_institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 165, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 670));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("User Portal");
        MENU_BAR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Edit Student Info");
        MENU_BAR.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel17.setText("NOTIFICATION");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        MENU_BAR.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 140, -1));

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

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked

        int s = JOptionPane.showConfirmDialog(null," do you want to logout? ","confirmation message", JOptionPane.YES_NO_OPTION);
        if ( s == JOptionPane.YES_OPTION){
            home.setVisible(true);
            this.dispose();
        }
        else if(s == JOptionPane.NO_OPTION){
            System.out.println("you have clicked NO");
        }      
        else{
            System.out.println("you have clicked NO");
        }
    }//GEN-LAST:event_nameMouseClicked

    private void fast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_nameActionPerformed

    }//GEN-LAST:event_fast_nameActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        getGender("Male");
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        getGender("Female");
    }//GEN-LAST:event_femaleActionPerformed

    private void customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customActionPerformed
        getGender("Custom");
    }//GEN-LAST:event_customActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed


    }//GEN-LAST:event_submitActionPerformed

    private void nid_birth_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birth_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birth_numberActionPerformed

    private void gendercbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gendercbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gendercbActionPerformed

    private void nidorbirthcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nidorbirthcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nidorbirthcbActionPerformed

    private void passcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passcbActionPerformed

    private void dobcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobcbActionPerformed

    private void institute_officeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute_officeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute_officeActionPerformed

    private void phonecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_phonecbItemStateChanged
        // TODO add your handling code here:
        if(phonecb.isSelected()){
            phone.setEditable(true);
        }
        else{
            phone.setEditable(false);
            System.out.print("dsfhjks");
        }
    }//GEN-LAST:event_phonecbItemStateChanged

    private void fast_namecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fast_namecbItemStateChanged
        if(fast_namecb.isSelected()){
            fast_name.setEditable(true);
        }
        else{
            fast_name.setEditable(false);
            
        }
    }//GEN-LAST:event_fast_namecbItemStateChanged

    private void last_namecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_last_namecbItemStateChanged
        if(last_namecb.isSelected()){
            last_name.setEditable(true);
        }
        else{
            last_name.setEditable(false);
        }
   
    }//GEN-LAST:event_last_namecbItemStateChanged

    private void emailcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_emailcbItemStateChanged
        if(emailcb.isSelected()){
            email.setEditable(true);
        }
        else{
            email.setEditable(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_emailcbItemStateChanged

    private void institutecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_institutecbItemStateChanged
        if(institutecb.isSelected()){
            institute_office.setEditable(true);
        }
        else{
            institute_office.setEditable(false);
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_institutecbItemStateChanged

    private void ins_idcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ins_idcbItemStateChanged
        if(ins_idcb.isSelected()){
            id_of_institute_office.setEditable(true);
        }
        else{
            id_of_institute_office.setEditable(false);
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ins_idcbItemStateChanged

    private void nidorbirthcbStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nidorbirthcbStateChanged
        if(nidorbirthcb.isSelected()){
            nid_birth_number.setEditable(true);
        }
        else{
            nid_birth_number.setEditable(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_nidorbirthcbStateChanged

    private void dobcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dobcbItemStateChanged
        // TODO add your handling code here:date_of_birth
        if(dobcb.isSelected()){
            date_of_birth.setEnabled(true);
            
        }
        else{
            date_of_birth.setEnabled(false);
        }
    }//GEN-LAST:event_dobcbItemStateChanged

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void passcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_passcbItemStateChanged
        // TODO add your handling code here:
        if(passcb.isSelected()){
            password.setEditable(true);
            confirm_password.setEditable(true); 
        } 
        else {
            password.setEditable(false);
            confirm_password.setEditable(true);
        }
    }//GEN-LAST:event_passcbItemStateChanged

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        // TODO add your handling code here:
        String x = JOptionPane.showInputDialog(this,"enter your current password.");
        if (x .equals(passr)){
                    if (necessary_data_insarted()){
                    update();}
        }
        else{
            JOptionPane.showMessageDialog(this,"Wrong Password!!!");
        }
    }//GEN-LAST:event_submitMouseClicked

    private void gendercbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gendercbItemStateChanged
        // TODO add your handling code here:
        if(gendercb.isSelected()){
           male.setEnabled(true);
           female.setEnabled(true);
           custom.setEnabled(true);
        }
        else{
           male.setEnabled(false);
           female.setEnabled(false);
           custom.setEnabled(false);
        }
    }//GEN-LAST:event_gendercbItemStateChanged

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        notification n = new notification(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

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

    private void id_of_institute_officeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_of_institute_officeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_of_institute_officeActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        book_issue bs = new book_issue(id);
        bs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    public static void main(String args[]) {
        change_info cf = new change_info(101);
        cf.setVisible(true);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(change_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(change_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(change_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(change_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel WELCOME;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel close;
    private rojerusan.RSPasswordTextPlaceHolder confirm_password;
    private javax.swing.JRadioButton custom;
    private rojeru_san.componentes.RSDateChooser date_of_birth;
    private javax.swing.JCheckBox dobcb;
    private app.bolivia.swing.JCTextField email;
    private javax.swing.JCheckBox emailcb;
    private app.bolivia.swing.JCTextField fast_name;
    private javax.swing.JCheckBox fast_namecb;
    private javax.swing.JRadioButton female;
    private app.bolivia.swing.JCTextField full_address;
    private javax.swing.JCheckBox full_addresscb;
    private javax.swing.JCheckBox gendercb;
    private javax.swing.JLabel home;
    private app.bolivia.swing.JCTextField id_of_institute_office;
    private javax.swing.JCheckBox ins_idcb;
    private app.bolivia.swing.JCTextField institute_office;
    private javax.swing.JCheckBox institutecb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JCheckBox last_namecb;
    private javax.swing.JRadioButton male;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField nid_birth_number;
    private javax.swing.JCheckBox nidorbirthcb;
    private javax.swing.JCheckBox passcb;
    private rojerusan.RSPasswordTextPlaceHolder password;
    private app.bolivia.swing.JCTextField phone;
    private javax.swing.JCheckBox phonecb;
    private javax.swing.JTextArea remarktf;
    private rojerusan.RSMaterialButtonCircle submit;
    // End of variables declaration//GEN-END:variables
}
