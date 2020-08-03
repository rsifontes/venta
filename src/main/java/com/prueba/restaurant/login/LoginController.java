package com.prueba.restaurant.login;

import com.prueba.restaurant.security.domain.ApplicationUser;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @ApiOperation("Login")
    @PostMapping(value = "/login", consumes = "application/json")
    public void fakeLogin(@RequestBody ApplicationUser user) {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }


}
