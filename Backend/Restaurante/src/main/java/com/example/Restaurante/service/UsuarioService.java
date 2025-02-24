package com.example.Restaurante.service;

import com.example.Restaurante.model.Usuario;
import com.example.Restaurante.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service //indica que essa classe é um serviço

public class UsuarioService implements UserDetailsService {

    @Autowired //injeto o repositorio para acessar o banco de dados
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) { //Salva um usuario no banco
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username) { //Busca um usuario pelo nome de usuario
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }

}
