package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import login.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //click en category of Finger Foods
    @FXML
    public void clickFinger(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fingerfoods.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/fingerFoodStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Western Soups
    @FXML
    public void clickWestern(MouseEvent event) {

    }


    //click en category of Sandwiches
    @FXML
    public void clickSandwiches(MouseEvent event) {

    }

    //click en category of Salads
    @FXML
    public void clickSalads(MouseEvent event) {

    }

    //click en category of Chicken
    @FXML
    public void clickChicken(MouseEvent event) {

    }

    //click en category of Burgers
    @FXML
    public void clickBurger(MouseEvent event) {

    }

    //click en category of Drinks
    @FXML
    public void clickDrinks(MouseEvent event) {

    }

    //click en category of Drinks
    @FXML
    public void clickDesserts(MouseEvent event) {

    }
}
