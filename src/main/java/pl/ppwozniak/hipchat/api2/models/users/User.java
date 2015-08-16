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

/**
 * @author wp
 */
public class User {

    private String mention_name;

    private int id;

    private UserLink links;

    private String name;

    public User() {
    }

    public User(String mention_name, int id, UserLink links, String name) {
        this.mention_name = mention_name;
        this.id = id;
        this.links = links;
        this.name = name;
    }

    public String getMention_name() {
        return mention_name;
    }

    public void setMention_name(String mention_name) {
        this.mention_name = mention_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserLink getLinks() {
        return links;
    }

    public void setLinks(UserLink links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserItem{" +
                "name='" + name + '\'' +
                ", links=" + links +
                ", id=" + id +
                ", mention_name='" + mention_name + '\'' +
                '}';
    }
}
