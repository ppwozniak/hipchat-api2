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

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class User implements Serializable {

    @JsonProperty("mention_name")
    private String mentionName;

    @JsonProperty("id")
    private int id;

    @JsonProperty("links")
    private Link link;

    @JsonProperty("name")
    private String name;

    @JsonProperty("version")
    private String version;

    public User() {
    }

    public String getMentionName() {
        return mentionName;
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

    public String getVersion() {
        return version;
    }
}
