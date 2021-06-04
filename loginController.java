package sample;

import Utils.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {

    @FXML
    private TextField idField;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> jobBox;

    @FXML
    private Button login;



    public void initialize() {
        jobBox.setItems(FXCollections.observableArrayList("Manager", "Doctor", "Nurse"));
    }


    @FXML
    void loginClick(MouseEvent event) {


       boolean flag= login(idField.getText(),jobBox.getValue(),userField.getText(), passwordField.getText());
        if (flag){
            System.out.println("successed!");
            switch (jobBox.getValue()){
                case "Manager": RunAdminpage();   break;
                case "Doctor" : RunDoctorFrame(); break;
                case "Nurse"  : RunNurseFrame();  break;
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Your username or password is error!");
            alert.showAndWait();
        }
    }

    private void RunNurseFrame() {
        try {
            Stage primaryStage = (Stage) login.getScene().getWindow();
            primaryStage.close();//打开新的窗口 所以要关闭当前的窗口
            NurseFrame page = new NurseFrame();//新窗口类
            Stage stage = new Stage();
            page.start(stage);//打开新窗口
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void RunDoctorFrame() {
        try {
            Stage primaryStage = (Stage) login.getScene().getWindow();
            primaryStage.close();//打开新的窗口 所以要关闭当前的窗口
            DoctorFrame page = new DoctorFrame();//新窗口类
            Stage stage = new Stage();
            page.start(stage);//打开新窗口
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void RunAdminpage() {

        try {
            Stage primaryStage = (Stage) login.getScene().getWindow();
            primaryStage.close();//打开新的窗口 所以要关闭当前的窗口
            admin page = new admin();//新窗口类
            Stage stage = new Stage();
            page.start(stage);//打开新窗口
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public boolean login(String ID,String Job ,String username,String password){
        if (null == username || null==password){
            return  false;
        }
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
            //建立DATABASE连接
            connection = JDBCUtils.getConnection();
            //定义SQL查询
            String sql = "select *from user where username = ? and password = ? and Staff_ID= ? and job= ?";
            //获取SQL执行的对象 使用预编译 来处理sql注入问题
            preparedStatement =connection.prepareStatement(sql);
            //给sql的占位符？进行赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,ID);
            preparedStatement.setString(4,Job);
            //开始执行sql查询
            resultSet=preparedStatement.executeQuery();
            //判断是否存在查询对象
            return resultSet.next(); //如果存在 则返回true 如果不存在 则返回flase
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtils.Close(resultSet,preparedStatement,connection);
        }
        return false;
    }
}
