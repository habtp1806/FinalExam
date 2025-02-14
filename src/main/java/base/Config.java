package base;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties properties;

    static {
        loadProperties();

    }

    public static void loadProperties() {
        properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("config.properties file not found.");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }




    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getTimeInSeconds(String propertyName) {
        String propertyValue = getProperty(propertyName);
        return Integer.parseInt(propertyValue);
    }


}
