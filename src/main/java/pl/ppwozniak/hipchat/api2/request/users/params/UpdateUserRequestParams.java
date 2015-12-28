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

import lombok.ToString;
import pl.ppwozniak.hipchat.api2.models.users.ViewUserModel;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class UpdateUserRequestParams implements Serializable {

    private String name;

    private String title;

    private String status;

    private String show;

    private String mentionName;

    private boolean admin;

    private String timezone;

    private String password;

    private String email;

    public UpdateUserRequestParams(String name, String title, String status, String show, String mentionName,
                                   boolean admin, String timezone, String password, String email) {
        this.name = name;
        this.title = title;
        this.status = status;
        this.show = show;
        this.mentionName = mentionName;
        this.admin = admin;
        this.timezone = timezone;
        this.password = password;
        this.email = email;
    }

    public UpdateUserRequestParams(String email, String mentionName, String show, String name) {
        this(name, "", null, null, mentionName, false, "UTC", "", email);
        this.email = email;
        this.mentionName = mentionName;
        this.show = show;
        this.name = name;
        this.password = "";

    }

    public UpdateUserRequestParams(ViewUserModel model) {
        this(model.getName(), model.getTitle(), null, null, model.getMentionName(), model.isGroupAdmin(),
                model.getTimezone(), "", model.getEmail());
        if (model.getPresence() != null) {
            this.status = model.getPresence().getStatus();
            this.show = model.getPresence().getShow();
        } else {
            this.status = null;
            this.show = null;
        }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getMentionName() {
        return mentionName;
    }

    public void setMentionName(String mentionName) {
        this.mentionName = mentionName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
}
