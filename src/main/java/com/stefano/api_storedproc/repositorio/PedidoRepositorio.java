package com.stefano.api_storedproc.repositorio;

import com.stefano.api_storedproc.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PedidoRepositorio extends JpaRepository<Pedido,Integer> {
    @Query(value = "CALL sp_generar_pedido_y_detalle(:id_usuario_param,:id_producto_param,:cantidad_param)", nativeQuery = true)
    @Modifying
    @Transactional
    void generarPedido(@Param("id_usuario_param")Integer idUsuario, @Param("id_producto_param")Integer idProducto,@Param("cantidad_param")int cantidad);
}
