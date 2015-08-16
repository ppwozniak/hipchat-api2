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
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.ApiRequest;

/**
 * @author wp
 */
public class GetAllUsersRequest implements ApiRequest {

    private static final String URL = "user";

    private int startIndex;

    private int maxResult;

    private boolean includeGuests;

    private boolean includeDeleted;

    private GetAllUsersRequest(int startIndex, int maxResult, boolean includeGuests, boolean includeDeleted) {
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
        return Unirest.get(ApiData.URL + URL)
                .queryString(ApiData.TOKEN_PARAM_NAME, token)
                .queryString("start-index", startIndex)
                .queryString("max-results", maxResult)
                .queryString("include-guests", includeGuests)
                .queryString("include-deleted", includeDeleted);
    }
}
