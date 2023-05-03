package Patients;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public static Connection createDBConnection(){
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get Connection
            String url="jdbc:mysql://localhost:3306/oop_selfhealthcaresystem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url,username,password);

        }catch (Exception ex){
             ex.printStackTrace();
        }
        return con;
    }       

}

