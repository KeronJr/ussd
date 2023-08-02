package com.example.ussd.Model;

public class UssdSession {
    private String sessionId;
    private String phoneNumber;
    private int level;
    private String language;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String location;

    public UssdSession() {
        // Default constructor
    }

    // Constructors with all fields
    public UssdSession(String sessionId, String phoneNumber, int level, String language,
                       String firstName, String lastName, String nationalId, String location) {
        this.sessionId = sessionId;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.language = language;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.location = location;
    }

    // Getters and setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

