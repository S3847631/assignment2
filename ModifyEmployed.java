package sample;

import Utils.CareUtils;
import Utils.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModifyEmployed {

    @FXML
    private TableView<Staff> table;

    @FXML
    private TableColumn<Staff, String> staff;

    @FXML
    private TableColumn<Staff, String> name;

    @FXML
    private TableColumn<Staff, String> password;

    @FXML
    private TableColumn<Staff, String> job;

    @FXML
    private TableColumn<Staff, String> phone;




    @FXML
    private void initialize(){
        ObservableList<Staff> data = FXCollections.observableArrayList();
        data = loadDataBase();
        table.setEditable(true);

        staff.setCellValueFactory(cellData->cellData.getValue().staffIDProperty());
        staff.setCellFactory(TextFieldTableCell.forTableColumn());
        staff.setOnEditCommit((TableColumn.CellEditEvent<Staff,String> t)->{
            Staff staff = t.getRowValue();
            String id = staff.getStaffID();

            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setStaffID(t.getNewValue());

            CareUtils.updateUserData(staff,id);
        });

        name.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit((TableColumn.CellEditEvent <Staff,String> t)->{
            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setName(t.getNewValue());

            CareUtils.updateUserName(t.getRowValue());
        });

        password.setCellValueFactory(cellData->cellData.getValue().passwordProperty());
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setOnEditCommit((TableColumn.CellEditEvent <Staff,String> t)->{
            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setPassword(t.getNewValue());
            CareUtils.updateUserPassword(t.getRowValue());
        });

        job.setCellValueFactory(cellData->cellData.getValue().jobProperty());
        job.setCellFactory(TextFieldTableCell.forTableColumn());
        job.setOnEditCommit((TableColumn.CellEditEvent <Staff,String> t)->{
            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setJob(t.getNewValue());

            CareUtils.updateUserJob(t.getRowValue());
        });


        phone.setCellValueFactory(cellData->cellData.getValue().phoneProperty());
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit((TableColumn.CellEditEvent <Staff,String> t)->{
            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setPhone(t.getNewValue());

            CareUtils.updateUserPhone(t.getRowValue());
        });


        table.setItems(data);

    }






    public ObservableList<Staff> loadDataBase(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs =null;
        Staff staff = null;


        String nurse ="Nurse";
        String doctor ="Doctor";

        ObservableList<Staff> Data = FXCollections.observableArrayList();
        List<Staff> list =new ArrayList<Staff>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where job =? or Job = ?";

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,nurse);
            preparedStatement.setString(2,doctor);
            rs = preparedStatement.executeQuery();

            while (rs.next()){
                staff =new Staff();
                staff.setStaffID(rs.getString("Staff_ID"));
                staff.setName(rs.getString("userName"));
                staff.setJob(rs.getString("Job"));
                staff.setPassword(rs.getString("passWord"));
                staff.setPhone(rs.getString("phone"));

                list.add(staff);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.Close(rs,preparedStatement,connection);
        }

        Data.addAll(list);

        return Data;
    }
}
