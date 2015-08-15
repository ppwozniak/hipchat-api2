/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.codehaus.jackson.map.ObjectMapper;
import pl.ppwozniak.hipchat.api2.misc.ApiUrl;
import pl.ppwozniak.hipchat.api2.misc.TokenLoader;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUsersModel;
import pl.ppwozniak.hipchat.api2.models.users.UserItem;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wp
 */
public class Test2 {

    public static void main(String[] args) throws IOException, UnirestException {
        HttpRequest request = Unirest.get(ApiUrl.URL + "user").queryString("auth_token", TokenLoader.loadToken());
        InputStream is = request.asJson().getRawBody();

        ObjectMapper mapper = new ObjectMapper();
        GetAllUsersModel response = mapper.readValue(is, GetAllUsersModel.class);

        for (UserItem i : response.getUserItems()) {
            System.out.println(i);
        }
    }
}
