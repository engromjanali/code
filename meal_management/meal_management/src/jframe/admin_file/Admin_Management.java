/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe.admin_file;  

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import jframe.method_romjanali01673.DB_connection;
import jframe.admin_login;
import jframe.home_page;
import jframe.method_romjanali01673.necessaryMethod;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Admin_Management extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    int id;
    
        String fast_namer; 
        String last_namer ;
        String phoner ;
        String emailr;
        String genderr = "";
        Long nid_birth_numberr ;
        java.sql.Date Date_of_birthr;
        String e_statusr = "";
        String ftr_namer ;
        String full_addressr;
        long ftr_nidr;
        
        int s_id;
        
        String type="";
        boolean bod_date_valid;
        int root_flag = 1; 

        
    public Admin_Management(int id) {
        this.id = id;
        initComponents();
        ROOT_SIMPLE();     
    }
    public java.sql.Date get_Birth_Date(){
        bod_date_valid = false;// ai method er " bod_date_valid"  er value akbar change hoila joto e event hok na kano er default value asbe na. last changes e takba.
        
        java.sql.Date DATE_OF_BIRTH = new java.sql.Date(2004-02-01);//it's here for try_catch variable can't access return type.
        try{
        // we will get the util-date from the compunents and we have to use the method getDatoFecha()
        // to save the date in database we have to convart in sql-date
        //the process is util-long-sql
        Date DOB = dob.getDatoFecha();//util date
        Long dateofbirth = DOB.getTime();//long date
        DATE_OF_BIRTH = new java.sql.Date(dateofbirth);//sql date 
        }catch (Exception e ){
            JOptionPane.showMessageDialog(this,"Enter your Date of Birth!");
            bod_date_valid = true;
        }
            return DATE_OF_BIRTH ;
    }
    public void ROOT_SIMPLE(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "select * FROM admin_data where user_id =? and admin_type = \"ROOT\"";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                set_profile();             
            }else{
                JOptionPane.showMessageDialog(this, "You Hava No ROOT Access!");
                Admin_home ah = new Admin_home(id);
                ah.setVisible(true);
                root_flag= 0;
                
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
    public void updated(int use_id){
        String fast_names = nm.remove_white_space(fast_name.getText()).toUpperCase();
        String last_names = nm.remove_white_space(last_name.getText().toUpperCase());
        String phones = nm.remove_white_space(phone.getText()).toUpperCase();
        String emails = nm.remove_white_space(email.getText()).toUpperCase();
        String full_addresss = nm.remove_white_space(full_address.getText()).toUpperCase();
        String fatrer_names = nm.remove_white_space(ftr_name.getText()).toUpperCase();
        String statiss = "REGULER";
        if(REGULER.isSelected()){
            statiss ="REGULER";
        }
        else if(SUSPENDED.isSelected()){
            statiss = "SUSPENDED";
        }
        String genders="MALE";
        if(male.isSelected()){
            genders ="MALE";
        }
        else if(female.isSelected()){
            genders = "FEMALE";
        }
        else{
            genders = "CUSTOM";
        }
        String types = "SIMPLE";
        if(ROOT.isSelected()){
            types = "ROOT";
        }
        else{
            types = "SIMPLE";
        }
        long nid_births=0L;
        long father_nids=0L;
        
        try{
        nid_births= nm.stringToLong(nid_birth_number.getText());
        father_nids = nm.stringToLong(ftr_nid.getText());
        }
        catch(Exception es){
            es.printStackTrace();
        }
        //end
    Connection con = DB_connection.getConnection();
    try {
        //wanted data
    
    String sql = "update  employee_data set fast_name=?, last_name=?, nid =?, phone =?, email=?, full_address=?, dob=?, gender=?, ftr_nid=?, ftr_name=?, e_status=? where position=? and user_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1,fast_names);
    pst.setString(2,last_names);
    pst.setLong(3,nid_births);
    pst.setString(4,phones);
    pst.setString(5,emails);
    pst.setString(6,full_addresss);
    pst.setDate(7,get_Birth_Date());
    pst.setString(8,genders);
    pst.setLong(9,father_nids);
    pst.setString(10,fatrer_names);
    pst.setString(11,statiss);
    pst.setString(12, "ADMIN");
    pst.setInt(13,use_id);
    int rs = pst.executeUpdate();
    
    if(rs>0){
        
    String sql2 = "update admin_data set admin_type=? where user_id=?;";
    PreparedStatement pst2 = con.prepareStatement(sql2);
    pst2.setInt(2, s_id);
    pst2.setString(1, types);
                pst.close();
           
    int rs2 = pst2.executeUpdate();
    if (rs2>0) {
        update_up_his();
    }            pst2.close();
        }
            
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Updatation  failed.");
    }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void update_up_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into employee_history(E_id  , A_E_id ,by_who ,T_status ,T_time, T_date,U_type) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, s_id);
            pst.setInt(2, id);
            pst.setString(3, "ADMIN");
            pst.setString(4, "UPDATED");
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());
            pst.setString(7, "ADMIN");

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
        JOptionPane.showMessageDialog(this, "Updated!");
           }
           else{
               JOptionPane.showMessageDialog(this, "faled!"); 
           }               pst.close();
            
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
    
    public void add(){
        String fast_names = nm.remove_white_space(fast_name.getText()).toUpperCase();
        String last_names = nm.remove_white_space(last_name.getText().toUpperCase());
        String phones = nm.remove_white_space(phone.getText()).toUpperCase();
        String emails = nm.remove_white_space(email.getText()).toUpperCase();
        String full_addresss = nm.remove_white_space(full_address.getText()).toUpperCase();
        String fatrer_names = nm.remove_white_space(ftr_name.getText()).toUpperCase();
        String statiss = "REGULER";
        if(REGULER.isSelected()){
            statiss ="REGULER";
        }
        else if(SUSPENDED.isSelected()){
            statiss = "SUSPENDED";
        }
        String genders="MALE";
        if(male.isSelected()){
            genders ="MALE";
        }
        else if(female.isSelected()){
            genders = "FEMALE";
        }
        else{
            genders = "CUSTOM";
        }
        String types = "SIMPLE";
        if(ROOT.isSelected()){
            types = "ROOT";
        }
        else{
            types = "SIMPLE";
        }
        long nid_births=0L;
        long father_nids=0L;
        
        try{
        nid_births= nm.stringToLong(nid_birth_number.getText());
        father_nids = nm.stringToLong(ftr_nid.getText());
        }
        catch(Exception es){
            es.printStackTrace();
        }
        //end
    Connection con = DB_connection.getConnection();
    try {
       
    
    String sql = "insert into employee_data( fast_name, last_name, nid , phone , email, full_address, dob, gender, ftr_nid, ftr_name, e_status,position) values(?,?,?,?,?,?,?,?,?,?,?,?);";
    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1,fast_names);
    pst.setString(2,last_names);
    pst.setLong(3,nid_births);
    pst.setString(4,phones);
    pst.setString(5,emails);
    pst.setString(6,full_addresss);
    pst.setDate(7,get_Birth_Date());
    pst.setString(8,genders);
    pst.setLong(9,father_nids);
    pst.setString(10,fatrer_names);
    pst.setString(11,statiss);
    pst.setString(12, "ADMIN");
    int rs = pst.executeUpdate();
    
    if(rs>0){
        String sql1 = "SELECT * FROM employee_data WHERE nid = ? ";
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setLong(1, nid_births);
        ResultSet rs1 = pst1.executeQuery();
    
        if(rs1.next()){
            s_id = rs1.getInt("user_id");
            String sql2 = "insert into admin_data(user_id,admin_type) values (?,?);";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setInt(1, s_id);
            pst2.setString(2, types);
            int rs2 = pst2.executeUpdate();
            if (rs2>0) {
                update_add_his();
            }
            pst2.close();
        }            
        pst1.close();
    }            
    pst.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "The ADMIN Already Exist");
    }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}
    public void update_add_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into employee_history(E_id  , A_E_id ,by_who ,T_status ,T_time, T_date,U_type) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, s_id);
            pst.setInt(2, id);
            pst.setString(3, "ADMIN");
            pst.setString(4, "ADDED");
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());
            pst.setString(7, "ADMIN");

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
        JOptionPane.showMessageDialog(this, "New Admin Added!");
        String formattedNumber = String.format("%08d", s_id); 
        JOptionPane.showMessageDialog(this, "USER ID : "+formattedNumber+"  & PASSWORD : 1234");
           }
           else{
               JOptionPane.showMessageDialog(this, "faled!"); 
           }               pst.close();
            
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
    
    
    public long get_nid_or_birth_number(String NID_B_number){
        
        long NID_B_Number = 0L;
        try{
            NID_B_Number = Long.parseLong(NID_B_number);
            if(NID_B_number.length()>17){
            JOptionPane.showMessageDialog(this,"you have insert more then 17 digit");
            NID_B_Number = 0L;
                }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Enter valid NID number:");
        }
        
        return NID_B_Number;
    }
    public boolean check_valid_date (){
        LocalDate bod = get_Birth_Date().toLocalDate();
        LocalDate today = LocalDate.now();
        
        long x =ChronoUnit.YEARS.between(bod, today);
        boolean ans = true;
        if(x<=17){
            JOptionPane.showMessageDialog(this, "AGE RESTICTION FOR (0-18)");
            System.out.print(x);
            ans = false;
        }

        return ans;
    }
    
    public void removee(int s_id){

            Connection con = DB_connection.getConnection();
        try{
            String sql = "delete from employee_data where user_id = ? and position = ?";
            String sql1 ="delete from employee_data where user_id = ? and podition = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1);
            pst.setInt(1, s_id);
            pst.setString(2,"ADMIN");
            pst1.setInt(1, s_id);
            pst1.setString(2,"ADMIN");
            int rs = pst.executeUpdate();
            int rs1 = pst1.executeUpdate();
            if(rs>0&&rs1>0){
                update_DLT_his();
            }
            else{
                JOptionPane.showMessageDialog(this, "Admin Dose Not Exist!");
            }
                    pst.close();
                    pst1.close();
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
    public void update_DLT_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into employee_history(E_id  , A_E_id ,by_who ,T_status ,T_time, T_date,U_type) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, s_id);
            pst.setInt(2, id);
            pst.setString(3, "ADMIN");
            pst.setString(4, "DELETED");
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());
            pst.setString(7, "ADMIN");

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
                JOptionPane.showMessageDialog(this, "Admin Deleted!");
           }
           else{
               JOptionPane.showMessageDialog(this, "faled!"); 
           }               pst.close();
           
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
    
    public boolean  necessary_data_insarted(){
        
        boolean res = true;
        get_Birth_Date();
        
        String F_name  = nm.remove_white_space(fast_name.getText());
        String L_name = nm.remove_white_space(last_name.getText());
        String Phone = nm.remove_white_space(phone.getText());
        String Email = nm.remove_white_space(email.getText());
        String Institute_Office = nm.remove_white_space(ftr_name.getText());
        String F_address  = nm.remove_white_space(full_address.getText());
        
        
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
        else if(get_nid_or_birth_number(nm.remove_white_space(nid_birth_number.getText()))==0L){
            
            res =  false;
        }

        else if(bod_date_valid){
            res =  false;
        }
      
        else if (Institute_Office.equals("") ){
            JOptionPane.showMessageDialog(this,  "Enter Your Father's Name: ");

            res =  false;
        }
        else if(get_nid_or_birth_number(nm.remove_white_space(ftr_nid.getText()))==0L){
            JOptionPane.showMessageDialog(this, "Enter Your Fater Nid Number");
            res =  false;
        }
        else if (F_address.equals("")){
            JOptionPane.showMessageDialog(this,  "Enter your Full Address: ");

            res =  false;
        }
        else if(!check_valid_date ()){
            res = false;
        } 
        return res ;
    }


    
    public void set_info(){
        fast_name.setText(fast_namer);
        last_name.setText(last_namer);
        phone .setText(phoner);
        email .setText(emailr);
        if(genderr.equals("MALE")){
            male.setSelected(true);
        }
        else if(genderr.equals("FEMALE")){
            female.setSelected(true);
        }
        else{
            custom.setSelected(true);
        }
        nid_birth_number.setText(String.valueOf(nid_birth_numberr));
        dob.setDatoFecha(Date_of_birthr);
        ftr_nid .setText(String.valueOf(ftr_nidr));
        ftr_name.setText(ftr_namer);
        full_address .setText(full_addressr);
        if(e_statusr.equals("REGULER")){
            REGULER.setSelected(true);
        }
        else{
            SUSPENDED.setSelected(true);
        }
        
        if(type.equals("ROOT")){
            ROOT.setSelected(true);
        }
        else{
            SIMPLE.setSelected(true);
        }
    }
    
    public void get_info(int student_id){  
        this.s_id = student_id;
    Connection con = DB_connection.getConnection();
    try {
        //wanted data
    
    String sql = "SELECT * FROM employee_data WHERE user_id = ? and position = ?";
    String sql1 = "SELECT * FROM admin_data WHERE user_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    PreparedStatement pst1 = con.prepareStatement(sql1);
    pst.setInt(1,student_id);
    pst.setString(2, "ADMIN");
    pst1.setInt(1, student_id);

    ResultSet rs = pst.executeQuery(); // Changed executeUpdate() to executeQuery()
     ResultSet rs1 = pst1.executeQuery();
     
    if (rs.next() && rs1.next()) {
       
        fast_namer = rs.getString("fast_name");
        last_namer = rs.getString("last_name"); 
        phoner = rs.getString("phone"); 
        emailr = rs.getString("email"); 
        genderr = rs.getString("gender"); 
        nid_birth_numberr = rs.getLong("nid"); 
        Date_of_birthr = rs.getDate("dob"); 
        e_statusr = rs.getString("e_status"); // 
        full_addressr = rs.getString("full_address");
        ftr_namer = rs.getString("ftr_name");  
        ftr_nidr = rs.getLong("ftr_nid");  
        
        type = rs1.getString("admin_type");
    }
    else{
        JOptionPane.showMessageDialog(this, "Admin Not Found");
    }
                    pst.close();
            rs.close();            pst1.close();
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


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        WELCOME = new javax.swing.JPanel();
        fast_name = new app.bolivia.swing.JCTextField();
        phone = new app.bolivia.swing.JCTextField();
        last_name = new app.bolivia.swing.JCTextField();
        nid_birth_number = new app.bolivia.swing.JCTextField();
        email = new app.bolivia.swing.JCTextField();
        full_address = new app.bolivia.swing.JCTextField();
        ftr_name = new app.bolivia.swing.JCTextField();
        ftr_nid = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        student_id = new app.bolivia.swing.JCTextField();
        jButton1 = new javax.swing.JButton();
        ADD = new rojerusan.RSMaterialButtonCircle();
        APPROVE3 = new rojerusan.RSMaterialButtonCircle();
        upde = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        ROOT = new javax.swing.JRadioButton();
        SIMPLE = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        REGULER = new javax.swing.JRadioButton();
        SUSPENDED = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        custom = new javax.swing.JRadioButton();
        dob = new rojeru_san.componentes.RSDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LMS_DESHBOARD = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MANAGE_STUDENT = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        MANAGE_LIBRARIAN = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        MANAGE_MOPDARATOR = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        HOME_PAGE = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        MANGE_ADMIN = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        MANAGE_BOOK = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ALL_HISTORY = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        CUSTOM_OPRATION = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        NOTIFY = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MENU_BAR.setBackground(new java.awt.Color(0, 102, 102));
        MENU_BAR.setAutoscrolls(true);
        MENU_BAR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        name.setText("ADMIN");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        MENU_BAR.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 280, -1));

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/home_24px.png"))); // NOI18N
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
        MENU_BAR.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 140, 50));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Admin Portal");
        MENU_BAR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 180, 50));

        getContentPane().add(MENU_BAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 50));

        WELCOME.setBackground(new java.awt.Color(0, 0, 0));
        WELCOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WELCOMEMouseClicked(evt);
            }
        });

        fast_name.setToolTipText("");
        fast_name.setPlaceholder("Fast Name");
        fast_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fast_nameMouseClicked(evt);
            }
        });
        fast_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fast_nameActionPerformed(evt);
            }
        });

        phone.setForeground(new java.awt.Color(255, 255, 255));
        phone.setToolTipText("Enter your Phone Number with Country code.");
        phone.setPlaceholder("phone");
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        last_name.setForeground(new java.awt.Color(255, 255, 255));
        last_name.setPlaceholder("Last Name");

        nid_birth_number.setForeground(new java.awt.Color(255, 255, 255));
        nid_birth_number.setToolTipText("nid -10,13,17 digit and birth 16,17 digit");
        nid_birth_number.setPlaceholder("NID/Birth number ");
        nid_birth_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_birth_numberActionPerformed(evt);
            }
        });

        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setPlaceholder("Email Address");

        full_address.setForeground(new java.awt.Color(255, 255, 255));
        full_address.setPlaceholder("Full Address");

        ftr_name.setForeground(new java.awt.Color(255, 255, 255));
        ftr_name.setPlaceholder("Father's Name  :");
        ftr_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftr_nameActionPerformed(evt);
            }
        });

        ftr_nid.setForeground(new java.awt.Color(255, 255, 255));
        ftr_nid.setPlaceholder("Father's NID : ");

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("FAST NAME");

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("LAST NAME");

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("PHONE");

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("FULL ADDRESS");

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("FATHER'S NAME");

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("FATHER'S NID");

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("NID/BIRTH NUMBER");

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("EMAIL ADDRESS");

        student_id.setPlaceholder("Find by Employee ID");
        student_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_idActionPerformed(evt);
            }
        });

        jButton1.setText("Find");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        ADD.setBackground(new java.awt.Color(0, 153, 153));
        ADD.setForeground(new java.awt.Color(0, 0, 0));
        ADD.setText("add");
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDMouseClicked(evt);
            }
        });
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        APPROVE3.setBackground(new java.awt.Color(0, 153, 153));
        APPROVE3.setForeground(new java.awt.Color(0, 0, 0));
        APPROVE3.setText("remove");
        APPROVE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                APPROVE3MouseClicked(evt);
            }
        });
        APPROVE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APPROVE3ActionPerformed(evt);
            }
        });

        upde.setBackground(new java.awt.Color(0, 153, 153));
        upde.setForeground(new java.awt.Color(0, 0, 0));
        upde.setText("update");
        upde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updeMouseClicked(evt);
            }
        });
        upde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updeActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN TYPE");

        ROOT.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(ROOT);
        ROOT.setForeground(new java.awt.Color(255, 255, 255));
        ROOT.setText("ROOT");

        SIMPLE.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(SIMPLE);
        SIMPLE.setForeground(new java.awt.Color(255, 255, 255));
        SIMPLE.setSelected(true);
        SIMPLE.setText("SIMPLE");

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("DATE OF BIRTH");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("His/Her Gender-");

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Admin Status");

        REGULER.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(REGULER);
        REGULER.setForeground(new java.awt.Color(255, 255, 255));
        REGULER.setSelected(true);
        REGULER.setText("Reguler");

        SUSPENDED.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(SUSPENDED);
        SUSPENDED.setForeground(new java.awt.Color(255, 255, 255));
        SUSPENDED.setText("Suspended");

        male.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup3.add(male);
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setSelected(true);
        male.setText("Male");

        female.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup3.add(female);
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");

        custom.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup3.add(custom);
        custom.setForeground(new java.awt.Color(255, 255, 255));
        custom.setText("Custom");

        dob.setBackground(new java.awt.Color(0, 0, 0));
        dob.setForeground(new java.awt.Color(255, 255, 255));
        dob.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dob.setFormatoFecha("dd/MM/yyyy");
        dob.setPlaceholder("DD/MM/YYYY");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Find By Employee ID :");

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(last_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel34)
                                    .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(335, 335, 335)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(female)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(custom))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1)))))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SIMPLE)
                            .addComponent(ROOT))
                        .addGap(6, 6, 6))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ftr_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftr_nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(REGULER)
                                    .addComponent(SUSPENDED))
                                .addGap(18, 18, 18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(upde, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(APPROVE3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(male)
                            .addComponent(female)
                            .addComponent(custom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(ROOT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(SIMPLE)))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)))
                        .addGap(12, 12, 12)
                        .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(ftr_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(upde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(APPROVE3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ftr_nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(REGULER)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SUSPENDED))))
                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(WELCOMELayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(39, 39, 39))
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1140, 670));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LMS_DESHBOARD.setBackground(new java.awt.Color(255, 0, 0));
        LMS_DESHBOARD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel4.setText("LMS DESHBOARD");
        LMS_DESHBOARD.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, -1, 30));

        jPanel2.add(LMS_DESHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        MANAGE_STUDENT.setBackground(new java.awt.Color(0, 0, 0));
        MANAGE_STUDENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MANAGE_STUDENTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MANAGE_STUDENTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MANAGE_STUDENTMouseExited(evt);
            }
        });
        MANAGE_STUDENT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Student");
        MANAGE_STUDENT.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(MANAGE_STUDENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, 40));

        MANAGE_LIBRARIAN.setBackground(new java.awt.Color(0, 0, 0));
        MANAGE_LIBRARIAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MANAGE_LIBRARIANMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MANAGE_LIBRARIANMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MANAGE_LIBRARIANMouseExited(evt);
            }
        });
        MANAGE_LIBRARIAN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Manage Librarian");
        MANAGE_LIBRARIAN.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(MANAGE_LIBRARIAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 40));

        MANAGE_MOPDARATOR.setBackground(new java.awt.Color(0, 0, 0));
        MANAGE_MOPDARATOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MANAGE_MOPDARATORMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MANAGE_MOPDARATORMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MANAGE_MOPDARATORMouseExited(evt);
            }
        });
        MANAGE_MOPDARATOR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mange Moderator");
        MANAGE_MOPDARATOR.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(MANAGE_MOPDARATOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 200, 40));

        HOME_PAGE.setBackground(new java.awt.Color(0, 0, 0));
        HOME_PAGE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HOME_PAGEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HOME_PAGEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HOME_PAGEMouseExited(evt);
            }
        });
        HOME_PAGE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/home_24px.png"))); // NOI18N
        jLabel8.setText("HOME PAGE");
        HOME_PAGE.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(HOME_PAGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 40));

        MANGE_ADMIN.setBackground(new java.awt.Color(0, 0, 255));
        MANGE_ADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MANGE_ADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MANGE_ADMINMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MANGE_ADMINMouseExited(evt);
            }
        });
        MANGE_ADMIN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Manage Admin");
        MANGE_ADMIN.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(MANGE_ADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 200, 40));

        MANAGE_BOOK.setBackground(new java.awt.Color(0, 0, 0));
        MANAGE_BOOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MANAGE_BOOKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MANAGE_BOOKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MANAGE_BOOKMouseExited(evt);
            }
        });
        MANAGE_BOOK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("manage Book");
        MANAGE_BOOK.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(MANAGE_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 40));

        ALL_HISTORY.setBackground(new java.awt.Color(0, 0, 0));
        ALL_HISTORY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ALL_HISTORYMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ALL_HISTORYMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ALL_HISTORYMouseExited(evt);
            }
        });
        ALL_HISTORY.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("All History");
        ALL_HISTORY.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, -1));

        jPanel2.add(ALL_HISTORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 200, 40));

        CUSTOM_OPRATION.setBackground(new java.awt.Color(0, 0, 0));
        CUSTOM_OPRATION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CUSTOM_OPRATIONMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CUSTOM_OPRATIONMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CUSTOM_OPRATIONMouseExited(evt);
            }
        });
        CUSTOM_OPRATION.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Custom Opration");
        CUSTOM_OPRATION.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel2.add(CUSTOM_OPRATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 200, 40));

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

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_1.png"))); // NOI18N
        jLabel15.setText("Logout");
        LOGOUT.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 200, 40));

        NOTIFY.setBackground(new java.awt.Color(0, 0, 0));
        NOTIFY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NOTIFYMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NOTIFYMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NOTIFYMouseExited(evt);
            }
        });
        NOTIFY.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Notify ");
        NOTIFY.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(NOTIFY, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setText("Features");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        home_page hp = new home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked

    }//GEN-LAST:event_nameMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        notification n = new notification(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void MANAGE_STUDENTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_STUDENTMouseClicked
        student_management sm = new student_management(id);
        sm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MANAGE_STUDENTMouseClicked

    private void MANAGE_STUDENTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_STUDENTMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        MANAGE_STUDENT.setBackground(mousein);
    }//GEN-LAST:event_MANAGE_STUDENTMouseEntered

    private void MANAGE_STUDENTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_STUDENTMouseExited
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        MANAGE_STUDENT.setBackground(mousein);
    }//GEN-LAST:event_MANAGE_STUDENTMouseExited

    private void MANAGE_LIBRARIANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_LIBRARIANMouseClicked
        Librarian_Management lm = new Librarian_Management(id);
        lm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MANAGE_LIBRARIANMouseClicked

    private void MANAGE_LIBRARIANMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_LIBRARIANMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        MANAGE_LIBRARIAN.setBackground(mousein);
    }//GEN-LAST:event_MANAGE_LIBRARIANMouseEntered

    private void MANAGE_LIBRARIANMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_LIBRARIANMouseExited
        // TODO add your handling code here:
        Color mouseout = new Color(0,0,0);
        MANAGE_LIBRARIAN.setBackground(mouseout);
    }//GEN-LAST:event_MANAGE_LIBRARIANMouseExited

    private void MANAGE_MOPDARATORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_MOPDARATORMouseClicked
        Moderator_Management mm = new Moderator_Management(id);
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MANAGE_MOPDARATORMouseClicked

    private void MANAGE_MOPDARATORMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_MOPDARATORMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(51,51,51);
        MANAGE_MOPDARATOR.setBackground(mousein);
    }//GEN-LAST:event_MANAGE_MOPDARATORMouseEntered

    private void MANAGE_MOPDARATORMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_MOPDARATORMouseExited
        // TODO add your handling code here:
        Color mouseout = new Color(0,0,0);
        MANAGE_MOPDARATOR.setBackground(mouseout);
    }//GEN-LAST:event_MANAGE_MOPDARATORMouseExited

    private void HOME_PAGEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOME_PAGEMouseClicked
Admin_home AH= new Admin_home(id);
AH.setVisible(true);
this.dispose();
    }//GEN-LAST:event_HOME_PAGEMouseClicked

    private void HOME_PAGEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOME_PAGEMouseEntered
        Color mousein = new Color(51,51,51);
        HOME_PAGE.setBackground(mousein);
    }//GEN-LAST:event_HOME_PAGEMouseEntered

    private void HOME_PAGEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOME_PAGEMouseExited
        Color mouseout = new Color(0,0,0);
        HOME_PAGE.setBackground(mouseout);
    }//GEN-LAST:event_HOME_PAGEMouseExited

    private void MANGE_ADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANGE_ADMINMouseClicked
        Admin_Management am = new Admin_Management(id);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MANGE_ADMINMouseClicked

    private void MANGE_ADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANGE_ADMINMouseEntered
        Color mousein = new Color(51,51,51);
        MANGE_ADMIN.setBackground(mousein);
    }//GEN-LAST:event_MANGE_ADMINMouseEntered

    private void MANGE_ADMINMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANGE_ADMINMouseExited
        Color mousein = new Color(0,0,255);
        MANGE_ADMIN.setBackground(mousein);
    }//GEN-LAST:event_MANGE_ADMINMouseExited

    private void MANAGE_BOOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_BOOKMouseClicked
        Book_Management  bm = new Book_Management(id);
        bm.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_MANAGE_BOOKMouseClicked

    private void MANAGE_BOOKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_BOOKMouseEntered
        Color mousein = new Color(51,51,51);
        MANAGE_BOOK.setBackground(mousein);
    }//GEN-LAST:event_MANAGE_BOOKMouseEntered

    private void MANAGE_BOOKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGE_BOOKMouseExited
        Color mousein = new Color(0,0,0);
        MANAGE_BOOK.setBackground(mousein);
    }//GEN-LAST:event_MANAGE_BOOKMouseExited

    private void ALL_HISTORYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ALL_HISTORYMouseClicked
        all_history ah = new all_history(id);
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ALL_HISTORYMouseClicked

    private void ALL_HISTORYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ALL_HISTORYMouseEntered
        Color mousein = new Color(51,51,51);
        ALL_HISTORY.setBackground(mousein);
    }//GEN-LAST:event_ALL_HISTORYMouseEntered

    private void ALL_HISTORYMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ALL_HISTORYMouseExited
        Color mousein = new Color(0,0,0);
        ALL_HISTORY.setBackground(mousein);
    }//GEN-LAST:event_ALL_HISTORYMouseExited

    private void CUSTOM_OPRATIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CUSTOM_OPRATIONMouseClicked
        Custom_Opration co = new Custom_Opration(id);
        co.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_CUSTOM_OPRATIONMouseClicked

    private void CUSTOM_OPRATIONMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CUSTOM_OPRATIONMouseEntered
        Color mousein = new Color(51,51,51);
        CUSTOM_OPRATION.setBackground(mousein);
    }//GEN-LAST:event_CUSTOM_OPRATIONMouseEntered

    private void CUSTOM_OPRATIONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CUSTOM_OPRATIONMouseExited
        Color mousein = new Color(0,0,0);
        CUSTOM_OPRATION.setBackground(mousein);
    }//GEN-LAST:event_CUSTOM_OPRATIONMouseExited

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
        int a = JOptionPane.showConfirmDialog(this,"Do you want to Logout?","woring",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            admin_login al = new admin_login();
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

    private void NOTIFYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NOTIFYMouseClicked
        Notify nf = new Notify(id);
        nf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NOTIFYMouseClicked

    private void NOTIFYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NOTIFYMouseEntered
        Color mousein = new Color(51,51,51);
        NOTIFY.setBackground(mousein);
    }//GEN-LAST:event_NOTIFYMouseEntered

    private void NOTIFYMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NOTIFYMouseExited
        Color mousein = new Color(0,0,0);
        NOTIFY.setBackground(mousein);
    }//GEN-LAST:event_NOTIFYMouseExited

    private void updeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updeActionPerformed

    private void updeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updeMouseClicked
        updated(s_id);
    }//GEN-LAST:event_updeMouseClicked

    private void APPROVE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APPROVE3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_APPROVE3ActionPerformed

    private void APPROVE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APPROVE3MouseClicked
        removee(s_id);
    }//GEN-LAST:event_APPROVE3MouseClicked

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDActionPerformed

    private void ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseClicked
       if(necessary_data_insarted()){
       add();
       } 
    }//GEN-LAST:event_ADDMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
if(root_flag==0){
    this.dispose();
}
int s_id = nm.stringToint(student_id.getText());
        get_info(s_id);
        set_info();
    }//GEN-LAST:event_jButton1MouseClicked

    private void student_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_idActionPerformed

    private void ftr_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftr_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftr_nameActionPerformed

    private void nid_birth_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birth_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birth_numberActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void fast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_nameActionPerformed

    }//GEN-LAST:event_fast_nameActionPerformed

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

    private void WELCOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WELCOMEMouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_WELCOMEMouseClicked

    private void fast_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fast_nameMouseClicked
if(root_flag==0){
    this.dispose();
}        // TODO add your handling code here:
    }//GEN-LAST:event_fast_nameMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle ADD;
    private javax.swing.JPanel ALL_HISTORY;
    private rojerusan.RSMaterialButtonCircle APPROVE3;
    private javax.swing.JPanel CUSTOM_OPRATION;
    private javax.swing.JPanel HOME_PAGE;
    private javax.swing.JPanel LMS_DESHBOARD;
    private javax.swing.JPanel LOGOUT;
    private javax.swing.JPanel MANAGE_BOOK;
    private javax.swing.JPanel MANAGE_LIBRARIAN;
    private javax.swing.JPanel MANAGE_MOPDARATOR;
    private javax.swing.JPanel MANAGE_STUDENT;
    private javax.swing.JPanel MANGE_ADMIN;
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel NOTIFY;
    private javax.swing.JRadioButton REGULER;
    private javax.swing.JRadioButton ROOT;
    private javax.swing.JRadioButton SIMPLE;
    private javax.swing.JRadioButton SUSPENDED;
    private javax.swing.JPanel WELCOME;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel close;
    private javax.swing.JRadioButton custom;
    private rojeru_san.componentes.RSDateChooser dob;
    private app.bolivia.swing.JCTextField email;
    private app.bolivia.swing.JCTextField fast_name;
    private javax.swing.JRadioButton female;
    private app.bolivia.swing.JCTextField ftr_name;
    private app.bolivia.swing.JCTextField ftr_nid;
    private app.bolivia.swing.JCTextField full_address;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private app.bolivia.swing.JCTextField last_name;
    private javax.swing.JRadioButton male;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField nid_birth_number;
    private app.bolivia.swing.JCTextField phone;
    private app.bolivia.swing.JCTextField student_id;
    private rojerusan.RSMaterialButtonCircle upde;
    // End of variables declaration//GEN-END:variables
public static void main(String [] args){
    Admin_Management x = new Admin_Management(1);
    x.setVisible(true);
}}
