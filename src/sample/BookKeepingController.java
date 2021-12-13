package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookKeepingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button infoButton;

    @FXML
    private Button translationButton;

    @FXML
    private Button historyTranslationButton;

    @FXML
    void initialize() {
        infoButton.setOnAction(event -> finishWindow());

    }

    private void finishWindow() {
        infoButton.getScene().getWindow().hide(); // закрытие текущего окна


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OrganizatsiyaRecipient.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 600));
        stage.showAndWait(); // чтобы подождал


    }

}
