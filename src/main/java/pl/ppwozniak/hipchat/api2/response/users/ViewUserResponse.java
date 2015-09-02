/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.response.users;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;
import pl.ppwozniak.hipchat.api2.common.ApiRequest;
import pl.ppwozniak.hipchat.api2.common.ApiResponse;
import pl.ppwozniak.hipchat.api2.models.users.ViewUserModel;
import pl.ppwozniak.hipchat.api2.response.AbstractResponse;

import java.io.IOException;

/**
 * @author wp
 */
public class ViewUserResponse extends AbstractResponse implements ApiResponse {

    private ViewUserModel model;

    private ViewUserResponse(ApiRequest request, int status, ViewUserModel model) {
        super(request, status);
        this.model = model;
    }

    public ViewUserResponse(ApiRequest request) {
        this(request, -1, new ViewUserModel());
    }

    @Override
    public void run(String token) throws IOException, UnirestException {
        setStatus(0);
        HttpResponse<JsonNode> response = getRequest().getRequest(token).asJson();
        setStatus(response.getStatus());
        if (getStatus() == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response.getRawBody(), ViewUserModel.class);
        }
    }

    @Override
    public ApiRequest getRequest() {
        return super.getRequest();
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    public ViewUserModel getModel() {
        return model;
    }
}
