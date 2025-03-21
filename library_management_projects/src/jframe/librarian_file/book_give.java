/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe.librarian_file;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import jframe.method_romjanali01673.DB_connection;
import jframe.home_page;
import jframe.librarian_login;
import jframe.method_romjanali01673.necessaryMethod;

public class book_give extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    int id;
    int book_ids;
    int student_ids;

    public book_give(int id) {
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
    public int input_valid_get(String input){
        int i = 0;
        try{
            i = Integer.valueOf(remove_white_space(input));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Enter valid Input");
        }
        return i;
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
    public int total_book_quantity(){
        book_ids = input_valid_get(book_id.getText());
        int res=0;
        Connection con= DB_connection.getConnection();
        try{
        String sql ="select * from book_data where book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);  
        pst.setInt(1,input_valid_get(book_id.getText()));
        ResultSet rs= pst.executeQuery();
        if(rs.next()){
            res = rs.getInt("quantity");
            book_name.setText(rs.getString("book_name"));
            book_author.setText(rs.getString("author"));
            book_type.setText(rs.getString("book_type"));
            book_part.setText(rs.getString("book_part"));
            book_price.setText(rs.getString("price"));
            
            rs.close();
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
    public int reading_book_quantity(){
        int res=0;
        Connection con= DB_connection.getConnection();
        try{
        String sql ="select * from book_history where book_id = ? and T_status = ?";
        PreparedStatement pst = con.prepareStatement(sql);  
        pst.setInt(1,input_valid_get(book_id.getText()));
        pst.setString(2, "GIVED");
        ResultSet rs= pst.executeQuery();
        while(rs.next()){
            res++;
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
    
    public int returned_book_quantity(){
        int res=0;
        Connection con= DB_connection.getConnection();
        try{
        String sql ="select * from book_history where book_id = ? and T_status = ?";
        PreparedStatement pst = con.prepareStatement(sql);  
        pst.setInt(1,input_valid_get(book_id.getText()));
        pst.setString(2, "RETURNED");
        ResultSet rs= pst.executeQuery();
        while(rs.next()){
            res++;
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
    

    public void set_data_in_textfield(){
        student_ids = input_valid_get(student_id.getText());
        Connection con = DB_connection.getConnection();
        try{
            
        String sql = "select * from student_data where user_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,input_valid_get(student_id.getText()));
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
                String fast_name = rs.getString("fast_name");
                String last_name = rs.getString("last_name");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                
                //set data in TextField
                this.fast_name.setText(fast_name);
                this.last_name.setText(last_name);
                this.phone.setText(phone);
                this.gender.setText(gender);
        }
        else{
            JOptionPane.showMessageDialog(this, "Student Not Found!");
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
    
    
    
    public void delete(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "delete from student_book where student_id = ? and book_id=? and T_status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_ids);
            pst.setInt(2, book_ids);
            pst.setString(3, "ISSUED");
            
            int rs = pst.executeUpdate();
            if(rs>0){
                delete1();
            }
            else{
                JOptionPane.showMessageDialog(this, "Already Deleted or Given");
            }        pst.close();
        
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
    public void delete1(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "delete from book_history where student_id = ? and book_id=? and T_status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_ids);
            pst.setInt(2, book_ids);
            pst.setString(3, "ISSUED");
            
            int rs = pst.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(this, "deleted!");
            }
            else{
                JOptionPane.showMessageDialog(this, "ReChacked");
            }        pst.close();
        
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

    public boolean verify_otp(){
        boolean res = true;
            Connection con = DB_connection.getConnection();
        try{
            String sql = "select * from  book_history where student_id = ? and book_id=? and otp = ? and T_status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, student_ids);
            pst.setInt(2, book_ids);
            pst.setString(3, otp.getText());
            pst.setString(4,"ISSUED");

           
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            }
            else{
                res = false;
                JOptionPane.showMessageDialog(this, "Wrong Otp");
            }
                pst.close();
        rs.close();
        }catch(Exception e ){
            res = false;
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
    public boolean request_valid(){
        boolean k = false;
            Connection con = DB_connection.getConnection();
        try{
            String sql = "select * from book_history where book_id=? and T_status=? and T_date =? and student_id =? and employee_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_ids);
            pst.setString(2, "GAVE");
            pst.setDate(3, nm.getTodayDate());
            pst.setInt(4, student_ids);
            pst.setInt(5, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               JOptionPane.showMessageDialog(this,"Already Requested!"); 
                k = true;
            }
                pst.close();
        rs.close();
        }catch(Exception e ){
            JOptionPane.showMessageDialog(this,"server Error!");
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return k;
    }    
    public void confirmed(){
            Connection con = DB_connection.getConnection();
        try{
            String sql = "insert into book_history(book_id, T_status,T_time,T_date,student_id,employee_id,by_who) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, book_ids);
            pst.setString(2, "GAVE");
            pst.setTime(3, nm.getNowTime());
            pst.setDate(4, nm.getTodayDate());
            pst.setInt(5, student_ids);
            pst.setInt(6, id);
            pst.setString(7, "LIBRARIAN");
            
            int rs = pst.executeUpdate();
            if(rs>0){
                update1();
            }
                pst.close();
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
    public void update1(){        
            Connection con = DB_connection.getConnection();
        try{
            String sql = "update student_book set  T_status=?,T_date =?, T_time=?  where book_id =? and student_id=? and T_status = \"ISSUED\" ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"TAKEN");
            pst.setDate(2,nm.getTodayDate());
            pst.setTime(3,nm.getNowTime());
            pst.setInt(4,book_ids);
            pst.setInt(5, student_ids);
            
            int rs = pst.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(this, "Book GAVE Success.");    
            }
            else{
                JOptionPane.showMessageDialog(this, "Already GAVEN");    
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        WELCOME = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        book_available = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        book_type = new app.bolivia.swing.JCTextField();
        search = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        book_id = new app.bolivia.swing.JCTextField();
        book_part = new app.bolivia.swing.JCTextField();
        book_name = new app.bolivia.swing.JCTextField();
        book_author = new app.bolivia.swing.JCTextField();
        book_price = new app.bolivia.swing.JCTextField();
        confirm_book_request = new rojerusan.RSMaterialButtonCircle();
        fast_name = new app.bolivia.swing.JCTextField();
        last_name = new app.bolivia.swing.JCTextField();
        student_id = new app.bolivia.swing.JCTextField();
        search1 = new rojerusan.RSMaterialButtonCircle();
        phone = new app.bolivia.swing.JCTextField();
        otp = new app.bolivia.swing.JCTextField();
        gender = new app.bolivia.swing.JCTextField();
        confirm_book_request1 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        add_book = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        receive_book = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        update_book = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        book_issue = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        contact_emp = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cotact_stdnt = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        MENU_BAR = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WELCOME.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Check the book is available or not!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Book type");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Part of the book");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("The book name is");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("The author name is ");

        book_available.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        book_available.setForeground(new java.awt.Color(102, 255, 255));
        book_available.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        book_available.setText("So far, you have not searched any books. ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("The book price ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 255));
        jLabel14.setText("Student Last Name :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 255, 255));
        jLabel15.setText("Student Phone Number :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 255, 255));
        jLabel17.setText("Student Gender :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 255, 255));
        jLabel16.setText("Student Fast Name :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 255, 255));
        jLabel18.setText("Book issue confirm request code :");

        book_type.setEditable(false);
        book_type.setBackground(new java.awt.Color(204, 255, 204));
        book_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_type.setPlaceholder("So far, you have not searched any books. ");
        book_type.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_typeActionPerformed(evt);
            }
        });

        search.setText("search");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 204, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(513, 8));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        book_id.setBackground(new java.awt.Color(204, 255, 204));
        book_id.setPlaceholder("Enter Your Book ID :");
        book_id.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_idActionPerformed(evt);
            }
        });

        book_part.setEditable(false);
        book_part.setBackground(new java.awt.Color(204, 255, 204));
        book_part.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_part.setPlaceholder("So far, you have not searched any books. ");
        book_part.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_part.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_partActionPerformed(evt);
            }
        });

        book_name.setEditable(false);
        book_name.setBackground(new java.awt.Color(204, 255, 204));
        book_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_name.setPlaceholder("So far, you have not searched any books. ");
        book_name.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_nameActionPerformed(evt);
            }
        });

        book_author.setEditable(false);
        book_author.setBackground(new java.awt.Color(204, 255, 204));
        book_author.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_author.setPlaceholder("So far, you have not searched any books. ");
        book_author.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_authorActionPerformed(evt);
            }
        });

        book_price.setEditable(false);
        book_price.setBackground(new java.awt.Color(204, 255, 204));
        book_price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_price.setPlaceholder("So far, you have not searched any books. ");
        book_price.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_priceActionPerformed(evt);
            }
        });

        confirm_book_request.setText("Confirm book request");
        confirm_book_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirm_book_requestMouseClicked(evt);
            }
        });
        confirm_book_request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_book_requestActionPerformed(evt);
            }
        });

        fast_name.setEditable(false);
        fast_name.setBackground(new java.awt.Color(204, 255, 204));
        fast_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fast_name.setPlaceholder("So far, you did not search any student. ");
        fast_name.setSelectionColor(new java.awt.Color(102, 102, 255));
        fast_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fast_nameActionPerformed(evt);
            }
        });

        last_name.setEditable(false);
        last_name.setBackground(new java.awt.Color(204, 255, 204));
        last_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        last_name.setPlaceholder("So far, you did not search any student. ");
        last_name.setSelectionColor(new java.awt.Color(102, 102, 255));
        last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_nameActionPerformed(evt);
            }
        });

        student_id.setBackground(new java.awt.Color(204, 255, 204));
        student_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        student_id.setPlaceholder("Enter Student ID");
        student_id.setSelectionColor(new java.awt.Color(102, 102, 255));
        student_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_idActionPerformed(evt);
            }
        });

        search1.setText("search");
        search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search1MouseClicked(evt);
            }
        });
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        phone.setEditable(false);
        phone.setBackground(new java.awt.Color(204, 255, 204));
        phone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phone.setPlaceholder("So far, you did not search any student. ");
        phone.setSelectionColor(new java.awt.Color(102, 102, 255));
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        otp.setBackground(new java.awt.Color(204, 255, 204));
        otp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        otp.setPlaceholder("Enter OTP here.");
        otp.setSelectionColor(new java.awt.Color(102, 102, 255));
        otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpActionPerformed(evt);
            }
        });

        gender.setEditable(false);
        gender.setBackground(new java.awt.Color(204, 255, 204));
        gender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gender.setPlaceholder("So far, you did not search any student. ");
        gender.setSelectionColor(new java.awt.Color(102, 102, 255));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        confirm_book_request1.setText("delete");
        confirm_book_request1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirm_book_request1MouseClicked(evt);
            }
        });
        confirm_book_request1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_book_request1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(book_author, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(book_type, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(book_part, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(book_price, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(WELCOMELayout.createSequentialGroup()
                            .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGap(124, 124, 124)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(WELCOMELayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(135, 135, 135)))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(book_available, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(fast_name, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(WELCOMELayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(confirm_book_request1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(confirm_book_request, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(153, Short.MAX_VALUE))))
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(book_available, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(book_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_part, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(128, 128, 128))
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(student_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(fast_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(last_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addGap(51, 51, 51)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15))
                .addGap(56, 56, 56)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(otp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)))
                .addGap(42, 42, 42)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm_book_request, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm_book_request1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        getContentPane().add(WELCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1140, 670));

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

        receive_book.setBackground(new java.awt.Color(0, 0, 0));
        receive_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receive_bookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                receive_bookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                receive_bookMouseExited(evt);
            }
        });
        receive_book.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Receive(Returned)");
        receive_book.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(receive_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 40));

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

        book_issue.setBackground(new java.awt.Color(255, 0, 0));
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

        contact_emp.setBackground(new java.awt.Color(0, 0, 0));
        contact_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contact_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contact_empMouseExited(evt);
            }
        });
        contact_emp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact with Employee");
        contact_emp.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel2.add(contact_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, 40));

        cotact_stdnt.setBackground(new java.awt.Color(0, 0, 0));
        cotact_stdnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cotact_stdntMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cotact_stdntMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cotact_stdntMouseExited(evt);
            }
        });
        cotact_stdnt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Contact With Student");
        cotact_stdnt.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel2.add(cotact_stdnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 40));

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

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel21.setText("NOTIFICATION");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        MENU_BAR.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 170, 50));

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

    private void confirm_book_requestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_book_requestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_book_requestActionPerformed

    private void book_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_priceActionPerformed

    private void book_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_authorActionPerformed

    private void book_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_nameActionPerformed

    private void book_partActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_partActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_partActionPerformed

    private void book_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_idActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
if(input_valid_get(book_id.getText())!= 0){
    if((total_book_quantity()-(reading_book_quantity()-returned_book_quantity())>0)  ){
        book_available.setText("The Book Is : Abailable.");
    }
    else{
        book_available.setText("The Book Is : Unavailable.");
    }
}
    }//GEN-LAST:event_searchMouseClicked

    private void book_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_typeActionPerformed

    private void fast_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fast_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fast_nameActionPerformed

    private void last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last_nameActionPerformed

    private void student_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_idActionPerformed

    private void search1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseClicked
        if(input_valid_get(student_id.getText())!=0){
            set_data_in_textfield();
        }
    }//GEN-LAST:event_search1MouseClicked

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otpActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void add_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_bookMouseClicked
        book_add as = new book_add(id);
        as.setVisible(true);
        this.dispose();
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

    private void receive_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receive_bookMouseClicked
        update_book ac = new update_book(id);
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_receive_bookMouseClicked

    private void receive_bookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receive_bookMouseEntered
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        receive_book.setBackground(mousein);
    }//GEN-LAST:event_receive_bookMouseEntered

    private void receive_bookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receive_bookMouseExited
        // TODO add your handling code here:
        Color mousein = new Color(0,0,0);
        receive_book.setBackground(mousein);
    }//GEN-LAST:event_receive_bookMouseExited

    private void update_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_bookMouseClicked
        update_book cws = new update_book(id);
        cws.setVisible(true);
        this.dispose();
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
        Color mouseout = new Color(255,0,0);
        book_issue.setBackground(mouseout);
    }//GEN-LAST:event_book_issueMouseExited

    private void confirm_book_request1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_book_request1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_book_request1ActionPerformed

    private void confirm_book_request1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm_book_request1MouseClicked
       int i = JOptionPane.showConfirmDialog(this, "Do you want to delete the Issues?", "Confiramation Message", JOptionPane.YES_NO_OPTION);
       if(i==0){
           delete();
       }
    }//GEN-LAST:event_confirm_book_request1MouseClicked

    private void confirm_book_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm_book_requestMouseClicked
        if(student_ids!=0 && book_ids!=0){
                if((total_book_quantity()-(reading_book_quantity()-returned_book_quantity())>0)  ){
                    if(verify_otp()){
                        confirmed();
                    }
                }
        }
        else{
        JOptionPane.showMessageDialog(this, "Enter The necessary Input and Search!");
        }
    }//GEN-LAST:event_confirm_book_requestMouseClicked

    private void contact_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_empMouseClicked
        contact_employee cmpdata = new contact_employee(id);
        cmpdata.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_contact_empMouseClicked

    private void contact_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_empMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_empMouseEntered

    private void contact_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_empMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_empMouseExited

    private void cotact_stdntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cotact_stdntMouseClicked
        contact_employee cmpdata = new contact_employee(id);
        cmpdata.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cotact_stdntMouseClicked

    private void cotact_stdntMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cotact_stdntMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cotact_stdntMouseEntered

    private void cotact_stdntMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cotact_stdntMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cotact_stdntMouseExited

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

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        Notify n = new Notify(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

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
book_give bg = new book_give(9);
bg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LOGOUT;
    private javax.swing.JPanel MENU_BAR;
    private javax.swing.JPanel WELCOME;
    private javax.swing.JPanel add_book;
    private app.bolivia.swing.JCTextField book_author;
    private javax.swing.JLabel book_available;
    private app.bolivia.swing.JCTextField book_id;
    private javax.swing.JPanel book_issue;
    private app.bolivia.swing.JCTextField book_name;
    private app.bolivia.swing.JCTextField book_part;
    private app.bolivia.swing.JCTextField book_price;
    private app.bolivia.swing.JCTextField book_type;
    private javax.swing.JLabel close;
    private rojerusan.RSMaterialButtonCircle confirm_book_request;
    private rojerusan.RSMaterialButtonCircle confirm_book_request1;
    private javax.swing.JPanel contact_emp;
    private javax.swing.JPanel cotact_stdnt;
    private app.bolivia.swing.JCTextField fast_name;
    private javax.swing.Box.Filler filler1;
    private app.bolivia.swing.JCTextField gender;
    private javax.swing.JLabel home;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private app.bolivia.swing.JCTextField last_name;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private app.bolivia.swing.JCTextField otp;
    private app.bolivia.swing.JCTextField phone;
    private javax.swing.JPanel receive_book;
    private rojerusan.RSMaterialButtonCircle search;
    private rojerusan.RSMaterialButtonCircle search1;
    private app.bolivia.swing.JCTextField student_id;
    private javax.swing.JPanel update_book;
    // End of variables declaration//GEN-END:variables
}
