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

import lombok.ToString;
import pl.ppwozniak.hipchat.api2.models.ErrorModel;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class ApiResponse<R, M> implements Serializable {

    private R request;

    private int status;

    private M model;

    private ErrorModel errorModel;

    public ApiResponse(R request, int status, M model) {
        this.request = request;
        this.status = status;
        this.model = model;
        this.errorModel = null;
    }

    public ApiResponse(R request, int status, ErrorModel errorModel) {
        this.request = request;
        this.status = status;
        this.model = null;
        this.errorModel = errorModel;
    }

    public ApiResponse(R request, int status, M model, ErrorModel errorModel) {
        this.request = request;
        this.status = status;
        this.model = model;
        this.errorModel = errorModel;
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

    public ErrorModel getErrorModel() {
        return errorModel;
    }
}
