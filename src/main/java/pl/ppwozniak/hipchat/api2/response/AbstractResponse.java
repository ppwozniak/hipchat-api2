/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-02
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.response;

import pl.ppwozniak.hipchat.api2.common.ApiRequest;

/**
 * @author wp
 */
public abstract class AbstractResponse {

    private ApiRequest request;

    private int status;

    public AbstractResponse(ApiRequest request, int status) {
        this.request = request;
        this.status = status;
    }

    public ApiRequest getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    protected void setStatus(int status) {
        this.status = status;
    }
}
