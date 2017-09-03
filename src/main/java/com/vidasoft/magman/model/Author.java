package com.vidasoft.magman.model;

import javax.persistence.*;

@Entity
public class Author extends User {

    private boolean isRegular;
    private int salary;

    public Author() {
    }

    public Author(String userName, String password, String firstName,
                  String lastName, String email, boolean isRegular, int salary) {
        super(userName, password, firstName, lastName, email);
        this.isRegular = isRegular;
        this.salary = salary;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Author{" +
                "userName='" + getUserName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", isRegular=" + isRegular +
                ", salary=" + salary +
                '}';
    }
}
