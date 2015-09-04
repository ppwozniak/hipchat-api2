/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-09-04
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.request.users;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import pl.ppwozniak.hipchat.api2.common.AbstractRequest;
import pl.ppwozniak.hipchat.api2.common.ApiData;
import pl.ppwozniak.hipchat.api2.common.ClientJsonMapper;
import pl.ppwozniak.hipchat.api2.models.users.sub.CreateUserFullBody;
import pl.ppwozniak.hipchat.api2.models.users.sub.CreateUserSimpleBody;

/**
 * @author wp
 */
public class CreateUserRequest extends AbstractRequest {

    private static final String REQUEST_URL = "user";

    private String name;

    private String title;

    private String mentionName;

    private boolean admin;

    private String timezone;

    private String password;

    private String email;

    private int type;

    public CreateUserRequest(String name, String title, String mentionName, boolean admin, String timezone,
                             String password, String email) {
        type = 0;
        this.name = name;
        this.title = title;
        this.mentionName = mentionName;
        this.admin = admin;
        this.timezone = timezone;
        this.password = password;
        this.email = email;
    }

    public CreateUserRequest(String name, String email) {
        type = 1;
        this.name = name;
        this.email = email;
    }

    @Override
    public HttpRequest getRequest(String token) {
        Unirest.setObjectMapper(new ClientJsonMapper());
        HttpRequestWithBody request = Unirest.post(ApiData.URL + REQUEST_URL)
                .header("Content-Type", "application/json")
                .queryString(ApiData.TOKEN_PARAM_NAME, token);

        switch (type) {
            case 0:
                CreateUserFullBody createUserFullBody = new CreateUserFullBody(name, title, mentionName, admin,
                        timezone, password, email);
                request.body(createUserFullBody);
                break;
            case 1:
                CreateUserSimpleBody createUserSimpleBody = new CreateUserSimpleBody(name, email);
                request.body(createUserSimpleBody);
                break;
            default:
                break;
        }
        setUrl(request.getUrl());
        return request;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getMentionName() {
        return mentionName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", mentionName='" + mentionName + '\'' +
                ", admin=" + admin +
                ", timezone='" + timezone + '\'' +
                ", password='" + "[password]" + '\'' +
                ", email='" + email + '\'' +
                ", url=" + getUrl() +
                '}';


    }
}
