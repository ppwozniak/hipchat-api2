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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
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
