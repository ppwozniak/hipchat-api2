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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author wp
 */
@ToString(callSuper = true)
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
}
