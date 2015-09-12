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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
@Getter
@ToString
@NoArgsConstructor
public class ErrorModel implements Serializable {

    @JsonProperty("error")
    private Error error;

    @JsonProperty("type")
    private ErrorType type;

    @JsonProperty("status")
    private ErrorStatus status;
}
