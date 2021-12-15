package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public  class  TranslationController {


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
    private Button continueButton;


    String getInfo() {
        String numberOrganization = "";

        double sum = Double.parseDouble(sumTextField.getText());
        String viewTransfer = "";

        if (numberComboBox.getValue().equals("345")) {
            numberOrganization = "345";
        }
        if (numberComboBox.getValue().equals("456")) {
            numberOrganization = "456";
        }
        if (numberComboBox.getValue().equals("543")) {
            numberOrganization = "543";
        }
        if (typeComboBox.getValue().equals("Банковский перевод")) {
            viewTransfer = "Банковский перевод";
        }
        if (typeComboBox.getValue().equals("Электронный перевод")) {
            viewTransfer = "Электронный перевод";
        }
        if (typeComboBox.getValue().equals("Почтовый перевод")) {
            viewTransfer = "Почтовый перевод";
        }

        return numberOrganization + sum + viewTransfer;
    }

    @FXML
    void continueTransfer(ActionEvent actionEvent) {
        StageHolder.getTwoTranslationStage().showAndWait();

    }


}
