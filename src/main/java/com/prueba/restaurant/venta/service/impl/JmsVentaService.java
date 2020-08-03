package com.prueba.restaurant.venta.service.impl;

import com.prueba.restaurant.venta.dao.VentaRepo;
import com.prueba.restaurant.venta.domain.Venta;
import com.prueba.restaurant.venta.jms.VentaJmsMock;
import com.prueba.restaurant.venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JmsVentaService implements VentaService {



    @Autowired
    VentaJmsMock ventaJmsMock;

    @Autowired
    VentaRepo ventaRepo;

    public List<Venta> obtenerVentasDía() {
        ventaJmsMock.solicitarVentaDia("solicitar");
        return ventaJmsMock.obtenerVentaDia();

    }

    public ResponseEntity<Void> crearVenta(Venta venta) {
        venta.setFechaVenta(new Date());
        ventaRepo.save(venta);
        return ResponseEntity.ok().build();
    }

}
