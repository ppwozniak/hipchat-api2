/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-12-28
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.users;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ppwozniak.hipchat.api2.ApiClient;
import pl.ppwozniak.hipchat.api2.request.users.sub.GetPhotoType;
import pl.ppwozniak.hipchat.api2.utils.RequestDataLoader;
import pl.ppwozniak.hipchat.api2.utils.TokenLoader;

/**
 * @author wp
 */
public class GetPhotoTest {

    @Test
    public void statusBigTest() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken())
                .getPhoto(RequestDataLoader.getProperty(getClass(), "name"), GetPhotoType.BIG).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void bigPhotoBytesTest() throws Exception {
        byte[] bytes = ApiClient.createClient(TokenLoader.loadToken())
                .getPhoto(RequestDataLoader.getProperty(getClass(), "name"), GetPhotoType.BIG).getModel().getPhoto();
        Assert.assertNotNull(bytes);
    }

    @Test
    public void statusSmallTest() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken())
                .getPhoto(RequestDataLoader.getProperty(getClass(), "name"), GetPhotoType.SMALL).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void smallPhotoBytesTest() throws Exception {
        byte[] bytes = ApiClient.createClient(TokenLoader.loadToken())
                .getPhoto(RequestDataLoader.getProperty(getClass(), "name"), GetPhotoType.SMALL).getModel().getPhoto();
        Assert.assertNotNull(bytes);
    }
}
