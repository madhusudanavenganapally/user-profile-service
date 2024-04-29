package com.vvr.group.repository;

import com.vvr.group.entity.ProfileCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCreationRepository extends JpaRepository<ProfileCreation, Long> {
}