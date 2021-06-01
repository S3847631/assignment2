package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminPageController {

    @FXML
    private Label addStaff;

    @FXML
    private Label Resident;

    @FXML
    private Label Shift;

    @FXML
    private AnchorPane Anch1;

    public AnchorPane getAnch1() {
        return Anch1;
    }

    public void setAnch1(AnchorPane anch1) {
        Anch1 = anch1;
    }

    @FXML
    void ClickAddStaff(MouseEvent event) {
        AnchorPane pane =new AdminPage().initAddStaffPage();
        Anch1.getChildren().clear();
        Anch1.getChildren().add(pane);
    }

    @FXML
    void ClickResident(MouseEvent event) {
        AnchorPane pane =new AdminPage().initWardPage();
        Anch1.getChildren().clear();
        Anch1.getChildren().add(pane);

    }

    @FXML
    void ClickShift(MouseEvent event) {
        AnchorPane pane =new AdminPage().initShift();
        Anch1.getChildren().clear();
        Anch1.getChildren().add(pane);
    }


}

