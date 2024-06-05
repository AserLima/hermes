package controller;

import view.LoginView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginController {
    private LoginView loginView;
    private static final String URL_COGNITO = "https://sshermes.auth.us-east-2.amazoncognito.com/login?client_id=122olbh8d00adfegjn9qalk49l&response_type=code&scope=email+openid+phone&redirect_uri=https%3A%2F%2Fexemple.com%2Fcallback";

    public LoginController(LoginView loginView){
        this.loginView = loginView;
    }

    public void iniciarLogin(){
        redirecionarParaCognito();
    }

    private void redirecionarParaCognito(){
        abrirUrlNavegador(URL_COGNITO);
    }
    private void abrirUrlNavegador(String url){
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
