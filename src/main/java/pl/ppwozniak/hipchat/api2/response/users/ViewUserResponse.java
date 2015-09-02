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
import pl.ppwozniak.hipchat.api2.models.users.ViewUserModel;
import pl.ppwozniak.hipchat.api2.response.ApiResponse;

import java.io.IOException;

/**
 * @author wp
 */
public class ViewUserResponse implements ApiResponse {

    private ApiRequest request;

    private int status;

    private ViewUserModel model;

    private ViewUserResponse(ApiRequest request, int status, ViewUserModel model) {
        this.request = request;
        this.status = status;
        this.model = model;
    }

    public ViewUserResponse(ApiRequest request) {
        this(request, -1, new ViewUserModel());
    }

    @Override
    public void run(String token) throws IOException, UnirestException {
        status = 0;
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        status = response.getStatus();
        if (status == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response.getRawBody(), ViewUserModel.class);
        }
    }

    public ApiRequest getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public ViewUserModel getModel() {
        return model;
    }
}
