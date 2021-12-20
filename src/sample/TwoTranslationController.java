package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
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
    private Label outPutIdTransfer;

    @FXML
    private Label outPutSumTf;

    @FXML
    private Label outPutViewTf;

    @FXML
    private Label outPutDateTf;

    @FXML
    public void continueTranslation(ActionEvent event) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dialogInfo();
        StageHolder.getTwoTranslationStage().close();
        StageHolder.getTranslationStage().close();
        try {
            dbHandler.saveTransfer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @FXML
    public void onMouseMoved(MouseEvent event){
        outPutNumberTf.setText(TranslationHolder.getNumberOrganization());
        outPutIdTransfer.setText(Integer.valueOf(TranslationHolder.getId_transfer()).toString());
        outPutSumTf.setText(Double.valueOf(TranslationHolder.getSum()).toString());
        outPutViewTf.setText(TranslationHolder.getViewTransfer());
        outPutDateTf.setText(TranslationHolder.getDate().toString());
    }

    private void dialogInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационный диалог");
        alert.setHeaderText("Перевод выполнен!");
        alert.showAndWait();
    }
}
