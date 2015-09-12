/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.ClientJsonMapper;
import pl.ppwozniak.hipchat.api2.request.users.body.CreateUserRequestBody;
import pl.ppwozniak.hipchat.api2.request.users.params.CreateUserRequestParams;

/**
 * @author wp
 */
public class CreateUserRequest extends AbstractRequest {

    private static final String REQUEST_URL = "user";

    private CreateUserRequestParams params;

    public CreateUserRequest(CreateUserRequestParams params) {
        this.params = params;
    }

    @Override
    public HttpRequest getRequest(String token) {
        Unirest.setObjectMapper(new ClientJsonMapper());
        HttpRequestWithBody request = Unirest.post(ApiData.URL + REQUEST_URL)
                .header("Content-Type", "application/json")
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        CreateUserRequestBody body = new CreateUserRequestBody(params.getName(), params.getTitle(),
                params.getMentionName(), params.isGroupAdmin(), params.getTimezone(), params.getPassword(),
                params.getEmail());
        request.body(body);

        setUrl(request.getUrl());
        return request;
    }

    public CreateUserRequestParams getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "params=" + params +
                '}';
    }
}
