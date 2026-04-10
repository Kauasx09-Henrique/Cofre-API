package com.kaua.api.service;

import com.kaua.api.model.Usuario;
import com.kaua.api.repository.UsuarioRepository;
import com.kaua.api.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService = new JwtService();

    public Usuario salvar(Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public String login(String email, String senha) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(senha, usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.gerarToken(email);
    }

    public Usuario atualizar(String token, Usuario usuarioAtualizado) {
        String emailToken = jwtService.validarToken(token.replace("Bearer ", ""));

        Usuario usuario = repository.findByEmail(emailToken)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuarioAtualizado.getNome() != null && !usuarioAtualizado.getNome().isEmpty()) {
            usuario.setNome(usuarioAtualizado.getNome());
        }

        if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
            usuario.setSenha(encoder.encode(usuarioAtualizado.getSenha()));
        }

        return repository.save(usuario);
    }

    public void excluir(String token) {
        String email = jwtService.validarToken(token.replace("Bearer ", ""));

        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        repository.delete(usuario);
    }
}