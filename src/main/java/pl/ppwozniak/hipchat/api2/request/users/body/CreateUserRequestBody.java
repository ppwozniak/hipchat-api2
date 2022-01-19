/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-05
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class CreateUserRequestBody implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("title")
    private String title;

    @JsonProperty("mention_name")
    private String mentionName;

    @JsonProperty("is_group_admin")
    private boolean admin;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("password")
    private String password;

    public CreateUserRequestBody(String name, String email, String title, String mentionName, boolean admin,
                                 String timezone, String password) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.mentionName = mentionName;
        this.admin = admin;
        this.timezone = timezone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getMentionName() {
        return mentionName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getPassword() {
        return password;
    }
}
