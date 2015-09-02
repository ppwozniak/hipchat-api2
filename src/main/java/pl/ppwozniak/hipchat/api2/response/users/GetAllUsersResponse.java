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
import pl.ppwozniak.hipchat.api2.common.ApiResponse;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUserModel;
import pl.ppwozniak.hipchat.api2.response.AbstractResponse;

import java.io.IOException;

/**
 * @author wp
 */
public class GetAllUsersResponse extends AbstractResponse implements ApiResponse {

    private GetAllUserModel model;

    private GetAllUsersResponse(ApiRequest request, int status, GetAllUserModel model) {
        super(request, status);
        this.model = model;
    }

    public GetAllUsersResponse(ApiRequest request) {
        this(request, -1, new GetAllUserModel());
    }

    @Override
    public void run(String token) throws IOException, UnirestException {
        setStatus(0);
        HttpResponse<JsonNode> response = getRequest().getRequest(token).asJson();
        setStatus(response.getStatus());
        if (getStatus() == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response.getRawBody(), GetAllUserModel.class);
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

    public GetAllUserModel getModel() {
        return model;
    }
}
