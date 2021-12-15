package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StageHolder {
    private static Stage authorizationStage;
    private static Stage registrationStage;
    private static Stage bookKeepingStage;
    private static Stage infoStage;
    private static Stage translationStage;
    private static Stage twoTranslationStage;

    public static void load() {
        try {
            authorizationStage = new Stage();
            Parent root = FXMLLoader.load(StageHolder.class.getResource("Authorization.fxml"));
            authorizationStage.setTitle("Бухгалтерия №5");
            authorizationStage.setScene(new Scene(root, 600, 600));

            registrationStage = new Stage();
            Parent root2 = FXMLLoader.load(StageHolder.class.getResource("Registration.fxml"));
            registrationStage.initOwner(authorizationStage);
            registrationStage.initModality(Modality.APPLICATION_MODAL);
            registrationStage.setScene(new Scene(root2, 600, 600));

            bookKeepingStage = new Stage();
            Parent root6 = FXMLLoader.load(StageHolder.class.getResource("BookKeeping.fxml"));
            bookKeepingStage.setScene(new Scene(root6, 600, 600));


            infoStage = new Stage();
            Parent root3 = FXMLLoader.load(StageHolder.class.getResource("OrganizatsiyaRecipient.fxml"));
            infoStage.initOwner(bookKeepingStage);
            infoStage.setScene(new Scene(root3, 600, 600));

            translationStage = new Stage();
            Parent root4 = FXMLLoader.load(StageHolder.class.getResource("Translation.fxml"));
            translationStage.initOwner(bookKeepingStage);
            translationStage.setScene(new Scene(root4, 600, 600));

            twoTranslationStage = new Stage();
            Parent root5 = FXMLLoader.load(StageHolder.class.getResource("TwoTranslation.fxml"));
            twoTranslationStage.initModality(Modality.APPLICATION_MODAL);
            twoTranslationStage.setScene(new Scene(root5, 600, 600));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Stage getAuthorizationStage() {
        return authorizationStage;
    }

    public static Stage getRegistrationStage() {
        return registrationStage;
    }
    public static Stage getBookKeepingStage(){return bookKeepingStage;}

    public static Stage getInfoStage() {
        return infoStage;
    }

    public static Stage getTranslationStage() {
        return translationStage;
    }

    public static Stage getTwoTranslationStage() {
        return twoTranslationStage;
    }
}
