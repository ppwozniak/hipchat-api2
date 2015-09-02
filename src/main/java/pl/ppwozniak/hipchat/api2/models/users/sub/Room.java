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

/**
 * @author wp
 */
public class Room {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("links")
    private RoomLink roomLink;

    public Room() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RoomLink getRoomLink() {
        return roomLink;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomLink=" + roomLink +
                '}';
    }
}
