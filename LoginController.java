package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Label Staff_ID;

    @FXML
    private Label Name;

    @FXML
    private Label Password;

    @FXML
    private Label Position;

    @FXML
    private TextField staffIDtexField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ChoiceBox<String> PositionBox;


    @FXML
    private VBox vbox;

    @FXML
    private Button LogButton;

    @FXML
    private Button ExitButton;

    public void initialize() {
        PositionBox.setItems(FXCollections.observableArrayList("Manager", "Doctor", "Nurse"));
    }

    private String staffid;
    private String useName;
    private String password;
    private String position;

    @FXML
    void ClickEvent(ActionEvent event) {
        staffid = staffIDtexField.getText().trim();
        useName = NameField.getText().trim();
        password = passwordField.getText().trim();
        position = PositionBox.getValue();
        boolean flag = new Login().login(staffid, position, useName, password);
        if (flag) {
            switch (position) {
                case "Manager":
                    RunAdminpage();

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Your username or password is error!");
            alert.showAndWait();
        }

    }

    @FXML
    void ExitEvent(ActionEvent event) {
        System.exit(0);
    }

    public void RunAdminpage() {

        try {
            Stage primaryStage = (Stage) LogButton.getScene().getWindow();
            primaryStage.close();//
            AdminPage page = new AdminPage();//new window for admin page
            Stage stage = new Stage();
            page.start(stage);//open window for admin page
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
