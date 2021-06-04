package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class WardInfo {

    @FXML
    private TextArea TextArea;

    @FXML
    private ChoiceBox<String> illChoicebox;

    @FXML
    private ChoiceBox<Integer> changBed;


    public void initialize(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            list.add(i);
        }
        illChoicebox.setItems(FXCollections.observableArrayList("Fine", "Need to care for"));
        changBed.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    void ClickOK(MouseEvent event) {

    }

    @FXML
    void ClickReturn(MouseEvent event) {

    }

}
