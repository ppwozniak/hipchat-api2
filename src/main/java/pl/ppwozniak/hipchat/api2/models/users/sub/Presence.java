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

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
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

    @Override
    public String toString() {
        return "Presence{" +
                "online=" + online +
                ", client=" + client +
                ", show='" + show + '\'' +
                ", idle=" + idle +
                ", status='" + status + '\'' +
                '}';
    }
}
