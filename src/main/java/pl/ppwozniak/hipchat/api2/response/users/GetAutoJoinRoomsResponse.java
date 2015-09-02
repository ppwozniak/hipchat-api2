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
import pl.ppwozniak.hipchat.api2.common.request.ApiRequest;
import pl.ppwozniak.hipchat.api2.common.response.AbstractResponse;
import pl.ppwozniak.hipchat.api2.models.users.GetAutoJoinRoomsModel;

import java.io.IOException;

/**
 * @author wp
 */
public class GetAutoJoinRoomsResponse extends AbstractResponse {

    private GetAutoJoinRoomsModel model;

    private GetAutoJoinRoomsResponse(ApiRequest request, int status, GetAutoJoinRoomsModel model) {
        super(request, status);
        this.model = model;
    }

    public GetAutoJoinRoomsResponse(ApiRequest request) {
        this(request, -1, new GetAutoJoinRoomsModel());
    }

    @Override
    public void run(String token) throws IOException, UnirestException {
        setStatus(0);
        HttpResponse<JsonNode> response = getRequest().getRequest(token).asJson();
        setStatus(response.getStatus());
        if (getStatus() == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = mapper.readValue(response.getRawBody(), GetAutoJoinRoomsModel.class);
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

    public GetAutoJoinRoomsModel getModel() {
        return model;
    }
}
