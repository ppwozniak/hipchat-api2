/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-12-30
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users.body;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author wp
 */
@ToString
public class UpdatePhotoRequestBody implements Serializable {

    @JsonProperty("photo")
    private String photo;

    public UpdatePhotoRequestBody(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
