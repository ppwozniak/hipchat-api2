/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-12
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users.params;

import java.io.Serializable;

/**
 * @author wp
 */
public class CreateUserRequestParams implements Serializable {

    private String name;

    private String title;

    private String mentionName;

    private boolean groupAdmin;

    private String timezone;

    private String password;

    private String email;


    public CreateUserRequestParams(String name, String email) {
        this(name, "", name, false, "UTC", null, email);
    }

    public CreateUserRequestParams(String name, String email, String password) {
        this(name, "", name, false, "UTC", password, email);
    }

    public CreateUserRequestParams(String name, String title, String mentionName, boolean groupAdmin, String timezone,
                                   String password, String email) {
        this.name = name;
        this.title = title;
        this.mentionName = mentionName;
        this.groupAdmin = groupAdmin;
        this.timezone = timezone;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMentionName() {
        return mentionName;
    }

    public void setMentionName(String mentionName) {
        this.mentionName = mentionName;
    }

    public boolean isGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(boolean groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CreateUserRequestParams{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", mentionName='" + mentionName + '\'' +
                ", groupAdmin=" + groupAdmin +
                ", timezone='" + timezone + '\'' +
                ", password='" + "[password]" + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
