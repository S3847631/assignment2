package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminPage extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        primaryStage.setTitle("AdminPage");
        primaryStage.getIcons().add(new Image("pictures/hospital.png"));
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
    }

    public AnchorPane initAddStaffPage(){
        try {
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("AddStaffPage.fxml"));
            AnchorPane pane =loader.load();
            return pane;
        }catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }

    public AnchorPane initWardPage(){
        try {
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("Ward.fxml"));
            AnchorPane pane =loader.load();
            return pane;
        }catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }
    public AnchorPane initShift(){
        try {
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("Shift.fxml"));
            AnchorPane pane =loader.load();
            return pane;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
