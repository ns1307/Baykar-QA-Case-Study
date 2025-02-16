package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        String path= "configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(path);
            properties= new Properties();
            properties.load(fis);


        } catch (IOException e) {
            System.out.println("Properties file not found");

        }

    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }

    public static List<String> getPropertyAsList(String key) {
        String propertyString = properties.getProperty(key); // Varsayılan değer
        return Arrays.asList(propertyString.split(",")); // Virgüle göre ayır ve listeye çevir
    }


}