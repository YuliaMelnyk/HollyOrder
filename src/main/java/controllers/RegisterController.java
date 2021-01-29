package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import login.Main;
import model.User;
import services.RegisterService;

import java.io.IOException;

/**
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */
public class RegisterController {


    @FXML
    private Button btn_register;

    @FXML
    private TextField tf_email, tf_password, tf_name, tf_surname, tf_phone;


    @FXML
    void insertInto(MouseEvent event) {

        if(fieldIsEmpty()) {
            showAlertFieldEmpty();
        }else {
            RegisterService registerService = new RegisterService();
            User user = newUserData();
            registerService.save(user);

            Alert errorSendMail = new Alert(Alert.AlertType.CONFIRMATION);
            errorSendMail.setTitle("You are sign in");
            errorSendMail.setHeaderText("Confirmation");
            errorSendMail.setContentText("Please click in the Log in button and login ");
            errorSendMail.show();
        }
    }

    private User newUserData() {

        String email = tf_email.getText();
        String password = tf_password.getText();
        String name = tf_name.getText();
        String surname = tf_surname.getText();
        String phone = tf_phone.getText();

        return new User(email, password, name, surname,  phone);
    }

    @FXML
    void newUserLogin(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    private boolean fieldIsEmpty() {
        return "".equals(tf_email.getText()) || "".equals(tf_password.getText()) || "".equals(tf_name.getText())
                || "".equals(tf_surname.getText()) || "".equals(tf_phone.getText());
    }

    private void showAlertFieldEmpty() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Error");
        alert.setContentText("Some of the fields on the Registration Form are not filled");
        alert.setTitle("Please fill all required fields. ");
        alert.show();
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

}
