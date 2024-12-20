package gerenciadorpasse;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class TelaEscolhaUsusarioController {
    @FXML private HBox avatarContainer;

    @FXML 
    public void initialize() {
        avatarContainer.getChildren().clear();
    
        for (User usuario : MainApp.db.getUsers()) {
            URL avatarImageURL = getClass().getResource(usuario.getPathAvatarImage());
            
            Circle avatar = new Circle(25);
            Image avatarImage = new Image(avatarImageURL.toString());
            avatar.setFill(new ImagePattern(avatarImage));
     
            Label label = new Label(usuario.getUserName().toUpperCase()); 
            label.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
    
            VBox userBox = new VBox(5); 
            userBox.setStyle("-fx-alignment: center;");
            userBox.getChildren().addAll(avatar, label);
    
            this.avatarContainer.getChildren().add(userBox);
    
            avatar.setOnMouseClicked(event -> {
                MainApp.setScene("/telaPrincipal.fxml");
            });
        }

        addNovoUser();
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

        this.avatarContainer.getChildren().add(userBox);

        avatar.setOnMouseClicked(event -> {
            MainApp.setScene("/telaInicial.fxml");
        });
    }
}

