/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2016-01-09
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.ClientJsonMapper;
import pl.ppwozniak.hipchat.api2.request.users.body.ShareLinkWithUserRequestBody;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class ShareLinkWithUserRequest extends AbstractRequest {

    private static final String REQUEST_URL_PART1 = "user/";

    private static final String REQUEST_URL_PART2 = "share/link";

    private String idOrName;

    private String message;

    private String link;

    public ShareLinkWithUserRequest(String idOrName, String message, String link) {
        this.idOrName = idOrName;
        this.message = message;
        this.link = link;
    }

    public ShareLinkWithUserRequest(String idOrName, String link) {
        this(idOrName, "", link);
    }

    @Override
    public HttpRequest getRequest(String token) {
        Unirest.setObjectMapper(new ClientJsonMapper());
        HttpRequestWithBody request = Unirest.post(ApiData.URL + REQUEST_URL_PART1 + idOrName + "/" + REQUEST_URL_PART2)
                .queryString(ApiData.TOKEN_PARAM_NAME, token)
                .header("Content-Type", "application/json");

        ShareLinkWithUserRequestBody body = new ShareLinkWithUserRequestBody(message, link);
        request.body(body);

        setUrl(request.getUrl());
        return request;
    }
}
