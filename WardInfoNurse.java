package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WardInfoNurse extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WardInfo.fxml"));
        primaryStage.setTitle("Nurse");
        primaryStage.setScene(new Scene(root,550,500));
        primaryStage.show();
    }
}
