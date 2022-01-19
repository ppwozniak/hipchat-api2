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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.models.users.sub.Room;

/**
 * @author wp
 */
@ToString(callSuper = true)
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
}
