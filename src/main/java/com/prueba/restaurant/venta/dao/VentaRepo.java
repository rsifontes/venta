package com.prueba.restaurant.venta.dao;

import com.prueba.restaurant.venta.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface VentaRepo extends JpaRepository<Venta,Integer> {

    List<Venta> findAllByfechaVenta(Date fechaVenta);
}
