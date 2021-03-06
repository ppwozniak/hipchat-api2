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

import lombok.ToString;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class DeleteUserModel extends EmptyContentModel {

    public DeleteUserModel(String status) {
        super(status);
    }
}
