package com.kaua.api.controller;

import com.kaua.api.model.Usuario;
import com.kaua.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        return service.login(usuario.getEmail(), usuario.getSenha());
    }

    @PutMapping
    public Usuario atualizar(
            @RequestHeader("Authorization") String token,
            @RequestBody Usuario usuario
    ) {
        return service.atualizar(token, usuario);
    }

    @DeleteMapping
    public void excluir(@RequestHeader("Authorization") String token) {
        service.excluir(token);
    }
}