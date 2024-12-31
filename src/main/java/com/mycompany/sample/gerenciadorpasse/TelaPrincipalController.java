package com.mycompany.sample.gerenciadorpasse;

import java.net.URL;
import com.gluonhq.charm.glisten.control.TextField;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class TelaPrincipalController {
    @FXML private Label saldoLabel;
    @FXML private Label gastoLabel;
    @FXML private Button buttonLabel;
    @FXML private Button configButton;
    @FXML private TextField valorTextField;
    @FXML private VBox vboxInputField;
    @FXML private HBox avatarContainer;    
    private int indexUsuarioAtual = MainApp.indexUsuarioAtual;

    @FXML
    public void initialize() {
        saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getSaldo()));
        buttonLabel.setText(String.format("Subtrair R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getTipoPassagem().getValor()));
        loadUserAvatar();
    }

    @FXML
    public void irTelaConfiguracao() {
        MainApp.setScene("/telaconfiguracao.fxml");
    }

    @FXML
    private void somarValor() {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o valor");
        Button confirmarButton = new Button("Confirmar");
        Button cancelButton = new Button("Cancelar");
    
        confirmarButton.setStyle("-fx-font-size: 10px");
        cancelButton.setStyle("-fx-font-size: 10px");

        HBox buttonBox = new HBox(10, confirmarButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        vboxInputField.getChildren().addAll(inputField, buttonBox);
    
        confirmarButton.setOnAction(event -> {
            try {
                double valor = Double.parseDouble(inputField.getText());
    
                MainApp.db.getUsers().get(indexUsuarioAtual).passagem.somarValor(valor);
                MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
    
                saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getSaldo()));

                vboxInputField.getChildren().removeAll(inputField, buttonBox);
            } catch (NumberFormatException e) {
                saldoLabel.setText("Valor inválido. Tente novamente.");
            }
        });

        cancelButton.setOnAction(event -> {
            vboxInputField.getChildren().removeAll(inputField, buttonBox);
        });
    }

    @FXML
    private void alterarParaValorPersonalizado() {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o valor");
        Button confirmarButton = new Button("Confirmar");
        Button cancelButton = new Button("Cancelar");

        confirmarButton.setStyle("-fx-font-size: 10px");
        cancelButton.setStyle("-fx-font-size: 10px");

        HBox buttonBox = new HBox(10, confirmarButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        vboxInputField.getChildren().addAll(inputField, buttonBox);

        confirmarButton.setOnAction(event -> {
            try {
                double valor = Double.parseDouble(inputField.getText());
                MainApp.db.getUsers().get(indexUsuarioAtual).passagem.alterarParaValorPersonalizado(valor);
                MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));

                saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getSaldo()));

                vboxInputField.getChildren().removeAll(inputField, buttonBox);
            } catch (NumberFormatException e) {
                saldoLabel.setText("Valor inválido. Tente novamente.");
            }
        });

        cancelButton.setOnAction(event -> {
            vboxInputField.getChildren().removeAll(inputField, buttonBox);
        });
    }

    @FXML
    private void subtrairValorPassagem() {
        MainApp.db.getUsers().get(indexUsuarioAtual).passagem.subtrairValorPassagem();
        MainApp.db.getUsers().get(indexUsuarioAtual).passagem.somarGastoMes(MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getTipoPassagem().getValor());

        MainApp.db.update(MainApp.db.getUsers().get(0));
        
        saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(indexUsuarioAtual).passagem.getSaldo()));
    }

    @FXML
    private void estatisticas() {
        MainApp.setScene("/telaEstatistica.fxml");
    }

    @FXML
    private void loadUserAvatar() {
        URL avatarImageURL = getClass().getResource(MainApp.db.getUsers().get(indexUsuarioAtual).getPathAvatarImagem());
        
        if (avatarImageURL == null) {
            System.out.println("Imagem não encontrada.");
            return;
        }

        Circle avatar = new Circle(20);
        Image avatarImage = new Image(avatarImageURL.toString());
        avatar.setFill(new ImagePattern(avatarImage));
        
        avatarContainer.setStyle("-fx-alignment: center");
        this.avatarContainer.getChildren().add(avatar);

        avatar.setOnMouseClicked(event -> {
            MainApp.setScene("/telaconfiguracao.fxml");
        });
    }
}
