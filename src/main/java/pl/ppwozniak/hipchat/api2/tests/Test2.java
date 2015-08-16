/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.tests;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import pl.ppwozniak.hipchat.api2.common.ApiResponse;
import pl.ppwozniak.hipchat.api2.common.TokenLoader;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUsersModel;
import pl.ppwozniak.hipchat.api2.models.users.User;
import pl.ppwozniak.hipchat.api2.request.users.GetAllUsersRequest;

import java.io.IOException;

/**
 * @author wp
 */
public class Test2 {

    public static void main(String[] args) throws IOException, UnirestException, InstantiationException,
            IllegalAccessException {
//        HttpRequest request = Unirest.get(ApiUrl.URL + "user").queryString("auth_token", TokenLoader.loadToken());
        HttpRequest request = new GetAllUsersRequest().getRequest(TokenLoader.loadToken());
//        HttpResponse<JsonNode> response = request.asJson();

        ApiResponse<GetAllUsersModel> apiResponse = new ApiResponse<>(GetAllUsersModel.class);
        apiResponse.response(request.asJson());

        for (User i : apiResponse.getModel().getUsers()) {
            System.out.println(i);
        }

//        System.out.println("Status: " + response.getStatus());
//
//        ObjectMapper mapper = new ObjectMapper();
//        if (response.getStatus() == HttpStatus.SC_OK) {
//            GetAllUsersModel model = mapper.readValue(response.getRawBody(), GetAllUsersModel.class);
//
//            for (UserItem i : model.getUserItems()) {
//                System.out.println(i);
//            }
//        } else {
//            System.out.println("Blad... ");
//        }
    }
}
