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
import com.mashape.unirest.request.HttpRequestWithBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.ClientJsonMapper;
import pl.ppwozniak.hipchat.api2.request.users.body.UpdateUserRequestBody;
import pl.ppwozniak.hipchat.api2.request.users.params.UpdateUserRequestParams;
import pl.ppwozniak.hipchat.api2.request.users.sub.RequestPresence;

/**
 * @author wp
 */
@Getter
@AllArgsConstructor
public class UpdateUserRequest extends AbstractRequest {

    private static final String REQUEST_URL = "user/";

    private String idOrEmail;

    private UpdateUserRequestParams params;

    @Override
    public HttpRequest getRequest(String token) {
        Unirest.setObjectMapper(new ClientJsonMapper());
        HttpRequestWithBody request = Unirest.put(ApiData.URL + REQUEST_URL + idOrEmail)
                .header("Content-Type", "application/json")
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        UpdateUserRequestBody body = new UpdateUserRequestBody(params.getName(), params.getTitle(),
                new RequestPresence(params.getStatus(), params.getShow()), params.getMentionName(), params.isAdmin(),
                params.getTimezone(), params.getPassword(), params.getEmail());
        request.body(body);

        setUrl(request.getUrl());
        return request;
    }

    @Override
    public String toString() {
        return "UpdateUserModel{" +
                "idOrEmail='" + idOrEmail + '\'' +
                ", params=" + params +
                '}';
    }
}
