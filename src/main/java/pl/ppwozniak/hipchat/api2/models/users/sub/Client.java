/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users.sub;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class Client implements Serializable {

    @JsonProperty("version")
    private String version;

    @JsonProperty("type")
    private String type;

    public Client() {
    }

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }
}
