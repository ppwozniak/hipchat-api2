/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.common;

import java.io.Serializable;

/**
 * @author wp
 */
public class Response<R, M> implements Serializable {

    private R request;

    private int status;

    private M model;

    public Response(R request, int status, M model) {
        this.request = request;
        this.status = status;
        this.model = model;
    }

    public R getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public M getModel() {
        return model;
    }
}
