package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static sample.ConstOrganizatsiyaRecipient.NAME_RECIPIENT;
import static sample.ConstOrganizatsiyaRecipient.ORGANIZATSIYA_TABLE;


public class OrganizatsiyaRecipientController {

    @FXML
    private ComboBox<String> organizatsiyaComboBox;

    @FXML

    private Button takeInfoButton;

    @FXML
    private Label outPutInfoLabel;


    public String getInfoRecipient() {
        String str = "";
        String nameOrganization = "";
        if (organizatsiyaComboBox.getValue().equals("ПРОТЕК")) {
            nameOrganization = "ПРОТЕК";
        }
        if (organizatsiyaComboBox.getValue().equals("Тортуга")) {
            nameOrganization = "Тортуга";
        }
        if (organizatsiyaComboBox.getValue().equals("Сервис-Торг")) {
            nameOrganization = "Сервис-Торг";
        }
        String select = "SELECT * FROM " + ORGANIZATSIYA_TABLE + " WHERE " +
                NAME_RECIPIENT + "=?";
        try (PreparedStatement prSt = DatabaseHandler.getDbConnection().prepareStatement(select)) {
            prSt.setString(1, nameOrganization);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                int id_recipient = resultSet.getInt("id_recipient");
                String name_recipient = resultSet.getString("name_recipient");
                String city_recipient = resultSet.getString("city_recipient");
                String street_recipient = resultSet.getString("street_recipient");
                String type_organization = resultSet.getString("type_organization");
                str = "Номер организации: " + id_recipient + "\n" + "Название организации: " +
                        name_recipient + "\n" + "Город: " + city_recipient + "\n" + "Улица: "
                        + street_recipient + "\n" + "Тип организации " + type_organization;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    @FXML
    public void outPutInformation(ActionEvent event) {

        outPutInfoLabel.setText(getInfoRecipient());

    }



}