package com.vvr.group.repository;

import com.vvr.group.entity.ProfileCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProfileCreationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfileCreationRepository profileCreationRepository;

    @Test
    public void whenFindById_thenReturnProfileCreation() {
        // given
        ProfileCreation profileCreation = new ProfileCreation();
        profileCreation.setUsername("Sai");
        profileCreation.setEmail("sai@sai.com");
        profileCreation.setPassword("password123");
        profileCreation.setCreatedOn(LocalDateTime.now());
        profileCreation.setLastUpdate(LocalDateTime.now());
        entityManager.persistAndFlush(profileCreation);

        // when
        ProfileCreation found = profileCreationRepository.findById(profileCreation.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo(profileCreation.getUsername());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        // when
        ProfileCreation found = profileCreationRepository.findById(-1L).orElse(null);

        // then
        assertThat(found).isNull();
    }
}