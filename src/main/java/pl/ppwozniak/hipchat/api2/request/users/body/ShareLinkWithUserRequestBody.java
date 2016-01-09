/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2016-01-09
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users.body;

import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author wp
 */
@ToString
public class ShareLinkWithUserRequestBody {

    @JsonProperty("message")
    private String message;

    @JsonProperty("link")
    private String link;

    public ShareLinkWithUserRequestBody(String message, String link) {
        this.message = message;
        this.link = link;
    }

    public String getMessage() {
        return message;
    }

    public String getLink() {
        return link;
    }
}
