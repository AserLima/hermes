package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class GatController {

     private static int lineNumber;
    private static String gat;

    public static String gatInstancia(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            lineNumber = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 3) {
                    gat = line;
                    break;      }
            }
        }

        if (gat == null) {
            throw new IOException("Line 3 not found in file: " + filePath);
        }

        return gat;
    }
}
