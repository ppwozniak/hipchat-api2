/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;
import pl.ppwozniak.hipchat.api2.models.users.sub.Group;
import pl.ppwozniak.hipchat.api2.models.users.sub.Presence;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class ViewUserModel extends AbstractUserModel {

    @JsonProperty("xmpp_jid")
    private String jabberId;

    @JsonProperty("is_deleted")
    private boolean deleted;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_active")
    private String lastActive;

    @JsonProperty("title")
    private String title;

    @JsonProperty("presence")
    private Presence presence;

    @JsonProperty("created")
    private String dateOfCreation;

    @JsonProperty("id")
    private int id;

    @JsonProperty("mention_name")
    private String mentionName;

    @JsonProperty("version")
    private String version;

    @JsonProperty("is_group_admin")
    private boolean groupAdmin;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("is_guest")
    private boolean guest;

    @JsonProperty("email")
    private String email;

    @JsonProperty("photo_url")
    private String photoUrl;

    @JsonProperty("group")
    private Group group;

    @JsonProperty("roles")
    private String[] roles;

    public ViewUserModel() {
    }

    public String getJabberId() {
        return jabberId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getName() {
        return name;
    }

    public String getLastActive() {
        return lastActive;
    }

    public String getTitle() {
        return title;
    }

    public Presence getPresence() {
        return presence;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public String getMentionName() {
        return mentionName;
    }

    public String getVersion() {
        return version;
    }

    public boolean isGroupAdmin() {
        return groupAdmin;
    }

    public String getTimezone() {
        return timezone;
    }

    public boolean isGuest() {
        return guest;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Group getGroup() {
        return group;
    }

    public String[] getRoles() {
        return roles;
    }
}
