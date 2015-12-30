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
import pl.ppwozniak.hipchat.api2.common.ApiResponse;
import pl.ppwozniak.hipchat.api2.models.ErrorModel;
import pl.ppwozniak.hipchat.api2.models.users.*;
import pl.ppwozniak.hipchat.api2.request.users.*;
import pl.ppwozniak.hipchat.api2.request.users.params.CreateUserRequestParams;
import pl.ppwozniak.hipchat.api2.request.users.params.UpdateUserRequestParams;
import pl.ppwozniak.hipchat.api2.request.users.sub.GetPhotoType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    public ApiResponse<GetAllUsersRequest, GetAllUsersModel> getAllUsers
            (int startIndex, int maxResult, boolean includeGuests, boolean includeDeleted)
            throws IOException, UnirestException {
        GetAllUsersRequest request = new GetAllUsersRequest(startIndex, maxResult, includeGuests, includeDeleted);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        if (response.getStatus() == HttpStatus.SC_OK) {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), GetAllUsersModel.class));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public ApiResponse<GetAllUsersRequest, GetAllUsersModel> getAllUsers() throws IOException, UnirestException {
        return getAllUsers(0, 100, false, false);
    }

    public ApiResponse<GetAutoJoinRoomsRequest, GetAutoJoinRoomsModel> getAutoJoinRooms
            (String name, int startIndex, int maxResults) throws IOException, UnirestException {
        GetAutoJoinRoomsRequest request = new GetAutoJoinRoomsRequest(name, startIndex, maxResults);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        if (response.getStatus() == HttpStatus.SC_OK) {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), GetAutoJoinRoomsModel.class));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public ApiResponse<GetAutoJoinRoomsRequest, GetAutoJoinRoomsModel> getAutoJoinRooms(String name)
            throws IOException, UnirestException {
        return getAutoJoinRooms(name, 0, 100);
    }

    public ApiResponse<ViewUserRequest, ViewUserModel> viewUser(String name)
            throws IOException, UnirestException {
        ViewUserRequest request = new ViewUserRequest(name);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();
        if (response.getStatus() == HttpStatus.SC_OK) {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ViewUserModel.class));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public ApiResponse<CreateUserRequest, CreateUserModel> createUser(CreateUserRequestParams params)
            throws IOException, UnirestException {
        CreateUserRequest request = new CreateUserRequest(params);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();

        if (response.getStatus() == HttpStatus.SC_CREATED) {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), CreateUserModel.class));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public ApiResponse<UpdateUserRequest, UpdateUserModel> updateUser(String idOrEmail, UpdateUserRequestParams params)
            throws IOException, UnirestException {
        UpdateUserRequest request = new UpdateUserRequest(idOrEmail, params);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();

        if (response.getStatus() == HttpStatus.SC_NO_CONTENT) {
            return new ApiResponse<>(request, response.getStatus(), new UpdateUserModel("User updated"));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public ApiResponse<DeleteUserRequest, DeleteUserModel> deleteUser(String idOrEmail)
            throws IOException, UnirestException {
        DeleteUserRequest request = new DeleteUserRequest(idOrEmail);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();

        if (response.getStatus() == HttpStatus.SC_NO_CONTENT) {
            return new ApiResponse<>(request, response.getStatus(), new DeleteUserModel("User deleted"));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    private byte[] getPhotoAsBytes(InputStream is) throws IOException {
        int b;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while (true) {
            b = is.read();

            if (b == -1) {
                break;
            }

            baos.write(b);
        }

        baos.close();

        return baos.toByteArray();
    }

    public ApiResponse<GetPhotoRequest, GetPhotoModel> getPhoto(String idOrEmail, GetPhotoType type)
            throws IOException, UnirestException {
        GetPhotoRequest request = new GetPhotoRequest(idOrEmail, type);
        HttpResponse<InputStream> response = request.getRequest(token).asBinary();

        if (response.getStatus() == HttpStatus.SC_OK) {
            return new ApiResponse<>(request, response.getStatus(), new GetPhotoModel(getPhotoAsBytes(response.getBody())));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }

    public ApiResponse<DeletePhotoRequest, DeletePhotoModel> deletePhoto(String idOrEmail)
            throws IOException, UnirestException {
        DeletePhotoRequest request = new DeletePhotoRequest(idOrEmail);
        HttpResponse<JsonNode> response = request.getRequest(token).asJson();

        if (response.getStatus() == HttpStatus.SC_NO_CONTENT) {
            return new ApiResponse<>(request, response.getStatus(), new DeletePhotoModel("Photo deleted"));
        } else {
            return new ApiResponse<>(request, response.getStatus(),
                    new ObjectMapper().readValue(response.getRawBody(), ErrorModel.class));
        }
    }
}
