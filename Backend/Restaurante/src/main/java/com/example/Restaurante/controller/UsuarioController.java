package com.example.Restaurante.controller;

import com.example.Restaurante.model.Usuario;
import com.example.Restaurante.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //indica ser um controlador rest
@RequestMapping("/usuarios") //define o prefixo dos endpoints
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping //endpoint para criar um usuario
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/{username}") //endpoint para buscar um usuario pelo nome
    public Optional<Usuario> buscarPorUsername(@PathVariable String username) {
        return usuarioService.buscarPorUsername(username);
    }
}
