package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DoctorCon {

    @FXML
    private Menu ward1;

    @FXML
    private Menu ward2;

    @FXML
    private AnchorPane mainAnch;

    @FXML
    void ClickWard1(ActionEvent event) {
        AnchorPane pane = new DoctorCon().initWard1Frame();
        mainAnch.getChildren().clear();
        mainAnch.getChildren().add(pane);
    }

    @FXML
    void ClickWard2(ActionEvent event) {
        AnchorPane pane = new DoctorCon().initWard1Frame();
        mainAnch.getChildren().clear();
        mainAnch.getChildren().add(pane);
    }

    public AnchorPane initWard1Frame(){
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("WardDoc.fxml"));
            return  root;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
