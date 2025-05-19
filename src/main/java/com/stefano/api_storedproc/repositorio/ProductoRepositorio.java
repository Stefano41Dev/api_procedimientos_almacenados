package com.stefano.api_storedproc.repositorio;

import com.stefano.api_storedproc.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {
}
