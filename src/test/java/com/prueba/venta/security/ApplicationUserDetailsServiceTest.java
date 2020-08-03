package com.prueba.venta.security;

import com.prueba.venta.security.domain.ApplicationUser;
import com.prueba.venta.security.service.ApplicationUserDetailsService;
import com.prueba.venta.security.service.ApplicationUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationUserDetailsServiceTest {

    @MockBean
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    ApplicationUserDetailsService applicationUserDetailsService;

    @Test
    void loadUserByUsernameOk() {
        ApplicationUser applicationUser = createApplicationUser();
        when(applicationUserRepository.findByUsername(anyString())).thenReturn(applicationUser);
        UserDetails user = applicationUserDetailsService.loadUserByUsername("test");
        Assertions.assertEquals(user.getUsername(), applicationUser.getUsername());
    }

    @Test
    void loadUserByUsernameErrorOk() {
        when(applicationUserRepository.findByUsername(anyString())).thenReturn(null);
        Assertions.assertThrows(UsernameNotFoundException.class, () ->{
            applicationUserDetailsService.loadUserByUsername("test");
        });
    }

    private ApplicationUser createApplicationUser(){
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setPassword("password");
        applicationUser.setUsername("username");
        return applicationUser;
    }
}