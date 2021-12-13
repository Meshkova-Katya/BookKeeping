package sample;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class OrganizatsiyaRecipientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> organizatsiyaComboBox;

    @FXML
    private Button takeInfoButton;

    @FXML
    private Label outPutInfoLabel;


    @FXML
    void initialize() {
        takeInfoButton.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            OrganizatsiyaRecipient organizatsiyaRecipient = new OrganizatsiyaRecipient();

            if (organizatsiyaComboBox.getValue().equals("ПРОТЕК")) {
                outPutInfoLabel.setText(String.valueOf(organizatsiyaRecipient.toString()));
                dbHandler.info(organizatsiyaRecipient);
            }
        });


    }


}
