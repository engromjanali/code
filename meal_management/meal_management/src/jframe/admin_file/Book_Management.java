
package jframe.admin_file;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import jframe.method_romjanali01673.DB_connection;
import jframe.admin_login;
import jframe.home_page;
import jframe.method_romjanali01673.necessaryMethod;

public class Book_Management extends javax.swing.JFrame {
    necessaryMethod nm = new necessaryMethod();
    
    int id;
        int B_id = 0;
        String B_name = "";
        String B_type = "";
        String B_author = "";
        int B_part = 0;
        int B_price = 0;
        int B_quantity= 0;
        String B_source = "";
        String B_comment = "";  
        String status = "REGULER";
        int P_B_id = 0;
    public Book_Management(int id) {
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


    
    public void set_data_in_textfield(){
        P_B_id = nm.stringToint(book_id_d.getText());
        Connection con = DB_connection.getConnection();
        try{
            
        String sql = "select * from book_data where book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,nm.stringToint(book_id_d.getText()));
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
                int book_id = rs.getInt("book_id");
                String book_name = rs.getString("book_name");
                String book_author = rs.getString("author");
                int book_part = rs.getInt("book_part");
                String book_type = rs.getString("book_type");
                int price = rs.getInt("price");
                String few_line = rs.getString("few_i_line");
                int Quantity = rs.getInt("quantity");
                String source = rs.getString("book_source");
                String status = rs.getString("b_status");
                
                //set data in TextField
                this.book_id.setText(String.valueOf(book_id));
                this.book_name.setText(book_name);
                this.book_author.setText(book_author);
                this.book_type.setText(book_type);
                this.book_part.setText(String.valueOf(book_part));
                this.book_price.setText(String.valueOf(price));
                this.few_line.setText(few_line);
                this.book_quantity.setText(String.valueOf(Quantity));
                this.book_source.setText(source);
                if(status.equals("REGULER")){
                    REGULER.setSelected(true);
                }else{
                    SUSPENDED.setSelected(true);
                }
        }
        else{
            JOptionPane.showMessageDialog(this, "Book Not Found In Our Library!");
        }         pst.close();
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
//insart book data in data base.
    //add
    public boolean add_book(int book_id){
        boolean res = true;
        Connection con= DB_connection.getConnection();
        try{
        String sql = "insert into book_data(book_id,book_name,author,book_part,book_type,price,few_i_line,quantity,book_source,b_status) values(?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, nm.stringToint(this.book_id .getText()));
        pst.setString(2,book_name.getText());
        pst.setString(3,book_author.getText());
        pst.setInt(4,nm.stringToint(book_part.getText()));
        pst.setString(5, book_type.getText());
        pst.setInt(6,nm.stringToint(book_price.getText()));
        pst.setString(7,few_line.getText());
        pst.setInt(8,nm.stringToint(book_quantity.getText()));
        pst.setString(9,book_source.getText());
        if(REGULER.isSelected()){
             pst.setString(10,"REGULER");
        }
        else{
            pst.setString(10,"SUSPENDED");
        }
        
        
        int rs = pst.executeUpdate();
        if (rs>0){
        }
        else{
            res = false;
        } pst.close();
           
        }catch(Exception e ){
            res = false;
            JOptionPane.showMessageDialog(this, "New Book Addation Faild!");
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
    public void add_book_history(){
        Connection con = DB_connection.getConnection();
        try{
        String sql = "insert into book_history(book_id, T_status, T_time, T_date, employee_id, quantity) values(?,?,?,?,?,?) ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, B_id);
        pst.setString(2, "ADDED");
        pst.setTime(3, nm.getNowTime());
        pst.setDate(4, nm.getTodayDate());
        pst.setInt(5, id);
        pst.setInt(6, B_quantity);
        int rs = pst.executeUpdate();
        
        if (rs>0){
            JOptionPane.showMessageDialog(this, "The New book Has Been Added.");
        }
        else{
            JOptionPane.showMessageDialog(this, "New Book Addition Failed!");
        } pst.close();
           
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public boolean take_book_data(){
        boolean res = true;
        try{
         B_id = nm.stringToint(book_id.getText());
         B_name = nm.remove_white_space(book_name.getText()).toUpperCase();
         B_type = nm.remove_white_space(book_type.getText()).toUpperCase();
         B_author = nm.remove_white_space(book_author.getText()).toUpperCase();
         B_part = nm.stringToint(book_part.getText());
         B_price = nm.stringToint(book_price.getText());
         B_quantity= nm.stringToint(book_quantity.getText());
         B_source = nm.remove_white_space(book_source.getText()).toUpperCase();
         B_comment = nm.remove_white_space(few_line.getText()).toUpperCase();    
         if(REGULER.isSelected()){
             status = "REGULER";
         }
         else if(SUSPENDED.isSelected()){
             status = "SUSPENDED";
         }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Enter valid input!");
            res = false;
        }
        return res;
    }
    public boolean update_book(){
        boolean res = true;
        Connection con= DB_connection.getConnection();
        try{
        String sql = "update book_data set book_id=?,book_name=?,author=?,book_part=?,book_type=?,price=?,few_i_line=?,quantity=?,book_source=?,b_status=? where book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,B_id );
        pst.setString(2,B_name);
        pst.setString(3,B_author);
        pst.setInt(4,B_part);
        pst.setString(5,B_type);
        pst.setInt(6,B_price);
        pst.setString(7,B_comment);
        pst.setInt(8,B_quantity);
        pst.setString(9,B_source);
        pst.setString(10,status);
        pst.setInt(11, P_B_id);
        
        int rs = pst.executeUpdate();
        if (rs>0){
        }
        else{
            res = false;
        } pst.close();
           
        }catch(Exception e ){
            res = false;
            JOptionPane.showMessageDialog(this, "Book updatation Faild!");
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
    public void update_book_history(){
        Connection con = DB_connection.getConnection();
        try{
        String sql = "insert into book_history(book_id, T_status, T_time, T_date, employee_id, quantity) values(?,?,?,?,?,?) ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, B_id);
        pst.setString(2, "UPDATED");
        pst.setTime(3, nm.getNowTime());
        pst.setDate(4, nm.getTodayDate());
        pst.setInt(5, id);
        pst.setInt(6, B_quantity);
        int rs = pst.executeUpdate();
        
        if (rs>0){
            JOptionPane.showMessageDialog(this, "The Book Data Has Been Updated.");
        }
        else{
            JOptionPane.showMessageDialog(this, "Failed!");
        } pst.close();
           
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    
    public boolean book_exist(int book_id){
        boolean res = true;
        Connection con = DB_connection.getConnection();
        try{
        String sql = "select * from book_data where book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, book_id);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            
        }
        else{
            res = false;
        } pst.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
            res = false;
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return res;
    }    
    
    public boolean checked_input_validity(){
        boolean res = true;
        
        if(nm.stringToint(book_id.getText())==0||nm.stringToint(book_id.getText())>999999){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book ID!");
        }
        else if(nm.remove_white_space(book_name.getText()).equals("")){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Name!");
        }
        else if(nm.remove_white_space(book_type.getText()).equals("")){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Type!");
        }
        else if(nm.remove_white_space(book_author.getText()).equals("")){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Author Name!");
        }
        else if(nm.stringToint(book_part.getText())==0||nm.stringToint(book_part.getText())>99){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Part!");
        }
        else if(nm.stringToint(book_price.getText())==0||nm.stringToint(book_price.getText())>99999){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Price!");
        }
        else if(nm.stringToint(book_quantity.getText())==0){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Quantity!");
        }
        else if(nm.remove_white_space(book_source.getText()).equals("")){
            res = false;
            JOptionPane.showMessageDialog(this, "Enter Book Source!");
        }
        else if(nm.remove_white_space(few_line.getText()).equals("")){
            res = false;
            JOptionPane.showMessageDialog(this, "Write Few Intrasting Line About The Book!");
        }
        
        return res;
    }
    //delete
    public boolean delete(){
        boolean res = true;
        Connection con = DB_connection.getConnection();
        try{
        String sql = "delete from book_data where book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, nm.stringToint(book_id.getText()));
        int rs = pst.executeUpdate();
        
        if (rs>0){
            remove_book_history();
        }
        else{
            res = false;
            JOptionPane.showMessageDialog(this, "The Book Dose Not Exist.");    
        } pst.close();
           
        }catch(Exception e){
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
    
    public void remove_book_history(){
        Connection con = DB_connection.getConnection();
        try{
        String sql = "insert into book_history(book_id, T_status, T_time, T_date, employee_id, quantity) values(?,?,?,?,?,?) ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, B_id);
        pst.setString(2, "DELETED");
        pst.setTime(3, nm.getNowTime());
        pst.setDate(4, nm.getTodayDate());
        pst.setInt(5, id);
        pst.setInt(6, B_quantity);
        int rs = pst.executeUpdate();
        
        if (rs>0){
            JOptionPane.showMessageDialog(this, "The Book Data Has Been Deleted.");
        }
        else{
            JOptionPane.showMessageDialog(this, "New Deletion Addition Failed!");
        } pst.close();
         
        }catch(Exception e){
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
        WELCOME = new javax.swing.JPanel();
        book_type = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        book_author = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        book_id = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        book_name = new app.bolivia.swing.JCTextField();
        book_part = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        book_quantity = new app.bolivia.swing.JCTextField();
        book_source = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        book_price = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        book_id_d = new app.bolivia.swing.JCTextField();
        jButton1 = new javax.swing.JButton();
        add = new rojerusan.RSMaterialButtonCircle();
        UPDATE = new rojerusan.RSMaterialButtonCircle();
        APPROVE3 = new rojerusan.RSMaterialButtonCircle();
        jScrollPane1 = new javax.swing.JScrollPane();
        few_line = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        SUSPENDED = new javax.swing.JRadioButton();
        REGULER = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        jLabel20 = new javax.swing.JLabel();
        ALL_HISTORY = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        CUSTOM_OPRATION = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        NOTIFY = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        HOME_PAGE = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        MENU_BAR = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WELCOME.setBackground(new java.awt.Color(0, 0, 0));

        book_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_type.setPlaceholder("So far, you have not searched any books. ");
        book_type.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_typeActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Book Type :");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Book Author :");

        book_author.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_author.setPlaceholder("So far, you have not searched any books. ");
        book_author.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_authorActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Book ID :");

        book_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_id.setPlaceholder("So far, you have not searched any books. ");
        book_id.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_idActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Book Name :");

        book_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_name.setPlaceholder("So far, you have not searched any books. ");
        book_name.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_nameActionPerformed(evt);
            }
        });

        book_part.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_part.setPlaceholder("So far, you have not searched any books. ");
        book_part.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_part.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_partActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Book Part :");

        book_quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_quantity.setPlaceholder("So far, you did not search any student. ");
        book_quantity.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_quantityActionPerformed(evt);
            }
        });

        book_source.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_source.setPlaceholder("So far, you did not search any student. ");
        book_source.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_sourceActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Source :");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book Quantity :");

        book_price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_price.setPlaceholder("So far, you have not searched any books. ");
        book_price.setSelectionColor(new java.awt.Color(102, 102, 255));
        book_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_priceActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Book Price :");

        book_id_d.setBackground(new java.awt.Color(204, 255, 204));
        book_id_d.setPlaceholder("Find by Book ID");
        book_id_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_id_dActionPerformed(evt);
            }
        });

        jButton1.setText("Find");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 153, 153));
        add.setForeground(new java.awt.Color(0, 0, 0));
        add.setText("add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        UPDATE.setBackground(new java.awt.Color(0, 153, 153));
        UPDATE.setForeground(new java.awt.Color(0, 0, 0));
        UPDATE.setText("update");
        UPDATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UPDATEMouseClicked(evt);
            }
        });
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
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

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        few_line.setColumns(20);
        few_line.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        few_line.setRows(5);
        jScrollPane1.setViewportView(few_line);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Few Intrasting Line About The Book ");

        SUSPENDED.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(SUSPENDED);
        SUSPENDED.setForeground(new java.awt.Color(255, 255, 255));
        SUSPENDED.setText("Suspended");

        REGULER.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(REGULER);
        REGULER.setForeground(new java.awt.Color(255, 255, 255));
        REGULER.setSelected(true);
        REGULER.setText("Reguler");

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Book Status");

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Find By Book ID :");

        javax.swing.GroupLayout WELCOMELayout = new javax.swing.GroupLayout(WELCOME);
        WELCOME.setLayout(WELCOMELayout);
        WELCOMELayout.setHorizontalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WELCOMELayout.createSequentialGroup()
                                .addComponent(book_id_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(APPROVE3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(book_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(book_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(book_part, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(book_author, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(book_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(book_source, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(book_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(book_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(88, 88, 88))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WELCOMELayout.createSequentialGroup()
                                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel38)
                                            .addGroup(WELCOMELayout.createSequentialGroup()
                                                .addComponent(REGULER)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SUSPENDED)))
                                        .addGap(117, 117, 117)))))))
                .addGap(42, 42, 42))
        );
        WELCOMELayout.setVerticalGroup(
            WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WELCOMELayout.createSequentialGroup()
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(REGULER)
                            .addComponent(SUSPENDED)))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(WELCOMELayout.createSequentialGroup()
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_part, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(book_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(book_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 28, Short.MAX_VALUE)
                        .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(book_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WELCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(APPROVE3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_id_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
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

        MANAGE_BOOK.setBackground(new java.awt.Color(0, 0, 255));
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

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Book management");
        MANAGE_BOOK.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

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

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("All History");
        ALL_HISTORY.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, -1));

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

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Custom Opration");
        CUSTOM_OPRATION.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Notify ");
        NOTIFY.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

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

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel23.setText("NOTIFICATION");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        MENU_BAR.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 140, 50));

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

    private void book_partActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_partActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_partActionPerformed

    private void book_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_nameActionPerformed

    private void book_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_idActionPerformed

    private void book_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_authorActionPerformed

    private void book_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_typeActionPerformed

    private void book_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_quantityActionPerformed

    private void book_sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_sourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_sourceActionPerformed

    private void book_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_priceActionPerformed

    private void book_id_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_id_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_id_dActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(nm.stringToint(book_id_d.getText())!=0){
            set_data_in_textfield();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        if(checked_input_validity()){
            if(take_book_data()){
                if(!book_exist(nm.stringToint(book_id.getText()))){
                    if(add_book(B_id)){
                        add_book_history();
                    }
                    }
                else{
                    JOptionPane.showMessageDialog(this, "The Book Already Exist!");                    
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void UPDATEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDATEMouseClicked
        if(checked_input_validity()){
            if(take_book_data()){
                if(book_exist(P_B_id)){
                    if(update_book()){
                        update_book_history();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Dose Not Exist!");        
                }
            }
        }
    }//GEN-LAST:event_UPDATEMouseClicked

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPDATEActionPerformed

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
        Color mousein = new Color(0,0,255);
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

    private void APPROVE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APPROVE3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_APPROVE3ActionPerformed

    private void APPROVE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APPROVE3MouseClicked
    if(P_B_id!=0){
        if(delete()){
            remove_book_history();
        }
    }
    }//GEN-LAST:event_APPROVE3MouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked

    }//GEN-LAST:event_nameMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        home_page hp = new home_page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        notification n = new notification(id);
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

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

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JRadioButton SUSPENDED;
    private rojerusan.RSMaterialButtonCircle UPDATE;
    private javax.swing.JPanel WELCOME;
    private rojerusan.RSMaterialButtonCircle add;
    private app.bolivia.swing.JCTextField book_author;
    private app.bolivia.swing.JCTextField book_id;
    private app.bolivia.swing.JCTextField book_id_d;
    private app.bolivia.swing.JCTextField book_name;
    private app.bolivia.swing.JCTextField book_part;
    private app.bolivia.swing.JCTextField book_price;
    private app.bolivia.swing.JCTextField book_quantity;
    private app.bolivia.swing.JCTextField book_source;
    private app.bolivia.swing.JCTextField book_type;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel close;
    private javax.swing.JTextArea few_line;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
    public static void main(String args[]) {
        Book_Management  bmm = new Book_Management(0010);
        bmm.setVisible(true);
    }
}
