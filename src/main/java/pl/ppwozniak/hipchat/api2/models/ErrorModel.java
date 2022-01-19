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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class ErrorModel implements Serializable {

    @JsonProperty("error")
    private Error error;

    @JsonProperty("type")
    private ErrorType type;

    @JsonProperty("status")
    private ErrorStatus status;

    public ErrorModel() {
    }

    public Error getError() {
        return error;
    }

    public ErrorType getType() {
        return type;
    }

    public ErrorStatus getStatus() {
        return status;
    }
}
