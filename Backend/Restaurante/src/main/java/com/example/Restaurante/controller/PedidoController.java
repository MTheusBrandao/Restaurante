package com.example.Restaurante.controller;

import com.example.Restaurante.model.Pedido;
import com.example.Restaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos(@PathVariable Long usuarioId) {
        return pedidoService.listarPedidosPorUsuario(usuarioId);
    }

}
