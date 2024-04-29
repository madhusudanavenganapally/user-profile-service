package com.vvr.group.entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "teacher_registration")
public class TeacherRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}