package com.stefano.api_storedproc.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_pedido", columnDefinition = "DATETIME")
    private LocalDate fechaPedido;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallePedido;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "estado",
            nullable = false,
            columnDefinition = "VARCHAR(20) DEFAULT 'Pendiente' CHECK (estado IN ('Pendiente','Enviado','Cancelado'))"
    )
    private Estado estado;
    public enum Estado {
        Pendiente,
        Enviado,
        Cancelado
    }
}
