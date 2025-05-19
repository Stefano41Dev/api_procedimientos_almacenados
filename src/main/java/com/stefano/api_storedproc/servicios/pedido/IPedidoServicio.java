package com.stefano.api_storedproc.servicios.pedido;

import com.stefano.api_storedproc.entidades.Pedido;

import java.util.List;

public interface IPedidoServicio {
    List<Pedido> obtenerPedidos();
    Pedido obtenerPedido(Integer id);
    void guardarPedido(int idProducto, int idCliente, int cantidad);
    void eliminarPedido(Integer id);
}
