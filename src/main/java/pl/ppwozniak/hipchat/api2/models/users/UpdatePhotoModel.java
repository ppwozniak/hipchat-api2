/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-12-30
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users;

import lombok.ToString;

/**
 * @author wp
 */
@ToString(callSuper = true)
public class UpdatePhotoModel extends EmptyContentModel {

    public UpdatePhotoModel(String status) {
        super(status);
    }
}
