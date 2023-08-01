package com.example.ussd.Model;

import jakarta.persistence.*;

@Entity
public class Userussd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String language;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String location;

    // Constructors, getters, and setters


    public Userussd() {
    }



    public Userussd( int id, String firstName, String lastName, String dateOfBirth, String location, String language) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLanguage(String language) {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

}
