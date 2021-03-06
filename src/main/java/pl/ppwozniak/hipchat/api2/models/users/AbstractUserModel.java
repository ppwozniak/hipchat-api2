/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;
import pl.ppwozniak.hipchat.api2.models.users.sub.Links;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public abstract class AbstractUserModel implements Serializable {

    @JsonProperty("links")
    private Links links;

    public AbstractUserModel() {
    }

    public Links getLinks() {
        return links;
    }
}
