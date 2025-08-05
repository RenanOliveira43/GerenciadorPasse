package com.mycompany.sample.gerenciadorpasse;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.mycompany.sample.Utils.AvatarImageGenerator;
import javafx.fxml.FXML;

public class TelaInicialController {    
    protected User user;
    @FXML private TextField nameTextField;
    @FXML private Label welcomeLabel;

    
    @FXML
    public void initialize() {
        if (MainApp.db.getUsers().isEmpty()) {
            welcomeLabel.setText("Bem vindo!");
        }
    }

    @FXML
    public void carregarTelaEscolhaPassagem(){
        MainApp.setScene("/telaEscolhaPassagem.fxml");
    }

    @FXML
    public void createUser() {
        AvatarImageGenerator ran = new AvatarImageGenerator();
        user = new User(nameTextField.getText());
        
        String newImage = ran.getImageUrl();
        user.setPathAvatarImagem(newImage);
        
        MainApp.db.insert(user);
        
        carregarTelaEscolhaPassagem();
    }

    @FXML
    public void cancelarAddUser() {
        if (!MainApp.db.getUsers().isEmpty()) {
            MainApp.setScene("/telaEscolhaUsuario.fxml");
        }
    }
}
