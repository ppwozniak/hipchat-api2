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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class Links extends Link {

    @JsonProperty("prev")
    private String prev;

    @JsonProperty("next")
    private String next;

    public Links() {
    }

    public String getPrev() {
        return prev;
    }

    public String getNext() {
        return next;
    }
}

