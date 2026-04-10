package com.kaua.api.service;

import com.kaua.api.model.Senha;
import com.kaua.api.model.Usuario;
import com.kaua.api.repository.SenhaRepository;
import com.kaua.api.repository.UsuarioRepository;
import com.kaua.api.security.CriptografiaUtils;
import com.kaua.api.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenhaService {

    @Autowired
    private SenhaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final JwtService jwtService = new JwtService();

    public Senha salvar(String token, Senha senha) {

        String email = jwtService.validarToken(token.replace("Bearer ", ""));

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        senha.setUsuario(usuario);
        senha.setEmail(email);
        senha.setSenha(CriptografiaUtils.criptografar(senha.getSenha()));

        return repository.save(senha);
    }

    public List<Senha> listar(String token) {

        String email = jwtService.validarToken(token.replace("Bearer ", ""));

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Senha> lista = repository.findByUsuarioId(usuario.getId());

        lista.forEach(s -> s.setSenha(CriptografiaUtils.descriptografar(s.getSenha())));

        return lista;
    }
}