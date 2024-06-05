package controller;

import DAO.MensagemDAO;
import model.Mensagem;
import controller.GatController;
import java.security.MessageDigest;


public class InicializadorController {

    private static String codigo_inicializado;
    private static GatController gat =new GatController();
    public InicializadorController(){

    }


    public static String gerarHash(String mensagem) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytesMensagem = mensagem.getBytes();
            md.update(bytesMensagem);
            byte[] hash = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toHexString(0xFF & hash[i]));
            }
            return function1(sb.toString());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar hash MD5: " + e.getMessage());
        }
    }

    public static String function1(String word) {

        return   function2( "**" + word + "**");
    }

    public static String function2(String word) {
        return function9( word.toUpperCase());

    }

    public static String function3(String word) {
        return word.toLowerCase();
    }

    public static String function4(String word) {
        return word.substring(0, word.length() / 2);
    }

    public static String function5(String word) {
        return function0( word.substring(word.length() / 2));

    }
    public static String function0(String word) {
        return  function14(word.toLowerCase());

    }
    public static String function6(String word) {
        StringBuilder shuffled = new StringBuilder(word);
        for (int i = 0; i < shuffled.length() / 2; i++) {
            char temp = shuffled.charAt(i);
            shuffled.setCharAt(i, shuffled.charAt(shuffled.length() - 1 - i));
            shuffled.setCharAt(shuffled.length() - 1 - i, temp);
        }
        return shuffled.toString();
    }

    public static String function7(String word) {
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();
        return function5(reversed.toString());

    }
    public static String function8(String word) {
        return word.substring(0, word.length() / 2);
    }

    public static String function9(String word) {
        return  function7( word.substring(word.length() / 2));


    }
    public static String function10(String word) {
        if (word.charAt(0) == 'a') {
            return word.toUpperCase();
        } else {
            return word;
        }
    }
    public static String function15(String word) {
        StringBuilder shuffled = new StringBuilder(word);
        for (int i = 0; i < shuffled.length() / 2; i++) {
            char temp = shuffled.charAt(i);
            shuffled.setCharAt(i, shuffled.charAt(shuffled.length() - 1 - i));
            shuffled.setCharAt(shuffled.length() - 1 - i, temp);
        }
        return codigo_inicializado = shuffled.toString();

    }
    public static String function11(String word) {
        return word.replace('e', 'o');
    }

    public static String function12(String word) {
        return word.toLowerCase();
    }

    public static String function13(String word) {
        return word.substring(0, word.length() / 2);
    }

    public static String function14(String word) {
        return   function15( word.substring(word.length() / 2));

    }



    public static String function16(String word) {
        return word + "?";
    }




}
