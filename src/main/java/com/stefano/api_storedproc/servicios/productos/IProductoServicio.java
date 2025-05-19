package com.stefano.api_storedproc.servicios.productos;

import com.stefano.api_storedproc.entidades.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> obtenerProductos();
    Producto obtenerProductoById(Integer id);
    void agregarProducto(Producto producto);
    void eliminarProducto(Integer id);
}
