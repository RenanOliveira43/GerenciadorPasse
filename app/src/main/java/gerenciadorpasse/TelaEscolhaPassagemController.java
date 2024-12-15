package gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaEscolhaPassagemController {
    @FXML
    public void carregarTelaPrincipal() {
        MainApp.setScene("/telaPrincipal.fxml");
    } 

    @FXML
    public void passagemComum() {
        MainApp.db.getUsers().get(0).passagem.setTipoPassagem(TipoPassagem.COMUM);
        MainApp.db.update(MainApp.db.getUsers().get(0));
    }

    @FXML
    public void passagemUniversitario() {
        MainApp.db.getUsers().get(0).passagem.setTipoPassagem(TipoPassagem.UNIVERSITARIO);
        MainApp.db.update(MainApp.db.getUsers().get(0));
    }

    @FXML
    public void passagemEstudante() {
        MainApp.db.getUsers().get(0).passagem.setTipoPassagem(TipoPassagem.ESTUDANTE);
        MainApp.db.update(MainApp.db.getUsers().get(0));
    }
}
