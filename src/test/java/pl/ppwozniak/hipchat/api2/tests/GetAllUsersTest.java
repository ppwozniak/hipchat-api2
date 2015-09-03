/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-03
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.tests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ppwozniak.hipchat.api2.common.request.ApiRequest;
import pl.ppwozniak.hipchat.api2.request.users.GetAllUsersRequest;
import pl.ppwozniak.hipchat.api2.response.users.GetAllUsersResponse;
import pl.ppwozniak.hipchat.api2.utils.TokenLoader;

/**
 * @author wp
 */
public class GetAllUsersTest {

    @Test
    public void statusTest() throws Exception {
        ApiRequest request = new GetAllUsersRequest();
        GetAllUsersResponse users = new GetAllUsersResponse(request);
        users.run(TokenLoader.loadToken());
        Assert.assertEquals(users.getStatus(), HttpStatus.SC_OK);
    }
}
