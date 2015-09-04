/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-05
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users.sub;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
public class CreateUserFullBody extends CreateUserSimpleBody implements Serializable {

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

    public CreateUserFullBody(String name, String title, String mentionName, boolean admin, String timezone, String password, String email) {
        super(name, email);
        this.title = title;
        this.mentionName = mentionName;
        this.admin = admin;
        this.timezone = timezone;
        this.password = password;
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

    @Override
    public String toString() {
        return "CreateUserFullBody{" +
                "title='" + title + '\'' +
                ", mentionName='" + mentionName + '\'' +
                ", admin=" + admin +
                ", timezone='" + timezone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
