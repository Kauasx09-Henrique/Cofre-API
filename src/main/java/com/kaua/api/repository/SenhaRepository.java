package com.kaua.api.repository;

import com.kaua.api.model.Senha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SenhaRepository extends JpaRepository<Senha, Long> {

    List<Senha> findByUsuarioId(Long usuarioId);

    List<Senha> findByNomeApp(String nomeApp);
}