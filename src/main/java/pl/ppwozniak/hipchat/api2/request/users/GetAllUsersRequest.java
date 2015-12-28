/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-16
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import lombok.ToString;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class GetAllUsersRequest extends AbstractRequest {

    private static final String REQUEST_URL = "user";

    private int startIndex;

    private int maxResult;

    private boolean includeGuests;

    private boolean includeDeleted;

    public GetAllUsersRequest(int startIndex, int maxResult, boolean includeGuests, boolean includeDeleted) {
        this.startIndex = startIndex;
        this.maxResult = maxResult;
        this.includeGuests = includeGuests;
        this.includeDeleted = includeDeleted;
    }

    public GetAllUsersRequest() {
        this(0, 100, false, false);
    }

    @Override
    public HttpRequest getRequest(String token) {
        HttpRequest request = Unirest.get(ApiData.URL + REQUEST_URL)
                .queryString("start-index", startIndex)
                .queryString("max-results", maxResult)
                .queryString("include-guests", includeGuests)
                .queryString("include-deleted", includeDeleted)
                .queryString(ApiData.TOKEN_PARAM_NAME, token);
        setUrl(request.getUrl());
        return request;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public boolean isIncludeGuests() {
        return includeGuests;
    }

    public boolean isIncludeDeleted() {
        return includeDeleted;
    }
}
