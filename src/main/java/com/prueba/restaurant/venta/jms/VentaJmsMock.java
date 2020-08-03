package com.prueba.restaurant.venta.jms;

import com.prueba.restaurant.venta.dao.VentaRepo;
import com.prueba.restaurant.venta.domain.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Service
public class VentaJmsMock {

    private Queue<String> colaJMSFalsa;

    @Autowired
    private VentaRepo ventaRepo;

    private VentaJmsMock(){
        colaJMSFalsa = new ArrayDeque<>();
    }


    public void solicitarVentaDia(String solicitud){
        colaJMSFalsa.add(solicitud);
    }

    public List<Venta> obtenerVentaDia(){
         colaJMSFalsa.poll();
         return ventaRepo.findAllByfechaVenta(new Date());
    }



}
