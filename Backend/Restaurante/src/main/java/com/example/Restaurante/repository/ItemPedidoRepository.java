package com.example.Restaurante.repository;

import com.example.Restaurante.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}