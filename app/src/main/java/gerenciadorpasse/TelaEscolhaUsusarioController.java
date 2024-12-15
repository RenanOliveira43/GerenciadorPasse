package gerenciadorpasse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class TelaEscolhaUsusarioController {

    @FXML
    private ListView<String> listViewUsuarios;

    @FXML
    private Button btnAdicionarUsuario;

    // Lista de usuários
    private final ObservableList<String> usuarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Conecta a lista de usuários ao ListView
        listViewUsuarios.setItems(usuarios);

        // Adiciona ação ao botão
        btnAdicionarUsuario.setOnAction(event -> adicionarUsuario());
        
        // Carregar usuários salvos
        carregarUsuarios();
    }

    // Método para adicionar um novo usuário
    private void adicionarUsuario() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Adicionar Usuário");
        dialog.setHeaderText("Novo Usuário");
        dialog.setContentText("Digite o nome do usuário:");

        // Espera entrada do usuário
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(nome -> {
            if (!nome.isBlank()) {
                usuarios.add(nome);
                salvarUsuario(nome); // Salvando o novo usuário (se necessário)
            }
        });
    }

    // Método para carregar usuários salvos (simulado)
    private void carregarUsuarios() {
        // Adicione lógica aqui para carregar os usuários de um arquivo ou banco de dados
        usuarios.addAll("Usuário 1", "Usuário 2", "Usuário 3");
    }

    // Método para salvar usuários (simulado)
    private void salvarUsuario(String usuario) {
        // Adicione lógica para salvar o usuário em um arquivo ou banco de dados
        System.out.println("Usuário salvo: " + usuario);
    }
}

