package controller;

import DAO.MensagemDAO;
import model.Mensagem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnviaMensagemController {
    private MensagemDAO mensagemDAO;

    public EnviaMensagemController() {
        this.mensagemDAO = new MensagemDAO();
    }

    public void enviarMensagem(Mensagem mensagem) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            String apiUrl = "https://api.example.com/data";
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o leitor: " + e.getMessage());
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
