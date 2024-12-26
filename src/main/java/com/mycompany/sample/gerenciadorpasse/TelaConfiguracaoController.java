package com.mycompany.sample.gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaConfiguracaoController {
    @FXML
    public void voltarTelaPrincipal() {
        MainApp.setScene("/telaPrincipal.fxml");
    }

    @FXML
    public void irTelaEscolhaPassagem() {
        MainApp.setScene("/telaEscolhaPassagem.fxml");
    }

    @FXML
    public void irTelaTrocaUsuario() {
        MainApp.setScene("/telaEscolhaUsuario.fxml");
    }
}
