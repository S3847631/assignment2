package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminController {


    @FXML
    private AnchorPane mainFrame;


    @FXML
    void addStaff(ActionEvent event) {

        AnchorPane pane= new adminController().initAddStaffFrame();
        mainFrame.getChildren().clear();
        mainFrame.getChildren().add(pane);
    }

    @FXML
    void modifyEmploeye(ActionEvent event) {
        AnchorPane pane = new adminController().initModifyEmplo();
        mainFrame.getChildren().clear();
        mainFrame.getChildren().add(pane);
    }

    @FXML
    void shift(ActionEvent event) {
        AnchorPane pane = new adminController().initShiftFrame();
        mainFrame.getChildren().clear();
        mainFrame.getChildren().add(pane);
    }

    @FXML
    void ward1(ActionEvent event) {
        AnchorPane pane =new adminController().initWardFrame();
        mainFrame.getChildren().clear();
        mainFrame.getChildren().add(pane);
    }

    @FXML
    void ward2(ActionEvent event) {
        AnchorPane pane =new adminController().initWardFrame();
        mainFrame.getChildren().clear();
        mainFrame.getChildren().add(pane);
    }

    public AnchorPane initAddStaffFrame(){
        try {

            AnchorPane root = FXMLLoader.load(getClass().getResource("addstaff.fxml"));
            return root;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public AnchorPane initModifyEmplo(){
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("ModifyEmploye.fxml"));
            return root;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public AnchorPane initShiftFrame(){
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Shift.fxml"));
            return  root;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public AnchorPane initWardFrame(){
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Ward.fxml"));
            return  root;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
