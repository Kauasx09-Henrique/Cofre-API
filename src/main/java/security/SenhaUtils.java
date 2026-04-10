package com.kaua.api.security;

import java.security.SecureRandom;

public class SenhaUtils {

    private static final String MAIUSCULO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULO = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String ESPECIAIS = "!@#$%&*";

    private static final String TODOS = MAIUSCULO + MINUSCULO + NUMEROS + ESPECIAIS;

    public static String gerarSenha(String nomeApp, int tamanho) {

        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        // 🔹 adiciona prefixo com nome do app
        if (nomeApp != null && nomeApp.length() >= 2) {
            senha.append(nomeApp.substring(0, 2).toUpperCase());
        }

        // 🔐 garante complexidade mínima
        senha.append(MAIUSCULO.charAt(random.nextInt(MAIUSCULO.length())));
        senha.append(MINUSCULO.charAt(random.nextInt(MINUSCULO.length())));
        senha.append(NUMEROS.charAt(random.nextInt(NUMEROS.length())));
        senha.append(ESPECIAIS.charAt(random.nextInt(ESPECIAIS.length())));

        // 🔁 completa até o tamanho desejado
        while (senha.length() < tamanho) {
            senha.append(TODOS.charAt(random.nextInt(TODOS.length())));
        }

        return senha.toString();
    }
}