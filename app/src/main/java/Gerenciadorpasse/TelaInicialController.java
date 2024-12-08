package gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaInicialController {
    @FXML
    public void carregarTelaEscolhaPassagem(){
        MainApp.setScene("/telaEscolhaPassagem.fxml");
    }
}
