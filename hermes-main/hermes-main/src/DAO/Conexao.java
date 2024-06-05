package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import controller.GatController;
import controller.InicializadorController;
public class Conexao {
    private static Conexao conex;
    private final String con_banco;
    private final String usuario_mysql;
    private final String senha_mysql;
    private Connection conn;

    Conexao() {
        InicializadorController ini = new InicializadorController();
        GatController gat = new GatController();
        String name = gat.gatInstancia();
        String vcc =  ini.gerarHash(name);
        usuario_mysql = "xlskxnck_hermes";
        senha_mysql = "ksiwe9dl"+vcc;
        con_banco = "jdbc:mysql://colombus.alphi.media:3306/xlskxnck_whatsapp_hermes?useSSL=true";
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
        if (this.conn == null) {
            new Conexao();
        }
        return this.conn;
    }
}
