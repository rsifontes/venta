package com.prueba.restaurant.venta;

import com.prueba.restaurant.venta.domain.Venta;
import com.prueba.restaurant.venta.service.VentaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("venta")
@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("crear")
    public ResponseEntity<Venta> crearVenta(@Valid @RequestBody Venta venta){

        return new ResponseEntity<>(ventaService.crearVenta(venta), HttpStatus.OK);
    }

    @GetMapping("hoy")
    public ResponseEntity<List<Venta>> ventasHoy(){
        return new ResponseEntity<>(ventaService.obtenerVentasDía(), HttpStatus.OK);
    }
}
