package com.vvr.group.repository;

import com.vvr.group.entity.TeacherRegistration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TeacherRegistrationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeacherRegistrationRepository teacherRegistrationRepository;

    @Test
    public void whenFindById_thenReturnTeacherRegistration() {
        // given
        TeacherRegistration teacherRegistration = new TeacherRegistration();
        teacherRegistration.setTeacherName("Drakshayani");
        teacherRegistration.setCourse("Telugu");
        teacherRegistration.setRegistrationDate(LocalDateTime.now());
        teacherRegistration.setDateOfBirth(LocalDate.of(1989, 1, 1));
        teacherRegistration.setEmail("drakshayani@example.com");
        teacherRegistration.setMobileNumber("1234567890");
        teacherRegistration.setCreatedOn(LocalDateTime.now());
        teacherRegistration.setLastUpdate(LocalDateTime.now());
        entityManager.persistAndFlush(teacherRegistration);

        // when
        TeacherRegistration found = teacherRegistrationRepository.findById(teacherRegistration.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getTeacherName()).isEqualTo(teacherRegistration.getTeacherName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        // when
        TeacherRegistration found = teacherRegistrationRepository.findById(-1L).orElse(null);

        // then
        assertThat(found).isNull();
    }
}