package Bank;

import java.sql.*;  

public class DBConnection {

    Connection c;
    Statement s;


    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_system", "root", "");
            s = c.createStatement();

        } catch(Exception e) {
            // Print the stack trace of the exception
            e.printStackTrace();
        }
    }  
}  