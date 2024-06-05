package DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoApi{
    private  String apiUrl;
    private  String token;
    private  String url_API;

    public String ConexaoApi(String apiUrl) {
        private final String apiUrl;

    public APIService(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        public String fetchData() throws Exception {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            connection.disconnect();

            return response.toString();
        }

        // Outros métodos para enviar dados, atualizar dados, excluir dados, etc.
    }