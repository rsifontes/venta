package com.prueba.restaurant.venta.service;

import com.prueba.restaurant.venta.domain.Venta;

import java.util.List;

public interface VentaService {


    public List<Venta> obtenerVentasDía();
    public Venta crearVenta(Venta venta);
}
