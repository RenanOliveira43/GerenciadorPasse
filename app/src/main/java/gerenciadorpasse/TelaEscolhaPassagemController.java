package gerenciadorpasse;

import javafx.fxml.FXML;

public class TelaEscolhaPassagemController {
    private int indexUsuarioAtual = MainApp.indexUsuarioAtual;
    
    @FXML
    public void carregarTelaPrincipal() {
        try { 
            MainApp.setScene("/telaPrincipal.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    @FXML
    public void passagemComum() {
        MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setTipoPassagem(TipoPassagem.COMUM);
        MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
    }

    @FXML
    public void passagemUniversitario() {
        MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setTipoPassagem(TipoPassagem.UNIVERSITARIO);
        MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
    }

    @FXML
    public void passagemEstudante() {
        MainApp.db.getUsers().get(indexUsuarioAtual).passagem.setTipoPassagem(TipoPassagem.ESTUDANTE);
        MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
    }
}
