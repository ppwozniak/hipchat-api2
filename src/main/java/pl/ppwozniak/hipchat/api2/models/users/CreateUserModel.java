/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author wp
 */
public class CreateUserModel extends AbstractUserModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("password")
    private String password;

    public CreateUserModel() {
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CreateUserModel{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", links=" + getLinks() +
                '}';
    }
}
