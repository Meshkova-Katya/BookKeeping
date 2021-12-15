package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthorizationController {

    @FXML
    private TextField loginSignField;

    @FXML
    private PasswordField passwordSignField;

    @FXML
    private Button signInButton;

    @FXML
    private Button registerButton;


    @FXML
    public void initialize() {
        signInButton.setOnAction(event -> {
            String login = loginSignField.getText().trim();
            String password = passwordSignField.getText().trim();
            if (!login.equals("") && !password.equals("")) {
                loginUser(login, password);
            } else {
                String str = "Поле с логином или паролем пустое";
                errorInLoginOrPass(str);
            }
        });
        registerButton.setOnAction(event -> StageHolder.getRegistrationStage().showAndWait());

    }

    private void loginUser(String login, String password) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = dbHandler.authorization(login, password);

        if (user == null) {
            String str = "Такого пользователя не существует!";
            errorInLoginOrPass(str);
        } else {
            dialogInfo();

            StageHolder.getAuthorizationStage().close();
            StageHolder.getBookKeepingStage().showAndWait();


        }

    }

    private void errorInLoginOrPass(String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(string);
        alert.showAndWait();
    }

    private void dialogInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационный диалог");
        alert.setHeaderText("Вы успешно вошли в систему!");
        alert.showAndWait();
    }

}

