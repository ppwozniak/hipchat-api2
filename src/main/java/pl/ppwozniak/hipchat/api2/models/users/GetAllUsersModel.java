/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;
import pl.ppwozniak.hipchat.api2.models.users.sub.User;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class GetAllUsersModel extends AbstractUserModel {

    @JsonProperty("items")
    private User[] users;

    @JsonProperty("startIndex")
    private int startIndex;

    @JsonProperty("maxResults")
    private int maxResults;

    public GetAllUsersModel() {
    }

    public User[] getUsers() {
        return users;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResults() {
        return maxResults;
    }
}
