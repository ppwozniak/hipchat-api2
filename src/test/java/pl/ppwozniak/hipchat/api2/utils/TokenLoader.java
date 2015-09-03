/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wp
 */
public class TokenLoader {

    public static String loadToken() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/authToken.properties"));

        return properties.getProperty("token");
    }
}
