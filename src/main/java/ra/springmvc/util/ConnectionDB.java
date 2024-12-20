package ra.springmvc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String URL = "jdbc:mysql://localhost:3306/mvc";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "hung18061999";

    // mở kê nô
    public static Connection getConnection()  {
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
// đpngs kết nối
    public static void closeConnection(Connection connection) {
        if (connection!= null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
