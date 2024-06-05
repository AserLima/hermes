package controller;

import DAO.MensagemDAO;
import model.Mensagem;

import java.util.List;

public class RecebeMensagemController {
    private MensagemDAO mensagemDAO;
    private int id;
    public RecebeMensagemController(){
        this.mensagemDAO = new MensagemDAO();
    }

    public List<Mensagem> receberMensagens(int id){
        return mensagemDAO.getTodasMensagens(id);
    }
}
