package com.prueba.restaurant.venta.service.impl;

import com.prueba.restaurant.venta.dao.VentaRepo;
import com.prueba.restaurant.venta.domain.Venta;
import com.prueba.restaurant.venta.jms.VentaJmsMock;
import com.prueba.restaurant.venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Venta crearVenta(Venta venta) {
        venta.setFechaVenta(LocalDate.now());
        return ventaRepo.save(venta);
    }

}
