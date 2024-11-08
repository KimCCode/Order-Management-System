package ordering_system.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ordering_system.Util.Config;

public class DataBaseConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            String url = Config.getDbUrl();
            String user = Config.getDbUser();
            String password = Config.getDbPassword();  // You'll also need a getDbPassword() method in Config

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }

        return connection;
    }
}

