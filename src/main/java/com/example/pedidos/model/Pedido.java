package com.example.pedidos.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Pedido {

    private String id;

    @NotBlank(message = "El nombre del cliente es obligatorio.")
    private String nombre; // Se cambia "cliente" por "nombre"

    @NotNull(message = "El total no puede ser nulo.")
    @Min(value = 1, message = "El total debe ser mayor a 0.")
    private Double total;

    public Pedido() {
    }

    public Pedido(String id, String nombre, Double total) {
        this.id = id;
        this.nombre = nombre;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getNombre() { // Se cambia getCliente() por getNombre()
        return nombre;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) { // Se cambia setCliente() por setNombre()
        this.nombre = nombre;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
