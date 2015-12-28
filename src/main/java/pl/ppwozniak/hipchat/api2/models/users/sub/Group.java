/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users.sub;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class Group implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("links")
    private Link link;

    @JsonProperty("name")
    private String name;

    public Group() {
    }

    public int getId() {
        return id;
    }

    public Link getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
}
