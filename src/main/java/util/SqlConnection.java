package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    public final static String url = "jdbc:postgresql://localhost:5432/StepProjectDemo2";
    public final static String user = "postgres";
    public final static String pass = "12345";

    public static Connection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static Connection checkConnection(Connection connection){
        try {
            if(connection == null || connection.isClosed()){
                connection = SqlConnection.createConnection();
            }
        } catch (SQLException e) {
            System.out.println("Can not created Database Connection");
        }
        return connection;
    }
}
