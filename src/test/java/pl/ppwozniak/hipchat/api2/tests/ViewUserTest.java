/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.tests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ppwozniak.hipchat.api2.common.request.ApiRequest;
import pl.ppwozniak.hipchat.api2.request.users.ViewUserRequest;
import pl.ppwozniak.hipchat.api2.response.users.ViewUserResponse;
import pl.ppwozniak.hipchat.api2.utils.RequestDataLoader;
import pl.ppwozniak.hipchat.api2.utils.TokenLoader;

/**
 * @author wp
 */
public class ViewUserTest {

    @Test
    public void statusTest() throws Exception {
        ApiRequest request = new ViewUserRequest(RequestDataLoader.getProperty(getClass(), "name"));
        ViewUserResponse user = new ViewUserResponse(request);
        user.run(TokenLoader.loadToken());
        Assert.assertEquals(user.getStatus(), HttpStatus.SC_OK);
    }
}
