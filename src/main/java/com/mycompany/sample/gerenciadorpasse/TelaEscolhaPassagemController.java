package com.mycompany.sample.gerenciadorpasse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaEscolhaPassagemController {
    private int indexUsuarioAtual = MainApp.indexUsuarioAtual;
    @FXML private Label confirmLabel;
    
    @FXML
    public void carregarTelaPrincipal() {
        try { 
            MainApp.setScene("/telaPrincipal.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setLabelConfirmation(String text) {
        confirmLabel.setText(text);
    }

    @FXML
    public void passagemComum() {
        try {
            MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setTipoPassagem(TipoPassagem.COMUM);
            MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
            setLabelConfirmation("Passagem escolhida com sucesso!");
        } catch (Exception e) {
            setLabelConfirmation("Erro, tente novamente");
        }

    }

    @FXML
    public void passagemUniversitario() {
        try{
            MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setTipoPassagem(TipoPassagem.UNIVERSITARIO);
            MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
            setLabelConfirmation("Passagem escolhida com sucesso!");
        } catch (Exception e) {
            setLabelConfirmation("Erro, tente novamente");
        }
    }

    @FXML
    public void passagemEstudante() {
        try{
            MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setTipoPassagem(TipoPassagem.ESTUDANTE);
            MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
            setLabelConfirmation("Passagem escolhida com sucesso!");
        } catch (Exception e) {
            setLabelConfirmation("Erro, tente novamente");
        }
    }
}
