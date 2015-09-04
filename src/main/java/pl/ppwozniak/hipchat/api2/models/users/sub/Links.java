/**
 * *************************************************
 * Projekt: hipchat-api2
 * <p/>
 * Autor: Paweł Woźniak
 * <p/>
 * Data utworzenia: 2015-08-15
 * *************************************************
 */
package pl.ppwozniak.hipchat.api2.models.users.sub;

import java.io.Serializable;

/**
 * @author wp
 */
public class Links implements Serializable {

    private String self;
    private String prev;
    private String next;

    public Links() {
    }

    public Links(String self, String prev, String next) {
        this.self = self;
        this.prev = prev;
        this.next = next;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self='" + self + '\'' +
                ", prev='" + prev + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}

