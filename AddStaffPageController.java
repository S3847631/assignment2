package sample;

import JDBCUtils.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddStaffPageController {

    @FXML
    private TextField stafftext;

    @FXML
    private TextField nametext;

    @FXML
    private TextField passtext;

    @FXML
    private TextField phonetext;

    @FXML
    private Button conAndadd;

    @FXML
    private ChoiceBox<String> positionChoicebox;

    @FXML
    void conAndadd(MouseEvent event) {
        boolean flag =addStaff();

        if (flag){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Have an Information Dialog");
            alert.setContentText("New staff is added successfully！");
            alert.showAndWait();

            stafftext.setText("");
            nametext.setText("");
            passtext.setText("");
            phonetext.setText("");
            positionChoicebox.setValue("");
        }

    }

    public void initialize(){
        positionChoicebox.setItems(FXCollections.observableArrayList("Manager","Doctor","Nurse"));
    }

    public boolean addStaff(){
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        boolean resultSet =false;
        String staffid =stafftext.getText();
        String name=nametext.getText();
        String password=passtext.getText();
        String position =positionChoicebox.getValue();
        String phone =phonetext.getText();
        if(name==null||staffid==null||password==null||position==null||phone==null){
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
            preparedStatement.setString(4,position);
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
