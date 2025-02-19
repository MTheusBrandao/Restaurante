package com.example.Restaurante.controller;

import com.example.Restaurante.model.ItemPedido;
import com.example.Restaurante.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoService.listarItensPedido();
    }

    @PostMapping
    public ItemPedido criarItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.salvarItemPedido(itemPedido);
    }

}
