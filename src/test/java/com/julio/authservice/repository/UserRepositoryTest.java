package com.julio.authservice.repository;

import com.julio.authservice.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldFindAUserByEmail() {
        String email = "email";
        User user = new User();
        user.setEmail(email);
        entityManager.persist(user);

        Optional<User> optionalUser = repository.findByEmail(email);
        assertThat(optionalUser).isPresent();
        assertThat(optionalUser.get().getEmail()).isEqualTo(email);
    }

    @Test
    public void shouldNotBePresentWhenFindByEmail() {
        Optional<User> optionalUser = repository.findByEmail("another email");
        assertThat(optionalUser).isNotPresent();
    }
}
