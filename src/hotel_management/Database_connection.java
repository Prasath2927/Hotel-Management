package hotel_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connection {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String USER = "root"; 
    private static final String PASSWORD = "2729"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
