package ordering_system.Util;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("application.properties not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter method for database URL
    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    // Getter method for database username
    public static String getDbUser() {
        return properties.getProperty("db.user");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }

    // Add additional getters as needed
}

