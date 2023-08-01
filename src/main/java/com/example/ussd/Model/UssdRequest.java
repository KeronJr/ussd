package com.example.ussd.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
////@Table(name = "ussdrequest")

public class UssdRequest {
//
////    private Long id;
//    private String sessionId;
////    private String phoneNumber;
//    private String text;
////    private String firstName;
////    private String lastName;
////    private String dateOfBirth;
////    private String location;
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "phone_number", nullable = false)
//    private String phoneNumber;
//
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//    @Column(name = "date_of_birth", nullable = false)
//    private String dateOfBirth;
//
//    @Column(name = "location", nullable = false)
//    private String location;
//
//    // Constructors, getters, and setters
//
//    public UssdRequest() {
//    }
//
//    public UssdRequest(String phoneNumber, String firstName, String lastName, String dateOfBirth, String location, String sessionId, String text) {
//        this.phoneNumber = phoneNumber;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        this.location = location;
//        this.sessionId = sessionId;
//        this.text = text;
//
//    }

    private String sessionId;
    private String phoneNumber;
    private String text;
}
