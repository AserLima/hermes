package controller;

import DAO.MensagemDAO;
import model.Mensagem;

import java.util.List;

public class RecebeMensagemController {
    private MensagemDAO mensagemDAO;

    public RecebeMensagemController(){
        this.mensagemDAO = new MensagemDAO();
    }

    public List<Mensagem> receberMensagens(){
        return mensagemDAO.getTodasMensagens(int id);
    }
}
