package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){

 StageHolder.load();
    StageHolder.getAuthorizationStage().show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
