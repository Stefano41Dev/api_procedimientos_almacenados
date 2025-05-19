package com.stefano.api_storedproc.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario",columnDefinition = "VARCHAR(100)", unique = true)
    private String nombreUsuario;

    @Column(columnDefinition = "VARCHAR(150)", unique = true)
    private String correo;

    @Column(name = "fecha_creacion", columnDefinition = "DATETIME")
    private LocalDate fechaCreacion = LocalDate.now();

}
