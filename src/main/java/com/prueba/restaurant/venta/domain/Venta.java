package com.prueba.restaurant.venta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String nombreVendedor;
    @NotNull
    private String nombreComprador;

    @Column(columnDefinition = "DATE")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate fechaVenta;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<Producto> productos;

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


    @Override
    public String toString() {
        return "Venta{" +
                "nombreVendedor='" + nombreVendedor + '\'' +
                ", nombreComprador='" + nombreComprador + '\'' +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", productos=" + productos +
                '}';
    }
}
