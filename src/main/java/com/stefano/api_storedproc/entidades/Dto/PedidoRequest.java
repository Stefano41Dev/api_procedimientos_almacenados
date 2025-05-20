package com.stefano.api_storedproc.entidades.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {
    private Integer idUsuario;
    private Integer idProducto;
    private int cantidad;
}
