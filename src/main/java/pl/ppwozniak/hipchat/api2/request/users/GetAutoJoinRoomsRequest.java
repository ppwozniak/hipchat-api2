/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.request.ApiRequest;

/**
 * @author wp
 */
public class GetAutoJoinRoomsRequest implements ApiRequest {

    private static final String URL_P1 = "user/";

    private static final String URL_P2 = "/preference/auto-join";

    private String name;

    private int startIndex;

    private int maxResults;

    public GetAutoJoinRoomsRequest(String name, int startIndex, int maxResults) {
        this.name = name;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
    }

    public GetAutoJoinRoomsRequest(String name) {
        this(name, 0, 100);
    }

    @Override
    public HttpRequest getRequest(String token) {
        return Unirest.get(ApiData.URL + URL_P1 + name + URL_P2)
                .queryString("start-index", startIndex)
                .queryString("max-results", maxResults)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);
    }

    public String getName() {
        return name;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResults() {
        return maxResults;
    }
}
