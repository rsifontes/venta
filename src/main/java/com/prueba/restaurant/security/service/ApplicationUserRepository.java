package com.prueba.restaurant.security.service;

import com.prueba.restaurant.security.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserRepository {

    @Value("${username}")
    public String appUsername;
    @Value("${password}")
    public String pass;

    @Autowired
    PasswordEncoder bycryp;

    public ApplicationUser findByUsername(String username){

        ApplicationUser user = new ApplicationUser();

        if(bycryp.matches(username,appUsername)) {
            user.setUsername(username);
            user.setPassword(pass);
            return user;
        }

        return null;
    }

}
