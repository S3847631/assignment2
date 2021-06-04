package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Nurse {
    boolean flag = false;

    @FXML
    private AnchorPane mainFrame;


    @FXML
    void addStaff(ActionEvent event) {
        if (flag) {
            AnchorPane pane = new Nurse().initAddStaffFrame();
            mainFrame.getChildren().clear();
            mainFrame.getChildren().add(pane);
        }else {
            try {
                throw new CareHomeException.OperationException();
            } catch (CareHomeException.OperationException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Warning!");
                alert.setContentText("You don't have access. Please contact the administrator！");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void modifyEmploeye(ActionEvent event) {
        if (flag) {
            AnchorPane pane = new Nurse().initModifyEmplo();
            mainFrame.getChildren().clear();
            mainFrame.getChildren().add(pane);
        }else {
            try {
                throw new CareHomeException.OperationException();
            } catch (CareHomeException.OperationException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Warning!");
                alert.setContentText("You don't have access. Please contact the administrator！");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void shift(ActionEvent event) {
        if (flag) {

            AnchorPane pane = new Nurse().initShiftFrame();
            mainFrame.getChildren().clear();
            mainFrame.getChildren().add(pane);
        }else {
            try {
                throw new CareHomeException.OperationException();
            } catch (CareHomeException.OperationException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Warning!");
                alert.setContentText("You don't have access. Please contact the administrator！");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void ward1(ActionEvent event) {
        AnchorPane pane =new Nurse().initWardFrame();
        mainFrame.getChildren().clear();
        mainFrame.getChildren().add(pane);
    }

    @FXML
    void ward2(ActionEvent event) {
        AnchorPane pane =new Nurse().initWardFrame();
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
            AnchorPane root = FXMLLoader.load(getClass().getResource("WardNurse.fxml"));
            return  root;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
