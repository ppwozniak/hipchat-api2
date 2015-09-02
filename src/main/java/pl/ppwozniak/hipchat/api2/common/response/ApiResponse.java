/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-16
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.common.response;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

/**
 * @author wp
 */
public interface ApiResponse {

    void run(String token) throws IOException, UnirestException;
}
