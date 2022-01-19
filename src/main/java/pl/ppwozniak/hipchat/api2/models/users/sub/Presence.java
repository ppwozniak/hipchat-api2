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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class Presence implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("idle")
    private int idle;

    @JsonProperty("show")
    private String show;

    @JsonProperty("client")
    private Client client;

    @JsonProperty("is_online")
    private boolean online;

    public Presence() {
    }

    public String getStatus() {
        return status;
    }

    public int getIdle() {
        return idle;
    }

    public String getShow() {
        return show;
    }

    public Client getClient() {
        return client;
    }

    public boolean isOnline() {
        return online;
    }
}
