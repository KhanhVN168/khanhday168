/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Snack_Shop;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author icom
 */
public class Client_Controller {
    @FXML
    private JFXButton btnMenu;

    @FXML
    private JFXButton btnFeedback;
    
    @FXML
    private JFXButton btnSearch;
    
        @FXML
    void btnFeedback(ActionEvent event) {

    }

    @FXML
    void btnMenuClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToChoose();
    }

    @FXML
    void btnSearchClick(ActionEvent event) {

    }
}
