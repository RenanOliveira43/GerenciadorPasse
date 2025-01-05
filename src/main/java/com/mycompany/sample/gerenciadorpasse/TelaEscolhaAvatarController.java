package com.mycompany.sample.gerenciadorpasse;

import java.net.URL;
import java.util.List;

import com.mycompany.sample.Utils.AvatarImageGenerator;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaEscolhaAvatarController {
    @FXML private VBox centerContainer;
    @FXML private Label confirmationLabel;

    private int indexUsuarioAtual = MainApp.indexUsuarioAtual;

    @FXML
    public void initialize() {
        loadAvatarImages();
    }
    
    @FXML
    public void voltarTelaConfiguracao() {
        MainApp.setScene("/telaconfiguracao.fxml");
    }

    @FXML
    private void loadAvatarImages() {
        AvatarImageGenerator avatarImage = new AvatarImageGenerator();
        List<String> imageList = avatarImage.getImageList();

        for (int i = 0; i < imageList.size(); i += 3) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            hbox.setAlignment(Pos.CENTER);
            
            final int idx = i;

            URL imageUrl1 = getClass().getResource(imageList.get(i));
            if (imageUrl1 != null) {
                Image image1 = new Image(imageUrl1.toString());
                ImageView imageView1 = new ImageView(image1);
                imageView1.setFitWidth(80);
                imageView1.setFitHeight(80);
                imageView1.setPreserveRatio(true);
                hbox.getChildren().add(imageView1);

                imageView1.setOnMouseClicked(event -> {
                    MainApp.db.getUsers().get(indexUsuarioAtual).setPathAvatarImagem(imageList.get(idx));
                    MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
                    confirmationLabel.setText("Imagem definida com sucesso!");
                });
            }

            if (i + 1 < imageList.size()) {
                URL imageUrl2 = getClass().getResource(imageList.get(i + 1));
                if (imageUrl2 != null) {
                    Image image2 = new Image(imageUrl2.toString());
                    ImageView imageView2 = new ImageView(image2);
                    imageView2.setFitWidth(80);
                    imageView2.setFitHeight(80);
                    imageView2.setPreserveRatio(true);
                    hbox.getChildren().add(imageView2);

                    imageView2.setOnMouseClicked(event -> {
                        MainApp.db.getUsers().get(indexUsuarioAtual).setPathAvatarImagem(imageList.get(idx+1));
                        MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
                        confirmationLabel.setText("Imagem definida com sucesso!");
                    });
                }
            }

            if (i + 2 < imageList.size()) {
                URL imageUrl3 = getClass().getResource(imageList.get(i + 2));
                if (imageUrl3 != null) {
                    Image image3 = new Image(imageUrl3.toString());
                    ImageView imageView3 = new ImageView(image3);
                    imageView3.setFitWidth(80);
                    imageView3.setFitHeight(80);
                    imageView3.setPreserveRatio(true);
                    hbox.getChildren().add(imageView3);

                    imageView3.setOnMouseClicked(event -> {
                        MainApp.db.getUsers().get(indexUsuarioAtual).setPathAvatarImagem(imageList.get(idx+2));
                        MainApp.db.update(MainApp.db.getUsers().get(indexUsuarioAtual));
                        confirmationLabel.setText("Imagem definida com sucesso!");
                    });
                }
            }
            centerContainer.getChildren().add(hbox);
        }
    }
}
