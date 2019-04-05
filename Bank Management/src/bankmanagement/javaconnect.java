
package bankmanagement;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class javaconnect {
    Connection conn;
    PreparedStatement pst;
    
    public static Connection  connect()
    {
        try 
        {
            String driver ="oracle.jdbc.OracleDriver";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","RIAD","123456");
            System.out.println("Connected");
            return conn;
                       
        }
        catch(Exception ex) 
        {
            System.out.println("Not Connected Error:"+ex);
            
            
                       
        }
        return null;
    }
    
}
