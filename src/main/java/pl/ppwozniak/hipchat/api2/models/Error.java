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

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class Error implements Serializable {

    @JsonProperty("code")
    private int code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    @JsonProperty("description")
    private String description;

    @JsonProperty("expected_type")
    private String expectedType;

    @JsonProperty("field")
    private String field;

    @JsonProperty("validation")
    private String validation;

    @JsonProperty("value")
    private String value;

    public Error() {
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public String getExpectedType() {
        return expectedType;
    }

    public String getField() {
        return field;
    }

    public String getValidation() {
        return validation;
    }

    public String getValue() {
        return value;
    }
}
