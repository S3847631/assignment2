package sample;

import Utils.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddResident {

    @FXML
    private TextField ID;

    @FXML
    private TextField Name;

    @FXML
    private DatePicker Dob;

    @FXML
    private DatePicker Admitted;

    @FXML
    private DatePicker Discharged;

    @FXML
    private ChoiceBox<String> Gender;

    @FXML
    private ChoiceBox<Integer> BedID;

    @FXML
    private Button OK;


    public void initialize(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            list.add(i);
        }
        Gender.setItems(FXCollections.observableArrayList("Male", "Female"));
        BedID.setItems(FXCollections.observableArrayList(list));
    }
    public boolean Update(Resident resident) throws CareHomeException.AddResidentException {
        resident.setID(this.ID.getText().trim());
        resident.setName(this.Name.getText().trim());
        resident.setGender(Gender.getValue());
        try {
            resident.setBedID(BedID.getValue());
        }catch (NullPointerException exception){
            throw new CareHomeException.AddResidentException("Add Failed,BedID is Null!");
        }
        String Dob = resident.setDate(resident.getDob());
        String admit = Admitted.getValue().toString();
        String disCharged = Discharged.getValue().toString();
        //sql connected
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean resultSet = false;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into resident(ID,Name,Dob,Admitted,Discharged,Gender,BedID) values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, resident.getID());
            preparedStatement.setString(2, resident.getName());
            preparedStatement.setString(3, Dob);
            preparedStatement.setString(4, admit);
            preparedStatement.setString(5, disCharged);
            preparedStatement.setString(6, resident.getGender());
            preparedStatement.setInt(7, resident.getBedID());
            resultSet = preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
        return false;
    }



    @FXML
    void Ok(MouseEvent event) throws IOException {
        boolean flag= false;
        try {
            flag = Update(new Resident());
        } catch (CareHomeException.AddResidentException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Message!");
            alert.setContentText("Add Failed!");
            alert.showAndWait();
        }
        if (flag){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Message!");
            alert.setContentText("Add Sucessed!");
            alert.showAndWait();
            Stage primaryStage = (Stage) OK.getScene().getWindow();
            primaryStage.close();
            admin page = new admin();
            Stage stage =new Stage();
            page.start(stage);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Message!");
            alert.setContentText("Add Failed!");
            alert.showAndWait();
        }
    }

}

