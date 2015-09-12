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

/**
 * @author wp
 */
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Links extends Link {

    @JsonProperty("prev")
    private String prev;

    @JsonProperty("next")
    private String next;
}

