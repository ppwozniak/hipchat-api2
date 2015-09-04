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
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;

/**
 * @author wp
 */
public class ViewUserRequest extends AbstractRequest {

    private static final String REQUEST_URL = "user/";

    private String name;

    public ViewUserRequest(String name) {
        this.name = name;
    }

    @Override
    public HttpRequest getRequest(String token) {
        HttpRequest request = Unirest.get(ApiData.URL + REQUEST_URL + name)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);
        setUrl(request.getUrl());
        return request;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ViewUserRequest{" +
                "name='" + name + '\'' +
                ", url=" + getUrl() +
                '}';
    }
}
