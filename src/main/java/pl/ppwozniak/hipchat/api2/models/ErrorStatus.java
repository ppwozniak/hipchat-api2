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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author wp
 */
@Getter
@NoArgsConstructor
@ToString
public class ErrorStatus {

    @JsonProperty("description")
    private String description;

    @JsonProperty("optional")
    private String optional;

    @JsonProperty("type")
    private String[] type;
}
