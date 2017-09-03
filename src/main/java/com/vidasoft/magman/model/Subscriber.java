package com.vidasoft.magman.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Subscriber extends User {

    private String streetAddress;
    private LocalDate subscribedUntil;

    public Subscriber() {
    }

    public Subscriber(String userName, String password, String firstName,
                      String lastName, String email, String streetAddress,
                      LocalDate subscribedUntil) {
        super(userName, password, firstName, lastName, email);
        this.streetAddress = streetAddress;
        this.subscribedUntil = subscribedUntil;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public LocalDate getSubscribedUntil() {
        return subscribedUntil;
    }

    public void setSubscribedUntil(LocalDate subscribedUntil) {
        this.subscribedUntil = subscribedUntil;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "userName='" + getUserName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", subscribedUntil=" + subscribedUntil +
                '}';
    }
}
