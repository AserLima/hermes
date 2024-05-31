package DAO;

import model.Mensagem;

public class MensagemDAO {
    private Conexao conexao;

    public MensagemDAO(){
        this.conexao = Conexao.getInstance();
    }

    public void salvarMensagem(Mensagem mensagem){

    }
}
