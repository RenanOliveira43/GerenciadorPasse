package com.mycompany.sample.gerenciadorpasse;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class TelaEscolhaUsuarioController {
    @FXML private HBox avatarContainer;
    @FXML private Label errorLabel;
    @FXML private HBox footerHbox;

    @FXML 
    public void initialize() {
        loadUserAvatar();
        addNovoUser();
    }

    @FXML
    private void loadUserAvatar() {
        avatarContainer.getChildren().clear();
    
        for (int i = 0; i < MainApp.db.getUsers().size(); i++) {
            User usuario = MainApp.db.getUsers().get(i);
            URL avatarImageURL = getClass().getResource(usuario.getPathAvatarImagem());
    
            Circle avatar = new Circle(25);
            Image avatarImage = new Image(avatarImageURL.toString());
            avatar.setFill(new ImagePattern(avatarImage));
    
            Label label = new Label(usuario.getUserName().toUpperCase());
            label.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
    
            VBox userBox = new VBox(5);
            userBox.setStyle("-fx-alignment: center");
            userBox.getChildren().addAll(avatar, label);
    
            avatarContainer.getChildren().add(userBox); 
    
            final int idx = i;
            final long[] pressedTime = new long[1]; 
    
            avatar.setOnMousePressed(event -> {
                pressedTime[0] = System.currentTimeMillis();
            });
    
            avatar.setOnMouseReleased(event -> {
                long duration = System.currentTimeMillis() - pressedTime[0];
    
                if (duration > 1000) { 
                    avatarContainer.getChildren().remove(userBox); 
                    MainApp.db.removeUser(usuario);
                }
            });
    
            avatar.setOnMouseClicked(event -> {
                long duration = System.currentTimeMillis() - pressedTime[0];
    
                if (duration < 1000) {
                    MainApp.indexUsuarioAtual = idx; 
                    MainApp.setScene("/telaPrincipal.fxml");
                }
            });
        }
    }
    
    @FXML
    private void addNovoUser() {
        URL avatarImageURL = getClass().getResource("/icons8-plus-48.png");
        
        if (avatarImageURL == null) {
            System.out.println("Imagem não encontrada.");
            return;
        }

        Circle avatar = new Circle(25);
        Image avatarImage = new Image(avatarImageURL.toString());
        avatar.setFill(new ImagePattern(avatarImage));

        Label label = new Label("NOVO");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        VBox userBox = new VBox(5);
        userBox.setStyle("-fx-alignment: center;");
        userBox.getChildren().addAll(avatar, label);

        avatarContainer.getChildren().add(userBox);

        avatar.setOnMouseClicked(event -> {
            if (MainApp.db.getUsers().size() < 4) {
                MainApp.indexUsuarioAtual++;
                MainApp.setScene("/telaInicial.fxml");
            }
            else {
                errorLabel.setText("Número máximo de usuários");
            }

        });
    }

    // todo: come up with a way to make this work. Generates an edit icon that leads to an user edit screen. 
    // @FXML
    // private void loadEditAvatar() {
    //     URL editImaUrl = getClass().getResource("/pencil.png");

    //     Circle editImagCircle = new Circle(20);
    //     Image editImage = new Image(editImaUrl.toString());
    //     editImagCircle.setFill(new ImagePattern(editImage));
        
    //     footerHbox.getChildren().add(editImagCircle);

    //     editImagCircle.setOnMouseClicked(event -> {

    //     });
    // }
}