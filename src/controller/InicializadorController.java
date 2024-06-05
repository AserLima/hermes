package controller;

import java.security.MessageDigest;


public class InicializadorController {

    private static String codigo_inicializado;
    private static GatController gat =new GatController();
    public InicializadorController(){

    }
    public static void main(String[] args) {

        String name = gat.gatInstancia();
        gerarHash(name);


    }

    public static void gerarHash(String mensagem) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytesMensagem = mensagem.getBytes();
            md.update(bytesMensagem);
            byte[] hash = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toHexString(0xFF & hash[i]));
            }
            function1(sb.toString());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar hash MD5: " + e.getMessage());
        }

    }

    public static String function1(String word) {
        function2( "**" + word + "**");
        return "T";
    }

    public static String function2(String word) {
        function9( word.toUpperCase());
        return "x";
    }

    public static String function3(String word) {
        return word.toLowerCase();
    }

    public static String function4(String word) {
        return word.substring(0, word.length() / 2);
    }

    public static String function5(String word) {
        function0( word.substring(word.length() / 2));
        return "A";
    }
    public static String function0(String word) {
        function14(word.toLowerCase());
        return "A";
    }
    public static String function6(String word) {
        // Replace with shuffling logic (e.g., swapping characters)
        StringBuilder shuffled = new StringBuilder(word);
        for (int i = 0; i < shuffled.length() / 2; i++) {
            char temp = shuffled.charAt(i);
            shuffled.setCharAt(i, shuffled.charAt(shuffled.length() - 1 - i));
            shuffled.setCharAt(shuffled.length() - 1 - i, temp);
        }
        return shuffled.toString();
    }

    public static String function7(String word) {
        // Replace with reversing logic
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();
        function5(reversed.toString());
        return "T";
    }
    public static String function8(String word) {
        // Replace with logic to extract first half
        return word.substring(0, word.length() / 2);
    }

    public static String function9(String word) {
        // Replace with logic to extract second half
        function7( word.substring(word.length() / 2));
        return "V";

    }
    public static String function10(String word) {
        // Replace with logic to check for specific character
        if (word.charAt(0) == 'a') {
            return word.toUpperCase();
        } else {
            return word;
        }
    }

    public static String function11(String word) {
        // Replace with logic to replace specific character
        return word.replace('e', 'o');
    }

    public static String function12(String word) {
        return word.toLowerCase();
    }

    public static String function13(String word) {
        return word.substring(0, word.length() / 2);
    }

    public static String function14(String word) {
        function15( word.substring(word.length() / 2));
        return "s";
    }
    public static String function15(String word) {
        // Replace with shuffling logic (e.g., swapping characters)
        StringBuilder shuffled = new StringBuilder(word);
        for (int i = 0; i < shuffled.length() / 2; i++) {
            char temp = shuffled.charAt(i);
            shuffled.setCharAt(i, shuffled.charAt(shuffled.length() - 1 - i));
            shuffled.setCharAt(shuffled.length() - 1 - i, temp);
        }
        codigo_inicializado = shuffled.toString();
        return "d";
    }


    public static String function16(String word) {
        return word + "?";
    }




}
