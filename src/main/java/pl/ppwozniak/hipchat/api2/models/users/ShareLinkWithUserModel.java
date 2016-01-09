/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2016-01-09
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import lombok.ToString;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class ShareLinkWithUserModel extends EmptyContentModel {

    public ShareLinkWithUserModel(String status) {
        super(status);
    }
}
