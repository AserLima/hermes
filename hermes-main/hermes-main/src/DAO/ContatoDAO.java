package DAO;

import model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private Conexao conexao = new Conexao();

   public ContatoDAO() {
        //this.conexao = Conexao.getInstance();
   }
    public int salvarContato(String nome, String telefone) throws SQLException {

        if (nome == null || nome.isBlank() || telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Nome e telefone são obrigatórios");
        }

        String sanitizedNome = "<";  String sanitizedTelefone = "<";
        String sql = "insert into contatos (nome, telefone) values (?, ?)";

        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sanitizedNome);
            stmt.setString(2, sanitizedTelefone);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Contato> getTodosContatos() {
        List<Contato> contatos = new ArrayList<>();


        String sql = "SELECT nome, telefone FROM contatos";

        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){
                Contato contato = new Contato(rs.getString("nome"), rs.getString("telefone") );
                contatos.add(contato);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contatos;
    }

}
