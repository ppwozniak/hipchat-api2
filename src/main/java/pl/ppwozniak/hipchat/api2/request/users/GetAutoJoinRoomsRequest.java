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
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;

/**
 * @author wp
 */
public class GetAutoJoinRoomsRequest extends AbstractRequest {

    private static final String REQUEST_URL_PART1 = "user/";

    private static final String REQUEST_URL_PART2 = "/preference/auto-join";

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
        HttpRequest request = Unirest.get(ApiData.URL + REQUEST_URL_PART1 + name + REQUEST_URL_PART2)
                .queryString("start-index", startIndex)
                .queryString("max-results", maxResults)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);
        setUrl(request.getUrl());
        return request;
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

    @Override
    public String toString() {
        return "GetAutoJoinRoomsRequest{" +
                "maxResults=" + maxResults +
                ", startIndex=" + startIndex +
                ", name='" + name + '\'' +
                ", url=" + getUrl() +
                '}';
    }
}
