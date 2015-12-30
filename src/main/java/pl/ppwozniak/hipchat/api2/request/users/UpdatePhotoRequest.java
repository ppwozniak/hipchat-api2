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
import com.mashape.unirest.request.HttpRequestWithBody;
import lombok.ToString;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.ClientJsonMapper;
import pl.ppwozniak.hipchat.api2.request.users.body.UpdatePhotoRequestBody;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class UpdatePhotoRequest extends AbstractRequest {

    private static final String REQUEST_URL_PART1 = "user/";

    private static final String REQUEST_URL_PART2 = "photo";

    private String idOrEmail;

    private byte[] photo;

    public UpdatePhotoRequest(String idOrEmail, String filename) throws IOException {
        this(idOrEmail, IOUtils.toByteArray(new FileInputStream(filename)));
    }

    public UpdatePhotoRequest(String idOrEmail, byte[] photo) {
        this.idOrEmail = idOrEmail;
        this.photo = photo;
    }

    @Override
    public HttpRequest getRequest(String token) {
        Unirest.setObjectMapper(new ClientJsonMapper());
        HttpRequestWithBody request = Unirest.put(ApiData.URL + REQUEST_URL_PART1 + idOrEmail + "/" + REQUEST_URL_PART2)
                .header("Content-Type", "application/json")
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        UpdatePhotoRequestBody body = new UpdatePhotoRequestBody(Base64.encodeBase64String(photo));
        request.body(body);

        setUrl(request.getUrl());
        return request;
    }

    public byte[] getPhoto() {
        return photo;
    }
}
