/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.users;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ppwozniak.hipchat.api2.ApiClient;
import pl.ppwozniak.hipchat.api2.utils.RequestDataLoader;
import pl.ppwozniak.hipchat.api2.utils.TokenLoader;

/**
 * @author wp
 */
public class ViewUserTest {

    @Test
    public void statusTest() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken())
                .viewUser(RequestDataLoader.getProperty(getClass(), "name")).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }
}
