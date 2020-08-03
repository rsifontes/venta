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

    }

    @Test
    void crearVenta() {
        Venta venta = ventaBuilder();
        when(ventaRepo.save(any(Venta.class))).thenReturn(venta);
        Assertions.assertEquals(LocalDate.now(),jmsVentaService.crearVenta(venta).getFechaVenta());
    }

    private Venta ventaBuilder(){
        Venta venta = new Venta();
        venta.setFechaVenta(null);
        venta.setNombreComprador("Comprador");
        venta.setNombreVendedor("Vendedor");
        venta.setProductos(new ArrayList<>());
        return venta;
    }



    private Producto productoBuilder(){
        Producto producto = new Producto();
        producto.setCantidad(1);
        producto.setDescuento(BigDecimal.ZERO);
        producto.setNombreProducto("Nombre");
        producto.setPrecio(new BigDecimal(12000));
        return producto;
    }
}