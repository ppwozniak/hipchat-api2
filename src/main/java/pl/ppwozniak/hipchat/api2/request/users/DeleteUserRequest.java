/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-12
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;

/**
 * @author wp
 */
@Getter
@AllArgsConstructor
@ToString
public class DeleteUserRequest extends AbstractRequest {

    private static final String REQUEST_URL = "user/";

    private String idOrEmail;

    @Override
    public HttpRequest getRequest(String token) {
        HttpRequest request = Unirest.delete(ApiData.URL + REQUEST_URL + idOrEmail)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        setUrl(request.getUrl());
        return request;
    }
}
