package gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaInicialController {    
    protected static User user = new User();

    @FXML
    public void carregarTelaEscolhaPassagem(){
        MainApp.setScene("/telaEscolhaPassagem.fxml");
    }
}
