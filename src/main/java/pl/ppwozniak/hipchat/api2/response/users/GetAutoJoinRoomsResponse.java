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
import pl.ppwozniak.hipchat.api2.models.users.GetAutoJoinRoomsModel;

import java.io.IOException;

/**
 * @author wp
 */
public class GetAutoJoinRoomsResponse implements ApiResponse {

    private ApiRequest request;

    private int status;

    private GetAutoJoinRoomsModel model;

    private GetAutoJoinRoomsResponse(ApiRequest request, int status, GetAutoJoinRoomsModel model) {
        this.request = request;
        this.status = status;
        this.model = model;
    }

    public GetAutoJoinRoomsResponse(ApiRequest request) {
        this(request, -1, new GetAutoJoinRoomsModel());
    }

    @Override
    public void run(String token) throws IOException, UnirestException {
        status = 0;
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        status = response.getStatus();
        if (status == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response.getRawBody(), GetAutoJoinRoomsModel.class);
        }
    }

    public ApiRequest getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public GetAutoJoinRoomsModel getModel() {
        return model;
    }
}
