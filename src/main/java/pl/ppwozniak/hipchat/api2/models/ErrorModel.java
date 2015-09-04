/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
public class ErrorModel implements Serializable {

    @JsonProperty("error")
    private Error error;

    public ErrorModel() {
    }

    public Error getError() {
        return error;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "error=" + error +
                '}';
    }
}
