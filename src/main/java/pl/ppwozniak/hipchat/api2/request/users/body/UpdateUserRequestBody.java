/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-12
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonProperty;
import pl.ppwozniak.hipchat.api2.request.users.sub.RequestPresence;

import java.io.Serializable;

/**
 * @author wp
 */
@Getter
@AllArgsConstructor
public class UpdateUserRequestBody implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("presence")
    private RequestPresence presence;

    @JsonProperty("mention_name")
    private String mentionName;

    @JsonProperty("is_group_admin")
    private boolean groupAdmin;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @Override
    public String toString() {
        return "UpdateUserRequestBody{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", presence=" + presence +
                ", mentionName='" + mentionName + '\'' +
                ", groupAdmin=" + groupAdmin +
                ", timezone='" + timezone + '\'' +
                ", password='" + "[password]" + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
