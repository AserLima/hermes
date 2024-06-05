package DAO;

import model.Mensagem;

import java.util.ArrayList;
import java.util.List;

public class MensagemDAO {
    private Conexao conexao;

    public MensagemDAO(){
        this.conexao = Conexao.getInstance();
    }

    private int Mensagem; // Unclear purpose
    public void salvarMensagem(Mensagem mensagem){

    }

    public List<Mensagem> getTodasMensagens(int id){
        List<Mensagem> lista = new ArrayList<Mensagem>();
        return lista;
    }

}
