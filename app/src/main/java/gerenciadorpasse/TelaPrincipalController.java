package gerenciadorpasse;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TelaPrincipalController {
    @FXML private Label saldoLabel;
    @FXML private Label gastoLabel;
    @FXML private Button buttonLabel;
    @FXML private TextField valorTextField;
    @FXML private VBox teste;
    
    @FXML
    public void initialize() {
        saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(0).passagem.getSaldo()));
        gastoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(0).passagem.getGastoMes()));
        buttonLabel.setText(String.format("Subtrair R$ %.2f", MainApp.db.getUsers().get(0).passagem.getTipoPassagem().getValor()));
    }

    @FXML
    private void somarValor() {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o valor");
        Button confirmarButton = new Button("Confirmar");
    
        teste.getChildren().addAll(inputField, confirmarButton);
    
        confirmarButton.setOnAction(event -> {
            try {
                double valor = Double.parseDouble(inputField.getText());
    
                MainApp.db.getUsers().get(0).passagem.somarValor(valor);
                MainApp.db.update(MainApp.db.getUsers().get(0));
    
                saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(0).passagem.getSaldo()));

                teste.getChildren().removeAll(inputField, confirmarButton);
            } catch (NumberFormatException e) {
                saldoLabel.setText("Valor inválido. Tente novamente.");
            }
        });
    }

    @FXML
    private void alterarParaValorPersonalizado() {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o valor");
        Button confirmarButton = new Button("Confirmar");
    
        teste.getChildren().addAll(inputField, confirmarButton);
    
        confirmarButton.setOnAction(event -> {
            try {
                double valor = Double.parseDouble(inputField.getText());
    
                MainApp.db.getUsers().get(0).passagem.alterarParaValorPersonalizado(valor);
    
                saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(0).passagem.getSaldo()));

                MainApp.db.update(MainApp.db.getUsers().get(0));
    
                teste.getChildren().removeAll(inputField, confirmarButton);
            } catch (NumberFormatException e) {
                saldoLabel.setText("Valor inválido. Tente novamente.");
            }
        });
    }

    @FXML
    private void subtrairValorPassagem() {
        MainApp.db.getUsers().get(0).passagem.subtrairValorPassagem();;
        MainApp.db.getUsers().get(0).passagem.somarGastoMes(MainApp.db.getUsers().get(0).passagem.getTipoPassagem().getValor());

        MainApp.db.update(MainApp.db.getUsers().get(0));
        
        saldoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(0).passagem.getSaldo()));
        gastoLabel.setText(String.format("R$ %.2f", MainApp.db.getUsers().get(0).passagem.getGastoMes()));

    }

    @FXML
    private void estatisticas() {
        //todo
    }
}
