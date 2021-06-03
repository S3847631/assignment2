package sample;

import JDBCUtils.JDBCUtils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.joda.time.DateTime;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.SplittableRandom;

public class ResidentController {

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private DatePicker admitted;

    @FXML
    private DatePicker dob;

    @FXML
    private DatePicker discharge;

    @FXML
    private Button confirm;

    @FXML
    private Button Return;

    @FXML
    private ChoiceBox<String> gender;

    private Resident resident = new Resident();

    private int bedID;

    public void initialize() {
        gender.setItems(FXCollections.observableArrayList("Male", "Female"));
    }

    public ResidentController(int bedID) {
        this.bedID = bedID;
        System.out.println(bedID);
    }

    //sql connected
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    boolean resultSet = false;

    @FXML
    void ConfirmClick(MouseEvent event) {
        resident.setID(this.id.getText().trim());
        resident.setName(this.name.getText().trim());
        resident.setGender(gender.getValue());
        String Dob = resident.setDate(resident.getDob());
        String admit = admitted.getValue().toString();
        String disCharged = discharge.getValue().toString();

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
            preparedStatement.setInt(7, bedID);
            resultSet = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public boolean flag;

    @FXML
    void ReturnClick(MouseEvent event) {
        ReturnPage();
    }

    public void ReturnPage() {
        try {
            Stage primaryStage = (Stage) Return.getScene().getWindow();//将submit(登录按钮)与Main类中的primaryStage(新窗口)绑定 并执行close()
            primaryStage.close();//打开新的窗口 所以要关闭当前的窗口
            Room page = new Room();//新窗口类
            Stage stage = new Stage();
            page.start(stage);//打开新窗口
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isMale() {
        return resident.getGender().equals("Male");
    }
}
