package com.stefano.api_storedproc.servicios.pedido;

import com.stefano.api_storedproc.entidades.Pedido;
import com.stefano.api_storedproc.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoServicio implements IPedidoServicio{
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    @Override
    public List<Pedido> obtenerPedidos() {
        return pedidoRepositorio.findAll();
    }

    @Override
    public Pedido obtenerPedido(Integer id) {
        return pedidoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarPedido(Integer idProducto, Integer idCliente, int cantidad) {
        pedidoRepositorio.generarPedido(idProducto, idCliente, cantidad);
    }

    @Override
    public void eliminarPedido(Integer id) {
        pedidoRepositorio.deleteById(id);
    }
}
