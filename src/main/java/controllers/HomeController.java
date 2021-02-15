package controllers;

import com.jfoenix.controls.JFXButton;
import dao.DAO.CartDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import login.Main;
import model.Product;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static controllers.LoginController.cartItems;
import static controllers.LoginController.products;

/**
 * @author yuliiamelnyk on 2/9/21
 * @project HollyOrder
 */

public class HomeController extends BaseController implements Initializable {

    @FXML
    Tab cartTab;

    @FXML
    ScrollPane scrollPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements(scrollPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
