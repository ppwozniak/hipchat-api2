/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-16
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.tests;

import pl.ppwozniak.hipchat.api2.common.ApiRequest;
import pl.ppwozniak.hipchat.api2.common.TokenLoader;
import pl.ppwozniak.hipchat.api2.models.users.User;
import pl.ppwozniak.hipchat.api2.request.users.GetAllUsersRequest;
import pl.ppwozniak.hipchat.api2.response.users.GetAllUsersResponse;

/**
 * @author wp
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
        ApiRequest request = new GetAllUsersRequest();
        GetAllUsersResponse users = new GetAllUsersResponse(request);
        System.out.println(users.getStatus());
        users.run(TokenLoader.loadToken());
        System.out.println(users.getStatus());

        for (User i : users.getModel().getUsers()) {
            System.out.println(i);
        }

    }
}
