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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.request.users.sub.RequestPresence;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
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

    public UpdateUserRequestBody(String name, String title, RequestPresence presence, String mentionName,
                                 boolean groupAdmin, String timezone, String password, String email) {
        this.name = name;
        this.title = title;
        this.presence = presence;
        this.mentionName = mentionName;
        this.groupAdmin = groupAdmin;
        this.timezone = timezone;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public RequestPresence getPresence() {
        return presence;
    }

    public String getMentionName() {
        return mentionName;
    }

    public boolean isGroupAdmin() {
        return groupAdmin;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
