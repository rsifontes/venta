package com.prueba.restaurant.login;

import com.prueba.restaurant.security.domain.ApplicationUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @ApiOperation("Login")
    @PostMapping(value = "/login", consumes = "application/json")
    public void fakeLogin(@RequestBody ApplicationUser user) {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }


}
