/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.request.ApiRequest;

/**
 * @author wp
 */
public class ViewUserRequest implements ApiRequest {

    private static final String URL = "user/";

    private String name;

    public ViewUserRequest(String name) {
        this.name = name;
    }

    @Override
    public HttpRequest getRequest(String token) {
        return Unirest.get(ApiData.URL + URL + name)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);
    }

    public String getName() {
        return name;
    }
}
