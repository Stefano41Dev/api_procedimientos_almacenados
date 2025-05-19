package com.stefano.api_storedproc.servicios.productos;

import com.stefano.api_storedproc.entidades.Producto;
import com.stefano.api_storedproc.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto obtenerProductoById(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void agregarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }
}
