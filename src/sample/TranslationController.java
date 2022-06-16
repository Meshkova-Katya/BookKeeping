package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class TranslationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TextField sumTextField;

    @FXML
    private ComboBox<String> numberComboBox;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private ComboBox<?> typeComboBox1;

    @FXML
    private Button continueButton;

    private void setInfo() {
        TranslationHolder.setDate(new Date());
        TranslationHolder.setSum(Double.parseDouble(sumTextField.getText()));
        TranslationHolder.setNumberOrganization(numberComboBox.getValue());
        TranslationHolder.setId_transfer(generate());
        TranslationHolder.setViewTransfer(typeComboBox.getValue());
    }

    @FXML
    void continueTransfer(ActionEvent actionEvent) {
        setInfo();
        StageHolder.getTwoTranslationStage().showAndWait();

    }

    public int generate() {
        int a = 10000;
        int b = 99999;
        return a + (int) (Math.random() * b);
    }
}
