package controllers;


import java.io.IOException;
import java.net.URL;


import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import login.Main;
import model.User;
import services.UserService;


/**
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */


public class LoginController implements Initializable {


    @FXML
    Circle min;
    @FXML
    Circle close;
    ActionEvent event;

    @FXML
    private TextField tf_email, tf_password;


    @FXML
    Label login;
    private double xOffset = 0;
    private double yOffset = 0;

    public static User u1;

    private UserService userService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userService = new UserService();
    }

    @FXML
    void login(MouseEvent event) throws IOException {

        String email = tf_email.getText();
        String password = tf_password.getText();
        boolean isLogin = userService.login(email, password);
        if (isLogin) {
            u1 = userService.takeDataBylogin(email, password);

            sign();

        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error");
            error.setContentText("Enter valid login/password");
            error.setTitle("Wrong login or password");
            error.show();
        }
    }
    @FXML
    public void back(MouseEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("pin.fxml"));
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        blah.setOnMousePressed(event1 -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
        blah.setOnMouseDragged(event12 -> {
            appStage.setX(event12.getScreenX() - xOffset);
            appStage.setY(event12.getScreenY() - yOffset);
        });

        Scene scene = new Scene(blah);


        appStage.setScene(scene);
        appStage.show();

    }

    /**** minimize ****/
    @FXML
    public void minclick(MouseEvent event) {

        ((Stage) ((Circle) event.getSource()).getScene().getWindow()).setIconified(true);


    }

    /**** close screen ****/
    @FXML
    public void closeclick(MouseEvent event) {


        System.exit(0);


    }

    @FXML
    void registrate(MouseEvent event) throws  IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/registration.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void sign() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/homeStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

}

