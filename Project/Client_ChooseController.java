/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import Project.Data.ProjectSignUp;
import Project.DbProject.DbProject;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author icom
 */
public class Client_ChooseController {
    @FXML
    private ImageView anh1;

    @FXML
    private ImageView anh2;

    @FXML
    private ImageView anh3;

    @FXML
    private ImageView anh4;

    @FXML
    private ImageView anh5;

    @FXML
    private ImageView anh6;

    @FXML
    private ImageView anh7;

    @FXML
    private ImageView anh8;
    
    private ProjectSignUp psu;
    @FXML
    private JFXButton btnViewFood;

    @FXML
    private JFXButton btnViewDrink;
    
    @FXML
    private JFXButton menu;
    @FXML
    private Text user;
    @FXML
    void btnmenu(ActionEvent event) throws IOException {
        ProjectSignUp account = extractSignUpFromFields();
        Nagatice.getInstance().goToClient(account);
    }
    @FXML
    void btnViewDrinkClick(ActionEvent event) throws IOException {
        Nagatice.getInstance().goToDrink();
    }

    @FXML
    void btnViewFoodClick(ActionEvent event) throws IOException {
        Nagatice.getInstance().goToFood();
    }
    
    public void initialize(ProjectSignUp p){
        this.psu = p;
        if(this.psu != null){
            user.setText(p.getAccount());
        }
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connection conn = DbProject.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ImgLink FROM Products ");
            while (rs.next()) {
                list.add(rs.getString("ImgLink"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        String name = list.get(0);
        Image image = new Image(getClass().getResourceAsStream(name));
        Image image1 = new Image(getClass().getResourceAsStream(list.get(1)));
        Image image2 = new Image(getClass().getResourceAsStream(list.get(2)));
        Image image3 = new Image(getClass().getResourceAsStream(list.get(3)));
        Image image4 = new Image(getClass().getResourceAsStream(list.get(4)));
        Image image5 = new Image(getClass().getResourceAsStream(list.get(5)));
        Image image6 = new Image(getClass().getResourceAsStream(list.get(6)));
        Image image7 = new Image(getClass().getResourceAsStream(list.get(7)));
        System.out.println(image.getWidth());
        anh1.setImage(image);
        anh2.setImage(image1);
        anh3.setImage(image2);
        anh4.setImage(image3);
        anh5.setImage(image4);
        anh6.setImage(image5);
        anh7.setImage(image6);
        anh8.setImage(image7);
        System.out.println(list);
    
    }
    
    private ProjectSignUp extractSignUpFromFields() {
        ProjectSignUp sign = new ProjectSignUp(); 
        sign.setAccount(user.getText());
        return sign;
    }

}
