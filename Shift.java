package sample;

import Utils.CareUtils;
import Utils.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shift {

    @FXML
    private TableView<Staff> table;

    @FXML
    private TableColumn<Staff, String> staff;

    @FXML
    private TableColumn<Staff, String> name;

    @FXML
    private TableColumn<Staff, String> job;

    @FXML
    private TableColumn<Staff, String> working;

    @FXML
    private TableColumn<Staff, String> off_working;

    @FXML
    private void initialize(){
        ObservableList<Staff> data = FXCollections.observableArrayList();
        data = loadDataBase();
        table.setEditable(true);

        staff.setCellValueFactory(cellData->cellData.getValue().staffIDProperty());
        name.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        job.setCellValueFactory(cellData->cellData.getValue().jobProperty());

        working.setCellValueFactory(cellData->cellData.getValue().workHourProperty());
        working.setCellFactory(TextFieldTableCell.forTableColumn());
        working.setOnEditCommit((TableColumn.CellEditEvent <Staff,String> t)->{

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String time= t.getNewValue();

            try {
                sdf.parse(time);

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Warning");
                alert.setContentText("Illegal time format!");
                alert.showAndWait();
            }

            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setWorkHour(t.getNewValue());

            CareUtils.updateUserWorkingHour(t.getRowValue());
        });


        off_working.setCellValueFactory(cellData->cellData.getValue().offWorkHourProperty());
        off_working.setCellFactory(TextFieldTableCell.forTableColumn());
        off_working.setOnEditCommit((TableColumn.CellEditEvent <Staff,String> t)->{
            String EndTime =t.getNewValue();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
               Date Time1 =sdf.parse(EndTime);
               Date Time2 = CareUtils.GetWorkingData(t.getRowValue());
               long date =Math.abs(Time1.getTime()-Time2.getTime());
               if (date>1000*3600){
                   throw new CareHomeException.TimeErrorException("The working hours is over 8 hours!");
               }
                System.out.println(date);
            } catch (CareHomeException.TimeErrorException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Warning");
                alert.setContentText("The working hours is over 8 hours!");
                alert.showAndWait();
            } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Warning");
                alert.setContentText("Illegal time format!");
                alert.showAndWait();
            }


            ((Staff) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setOffWorkHour(t.getNewValue());

            CareUtils.updateUserOffWorkingHour(t.getRowValue());
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
                staff.setWorkHour(rs.getString("StartTime"));
                staff.setOffWorkHour(rs.getString("EndTime"));

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
