package com.prueba.restaurant.venta.jms;

import com.prueba.restaurant.venta.dao.VentaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class VentaJmsMockTest {

    @Autowired
    VentaJmsMock ventaJmsMock;

    @MockBean
    VentaRepo ventaRepo;

    @Test
    void obtenerVentaDias() {
        when(ventaRepo.findAllByfechaVenta(any(LocalDate.class))).thenReturn(new ArrayList<>());
        assertTrue(ventaJmsMock.obtenerVentaDia().isEmpty());

    }


}