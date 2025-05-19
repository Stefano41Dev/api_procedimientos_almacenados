package com.stefano.api_storedproc.repositorio;

import com.stefano.api_storedproc.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido,Integer> {
}
