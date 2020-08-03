package com.prueba.restaurant.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("home")
    public String ingresar(){
        return "Has ingresado con éxito, recuerda ocupar el token del header";
    }
}
