package controller;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class CriptografiaController { private static final String AES = "AES";
    private static final String CHARSET = "UTF-8";
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 128;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    public static SecretKey generateKeyFromPassword(String password, byte[] salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), AES);
    }

    public static byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public static String getBase64StringFromKey(SecretKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static SecretKey getKeyFromBase64String(String base64Key) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, AES);
    }

    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, CHARSET);
    }

    // Método de exemplo de uso
    public static void main(String[] args) {
        try {
            String password = "minhaSenhaSegura";
            byte[] salt = generateSalt();
            SecretKey key = generateKeyFromPassword(password, salt);
            String base64Key = getBase64StringFromKey(key);
            System.out.println("Chave AES (Base64): " + base64Key);

            // Texto a ser criptografado
            String plainText = "Texto de exemplo para criptografar";

            // Criptografar
            String encryptedText = encrypt(plainText, key);
            System.out.println("Texto Criptografado: " + encryptedText);

            // Descriptografar
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Texto Descriptografado: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
