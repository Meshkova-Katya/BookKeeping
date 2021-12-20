package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryTranslationController {
    private String[] propertyName = {"id",
            "id_transfer", "date_transfer", "transfer_type",
            "sum_transfer", "id_recipient"};
    private String[] propertyLabel = {"№",
            "Номер платежа", "Дата", "Тип платежа",
            "Сумма", "Номер получателя"};
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label outPutInfoLabel;
    @FXML
    private TableView<Translation> table;


    @FXML
    void initialize() {
        StageHolder.getHistoryTranslationStage().setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                DatabaseHandler dbHandler = new DatabaseHandler();
                ObservableList<Translation> tr = FXCollections.observableArrayList();

                tr.addAll(dbHandler.getTransfers());
                table.setItems(tr);
                for (int i = 0; i <
                        propertyLabel.length; i++) {
                    TableColumn<Translation, Object> col = new TableColumn<>(propertyLabel[i]);
                    col.setCellValueFactory(new
                            PropertyValueFactory<>(propertyName[i]));
                    table.getColumns().add(col);
                }
            }
        });


    }
}
