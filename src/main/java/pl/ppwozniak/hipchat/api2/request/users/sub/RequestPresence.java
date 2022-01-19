/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-12
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users.sub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class RequestPresence implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("show")
    private String show;

    public RequestPresence(String status, String show) {
        this.status = status;
        this.show = show;
    }

    public String getStatus() {
        return status;
    }

    public String getShow() {
        return show;
    }
}
