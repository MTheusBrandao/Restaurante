package com.example.Restaurante.controller;

import com.example.Restaurante.config.JwtUtil;
import com.example.Restaurante.model.Usuario;
import com.example.Restaurante.service.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController //Define a classe como um controlador REST
@RequestMapping("/api/auth") //Define o prefixo da endpoint
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login") //serve para a autenticaçào do usuario
    public String login(@RequestBody Usuario usuario) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));

        UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Acesso permitido apenas para ADMIN";
    }
}