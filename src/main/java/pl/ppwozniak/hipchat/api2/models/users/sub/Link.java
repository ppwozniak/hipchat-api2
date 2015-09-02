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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author wp
 */
public class Link {

    @JsonProperty("self")
    private String self;

    public Link() {
    }

    public String getSelf() {
        return self;
    }

    @Override
    public String toString() {
        return "Link{" +
                "self='" + self + '\'' +
                '}';
    }
}
