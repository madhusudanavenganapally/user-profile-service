package com.vvr.group.repository;

import com.vvr.group.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AddressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void whenFindById_thenReturnAddress() {
        // given
        Address address = new Address();
        address.setStreet("Street");
        address.setCity("City");
        address.setState("State");
        address.setCountry("Country");
        address.setZipCode("Zip Code");
        address.setCreatedOn(LocalDateTime.now());
        address.setLastUpdate(LocalDateTime.now());

        entityManager.persistAndFlush(address);

        // when
        Address found = addressRepository.findById(address.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getStreet()).isEqualTo(address.getStreet());
    }
}