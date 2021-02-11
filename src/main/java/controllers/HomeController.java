package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import login.Main;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author yuliiamelnyk on 2/9/21
 * @project HollyOrder
 */

public class HomeController implements Initializable {

    //list of products that add to card
    public static List<Product> products = new ArrayList<>();

    public static HashMap<Integer, Product> cartItems = new HashMap<>();



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
    public void clickWestern(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/soup.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/soup.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }


    //click en category of Sandwiches
    @FXML
    public void clickSandwiches(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/sandwiches.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Salads
    @FXML
    public void clickSalads(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/salads.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Chicken
    @FXML
    public void clickChicken(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/chicken.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Burgers
    @FXML
    public void clickBurger(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/burger.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Drinks
    @FXML
    public void clickDrinks(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/drinks.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    //click en category of Desserts
    @FXML
    public void clickDesserts(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/dessert.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }
}
