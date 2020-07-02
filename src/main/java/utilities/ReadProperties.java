package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadProperties {

    private static final String PROPS = "user.properties";

    public static String getLogin() {
        try {
            InputStream stream = ReadProperties.class.getClassLoader().getResourceAsStream(PROPS);
            Properties properties = new Properties();
            properties.load(stream);
            return properties.getProperty("userLogin");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static String getPassword() {
        try {
            InputStream stream = ReadProperties.class.getClassLoader().getResourceAsStream(PROPS);
            Properties properties = new Properties();
            properties.load(stream);
            return properties.getProperty("userPassword");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }


}