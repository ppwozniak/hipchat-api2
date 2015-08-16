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

import com.mashape.unirest.request.HttpRequest;

/**
 * @author wp
 */
public interface ApiRequest {

    HttpRequest getRequest(String token);
}
