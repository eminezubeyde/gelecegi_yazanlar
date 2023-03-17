package org.example.data.entity;

import java.util.Date;
import java.util.List;

public class Customer extends User {
    private String nationalityId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<Game> games;

    public Customer() {
    }

    public Customer(int id, String email, String password, String nationalityId, String firstName, String lastName, Date birthDate, List<Game> games) {
        super(id, email, password);
        this.nationalityId = nationalityId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.games = games;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nationalityId='" + nationalityId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", games=" + games +
                '}';
    }
}