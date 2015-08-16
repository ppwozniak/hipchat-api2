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

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @author wp
 */
public class ApiResponse<T> {

    T model;

    int status;

    public ApiResponse(Class<T> c) throws IllegalAccessException, InstantiationException {
        model = c.newInstance();
    }

    public void response(HttpResponse<JsonNode> response) throws IOException {
        status = response.getStatus();
        if (status == HttpStatus.SC_OK) {
            ObjectMapper mapper = new ObjectMapper();
            model = (T) mapper.readValue(response.getRawBody(), model.getClass());
        }
    }

    public T getModel() {
        return model;
    }

    public int getStatus() {
        return status;
    }
}
