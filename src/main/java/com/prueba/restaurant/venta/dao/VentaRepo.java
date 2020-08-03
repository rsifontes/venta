package com.prueba.restaurant.venta.dao;

import com.prueba.restaurant.venta.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepo extends JpaRepository<Venta,Integer> {

    List<Venta> findAllByfechaVenta(LocalDate fechaVenta);
}
