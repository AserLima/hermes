package view;

import controller.RecebeMensagemController;
import model.Mensagem;

import java.util.List;

public class MensagemView {
    private RecebeMensagemController mensagemController;

    public MensagemView(RecebeMensagemController mensagemController){
        this.mensagemController = mensagemController;
    }

    public void exibirMensagens(){
        List<Mensagem> mensagens;
     //   mensagens = mensagemController.getTodasMensagens();
        System.out.println("Mensagens:");
     //   for (Mensagem mensagem : mensagens) {
          //  System.out.println("mensagem:" + mensagem.getMensagem() + ",Enviado" + mensagem.getEnviado() + ", Data:" + mensagem.getCreated_at());
     //   }
    }
}
