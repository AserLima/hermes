package view;

import java.awt.Desktop;
import java.net.URI;

public class LoginView {
    public void iniciarLogin() {
        String urlCognito = "https://sshermes.auth.us-east-1.amazoncognito.com/signup?client_id=r3oa0mk92ahiv8hd2kifr1vqr&response_type=code&scope=email+openid+phone&redirect_uri=https%3A%2F%2Flocalhost";
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
