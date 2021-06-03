package sample;

import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class Login {
    public boolean login(String ID,String Position ,String username,String password){
        if (null == username || null==password){
            return  false;
        }
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
            //create the database connect
            connection = JDBCUtils.getConnection();
            //define as SQL check
            String sql = "select *from user where username = ? and password = ? and Staff_ID= ? and position= ?";
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,ID);
            preparedStatement.setString(4,Position);
            //start to execute the sql
             resultSet=preparedStatement.executeQuery();
            //to determine the execute method
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtils.Close(resultSet,preparedStatement,connection);
        }
        return false;
    }


//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("please enter your username！");
//        String username =sc.next();
//        System.out.println("please enter your password！");
//        String password =sc.next();
//
//        boolean flag = new Login().login(username,password);
//        if (flag){
//            System.out.println("Successfully login！");
//        }else
//        {
//            System.out.println("The error existed in username or password!");
//        }
//    }
}
