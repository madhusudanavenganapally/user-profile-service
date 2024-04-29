package com.vvr.group.repository;

import com.vvr.group.entity.StudentRegistration;
import com.vvr.group.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRegistrationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    @Test
    public void whenFindById_thenReturnStudentRegistration() {
        // given
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.setStudentName("Sai");
        studentRegistration.setCourse("Telugu");
        studentRegistration.setRegistrationDate(LocalDateTime.now());
        studentRegistration.setDateOfBirth(LocalDate.of(2000, 1, 1));
        studentRegistration.setGender("Male");
        studentRegistration.setGrade("A");
        studentRegistration.setFatherName("Father's Name");
        studentRegistration.setMotherName("Mother's Name");
        studentRegistration.setEmail("sai@sai.com");
        studentRegistration.setMobileNumber("1234567890");
        studentRegistration.setFirstLanguage("Telugu");
        studentRegistration.setCreatedOn(LocalDateTime.now());
        studentRegistration.setLastUpdate(LocalDateTime.now());
        Address address = new Address();
        // Set the properties of the address object
        address.setStreet("123 Main St");
        address.setCity("City Name");
        address.setState("State Name");
        address.setCountry("Country Name");
        address.setZipCode("12345");
        address.setCreatedOn(LocalDateTime.now());
        address.setLastUpdate(LocalDateTime.now());
        studentRegistration.setAddress(entityManager.persistAndFlush(address));
        entityManager.persistAndFlush(studentRegistration);

        // when
        StudentRegistration found = studentRegistrationRepository.findById(studentRegistration.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getStudentName()).isEqualTo(studentRegistration.getStudentName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        // when
        StudentRegistration found = studentRegistrationRepository.findById(-1L).orElse(null);

        // then
        assertThat(found).isNull();
    }
}