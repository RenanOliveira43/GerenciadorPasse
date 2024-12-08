package gerenciadorpasse;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaPrincipalController {
    @FXML private Label saldoLabel;
    @FXML private Label gastoLabel;
    @FXML private Button buttonLabel;
    @FXML private TextField valorTextField;
    
    @FXML
    public void initialize() {
        saldoLabel.setText(String.format("R$ %.2f", TelaInicialController.user.passagem.getSaldo()));
        gastoLabel.setText(String.format("R$ %.2f", TelaInicialController.user.passagem.getGastoMes()));
        buttonLabel.setText(String.format("Subtrair R$ %.2f", TelaInicialController.user.passagem.getTipoPassagem().getValor()));
    }

    @FXML
    private void somarValor() {
        double valor = 35.90f; // todo: pegar entrada do usuario

        TelaInicialController.user.passagem.somarValor(valor);
        saldoLabel.setText(String.format("R$ %.2f", TelaInicialController.user.passagem.getSaldo()));
    }

    @FXML
    private void subtrairValorPassagem() {
        TelaInicialController.user.passagem.subtrairValorPassagem();;
        saldoLabel.setText(String.format("R$ %.2f", TelaInicialController.user.passagem.getSaldo()));
    }

}
