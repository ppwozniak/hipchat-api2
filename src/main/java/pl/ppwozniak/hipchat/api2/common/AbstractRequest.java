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
public abstract class AbstractRequest implements ApiRequest, Serializable {

    private String url;

    @Override
    public String getUrl() {
        return url;
    }

    protected void setUrl(String url) {
        this.url = Utils.cleanUrlFromToken(url);
    }
}
