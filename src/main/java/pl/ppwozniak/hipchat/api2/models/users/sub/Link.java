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

import java.io.Serializable;

/**
 * @author wp
 */
public class Link implements Serializable {

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
