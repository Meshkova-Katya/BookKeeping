package sample;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthorizationController {

    @FXML
    private TextField loginSignField;

    @FXML
    private PasswordField passwordSignField;

    @FXML
    private Button SignInButton;

    @FXML
    private Button registerButton;


    @FXML
    public void initialize() {
        SignInButton.setOnAction(event -> {
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

            SignInButton.getScene().getWindow().hide(); // закрытие текущего окна

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("BookKeeping.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 600));
            stage.showAndWait(); // чтобы подождал

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

