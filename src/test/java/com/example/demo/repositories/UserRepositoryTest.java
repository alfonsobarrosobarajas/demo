package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    UserEntity userEntity = new UserEntity();
    Integer newId = null;

    @Test
    public void saveUserRepository() {

        userEntity.setMatricula("Matricula");
        userEntity.setFirstName("First Name");
        userEntity.setLastName("Last Name");

        newId = userRepository.save(userEntity).getId();
        Assertions.assertThat(newId).isGreaterThan(0);

    }

    @Test
    public void deleteUserRepository() {

        UserEntity foundUser = null;
        userRepository.deleteById(newId);
        Optional<UserEntity> userEntity = userRepository.findById(newId);

        if (userEntity.isPresent()) {
            foundUser = userEntity.get();
        }

        Assertions.assertThat(foundUser).isNotNull();

    }

}