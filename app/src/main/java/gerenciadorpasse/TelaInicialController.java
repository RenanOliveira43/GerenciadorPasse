package gerenciadorpasse;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.fxml.FXML;

public class TelaInicialController {    
    protected User user;
    private TextField nameTextField;
    @FXML
    public void carregarTelaEscolhaPassagem(){
        MainApp.setScene("/telaEscolhaPassagem.fxml");
    }

    @FXML
    public void createUser() {
        user = new User(nameTextField.getText());
        MainApp.db.insert(user);
    }
}
