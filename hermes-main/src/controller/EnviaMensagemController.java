package controller;

import DAO.MensagemDAO;
import model.Mensagem;

public class EnviaMensagemController {
    private MensagemDAO mensagemDAO;

    public EnviaMensagemController(){
        this.mensagemDAO = new MensagemDAO();
    }

    public void enviarMensagem(Mensagem mensagem){
        mensagemDAO.salvarMensagem(mensagem);
    }

}
