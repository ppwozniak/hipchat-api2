/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.codehaus.jackson.map.ObjectMapper;
import pl.ppwozniak.hipchat.api2.common.Response;
import pl.ppwozniak.hipchat.api2.models.users.GetAllUserModel;
import pl.ppwozniak.hipchat.api2.models.users.GetAutoJoinRoomsModel;
import pl.ppwozniak.hipchat.api2.models.users.ViewUserModel;
import pl.ppwozniak.hipchat.api2.request.users.GetAllUsersRequest;
import pl.ppwozniak.hipchat.api2.request.users.GetAutoJoinRoomsRequest;
import pl.ppwozniak.hipchat.api2.request.users.ViewUserRequest;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author wp
 */
public class ApiClient implements Serializable {

    private String token;

    private ApiClient(String token) {
        this.token = token;
    }

    public static ApiClient createClient(String token) {
        return new ApiClient(token);
    }

    public Response<GetAllUsersRequest, GetAllUserModel> getAllUsers
            (int startIndex, int maxResult, boolean includeGuests, boolean includeDeleted)
            throws IOException, UnirestException {
        GetAllUsersRequest request = new GetAllUsersRequest(startIndex, maxResult, includeGuests, includeDeleted);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        return new Response<>(request, response.getStatus(),
                new ObjectMapper().readValue(response.getRawBody(), GetAllUserModel.class));
    }

    public Response<GetAllUsersRequest, GetAllUserModel> getAllUsers() throws IOException, UnirestException {
        return getAllUsers(0, 100, false, false);
    }

    public Response<GetAutoJoinRoomsRequest, GetAutoJoinRoomsModel> getAutoJoinRooms
            (String name, int startIndex, int maxResults) throws IOException, UnirestException {
        GetAutoJoinRoomsRequest request = new GetAutoJoinRoomsRequest(name, startIndex, maxResults);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        return new Response<>(request, response.getStatus(),
                new ObjectMapper().readValue(response.getRawBody(), GetAutoJoinRoomsModel.class));
    }

    public Response<GetAutoJoinRoomsRequest, GetAutoJoinRoomsModel> getAutoJoinRooms(String name)
            throws IOException, UnirestException {
        return getAutoJoinRooms(name, 0, 100);
    }

    public Response<ViewUserRequest, ViewUserModel> viewUser(String name)
            throws IOException, UnirestException {
        ViewUserRequest request = new ViewUserRequest(name);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        return new Response<>(request, response.getStatus(),
                new ObjectMapper().readValue(response.getRawBody(), ViewUserModel.class));
    }
}
