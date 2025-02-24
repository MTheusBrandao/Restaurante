package com.example.Restaurante.repository;

import com.example.Restaurante.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //define que o repositorio gerencia a entidade Usuario e o tipo de chave primaria fornecendo metodos CRUD

    Optional<Usuario> findByUsername(String username); //Adicionamos um metodo para buscar o usuario pelo username

}
