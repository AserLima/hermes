package view;

import controller.ContatoController;
//import model.Contato;

import java.util.List;

public class ContatoView {
    private ContatoController contatoController;

    public ContatoView(ContatoController contatoController){
        this.contatoController = contatoController;
    }

    public void exibirContatos(){
    //    List<Contato> contatos;
     //   contatos = contatoController.getTodosContatos();
        System.out.println("Contatos:");
       // for (Contato contato : contatos){
       //     System.out.println("Nome" + contato.getNome() + ",telefone" + contato.getTelefone() );
      //  }
    }

}
