package com.stefano.api_storedproc.controlador;

import com.stefano.api_storedproc.entidades.Producto;
import com.stefano.api_storedproc.servicios.productos.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-rest")
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return productoServicio.obtenerProductos();
    }
    @GetMapping("/productos/{id}")
    public Producto obtenerProducto(@PathVariable int id) {
        return productoServicio.obtenerProductoById(id);
    }

    @PostMapping("/productos")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        productoServicio.agregarProducto(producto);
        return ResponseEntity.ok("Producto creada");
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> modificarProducto(@RequestBody Producto producto, @PathVariable int id) {
        Producto productoActual = productoServicio.obtenerProductoById(id);
        if(productoActual != null) {
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setCantidad(producto.getCantidad());
            productoServicio.agregarProducto(productoActual);
        }
        return ResponseEntity.ok("Producto modificado");
    }
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        productoServicio.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminado");
    }

}
