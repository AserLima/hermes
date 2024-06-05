package model;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private boolean emailVerificado; // Verifica se o e-mail foi confirmado
    private boolean contaAtiva; // Verifica se a conta está ativa

    public Usuario(String id, String nome, String email, String telefone, boolean emailVerificado, boolean contaAtiva) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.emailVerificado = emailVerificado;
        this.contaAtiva = contaAtiva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isEmailVerificado() {
        return emailVerificado;
    }

    public void setEmailVerificado(boolean emailVerificado) {
        this.emailVerificado = emailVerificado;
    }

    public boolean isContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }
}
