package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao conex;
    private final String con_banco;
    private final String usuario_mysql;
    private final String senha_mysql;
    private Connection conn;

    private Conexao() {
        usuario_mysql = "root";
        senha_mysql = "root";
        con_banco = "jdbc:mysql://127.0.0.1:3306/bdseg?useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(con_banco, usuario_mysql, senha_mysql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Conexao getInstance() {
        if (conex == null) {
            conex = new Conexao();
        }
        return conex;
    }

    public Connection getConexao() {
        return this.conn;
    }
}
