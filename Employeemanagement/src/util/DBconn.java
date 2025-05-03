package util;
import java.util.Properties;
import java.sql.*;
public class DBconn {
	private static Connection connection;
	 
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = DButil.getProperties();
                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                // Step 1& 2 : Load the Driver and establish the connection
                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
