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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author wp
 */
public class GetAllUsersModel {

    @JsonProperty("items")
    private User[] users;

    private int startIndex;

    private int maxResults;

    @JsonProperty("links")
    private UserLinks userLinks;

    public GetAllUsersModel() {
    }

    public GetAllUsersModel(User[] users, int startIndex, int maxResults, UserLinks userLinks) {
        this.users = users;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
        this.userLinks = userLinks;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public UserLinks getUserLinks() {
        return userLinks;
    }

    public void setUserLinks(UserLinks userLinks) {
        this.userLinks = userLinks;
    }
}
