package Utils;

import javafx.scene.control.Alert;
import jdk.nashorn.internal.scripts.JD;
import sample.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CareUtils {
    public static void updateUserData(Staff staff,String id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set  Staff_ID= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getStaffID());
            preparedStatement.setString(2, id);
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public static void updateUserName(Staff staff){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set   userName= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getStaffID());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public static void updateUserPassword(Staff staff){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set   passWord= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getPassword());
            preparedStatement.setString(2, staff.getStaffID());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public static void updateUserJob(Staff staff){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set   Job= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getJob());
            preparedStatement.setString(2, staff.getStaffID());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public static void updateUserPhone(Staff staff){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set   phone= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getPhone());
            preparedStatement.setString(2, staff.getStaffID());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }


    public static void updateUserWorkingHour(Staff rowValue) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set   StartTime= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rowValue.getWorkHour());
            preparedStatement.setString(2, rowValue.getStaffID());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public static void updateUserOffWorkingHour(Staff rowValue) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update user set   EndTime= ? where Staff_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rowValue.getOffWorkHour());
            preparedStatement.setString(2, rowValue.getStaffID());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtils.Close(preparedStatement, connection);
        }
    }

    public static Date GetWorkingData(Staff staff){
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet rs= null;

        try{
            connection= JDBCUtils.getConnection();
            String sql = "select *from user where Staff_ID=?";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,staff.getStaffID());

            rs= preparedStatement.executeQuery();
            while (rs.next()){

                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("HH:mm");
                try {
                    Date time =simpleDateFormat.parse(rs.getString("StartTime"));
                    return time;
                }catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Warning");
                    alert.setContentText("Illegal time format!");
                    alert.showAndWait();
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.Close(rs,preparedStatement,connection);
        }

        return null;
    }
}
