package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Date;
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
    private Label outPutDateTf;

    public TwoTranslationController( Date date, String numberOrganization, double sum, String viewTransfer, int id_transfer) {
        super(date, numberOrganization, sum, viewTransfer, id_transfer);
        outPutDateTf.setText(String.valueOf(date));
        outPutNumberTf.setText(numberOrganization);
        outPutSumTf.setText(String.valueOf(sum));
        outPutViewTf.setText(viewTransfer);

    }

    @FXML
    void continueTranslation(ActionEvent event) {
        String str = getInfo(numberOrganization, viewTransfer, id_transfer);
        System.out.println(str);

    }




}
