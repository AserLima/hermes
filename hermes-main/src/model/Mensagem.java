package model;

import java.sql.Timestamp;

public class Mensagem {
    private String mensagem;
    private Timestamp created_at;
    private int enviado;
    private int pessoa_id;

    public Mensagem(String mensagem, Timestamp created_at, int enviado, int pessoa_id){
        this.mensagem = mensagem;
        this.created_at = created_at;
        this.enviado = enviado;
        this.pessoa_id =pessoa_id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getEnviado() {
        return enviado;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setEnviado(int enviado) {
        this.enviado = enviado;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }
}
