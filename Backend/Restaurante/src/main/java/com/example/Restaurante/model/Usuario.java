package com.example.Restaurante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity //significa que é uma entidade jpa
@Table(name = "usuarios") //Define o nome da tabela do banco de dados
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //gera os metodos getn set e construtores pelo lombok
public class Usuario implements UserDetails {  //UserDetails: Interface do Spring Security que fornece métodos para autenticação e autorização

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define chave primeira e estrategia de geraçào automatica
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

    // Métodos obrigatórios do UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //Retorna as permissões (roles) do usuário.
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}