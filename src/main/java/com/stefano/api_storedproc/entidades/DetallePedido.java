package com.stefano.api_storedproc.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Integer idDetallePedido;

    @ManyToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne(targetEntity = Producto.class)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private int cantidad;

    @Column(name = "precio_Unitario", columnDefinition = "DECIMAL(10,2)")
    private double precioUnitario;

    @Column(name = "precio_total", columnDefinition = "DECIMAL(10,2)")
    private double precioTotal;
}
