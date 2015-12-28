/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-12-28
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.request.users.sub.GetPhotoType;

/**
 * @author wp
 */
@ToString
public class GetPhotoRequest extends AbstractRequest {

    private static final String REQUEST_URL_PART1 = "user/";

    private static final String REQUEST_URL_PART2 = "photo/";

    private String size;

    private String idOrEmail;

    public GetPhotoRequest(String idOrEmail, GetPhotoType type) {
        this.idOrEmail = idOrEmail;
        this.size = type.name().toLowerCase();
    }

    @Override
    public HttpRequest getRequest(String token) {
        HttpRequest request = Unirest.get(ApiData.URL + REQUEST_URL_PART1 + idOrEmail + "/" + REQUEST_URL_PART2 + size)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        setUrl(request.getUrl());
        return request;
    }

    public String getSize() {
        return size;
    }

    public String getIdOrEmail() {
        return idOrEmail;
    }
}
