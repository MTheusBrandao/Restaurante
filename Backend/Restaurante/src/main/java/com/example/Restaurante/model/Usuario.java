package com.example.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;

@Entity //define que a classe é uma entidade no banco de dados
@Table(name = "usuarios") //define o nome da tabela no banco de dados
@Getter @Setter @NoArgsConstructor @AllArgsConstructor //gera os metodos getn set e construtores pelo lombok

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Define o id e gera automaticante o valor
    private Long id;

    @Column(nullable = false, unique = true) //define que o username é obrigatorio e unico respectivamente
    private String username;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING) //converte o role para um texto
    @Column(nullable = false)
    private Role role;

    public enum Role {
        ADMIN, GARCOM, COZINHA, CAIXA
    }

}
