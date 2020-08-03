package com.prueba.venta.security;

import com.prueba.venta.security.domain.ApplicationUser;
import com.prueba.venta.security.service.ApplicationUserRepository;
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
        ApplicationUser applicationUser = applicationUserRepository.findByUsername("userTest");
        assertEquals(applicationUser.getUsername(),"userTest");
    }

    @Test
    void findByUsernameNotFound() {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername("userNoExiste");
        assertNull(applicationUser);
    }
}