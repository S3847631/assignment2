package sample;

import Utils.JDBCUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WardNurse {


    @FXML
    private AnchorPane mainFrame;

    private final HashMap<Integer, ImageView> bed = new HashMap<>();
    private final List<Integer> maleBeds = new ArrayList<>();
    private final List<Integer> femaleBeds = new ArrayList<>();

    public void initialize(){
        registerAllClickEvent();
        queryDB();
        update();
        //System.out.println(bed.get(0));
    }



    private void registerAllClickEvent() {
        List<Node> nodes = mainFrame.getChildren();

        int i=0;
        for (Node node : nodes){
            if(node instanceof ImageView){
                bed.put(i++, (ImageView) node);
                node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Stage primaryStage = (Stage) node.getScene().getWindow();
                        primaryStage.close();
                        WardInfoNurse page = new WardInfoNurse();//新窗口类
                        Stage stage = new Stage();
                        try {
                            page.start(stage);//打开新窗口
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void queryDB() {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "select Gender, BedID from resident";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("Gender").equals("Male")) {
                    maleBeds.add(rs.getInt("BedID"));
                } else {
                    femaleBeds.add(rs.getInt("BedID"));
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    private void update() {
        for (int maleID :
                maleBeds) {
            bed.get(maleID).setImage(new Image("pictures/bedmale.png"));
        }

        for (int femaleID :
                femaleBeds) {
            bed.get(femaleID).setImage(new Image("pictures/bedfemale.png"));
        }
    }
}
