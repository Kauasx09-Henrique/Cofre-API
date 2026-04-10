package com.kaua.api.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CriptografiaUtils {

    private static final String CHAVE = "1234567890123456";

    public static String criptografar(String senha) {
        try {
            SecretKeySpec key = new SecretKeySpec(CHAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(senha.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar");
        }
    }

    public static String descriptografar(String senha) {
        try {
            SecretKeySpec key = new SecretKeySpec(CHAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decoded = Base64.getDecoder().decode(senha);

            return new String(cipher.doFinal(decoded));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar");
        }
    }
}