/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-16
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.response.users;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;
import pl.ppwozniak.hipchat.api2.common.ApiRequest;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUsersModel;
import pl.ppwozniak.hipchat.api2.response.ApiResponse;

import java.io.IOException;

/**
 * @author wp
 */
public class GetAllUsersResponse implements ApiResponse {

    private GetAllUsersModel model;

    private int status;

    private ApiRequest request;

    private GetAllUsersResponse(ApiRequest request, int status, GetAllUsersModel model) {
        this.request = request;
        this.status = status;
        this.model = model;
    }

    public GetAllUsersResponse(ApiRequest request) {
        this(request, -1, new GetAllUsersModel());
    }

    @Override
    public void run(String token) throws IOException, UnirestException {
        status = 0;
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        status = response.getStatus();
        if (status == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response.getRawBody(), GetAllUsersModel.class);
        }
    }

    public int getStatus() {
        return status;
    }

    public GetAllUsersModel getModel() {
        return model;
    }

    public void setModel(GetAllUsersModel model) {
        this.model = model;
    }

    public ApiRequest getRequest() {
        return request;
    }
}
