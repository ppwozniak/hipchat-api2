/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-12-30
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class DeletePhotoRequest extends AbstractRequest {

    private static final String REQUEST_URL_PART1 = "user/";

    private static final String REQUEST_URL_PART2 = "photo";

    private String idOrEmail;

    public DeletePhotoRequest(String idOrEmail) {
        this.idOrEmail = idOrEmail;
    }

    @Override
    public HttpRequest getRequest(String token) {
        HttpRequest request = Unirest.delete(ApiData.URL + REQUEST_URL_PART1 + idOrEmail + "/" + REQUEST_URL_PART2)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        setUrl(request.getUrl());
        return request;
    }

    public String getIdOrEmail() {
        return idOrEmail;
    }
}
