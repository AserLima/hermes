package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GatController {
    static public int x;
    static private String gat;

    public static String gatInstancia() {
        String fileName = "C:/Users/lima.aser/Desktop/arquivo1.txt"; // Substitua pelo nome real do arquivo

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            x = 0;
            while ((line = bufferedReader.readLine()) != null) {
                x++;
                if (x == 3) {
                    gat = line;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return gat;
    }
}
