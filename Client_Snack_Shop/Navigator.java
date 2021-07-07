/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Snack_Shop;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {

    public static final String CLIENT_FXML = "Client_user.fxml";
    public static final String CHOOSE_FXML = "Choose.fxml";
    public static final String FOOD_FXML = "Food.fxml";
    public static final String DRINK_FXML = "Drink.fxml";

    private FXMLLoader loader;
    private Stage stage = null;

    private static Navigator nav = null;

    private Navigator() {
    }

    public static Navigator getInstance() {
        if (nav == null) {
            nav = new Navigator();
        }

        return nav;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    private void goTo(String fxml) throws IOException {
        this.loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
    }

    public void goToClient() throws IOException {
        this.goTo(CLIENT_FXML);
    }
    public void goToChoose() throws IOException {
        this.goTo(CHOOSE_FXML);
    }
    public void goToDrink() throws IOException {
        this.goTo(DRINK_FXML);
    }
    public void goToFood() throws IOException {
        this.goTo(FOOD_FXML);
    }
}
