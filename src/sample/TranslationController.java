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
    private Button continueButton;

    public TranslationController(Date date, String numberOrganization, double sum, String viewTransfer, int id_transfer) {
        this.date = date;
        this.numberOrganization = numberOrganization;
        this.sum = sum;
        this.viewTransfer = viewTransfer;
        this.id_transfer = id_transfer;
    }

    Date date;
    String numberOrganization;
    double sum;
    String viewTransfer;
    int id_transfer;


    String getInfo(String numberOrganization, String viewTransfer, int id_transfer) {
        Date date = new Date();
        double sum = Double.parseDouble(sumTextField.getText());
        if (numberComboBox.getValue().equals("345")) {
            numberOrganization = "345";
            id_transfer = generate();

        }
        if (numberComboBox.getValue().equals("456")) {
            numberOrganization = "456";
            id_transfer = generate();

        }
        if (numberComboBox.getValue().equals("543")) {
            numberOrganization = "543";
            id_transfer = generate();
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

        return "Номер организации-получателя: " + numberOrganization + "\n" + "Сумма: " + sum + "\n" +
                "Тип перечисления: " + viewTransfer + "\n" + "Номер перечисления: " + id_transfer + "\n" +
                "Дата: " + date;
    }

    @FXML
    void continueTransfer(ActionEvent actionEvent) {
        System.out.println(getInfo(numberOrganization, viewTransfer, id_transfer));
        StageHolder.getTwoTranslationStage().showAndWait();

    }

    public int generate() {
        int a = 10000;
        int b = 99999;
        return a + (int) (Math.random() * b);
    }


}
