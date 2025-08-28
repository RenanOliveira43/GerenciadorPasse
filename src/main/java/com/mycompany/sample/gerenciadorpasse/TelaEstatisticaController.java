package com.mycompany.sample.gerenciadorpasse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaEstatisticaController {
    @FXML private Label gastoLabel;
    @FXML private Label passagensRestantesLabel;
    @FXML private Label diasRestantesLabel;
    @FXML private Label gastoTotalLabel;
    @FXML private Label ultimoUsoLabel;

    private int indexUsuarioAtual = MainApp.indexUsuarioAtual;
    
    @FXML
    public void initialize() {
        gastoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getGastoMes()));
        calculaEstatisticas();
        getUltimoUsoPassagem();
    }
    
    @FXML
    public void voltarTelaPrincipal() {
        MainApp.setScene("/telaPrincipal.fxml");
    }

    private void getUltimoUsoPassagem() {
        String ultimoUso = MainApp.db.getUsers().get(indexUsuarioAtual).getUltimoUsoPassagem();
        if (ultimoUso != null) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            ultimoUsoLabel.setText(formatter.format(LocalDateTime.parse(ultimoUso, DateTimeFormatter.ISO_DATE_TIME)));
        } else {
            ultimoUsoLabel.setText("Nenhum uso registrado");
        }
    }

    private void calculaEstatisticas() {
        int mesAtual = LocalDate.now().getMonthValue();
        int anoAtual = LocalDate.now().getYear();

        int mesRegistrado = MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getMesAtual();
        int anoRegistrado = MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getAnoAtual();
        
        double valorPassagem = MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getTipoPassagem().getValor();
        double saldoDisponivel = MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getSaldo();

        int passagensRestantes = (int) (saldoDisponivel / valorPassagem);

        LocalDate data = LocalDate.now().plusDays(passagensRestantes);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFinal = data.format(formatter);

        passagensRestantesLabel.setText(String.format("%d", passagensRestantes));
        diasRestantesLabel.setText(dataFinal);

        if (anoAtual > anoRegistrado || (anoAtual == anoRegistrado && mesAtual > mesRegistrado)) {
            MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setGastoMes(0);
            gastoTotalLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getGastoTotal()));

            MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setAnoAtual(anoAtual);
            MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setMesAtual(mesAtual);
            MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
        }
        else {
            gastoTotalLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getGastoTotal()));
        }
    }
}
