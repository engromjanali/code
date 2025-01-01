/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe.admin_file;  

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;
import jframe.method_romjanali01673.DB_connection;
import jframe.admin_login;
import jframe.home_page;
import jframe.login;
import jframe.method_romjanali01673.necessaryMethod;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class student_management extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();

    int id;
    public boolean bod_date_valid = false;
    String passwd ;
    
int st_id= 0;
String fast_namer;
String last_namer;
String phoner ;
String emailr ;
String genderr = "";
long nid_birth_numberr ;
java.sql.Date Date_of_birthr ; 
String institute_officer ;
String id_numberr;
String full_addressr ;
String statusr= "REGULER";
java.sql.Time reg_time;
java.sql.Date reg_date;
//      wanted data variable
        String fast_namer1 = "";
        String last_namer1 =  "";
        String phoner1 = "";
        String emailr1 = "";
        String genderr1 =  "";
        long nid_birth_numberr1 =  0l;
        java.sql.Date Date_of_birthr1;
        String institute_officer1 = "";
        String id_numberr1 = "";
        String full_addressr1 = "";
        String statusr1 = "";
        String remarkr1 = "";
        
    public student_management(int id){
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
//delete student-----------------------------------------------------
    public void delete(){
        long student_nid=0L;
        student_nid = Long.parseLong(nid_birth_number.getText());
    Connection con = DB_connection.getConnection();
    try {
    String sql = "DELETE FROM student_data WHERE nid_birth = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setLong(1,student_nid);

    int rs = pst.executeUpdate(); // Changed executeUpdate() to executeQuery()

    if (rs>0) {
        update_delete_his();
        delete1();
        JOptionPane.showMessageDialog(this, "Deleted!");

    } else {
        JOptionPane.showMessageDialog(this, "The student does not exist!"); 
        
    }        pst.close();
        
    //System.out.println(Date_of_birth);
} catch (Exception e) {
    e.printStackTrace();

} finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}
    public void delete1(){
        long student_nid=0l;
        student_nid = Long.parseLong(nid_birth_number.getText());
    Connection con = DB_connection.getConnection();
    try {
    String sql = "DELETE FROM changes_student_data WHERE user_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
   
    pst.setInt(1,st_id);

    int rs = pst.executeUpdate();
    if(rs>0){
        JOptionPane.showMessageDialog(this,"Student has been deleted from changes table also!");
    }
        pst.close();
       
    //System.out.println(Date_of_birth);
} catch (Exception e) {
    e.printStackTrace();

} finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}
    
    public void update_delete_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(	user_id,T_status,by_who,employee_id,T_time,T_date) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, get_user_id(nid_birth_numberr));
            pst.setString(2, "DELETED");
            pst.setString(3, "ADMIN");
            pst.setInt(4, id);
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
        JOptionPane.showMessageDialog(this, "The student deleted!"); 
           }
           else{
               JOptionPane.showMessageDialog(this, "failed!"); 
           }    pst.close();
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"somthing wrong!");
            e.printStackTrace();
        }   finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    } 
//remove white space -----------------------------------------------
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
//set current data  -------------------------
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
if(statusr.equals("REGULER")){
    REGULER1.setSelected(true);
}
else{
    SUSPENDED1.setSelected(true);
}

 nid_birth_number.setText(String.valueOf(nid_birth_numberr));
 date_of_birth.setDatoFecha(Date_of_birthr);
 institute_office .setText(institute_officer);
 id_of_institute_office.setText(id_numberr);
 full_address .setText(full_addressr);
//set wanted data -------------------------------------
fast_name2.setText(fast_namer1);
 last_name2.setText(last_namer1);
 phone2 .setText(phoner1);
 email2 .setText(emailr1);
if(genderr1.equals("MALE")){
    male2.setSelected(true);
}
else if(genderr1.equals("FEMALE")){
    female2.setSelected(true);
}
else{
    custom2.setSelected(true);
}
if(statusr1.equals("REGULER")){
    REGULER2.setSelected(true);
}
else{
    SUSPENDED2.setSelected(true);
}

 nid_birth_number2.setText(String.valueOf(nid_birth_numberr1));
 dob2.setDatoFecha(Date_of_birthr1);
 institute_office2 .setText(institute_officer1);
 id_of_institute_office2.setText(id_numberr1);
 full_address2.setText(full_addressr1);
 remark.setText(remarkr1);
}

// add student 
public void add_student(){
       
        String F_name  = fast_name.getText().toUpperCase();
        String L_name = last_name.getText().toUpperCase();
        String Phone = phone.getText().toUpperCase();
        String Email = email.getText().toUpperCase();
        String Institute_Office = institute_office.getText().toUpperCase();
        String ID_Of_Institute_Office = id_of_institute_office.getText().toUpperCase();
        String F_address  = full_address.getText().toUpperCase();

        
        
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_data (fast_name , last_name  ,phone , email , gender , nid_birth , dob , institute_office , ins_office_id , full_address , s_status,pass) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql1 = "delete from registaed_student_data where nid_birth=?";
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1);
            
            pst1.setLong(1, nid_birth_numberr);
            
            pst.setString(1, remove_white_space(F_name));
            pst.setString(2, remove_white_space(L_name));
            pst.setString(3, remove_white_space(Phone));
            pst.setString(4, remove_white_space(Email));
            pst.setString(5, get_gender());
            pst.setLong(6, nm.stringToLong(nid_birth_number.getText()));
            pst.setDate(7, get_Birth_Date1());
            pst.setString(8, remove_white_space(Institute_Office));
            pst.setString(9, remove_white_space(ID_Of_Institute_Office));
            pst.setString(10, remove_white_space(F_address));
            pst.setString(11,statusr);
            pst.setString(12,passwd);


            int updatedRowCount = pst.executeUpdate();
            int updatedRowCount1 = pst1.executeUpdate();
       
           
            if ( updatedRowCount > 0 && updatedRowCount1>0){
                update_add_his();
           }
           else{
               JOptionPane.showMessageDialog(this, "User Already Exist"); 
           }   
               pst.close();
        
                pst1.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"User Already Exist!");
            e.printStackTrace();
       
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}
    public int get_user_id(long id){  
        int as = 0;
        
    Connection con = DB_connection.getConnection();
    try {
    String sql = "SELECT * FROM student_data WHERE nid_birth = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setLong(1,id);

    ResultSet rs = pst.executeQuery(); // Changed executeUpdate() to executeQuery()

    if (rs.next()) {
        as = rs.getInt("user_id");
    } else {
        JOptionPane.showMessageDialog(this, "failed"); 
        
    }        pst.close();
        rs.close();
    //System.out.println(Date_of_birth);
} catch (Exception e) {
    e.printStackTrace();

}finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
return as;
    }
    public void update_add_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(	user_id,T_status,by_who,employee_id,T_time,T_date) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, get_user_id(nid_birth_numberr));
            pst.setString(2, "ADDED");
            pst.setString(3, "ADMIN");
            pst.setInt(4, id);
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
                update_reg_his();
            }
            else{
               JOptionPane.showMessageDialog(this, "Failed!"); 
            }    
            pst.close();
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"somthing wrong!");
            e.printStackTrace();
        }   finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    } 
    public void update_reg_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(	user_id,T_status,by_who,T_time,T_date) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, get_user_id(nid_birth_numberr));
            pst.setString(2, "REGISTATION");
            pst.setString(3, "STUDENT");
            pst.setTime(4, reg_time);
            pst.setDate(5, reg_date);

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
        JOptionPane.showMessageDialog(this, "New Student Added!");
           }
           else{
               JOptionPane.showMessageDialog(this, "Failed!"); 
           }    pst.close();
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"somthing wrong!");
            e.printStackTrace();
        }   finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    } 
// update student data

    public void update(){
        
        String F_name  = fast_name2.getText().toUpperCase();
        String L_name = last_name2.getText().toUpperCase();
        String Phone = phone2.getText().toUpperCase();
        String Email = email2.getText().toUpperCase();
        String Institute_Office = institute_office2.getText().toUpperCase();
        String ID_Of_Institute_Office = id_of_institute_office2.getText().toUpperCase();
        String F_address  = full_address2.getText().toUpperCase();

        
        
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "update student_data set fast_name =?, last_name =? ,phone =?, email =?, gender =?, nid_birth =?, dob =?, institute_office =?, ins_office_id =?, full_address =?, s_status = ? where user_id=?;";
            String sql1 = "delete from changes_student_data where user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1);
            
            pst1.setInt(1, st_id);
            
            pst.setString(1, remove_white_space(F_name));
            pst.setString(2, remove_white_space(L_name));
            pst.setString(3, remove_white_space(Phone));
            pst.setString(4, remove_white_space(Email));
            pst.setString(5, get_gender());
            pst.setLong(6,nm.stringToLong(nid_birth_number2.getText()));
            pst.setDate(7, get_Birth_Date2());
            pst.setString(8, remove_white_space(Institute_Office));
            pst.setString(9, remove_white_space(ID_Of_Institute_Office));
            pst.setString(10, remove_white_space(F_address));
            pst.setString(11, getStatus());
            pst.setInt(12,st_id);

            int updatedRowCount = pst.executeUpdate();
            int updatedRowCount1 = pst1.executeUpdate();
       
           
            if ( updatedRowCount > 0 && updatedRowCount1>0){
                update_update_his();
               JOptionPane.showMessageDialog(this, "Account Updated");
           }
           else{
               JOptionPane.showMessageDialog(this, "Failed!!"); 
           }           pst.close();
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
    public void update_update_his(){
            Connection con = DB_connection.getConnection();
        try {
            String sql =  "insert into student_history(	user_id,T_status,by_who,employee_id,T_time,T_date) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, get_user_id(nid_birth_numberr));
            pst.setString(2, "UPDATED");
            pst.setString(3, "ADMIN");
            pst.setInt(4, id);
            pst.setTime(5, nm.getNowTime());
            pst.setDate(6, nm.getTodayDate());

            int updatedRowCount = pst.executeUpdate();

            if ( updatedRowCount > 0){
               JOptionPane.showMessageDialog(this, "Account Updated");
           }
           else{
               JOptionPane.showMessageDialog(this, "Failed !"); 
           }    pst.close();
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"somthing wrong!");
            e.printStackTrace();
        }   finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    }     
// get current student data  by id
    public void get_past_data(int id){  
        st_id = id;
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
        statusr = rs.getString("s_status");
    } else {
        JOptionPane.showMessageDialog(this, "The student does not exist!"); 
        
    }        pst.close();
        rs.close();
    //System.out.println(Date_of_birth);
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
//get past data by nid or birth ----------------------------------------
    public void get_past_data(long nid_b){     
    Connection con = DB_connection.getConnection();
    try {
    String sql = "SELECT * FROM student_data WHERE nid_birth = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setLong(1,nid_b);

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
        statusr = rs.getString("s_status");
        st_id = rs.getInt("user_id");
    } else {
 
        String sql1 = "SELECT * FROM registaed_student_data WHERE nid_birth = ?" ;
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setLong(1,nid_b);
        
        ResultSet rs1 = pst1.executeQuery();
        if(rs1.next()){
        fast_namer = rs1.getString("fast_name");
        last_namer = rs1.getString("last_name"); 
        phoner = rs1.getString("phone"); 
        emailr = rs1.getString("email"); 
        genderr = rs1.getString("gender"); 
        nid_birth_numberr = rs1.getLong("nid_birth"); 
        System.out.println(nid_birth_numberr);
        Date_of_birthr = rs1.getDate("dob"); 
        institute_officer = rs1.getString("institute_office"); 
        id_numberr = rs1.getString("ins_office_id"); // 
        full_addressr = rs1.getString("full_address");
        passwd = rs1.getString("pass");
        reg_time = rs1.getTime("registation_time");
        reg_date = rs1.getDate("registation_date");
        }
        else{
        JOptionPane.showMessageDialog(this, "The student does not exist!");
    }        pst1.close();
        rs1.close();
        }        pst.close();
        rs.close();
    //System.out.println(Date_of_birth);
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

//get wanted data by user id
    public void get_wanted_data(int id){     
    Connection con = DB_connection.getConnection();
    try {
    String sql = "SELECT * FROM changes_student_data WHERE user_id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1,id);

    ResultSet rs = pst.executeQuery(); // Changed executeUpdate() to executeQuery()

    if (rs.next()) {
        fast_namer1 = rs.getString("fast_name");
        last_namer1 = rs.getString("last_name"); 
        phoner1 = rs.getString("phone"); 
        emailr1 = rs.getString("email"); 
        genderr1 = rs.getString("gender"); 
        nid_birth_numberr1 = rs.getLong("nid_birth"); 
        Date_of_birthr1 = rs.getDate("dob"); 
        institute_officer1 = rs.getString("institute_office"); 
        id_numberr1 = rs.getString("ins_office_id"); // 
        full_addressr1 = rs.getString("full_address");
        remarkr1= rs.getString( "remark");
       
    }        pst.close();
        rs.close();
    //System.out.println(Date_of_birth);
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
// get wanted data by nid
    public void get_wanted_data(long id){     
    Connection con = DB_connection.getConnection();
    try {
    String sql = "SELECT * FROM changes_student_data WHERE nid_birth = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setLong(1,id);

    ResultSet rs = pst.executeQuery(); // Changed executeUpdate() to executeQuery()

    if (rs.next()) {
        fast_namer1 = rs.getString("fast_name");
        last_namer1 = rs.getString("last_name"); 
        phoner1 = rs.getString("phone"); 
        emailr1 = rs.getString("email"); 
        genderr1 = rs.getString("gender"); 
        nid_birth_numberr1 = rs.getLong("nid_birth"); 
        Date_of_birthr1 = rs.getDate("dob"); 
        institute_officer1 = rs.getString("institute_office"); 
        id_numberr1 = rs.getString("ins_office_id"); // 
        full_addressr1 = rs.getString("full_address");
        remarkr1= rs.getString( "remark");
       
    }        pst.close();
        rs.close();
    //System.out.println(Date_of_birth);
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
    
    public String get_gender(){
        String gender ="MALE";
        if(male2.isSelected()){
            gender = "MALE";
        }
        else if(female2.isSelected()){
            gender = "FEMALE";
        }
        else if(custom2.isSelected()){
            gender = "CUSTOM";
        }
        return gender;
    }
public String getStatus(){

    if(REGULER2.isSelected()){
        return "REGULER";
    }
    else{
        return "SUSPENDED";
    }
}

    
    
    
    public java.sql.Date get_Birth_Date1(){
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
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Enter your Date of Birth!");
            bod_date_valid = true;
        }
            return DATE_OF_BIRTH ;
            
    }
    public java.sql.Date get_Birth_Date2(){
        bod_date_valid = false;// ai method er " bod_date_valid"  er value akbar change hoila joto e event hok na kano er default value asbe na. last changes e takba.
        
        java.sql.Date DATE_OF_BIRTH = new java.sql.Date(2004-02-01);
        try{

        Date DOB = dob2.getDatoFecha();//util date
        Long dateofbirth = DOB.getTime();//long date
        DATE_OF_BIRTH = new java.sql.Date(dateofbirth);//sql date 
        }catch (Exception e ){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Enter your Date of Birth!");
            bod_date_valid = true;
        }
            return DATE_OF_BIRTH ;
            
    }
    

    public boolean  necessary_data_insarted(){
        
        boolean res = true;
        get_Birth_Date2();
        
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
        else if(nm.stringToLong(nid_birth_number2.getText())==0L){
            res =  false;
            JOptionPane.showMessageDialog(this,"Enter Valid NID/Birth Number");
        }
        else if(bod_date_valid){
            res =  false;
            JOptionPane.showMessageDialog(this,"Enter Valid DOB");
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

        return res ;
    }
    

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        WELCOME = new javax.swing.JPanel();
        fast_name = new app.bolivia.swing.JCTextField();
        phone = new app.bolivia.swing.JCTextField();
        last_name = new app.bolivia.swing.JCTextField();
        institute_office = new app.bolivia.swing.JCTextField();
        id_of_institute_office = new app.bolivia.swing.JCTextField();
        nid_birth_number = new app.bolivia.swing.JCTextField();
        email = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        full_address = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        find_d = new app.bolivia.swing.JCTextField();
        jButton1 = new javax.swing.JButton();
        added = new rojerusan.RSMaterialButtonCircle();
        deletes = new rojerusan.RSMaterialButtonCircle();
        updates = new rojerusan.RSMaterialButtonCircle();
        date_of_birth = new rojeru_san.componentes.RSDateChooser();
        male = new javax.swing.JRadioButton();
        custom = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        institute_office2 = new app.bolivia.swing.JCTextField();
        jLabel39 = new javax.swing.JLabel();
        full_address2 = new app.bolivia.swing.JCTextField();
        jLabel40 = new javax.swing.JLabel();
        email2 = new app.bolivia.swing.JCTextField();
        jLabel31 = new javax.swing.JLabel();
        phone2 = new app.bolivia.swing.JCTextField();
        jLabel41 = new javax.swing.JLabel();
        last_name2 = new app.bolivia.swing.JCTextField();
        jLabel42 = new javax.swing.JLabel();
        fast_name2 = new app.bolivia.swing.JCTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        male2 = new javax.swing.JRadioButton();
        female2 = new javax.swing.JRadioButton();
        custom2 = new javax.swing.JRadioButton();
        dob2 = new rojeru_san.componentes.RSDateChooser();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        nid_birth_number2 = new app.bolivia.swing.JCTextField();
        jLabel47 = new javax.swing.JLabel();
        id_of_institute_office2 = new app.bolivia.swing.JCTextField();
        bynid = new javax.swing.JRadioButton();
        byid = new javax.swing.JRadioButton();
        remark = new javax.swing.JTextArea();
        SUSPENDED2 = new javax.swing.JRadioButton();
        REGULER2 = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        REGULER1 = new javax.swing.JRadioButton();
        SUSPENDED1 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LMS_DESHBOARD = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MANAGE_STUDENT = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        MANAGE_LIBRARIAN = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        MANAGE_MOPDARATOR = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        MANGE_ADMIN = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        MANAGE_BOOK = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ALL_HISTORY = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        CUSTOM_OPRATION = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        NOTIFY = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        HOME_PAGE = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        id_of_institute_office.setPlaceholder("Institute/Office ID");

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

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("His/Her Gender-");

        full_address.setEditable(false);
        full_address.setPlaceholder("Full Address");

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

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("INSTITUTE OR OFFICE  NAME");

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ID OF INSTITUTE/OFFICE");

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("NID/BIRTH NUMBER");

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("DATE OF BIRTH");

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("EMAIL ADDRESS");

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Carrent Info ");

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Wanted Info");

        find_d.setPlaceholder("Find By NID No/birth No/Student ID");
        find_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_dActionPerformed(evt);
            }
        });

        jButton1.setText("Find");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        added.setBackground(new java.awt.Color(0, 153, 153));
        added.setForeground(new java.awt.Color(0, 0, 0));
        added.setText("add");
        added.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addedMouseClicked(evt);
            }
        });
        added.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addedActionPerformed(evt);
            }
        });

        deletes.setBackground(new java.awt.Color(0, 153, 153));
        deletes.setForeground(new java.awt.Color(0, 0, 0));
        deletes.setText("delete");
        deletes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletesMouseClicked(evt);
            }
        });
        deletes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletesActionPerformed(evt);
            }
        });

        updates.setBackground(new java.awt.Color(0, 153, 153));
        updates.setForeground(new java.awt.Color(0, 0, 0));
        updates.setText("update");
        updates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatesMouseClicked(evt);
            }
        });
        updates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesActionPerformed(evt);
            }
        });

        date_of_birth.setFormatoFecha("dd/MM/yyyy");

        male.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup3.add(male);
        male.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setSelected(true);
        male.setText("Male");
        male.setEnabled(false);

        custom.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup3.add(custom);
        custom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        custom.setForeground(new java.awt.Color(255, 255, 255));
        custom.setText("Custom");
        custom.setEnabled(false);

        female.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup3.add(female);
        female.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.setEnabled(false);

        institute_office2.setPlaceholder("Institute/ Office Name");
        institute_office2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institute_office2ActionPerformed(evt);
            }
        });

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("INSTITUTE OR OFFICE  NAME");

        full_address2.setPlaceholder("Full Address");

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("FULL ADDRESS");

        email2.setPlaceholder("Email Address");

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("EMAIL ADDRESS");

        phone2.setToolTipText("Enter your Phone Number with Country code.");
        phone2.setPlaceholder("phone");
        phone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone2ActionPerformed(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("PHONE");

        last_name2.setPlaceholder("Last Name");

        jLabel42.setBackground(new java.awt.Color(0, 0, 0));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("LAST NAME");

        fast_name2.setToolTipText("");
        fast_name2.setPlaceholder("Fast Name");
        fast_name2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fast_name2ActionPerformed(evt);
            }
        });

        jLabel43.setBackground(new java.awt.Color(0, 0, 0));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("FAST NAME");

        jLabel44.setBackground(new java.awt.Color(0, 0, 0));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("His/Her Gender-");

        male2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup4.add(male2);
        male2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        male2.setForeground(new java.awt.Color(255, 255, 255));
        male2.setSelected(true);
        male2.setText("Male");

        female2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup4.add(female2);
        female2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        female2.setForeground(new java.awt.Color(255, 255, 255));
        female2.setText("Female");

        custom2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup4.add(custom2);
        custom2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        custom2.setForeground(new java.awt.Color(255, 255, 255));
        custom2.setText("Custom");

        dob2.setFormatoFecha("dd/MM/yyyy");
        dob2.setPlaceholder("Date Of Birth(dd/mm/yyyy)");

        jLabel45.setBackground(new java.awt.Color(0, 0, 0));
        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("DATE OF BIRTH");

        jLabel46.setBackground(new java.awt.Color(0, 0, 0));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("NID/BIRTH NUMBER");

        nid_birth_number2.setToolTipText("nid -10,13,17 digit and birth 16,17 digit");
        nid_birth_number2.setPlaceholder("NID/Birth number ");
        nid_birth_number2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_birth_number2ActionPerformed(evt);
            }
        });

        jLabel47.setBackground(new java.awt.Color(0, 0, 0));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("ID OF INSTITUTE/OFFICE");

        id_of_institute_office2.setPlaceholder("Institute/Office ID");

        bynid.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(bynid);
        bynid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bynid.setForeground(new java.awt.Color(255, 255, 255));
        bynid.setText("By NID/Birth");
        bynid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynidActionPerformed(evt);
            }
        });

        byid.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(byid);
        byid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        byid.setForeground(new java.awt.Color(255, 255, 255));
        byid.setSelected(true);
        byid.setText("By Student ID");

        remark.setColumns(15);
        remark.setLineWrap(true);
        remark.setRows(4);
        remark.setTabSize(4);
        remark.setText("Remark Here...");
        remark.setToolTipText("More Details = More Possiblity To Approve Your Request.");
        remark.setWrapStyleWord(true);
        remark.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        remark.setPreferredSize(new java.awt.Dimension(0, 0));
        remark.setSelectedTextColor(new java.awt.Color(51, 0, 255));
        remark.setSelectionColor(new java.awt.Color(153, 153, 255));

        SUSPENDED2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup5.add(SUSPENDED2);
        SUSPENDED2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SUSPENDED2.setForeground(new java.awt.Color(255, 255, 255));
        SUSPENDED2.setText("Suspended");

        REGULER2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup5.add(REGULER2);
        REGULER2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        REGULER2.setForeground(new java.awt.Color(255, 255, 255));
        REGULER2.setSelected(true);
        REGULER2.setText("Reguler");

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Modarator Status");

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Modarator Status");

        REGULER1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(REGULER1);
        REGULER1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        REGULER1.setForeground(new java.awt.Color(255, 255, 255));
        REGULER1.setSelected(true);
        REGULER1.setText("Reguler");

        SUSPENDED1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(SUSPENDED1);
        SUSPENDED1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SUSPENDED1.setForeground(new java.awt.Color(255, 255, 255));
        SUSPENDED1.setText("Suspended");

        jLabel48.setBackground(new java.awt.Color(0, 0, 0));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Student Management");

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel27))
                                .addGap(91, 91, 91))
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel29)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel36)
                                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fast_name, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel30)
                        .addGap(310, 310, 310))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(find_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(bynid)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addGap(219, 219, 219)
                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(WELCOMELayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WELCOMELayout.createSequentialGroup()
                                                        .addComponent(male)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(female)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(custom))))
                                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel24)
                                                    .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(id_of_institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel22))
                                                .addComponent(date_of_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(byid)))))
                        .addGap(18, 18, 18)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(full_address2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(WELCOMELayout.createSequentialGroup()
                                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel43)
                                                        .addComponent(jLabel42)
                                                        .addComponent(jLabel41)
                                                        .addComponent(jLabel31))
                                                    .addGap(101, 101, 101))
                                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel40)
                                                    .addComponent(last_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fast_name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(WELCOMELayout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WELCOMELayout.createSequentialGroup()
                                                            .addComponent(male2)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(female2)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(custom2))))
                                                .addGroup(WELCOMELayout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel46)
                                                            .addComponent(nid_birth_number2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(id_of_institute_office2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel47))
                                                        .addComponent(dob2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(WELCOMELayout.createSequentialGroup()
                                            .addComponent(institute_office2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel28)
                                                .addGroup(WELCOMELayout.createSequentialGroup()
                                                    .addComponent(REGULER2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(SUSPENDED2))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(100, 100, 100))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updates, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletes, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel38)
                                        .addGroup(WELCOMELayout.createSequentialGroup()
                                            .addComponent(REGULER1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(SUSPENDED1)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(added, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)))
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(7, 7, 7)
                                .addComponent(fast_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(last_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel41)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(phone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                                .addGap(7, 7, 7)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(male2)
                                        .addComponent(female2)
                                        .addComponent(custom2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(WELCOMELayout.createSequentialGroup()
                                            .addComponent(jLabel45)
                                            .addGap(44, 44, 44)
                                            .addComponent(jLabel46)
                                            .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                            .addGap(87, 87, 87)
                                            .addComponent(nid_birth_number2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(5, 5, 5)))
                                    .addComponent(jLabel47)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(id_of_institute_office2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(dob2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(full_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel39)
                        .addGap(0, 0, 0)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(institute_office2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(REGULER2)
                                    .addComponent(SUSPENDED2)))))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(7, 7, 7)
                                .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel35)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                                .addGap(7, 7, 7)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(male)
                                        .addComponent(female)
                                        .addComponent(custom))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(WELCOMELayout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addGap(44, 44, 44)
                                            .addComponent(jLabel24)
                                            .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                            .addGap(87, 87, 87)
                                            .addComponent(nid_birth_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(5, 5, 5)))
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(id_of_institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(date_of_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(full_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37)
                        .addGap(1, 1, 1)
                        .addComponent(institute_office, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(REGULER1)
                            .addComponent(SUSPENDED1))
                        .addGap(79, 79, 79)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bynid)
                            .addComponent(byid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(find_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(remark, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(added, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updates, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1150, 670));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LMS_DESHBOARD.setBackground(new java.awt.Color(255, 0, 0));
        LMS_DESHBOARD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel4.setText("LMS DESHBOARD");
        LMS_DESHBOARD.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, -1, 30));

        jPanel2.add(LMS_DESHBOARD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        MANAGE_STUDENT.setBackground(new java.awt.Color(0, 0, 255));
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
        jLabel6.setText("Mange Modarator");
        MANAGE_MOPDARATOR.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(MANAGE_MOPDARATOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 200, 40));

        MANGE_ADMIN.setBackground(new java.awt.Color(0, 0, 0));
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
        jLabel11.setText("Book management");
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
        CUSTOM_OPRATION.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(CUSTOM_OPRATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 200, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setText("Features");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 670));

        MENU_BAR.setBackground(new java.awt.Color(0, 102, 102));
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_nameActionPerformed

    }//GEN-LAST:event_fast_nameActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void institute_officeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute_officeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute_officeActionPerformed

    private void nid_birth_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birth_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birth_numberActionPerformed

    private void find_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_find_dActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        long s_idl= 0l;
        int s_idi=0;
        
        if (byid.isSelected()){
        try{            
        s_idi = Integer.parseInt(find_d.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Search by Valid Query!");
        } 
        if(s_idi!=0){
                get_past_data(s_idi);
                get_wanted_data(s_idi);
                set_user_data();  
            }        
        }
        else{
        try{            
        s_idl = Long.parseLong(find_d.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Search by Valid Query!");
        }   
        if(s_idl!=0){
            get_past_data(s_idl);
            get_wanted_data(s_idl);
            set_user_data();        
        }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void addedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addedMouseClicked
        if(!(nid_birth_number.getText().equals("" )||nid_birth_number.getText().equals("0")) ){
            add_student();
        }
        else{
            JOptionPane.showMessageDialog(this, "Rechack!");
        }
    }//GEN-LAST:event_addedMouseClicked

    private void addedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addedActionPerformed

    private void deletesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletesMouseClicked
        int input = JOptionPane.showConfirmDialog(this, "Do you want to Delete?","Confirm Deletion!",JOptionPane.YES_NO_OPTION);
        if(input==0){
        if(!nid_birth_number.getText().equals("" )||nid_birth_number.getText().equals("0") ){
            delete();
        }
        else{
            JOptionPane.showMessageDialog(this, "Rechack!");
            }
        }
    }//GEN-LAST:event_deletesMouseClicked

    private void deletesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletesActionPerformed

    private void updatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatesMouseClicked
        if(necessary_data_insarted()){
            if(!nid_birth_number.getText().equals("" )||nid_birth_number.getText().equals("0") ){
                update();
            }
            else{
                JOptionPane.showMessageDialog(this, "Rechack!");
            }
        }
        else{
            
        }
    }//GEN-LAST:event_updatesMouseClicked

    private void updatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatesActionPerformed

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
        Color mousein = new Color(0,0,255);
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
        Color mousein = new Color(0,0,0);
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

    private void institute_office2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute_office2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute_office2ActionPerformed

    private void phone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone2ActionPerformed

    private void fast_name2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_name2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fast_name2ActionPerformed

    private void nid_birth_number2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_birth_number2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_birth_number2ActionPerformed

    private void bynidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bynidActionPerformed

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked

    }//GEN-LAST:event_nameMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        home_page hp = new home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

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
    private javax.swing.JPanel ALL_HISTORY;
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
    private javax.swing.JRadioButton REGULER1;
    private javax.swing.JRadioButton REGULER2;
    private javax.swing.JRadioButton SUSPENDED1;
    private javax.swing.JRadioButton SUSPENDED2;
    private javax.swing.JPanel WELCOME;
    private rojerusan.RSMaterialButtonCircle added;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JRadioButton byid;
    private javax.swing.JRadioButton bynid;
    private javax.swing.JLabel close;
    private javax.swing.JRadioButton custom;
    private javax.swing.JRadioButton custom2;
    private rojeru_san.componentes.RSDateChooser date_of_birth;
    private rojerusan.RSMaterialButtonCircle deletes;
    private rojeru_san.componentes.RSDateChooser dob2;
    private app.bolivia.swing.JCTextField email;
    private app.bolivia.swing.JCTextField email2;
    private app.bolivia.swing.JCTextField fast_name;
    private app.bolivia.swing.JCTextField fast_name2;
    private javax.swing.JRadioButton female;
    private javax.swing.JRadioButton female2;
    private app.bolivia.swing.JCTextField find_d;
    private app.bolivia.swing.JCTextField full_address;
    private app.bolivia.swing.JCTextField full_address2;
    private javax.swing.JLabel home;
    private app.bolivia.swing.JCTextField id_of_institute_office;
    private app.bolivia.swing.JCTextField id_of_institute_office2;
    private app.bolivia.swing.JCTextField institute_office;
    private app.bolivia.swing.JCTextField institute_office2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private app.bolivia.swing.JCTextField last_name;
    private app.bolivia.swing.JCTextField last_name2;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton male2;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField nid_birth_number;
    private app.bolivia.swing.JCTextField nid_birth_number2;
    private app.bolivia.swing.JCTextField phone;
    private app.bolivia.swing.JCTextField phone2;
    private javax.swing.JTextArea remark;
    private rojerusan.RSMaterialButtonCircle updates;
    // End of variables declaration//GEN-END:variables
public static void main(String [] args){
    student_management x = new student_management(345);
    x.setVisible(true);
}}
