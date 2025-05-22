import java.sql.Connection;
import java.sql.DriverManager;

try{
// driver install

Class.forName("com.mysql.jdbc.Driver");

//connection object 

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root", "");

// sql query 

String sql =  "insert into registed_student_data( fast_name, last_name) values("romjan","ali")";

// Statement object creation 

Statement stm = Connection.createStatement();

// execute sql statement

ResultSet rs = stm.executeQuery(sql);
    
    if ( rs.next()){
       JOptionPane.showMessageDialog(this, "Accout Created Successfully!");
    }
    else{
       JOptionPane.showMessageDialog(this, "record Insarte faled!"); 
    }   
    
    }catch(Exception e){
    
    JOptionPane.showMessageDialog(this,"the user already exist");
    e.printStackTrace();
    
    }    

}






























Connection con = DriverManager.getConnection("jdbc:sql://localhost:3306/my_database", "root", "password");
sql = "insart into user_info( name, age) values(?, ?);";
PreparedStatement pst = con.prepareStatement(sql);
pst.setString(1, "romjan");
pst.setInt(2, 20);

int x = pst.executeUpdate();

if(x>0){
    System.out.print("yes");
}

con.close();