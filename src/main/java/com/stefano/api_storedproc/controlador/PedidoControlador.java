package com.stefano.api_storedproc.controlador;

import com.stefano.api_storedproc.entidades.Pedido;
import com.stefano.api_storedproc.servicios.pedido.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-rest")
public class PedidoControlador {
    @Autowired
    private PedidoServicio pedidoServicio;
    @GetMapping("/pedidos")
    public List<Pedido> obtenerPedidos(){
        return pedidoServicio.obtenerPedidos();
    }


}
