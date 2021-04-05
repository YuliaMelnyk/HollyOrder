package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import login.Main;
import model.User;
import services.RegisterService;

import java.io.IOException;

/**
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */

// class controller for page registration.fxml
public class RegisterController {

    @FXML
    private TextField tf_email, tf_password, tf_name, tf_surname, tf_phone;

    @FXML
    Button btn_register;

    @FXML
    void insertInto(MouseEvent event) throws IOException {
        Window owner = btn_register.getScene().getWindow();
        // check if field is empty
        if (fieldIsEmpty()) {
            showAlertFieldEmpty();
            return;
            // for check email used regex
        } else if (!(tf_email.getText().matches("\\b[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}\\b"))) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email correctly");
            return;
        } else {
            // Saving our new user in database
            RegisterService registerService = new RegisterService();
            User user = newUserData();
            registerService.save(user);

            // show a window of confirmation
            Alert errorSendMail = new Alert(Alert.AlertType.CONFIRMATION);
            errorSendMail.setTitle("You are sign in");
            errorSendMail.setHeaderText("Confirmation");
            errorSendMail.setContentText("Please click in the Log in button and login ");
            errorSendMail.show();
            sign();
        }
    }

    // method for saving our values in local variables and return a new user
    private User newUserData() {
        String email = tf_email.getText();
        String password = tf_password.getText();
        String name = tf_name.getText();
        String surname = tf_surname.getText();
        String phone = tf_phone.getText();

        return new User(email, password, name, surname, phone);
    }

    // method to return in login page when user click back button
    @FXML
    void onBackToLogin(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene = new Scene(parent);
        Main.getPrimaryStage().setScene(scene);
    }

    // method for check if the text field is empty
    private boolean fieldIsEmpty() {
        return "".equals(tf_email.getText()) || "".equals(tf_password.getText()) || "".equals(tf_name.getText())
                || "".equals(tf_surname.getText()) || "".equals(tf_phone.getText());
    }

    // /method for show alert window when field is empty
    private void showAlertFieldEmpty() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Error");
        alert.setContentText("Some of the fields on the Registration Form are not filled");
        alert.setTitle("Please fill all required fields. ");
        alert.show();
    }

    //method to show alert window if email isn't correct
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
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
