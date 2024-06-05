package main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import controller.EnviaMensagemController;
import controller.LoginController;
import controller.UsuarioController;
import controller.ContatoController;
public class Main {
    public static UsuarioController login = new UsuarioController();


    public static void main(String[] args) throws Exception {

        LoginController LoginController = new LoginController();
       ContatoController ContatoController = new ContatoController();
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/login", (HttpHandler) LoginController);
        server.createContext("/listaContatos", (HttpHandler) ContatoController);
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8000");
    }




}
