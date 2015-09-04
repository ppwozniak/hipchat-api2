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

/**
 * @author wp
 */
public class CreateUserSimpleBody {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    public CreateUserSimpleBody(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CreateUserSimpleBody{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
