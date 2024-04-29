package com.vvr.group.entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "student_registration")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String motherName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String firstLanguage;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}