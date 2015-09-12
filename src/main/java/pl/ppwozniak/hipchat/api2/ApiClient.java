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
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;
import pl.ppwozniak.hipchat.api2.common.Response;
import pl.ppwozniak.hipchat.api2.models.ErrorModel;
import pl.ppwozniak.hipchat.api2.models.users.*;
import pl.ppwozniak.hipchat.api2.request.users.*;
import pl.ppwozniak.hipchat.api2.request.users.params.CreateUserRequestParams;
import pl.ppwozniak.hipchat.api2.request.users.params.UpdateUserRequestParams;

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
        if (response.getStatus() == HttpStatus.SC_OK) {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), GetAllUserModel.class));
        } else {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public Response<GetAllUsersRequest, GetAllUserModel> getAllUsers() throws IOException, UnirestException {
        return getAllUsers(0, 100, false, false);
    }

    public Response<GetAutoJoinRoomsRequest, GetAutoJoinRoomsModel> getAutoJoinRooms
            (String name, int startIndex, int maxResults) throws IOException, UnirestException {
        GetAutoJoinRoomsRequest request = new GetAutoJoinRoomsRequest(name, startIndex, maxResults);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        if (response.getStatus() == HttpStatus.SC_OK) {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), GetAutoJoinRoomsModel.class));
        } else {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public Response<GetAutoJoinRoomsRequest, GetAutoJoinRoomsModel> getAutoJoinRooms(String name)
            throws IOException, UnirestException {
        return getAutoJoinRooms(name, 0, 100);
    }

    public Response<ViewUserRequest, ViewUserModel> viewUser(String name)
            throws IOException, UnirestException {
        ViewUserRequest request = new ViewUserRequest(name);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        if (response.getStatus() == HttpStatus.SC_OK) {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ViewUserModel.class));
        } else {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public Response<CreateUserRequest, CreateUserModel> createUser(CreateUserRequestParams params)
            throws IOException, UnirestException {
        CreateUserRequest request = new CreateUserRequest(params);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();

        if (response.getStatus() == HttpStatus.SC_CREATED) {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), CreateUserModel.class));
        } else {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public Response<UpdateUserRequest, UpdateUserModel> updateUser(String nameOrEmail, UpdateUserRequestParams params)
            throws IOException, UnirestException {
        UpdateUserRequest request = new UpdateUserRequest(nameOrEmail, params);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();

        if (response.getStatus() == HttpStatus.SC_NO_CONTENT) {
            return new Response<>(request, response.getStatus(), new UpdateUserModel("User updated"));
        } else {
            return new Response<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }
}
