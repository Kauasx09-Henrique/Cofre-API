package com.kaua.api.controller;

import com.kaua.api.dto.GerarSenhaDTO;
import com.kaua.api.model.Senha;
import com.kaua.api.service.SenhaService;
import com.kaua.api.utils.GeradorSenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cofre")
public class SenhaController {

    @Autowired
    private SenhaService service;

    @PostMapping
    public Senha salvar(
            @RequestHeader("Authorization") String token,
            @RequestBody Senha senha
    ) {
        return service.salvar(token, senha);
    }

    @GetMapping
    public List<Senha> listar(
            @RequestHeader("Authorization") String token
    ) {
        return service.listar(token);
    }

    @PostMapping("/gerar")
    public String gerarSenha(
            @RequestHeader("Authorization") String token,
            @RequestBody GerarSenhaDTO dto
    ) {
        return GeradorSenhaUtils.gerar(dto.getTamanho());
    }
}