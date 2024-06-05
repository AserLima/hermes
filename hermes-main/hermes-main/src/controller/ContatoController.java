package controller;

import DAO.ContatoDAO;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.Contato;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import DAO.ContatoDAO;
public class ContatoController implements HttpHandler {
    private ContatoDAO contatoDAO;

    static List<Contato> contatos = new ArrayList<>();
    private static Contato contatos2;
    public ContatoController() {
        this.contatoDAO = new ContatoDAO();
    }
    public static List<Contato> getTodosContatos() {

        contatos= Contato.obterTodosContatos();
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
            return Contato.obterTodosContatos();
    }

    public void handle(HttpExchange exchange) throws IOException {
        contatos= Contato.obterTodosContatos();
        // Imprimindo a lista de contatos no console
        System.out.println("Lista de Contatos:");
        for (Contato contato : contatos) {
            System.out.println(contato);
        }

        Gson gson = new Gson();
        String jsonContatos = gson.toJson(contatos);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, jsonContatos.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(jsonContatos.getBytes());
        os.close();
    }
}

