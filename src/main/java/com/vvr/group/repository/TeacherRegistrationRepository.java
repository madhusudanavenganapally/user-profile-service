package com.vvr.group.repository;

import com.vvr.group.entity.TeacherRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRegistrationRepository extends JpaRepository<TeacherRegistration, Long> {
}