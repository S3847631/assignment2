package sample;

import Utils.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStaff {

    @FXML
    private TextField staffField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private ChoiceBox<String> jobBox;

    public void initialize() {
        jobBox.setItems(FXCollections.observableArrayList("Manager", "Doctor", "Nurse"));
    }


    @FXML
    private Button addbuton;

    @FXML
    void clickAdd(MouseEvent event) {
        boolean flag =addStaff();

        if (flag){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look an Information Dialog");
            alert.setContentText("Add Staff Sucessed！");
            alert.showAndWait();

            staffField.setText("");
            nameField.setText("");
            passwordField.setText("");
            phoneField.setText("");
            jobBox.setValue("");
        }

    }

    public boolean addStaff(){
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        boolean resultSet =false;
        String staffid =staffField.getText();
        String name=nameField.getText();
        String password=passwordField.getText();
        String job =jobBox.getValue();
        String phone =phoneField.getText();
        if(name==null||staffid==null||password==null||job==null||phone==null){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look an Information Dialog");
            alert.setContentText("Add Staff Failed！");
            alert.showAndWait();
            return  false;
        }
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into user(Staff_ID,userName,passWord,Job,phone) values (?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,staffid);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,job);
            preparedStatement.setString(5,phone);
            resultSet= preparedStatement.execute();
            return (!resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.Close(preparedStatement,connection);
        }
        return false;
    }

}
