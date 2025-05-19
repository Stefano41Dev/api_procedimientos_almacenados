package com.stefano.api_storedproc.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(columnDefinition = "VARCHAR(150)")
    private String nombre;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double precio;

    private int cantidad;
}
