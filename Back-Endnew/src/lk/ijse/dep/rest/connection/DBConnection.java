package lk.ijse.dep.rest.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection()throws Exception{
        if(connection==null){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "mysqlroot");
        }
        return connection;
    }
}
