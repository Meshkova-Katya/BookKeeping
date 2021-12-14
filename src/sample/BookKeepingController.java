package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

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
        infoButton.setOnAction(event -> StageHolder.getInfoStage().showAndWait());


    }



}
