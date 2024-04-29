package com.vvr.group.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String zipCode;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

}