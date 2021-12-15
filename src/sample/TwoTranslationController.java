package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TwoTranslationController extends TranslationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button transferButton;

    @FXML
    private Label outPutNumberTf;

    @FXML
    private Label outPutNameTf;

    @FXML
    private Label outPutSumTf;

    @FXML
    private Label outPutViewTf;

    @FXML
    void continueTranslation(ActionEvent event) {
        String str = getInfo();
        System.out.println(str);
    }



}
