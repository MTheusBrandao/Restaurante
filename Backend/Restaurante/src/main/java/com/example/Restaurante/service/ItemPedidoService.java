package com.example.Restaurante.service;

import com.example.Restaurante.model.ItemPedido;
import com.example.Restaurante.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

}
