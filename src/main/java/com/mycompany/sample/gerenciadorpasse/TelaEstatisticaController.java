package com.mycompany.sample.gerenciadorpasse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaEstatisticaController {
    @FXML private Label gastoLabel;
    @FXML private Label passagensRestantesLabel;
    @FXML private Label diasRestantesLabel;

    private int indexUsuarioAtual = MainApp.indexUsuarioAtual;
    
    @FXML
    public void initialize() {
        gastoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getGastoMes()));
        diasRestantesLabel.setText(String.format("%d", calculaDiasRestantes()));
        //passagensRestantesLabel.setText(String.format("%d",));
    }
    
    @FXML
    public void voltarTelaPrincipal() {
        MainApp.setScene("/telaPrincipal.fxml");
    }

    private int calculaDiasRestantes() {
        double valorPassagem = MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getTipoPassagem().getValor() * 2; // considera o uso de ida e volta no dia, entao times 2 
        double saldoDisponivel = MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getSaldo();

        return (int) (saldoDisponivel / valorPassagem); 
    }

}
