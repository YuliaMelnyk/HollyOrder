package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import login.Main;
import model.Product;
import model.User;
import services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */
// class controller for page login.fxml
public class LoginController implements Initializable {

    // list of products that add to card
    public static List<Product> products;

    // list of products that add to orders
    public static List<Product> productsDetailOrder = new ArrayList<>();

    // list of products that add to card
    public static HashMap<Product, Integer> cartItems = new HashMap<>();

    @FXML
    private TextField tf_email, tf_password;

    // user static - the one in all session
    public static User u1;

    private UserService userService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize userServise
        userService = new UserService();
        // initialize cartList
        products = new ArrayList<>();
    }

    // method check if user login and password are correct
    @FXML
    void login(MouseEvent event) throws IOException {

        String email = tf_email.getText();
        String password = tf_password.getText();
        boolean isLogin = userService.login(email, password);
        if (isLogin) {
            u1 = userService.takeDataBylogin(email, password);
            sign();
            // if not correct open the alert window
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error");
            error.setContentText("Enter valid login/password");
            error.setTitle("Wrong login or password");
            error.show();
        }
    }

    // method to open a registration scene when the user click in button
    @FXML
    void registrate(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/registration.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    // method to go to the home page if user login correctly
    @FXML
    void sign() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/homeStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

}

