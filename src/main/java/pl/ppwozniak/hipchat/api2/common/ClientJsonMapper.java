/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-05
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.common;

import com.mashape.unirest.http.ObjectMapper;

import java.io.IOException;

/**
 * @author wp
 */
public class ClientJsonMapper implements ObjectMapper {

    com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        try {
            return objectMapper.readValue(value, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String writeValue(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
