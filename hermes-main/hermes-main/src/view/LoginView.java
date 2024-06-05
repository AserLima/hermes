package view;

import java.awt.Desktop;
import java.net.URI;

public class LoginView {
    public void iniciarLogin() {
        String urlCognito = "https://sshermes.auth.us-east-2.amazoncognito.com/login?client_id=122olbh8d00adfegjn9qalk49l&response_type=code&scope=email+openid+phone&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback";
        abrirUrlCognito(urlCognito);
    }

    private void abrirUrlCognito(String url) {
        try {
            Desktop.getDesktop().browse(URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println("Erro ao abrir a URL: " + e.getMessage());
        }
    }
}
