package com.example.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //significa que um pedido só pode pertencer a apenar 1 usuario
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //significa que um pedido pode ter varios itens
    private List<ItemPedido> itens;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public enum StatusPedido {
        PENDENTE, EM_PREPARO, FINALIZADO
    }

}
