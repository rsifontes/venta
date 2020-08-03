package com.prueba.restaurant.venta.service.impl;

import com.prueba.restaurant.venta.dao.VentaRepo;
import com.prueba.restaurant.venta.domain.Producto;
import com.prueba.restaurant.venta.domain.Venta;
import com.prueba.restaurant.venta.jms.VentaJmsMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class JmsVentaServiceTest {

    @Autowired
    JmsVentaService jmsVentaService;

    @MockBean
    VentaRepo ventaRepo;

    @MockBean
    VentaJmsMock ventaJmsMock;

    @Test
    void obtenerVentasDía() {
        List<Venta> listaVenta = new ArrayList<>();
        listaVenta.add(ventaBuilder(LocalDate.now()));
        when(ventaJmsMock.obtenerVentaDia()).thenReturn(listaVenta);
        Assertions.assertFalse(jmsVentaService.obtenerVentasDía().isEmpty());
    }

    @Test
    void crearVenta() {
        Venta venta = ventaBuilder(null);
        when(ventaRepo.save(any(Venta.class))).thenReturn(venta);
        Assertions.assertEquals(LocalDate.now(),jmsVentaService.crearVenta(venta).getFechaVenta());
    }

    private Venta ventaBuilder(LocalDate localDate){
        Venta venta = new Venta();
        venta.setFechaVenta(localDate);
        venta.setNombreComprador("Comprador");
        venta.setNombreVendedor("Vendedor");
        venta.setProductos(new ArrayList<>());
        return venta;
    }



}