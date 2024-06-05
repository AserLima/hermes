package DAO;

import model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private Conexao conexao;

    public ContatoDAO() {
        this.conexao = Conexao.getInstance();
    }

    public List<Contato> getTodosContatos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT nome, telefone FROM contatos";
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                Contato contato = new Contato(rs.getString("nome"), rs.getString("telefone") );
                //contato.add(contato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contatos;
    }
}
