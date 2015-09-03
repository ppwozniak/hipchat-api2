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
import pl.ppwozniak.hipchat.api2.request.users.GetAutoJoinRoomsRequest;
import pl.ppwozniak.hipchat.api2.response.users.GetAutoJoinRoomsResponse;
import pl.ppwozniak.hipchat.api2.utils.RequestDataLoader;
import pl.ppwozniak.hipchat.api2.utils.TokenLoader;

/**
 * @author wp
 */
public class GetAutoJoinRoomsTest {

    @Test
    public void statusTest() throws Exception {
        ApiRequest request = new GetAutoJoinRoomsRequest(RequestDataLoader.getProperty(getClass(), "name"));
        GetAutoJoinRoomsResponse rooms = new GetAutoJoinRoomsResponse(request);
        rooms.run(TokenLoader.loadToken());
        Assert.assertEquals(rooms.getStatus(), HttpStatus.SC_OK);
    }
}
