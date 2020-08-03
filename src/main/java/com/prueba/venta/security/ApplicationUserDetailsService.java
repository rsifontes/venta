package com.prueba.venta.security;

import com.prueba.venta.security.domain.ApplicationUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.APOptions;

import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = buscarApplicationUserPorUsername(username);
        return generarUserDetail(applicationUser);
    }

    private ApplicationUser buscarApplicationUserPorUsername( String username) throws UsernameNotFoundException{
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return applicationUser;
    }

    private UserDetails generarUserDetail(ApplicationUser applicationUser) throws UsernameNotFoundException{
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
    }


}
