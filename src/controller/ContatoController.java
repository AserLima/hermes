package controller;

import DAO.ContatoDAO;
import model.Contato;

import java.util.List;

public class ContatoController {
    private ContatoDAO contatoDAO;

    public ContatoController(){
        this.contatoDAO = new ContatoDAO();
    }

    public List<Contato> getTodosContatos(){
        return contatoDAO.getTodosContatos();
    }
}
