package gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaInicialController {
    @FXML
    public void carregarTelaPrincipal(){
        MainApp.setScene("/telaPrincipal.fxml");
    }
}
