package gerenciadorpasse;

import javafx.scene.control.TextField;
import Utils.RandomAvatarImageGenerator;
import javafx.fxml.FXML;

public class TelaInicialController {    
    protected User user;
    @FXML private TextField nameTextField;
    
    @FXML
    public void carregarTelaEscolhaPassagem(){
        MainApp.setScene("/telaEscolhaPassagem.fxml");
    }

    @FXML
    public void createUser() {
        RandomAvatarImageGenerator ran = new RandomAvatarImageGenerator();
        user = new User(nameTextField.getText());
        
        String newImage = ran.getImageUrl();
        while (newImage.equals(user.getPathAvatarImage())) {
            newImage = ran.getImageUrl();
        }
        
        user.setPathAvatarImagem(newImage);
        
        MainApp.db.insert(user);
        
        carregarTelaEscolhaPassagem();
    }
    
}
