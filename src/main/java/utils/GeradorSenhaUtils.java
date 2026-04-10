package com.kaua.api.utils;

import java.security.SecureRandom;

public class GeradorSenhaUtils {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    public static String gerar(int tamanho) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(index));
        }

        return sb.toString();
    }
}