/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-03
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wp
 */
public class RequestDataLoader {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/requestdata.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(Class c, String name) {
        String cName = c.getSimpleName();
        String key = cName.substring(0, cName.length() - 4) + "." + name;
        return properties.getProperty(key);
    }
}
