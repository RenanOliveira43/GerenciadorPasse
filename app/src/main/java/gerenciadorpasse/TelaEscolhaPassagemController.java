package gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaEscolhaPassagemController {
    @FXML
    public void carregarTelaPrincipal() {
        MainApp.setScene("/telaPrincipal.fxml");
    } 

    @FXML
    public void passagemComum() {
        TelaInicialController.user.passagem.setTipoPassagem(TipoPassagem.COMUM);
    }

    @FXML
    public void passagemUniversitario() {
        TelaInicialController.user.passagem.setTipoPassagem(TipoPassagem.UNIVERSITARIO);
    }

    @FXML
    public void passagemEstudante() {
        TelaInicialController.user.passagem.setTipoPassagem(TipoPassagem.ESTUDANTE);
    }
}
