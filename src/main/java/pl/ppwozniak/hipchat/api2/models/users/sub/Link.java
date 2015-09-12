/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users.sub;

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
public class Link implements Serializable {

    @JsonProperty("self")
    private String self;
}
