package com.moshiur.userservice.model;

import jakarta.persistence.*;
@Entity
@Table(name = "address")
public class Address extends AuditBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
