package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.HospitalUtil;


public class PrescriptionController {

    @FXML
    private TextArea textArea;

    @FXML
    private Button confirm;

    @FXML
    void clickConfirm(MouseEvent event) {
        HospitalUtil.updateParentPrescription(bedID, textArea.getText());
        Stage primaryStage = (Stage) textArea.getScene().getWindow();
        primaryStage.close();
    }

    private int bedID;

    public PrescriptionController(int bedID){
        this.bedID = bedID;
    }

    public void initialize() {
        textArea.setText(HospitalUtil.getParentPrescription(bedID));
    }
}