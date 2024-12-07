package gerenciadorpasse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    protected static Stage stage;
    //protected static Database db = new Database(true);

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        setScene("/telaInicial.fxml");
        primaryStage.show();
    }

    public static void setScene(String fxml) {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource(fxml));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(MainApp.class.getResource("/style.css").toExternalForm());
            stage.setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}