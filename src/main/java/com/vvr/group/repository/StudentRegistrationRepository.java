package com.vvr.group.repository;

import com.vvr.group.entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
}