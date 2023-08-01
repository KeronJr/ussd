package com.example.ussd.Model;

import jakarta.persistence.*;

@Entity
public class Userz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String location;

    public Userz() {
        // Default constructor
    }

    // Constructors with all fields
    public Userz(String firstName, String lastName, String nationalId, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.location = location;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
