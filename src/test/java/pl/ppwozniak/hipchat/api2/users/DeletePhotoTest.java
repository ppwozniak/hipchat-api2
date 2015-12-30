/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-12-30
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
public class DeletePhotoTest {

    @Test
    public void deletePhotoStatus() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken())
                .deletePhoto(RequestDataLoader.getProperty(getClass(), "name")).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void deletePhotoStatus2() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken())
                .deletePhoto("dfg").getStatus();
        Assert.assertNotEquals(status, HttpStatus.SC_NO_CONTENT);
    }
}
