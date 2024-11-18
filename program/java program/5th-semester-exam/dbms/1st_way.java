/*CREATE TABLE user_info( id INT(8) ZEROFILL AUTO_INCREMENT NOT NULL UNIQUE, fast_name VARCHAR(30), last_name VARCHAR(30) NOT NULL, phone VARCHAR(15) NOT NULL, email VARCHAR(200) NOT NULL, gender VARCHAR(10) NOT NULL, nid_birth_number INT(17) NOT NULL, date_of_birth DATE NOT NULL, istitute_office VARCHAR(300) NOT NULL, id_number VARCHAR(20), full_address VARCHAR(300) NOT NULL, pass VARCHAR(20) NOT NULL );*/


import java.sql.Connection;
import java.sql.DriverManager;

try{
// driver install

Class.forName("com.mysql.jdbc.Driver");

//connection object 

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root", "");

// sql query 
String sql =  "insert into registed_student_data( fast_name, last_name) values(?,?)";

// Statement object creation 
PreparedStatement pst = con.prepareStatement(sql);

// pass values

pst.setString(1, F_name);
pst.setString(2, L_name);

// execute sql statement

int updatedRowCount = pst.executeUpdate();
//ResultSet rs = pst.executeQuery();

// colse connection

con.colse();
// feedback 
//String a = rs.getString("full_name");
if ( updatedRowCount > 0){
   JOptionPane.showMessageDialog(this, "Accout Created Successfully!");
}
else{
   JOptionPane.showMessageDialog(this, "record Insarte faled!"); 
}   

}catch(Exception e){

JOptionPane.showMessageDialog(this,"the user already exist");
e.printStackTrace();

}