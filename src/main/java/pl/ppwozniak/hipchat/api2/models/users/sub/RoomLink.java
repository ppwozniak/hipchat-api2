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
public class RoomLink implements Serializable {

    @JsonProperty("self")
    private String self;

    @JsonProperty("webhooks")
    private String webhooks;

    @JsonProperty("members")
    private String members;

    @JsonProperty("participants")
    private String participants;

    public RoomLink() {
    }

    public String getSelf() {
        return self;
    }

    public String getWebhooks() {
        return webhooks;
    }

    public String getMembers() {
        return members;
    }

    public String getParticipants() {
        return participants;
    }
}
