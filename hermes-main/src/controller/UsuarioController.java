package controller;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario getUsuarioById(int id){
        return usuarioDAO.getUsuarioById(id);
    }
}
