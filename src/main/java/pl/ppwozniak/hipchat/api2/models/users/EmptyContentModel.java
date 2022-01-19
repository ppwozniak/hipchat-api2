/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-12
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author wp
 */
@ToString
public abstract class EmptyContentModel {

    @JsonProperty("status")
    private String status;

    public EmptyContentModel(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
