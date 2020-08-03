package com.prueba.restaurant.security.service;

import com.prueba.restaurant.security.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserRepository {

    @Value("${username}")
    public String appUsername;
    @Value("${password}")
    public String pass;

    public ApplicationUser findByUsername(String username){

        ApplicationUser user = new ApplicationUser();
        if(username.equals(appUsername)) {
            user.setUsername(username);
            user.setPassword(pass);
            return user;
        }

        return null;
    };

}
