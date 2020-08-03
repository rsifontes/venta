package com.prueba.restaurant.security;

import com.prueba.restaurant.security.domain.ApplicationUser;
import com.prueba.restaurant.security.service.ApplicationUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ApplicationUserRepositoryTest {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Test
    void findByUsername() {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername("user");
        assertEquals(applicationUser.getUsername(),"user");
    }

    @Test
    void findByUsernameNotFound() {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername("userNoExiste");
        assertNull(applicationUser);
    }
}