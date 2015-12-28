/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-12
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class ErrorStatus implements Serializable {

    @JsonProperty("description")
    private String description;

    @JsonProperty("optional")
    private String optional;

    @JsonProperty("type")
    private String[] type;

    public ErrorStatus() {
    }

    public String getDescription() {
        return description;
    }

    public String getOptional() {
        return optional;
    }

    public String[] getType() {
        return type;
    }
}
