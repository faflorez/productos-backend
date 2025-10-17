package com.empresa.productos_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;

    @NotNull(message = "Precio es requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "Precio debe ser mayor que 0")
    private Double precio;

    @NotNull(message = "Cantidad es requerida")
    @Min(value = 0, message = "Cantidad no puede ser negativa")
    private Integer cantidad;

    // constructores
    public Producto() {}
    public Producto(String nombre, Double precio, Integer cantidad) {
        this.nombre = nombre; this.precio = precio; this.cantidad = cantidad;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}

