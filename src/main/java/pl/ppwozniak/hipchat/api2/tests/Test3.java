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

import pl.ppwozniak.hipchat.api2.common.ApiMethod;
import pl.ppwozniak.hipchat.api2.common.ApiRequest;
import pl.ppwozniak.hipchat.api2.common.TokenLoader;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUsersModel;
import pl.ppwozniak.hipchat.api2.models.users.User;
import pl.ppwozniak.hipchat.api2.request.users.GetAllUsersRequest;

/**
 * @author wp
 */
public class Test3 {

    public static void main(String[] args) throws Exception {
        ApiRequest request = new GetAllUsersRequest();

        ApiMethod<GetAllUsersModel> method = new ApiMethod(request, GetAllUsersModel.class);
        method.run(TokenLoader.loadToken());

        for (User i : method.getModel().getUsers()) {
            System.out.println(i);
        }

    }
}
