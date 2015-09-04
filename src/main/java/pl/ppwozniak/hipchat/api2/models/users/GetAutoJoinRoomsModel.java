/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import org.codehaus.jackson.annotate.JsonProperty;
import pl.ppwozniak.hipchat.api2.models.users.sub.Room;

import java.util.Arrays;

/**
 * @author wp
 */
public class GetAutoJoinRoomsModel extends AbstractUserModel {

    @JsonProperty("items")
    private Room[] rooms;

    @JsonProperty("startIndex")
    private int startIndex;

    @JsonProperty("maxResults")
    private int maxResults;

    public GetAutoJoinRoomsModel() {
    }

    public Room[] getRooms() {
        return rooms;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResults() {
        return maxResults;
    }

    @Override
    public String toString() {
        return "GetAutoJoinRoomsModel{" +
                "rooms=" + Arrays.toString(rooms) +
                ", startIndex=" + startIndex +
                ", maxResults=" + maxResults +
                ",links=" + getLinks() +
                '}';
    }
}
