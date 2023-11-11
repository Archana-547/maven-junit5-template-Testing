package Helper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class SetupFunctions {
    String username;
    String password;
    String baseUrl;


    public SetupFunctions() {

        try (InputStream input = new FileInputStream("settings.properties")){
            Properties properties = new Properties();
            properties.load(input);

            // api
            baseUrl = properties.getProperty("baseUrl");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public  String getUsername() {
             return username;
    }

    public String getPassword() {
            return password;
     }

     public String getBaseUrl() {
            return baseUrl;
    }
}
