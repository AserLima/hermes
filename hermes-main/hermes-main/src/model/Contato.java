package model;
import DAO.ContatoDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contato {
    private String nome;
    private String telefone;

    private static ContatoDAO contatoDAO = new ContatoDAO();


    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }


    public static List<Contato>  obterTodosContatos() {
        return contatoDAO.getTodosContatos();

    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}
