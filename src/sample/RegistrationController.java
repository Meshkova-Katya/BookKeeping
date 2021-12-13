package sample;


import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private TextField loginRegField;

    @FXML
    private PasswordField passwordRegField;

    @FXML
    private Button regButton;


    @FXML
    public void initialize() {
        regButton.setOnAction(event -> {
            signUpNewUser();
            StageHolder.getRegistrationStage().close();
        });

    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        String login = loginRegField.getText().trim();
        String password = passwordRegField.getText().trim();

        if (!login.equals("") && !password.equals("")) {


            User user = new User(login, password);


            try {

                dbHandler.registration(user);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            String str = "Заполните все поля!";
            errorInLoginOrPass(str);
        }

    }

    private void errorInLoginOrPass(String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(string);
        alert.showAndWait();
    }


}
