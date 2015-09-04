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
import pl.ppwozniak.hipchat.api2.ApiClient;
import pl.ppwozniak.hipchat.api2.utils.TokenLoader;

/**
 * @author wp
 */
public class GetAllUsersTest {

    @Test
    public void statusTest() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken()).getAllUsers().getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void statusTest2() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken()).getAllUsers(0, 100, false, false).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void statusTest3() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken()).getAllUsers(0, 100, true, false).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void statusTest4() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken()).getAllUsers(0, 100, true, true).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void statusTest5() throws Exception {
        int status = ApiClient.createClient(TokenLoader.loadToken()).getAllUsers(0, 100, false, true).getStatus();
        Assert.assertEquals(status, HttpStatus.SC_OK);
    }

    @Test
    public void test() throws Exception {
        System.out.println("URL: " + ApiClient.createClient(TokenLoader.loadToken()).getAllUsers().getRequest().getUrl());
    }
}
