/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-16
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.common;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

/**
 * @author wp
 */
public class ApiMethod<T> {

    private ApiRequest request;

    private ApiResponse<T> response;

    private Class<T> c;

    public ApiMethod(ApiRequest request, Class<T> c) {
        this.request = request;
        this.c = c;
    }

    public void run(String token) throws UnirestException, IOException, IllegalAccessException, InstantiationException {
        ApiResponse<T> response = new ApiResponse<>(c);
        response.response(request.getRequest(token).asJson());
        this.response = response;
    }

    public ApiRequest getRequest() {
        return request;
    }

    public ApiResponse<T> getResponse() {
        return response;
    }

    public T getModel() {
        return getResponse().getModel();
    }

    public int getStatus() {
        return getResponse().getStatus();
    }
}
