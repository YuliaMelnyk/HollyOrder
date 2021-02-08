package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import login.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SoupController implements Initializable {

    @FXML
    Label quantityLabelCar, quantityLabelTom, quantityLabelLem;

    @FXML
    ImageView plusFCh;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //labelFriedChicken.setText(LoginController.u1.getName());
    }

    //click on Image Back
    @FXML
    public void onBackToMenu(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/homeStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }


    //add to Cart Carrot Soup
    @FXML
    public void onCartCar(MouseEvent event) {

    }

    //add to Cart Tomato Soup
    @FXML
    public void onCartTom(MouseEvent event) {

    }

    //add to Cart Lemon Soup
    @FXML
    public void onCartLem(MouseEvent event) {

    }


    //plus quantity of Carrot Soup
    @FXML
    public void onPlusClickCar(MouseEvent event) {
        onPlus(quantityLabelCar);
    }

    //minus quantity of Carrot Soup
    @FXML
    public void onMinusClickCar(MouseEvent event) {
        onMinus(quantityLabelCar);
    }

    //plus quantity of Tomato Soup
    @FXML
    public void onPlusTom(MouseEvent event) {
        onPlus(quantityLabelTom);
    }

    //minus quantity of Tomato Soup
    @FXML
    public void onMinusTom(MouseEvent event) {
        onMinus(quantityLabelTom);
    }

    //minus quantity of Lemon Soup
    @FXML
    public void onMinusLem(MouseEvent event) {
        onMinus(quantityLabelLem);
    }

    //plus quantity of Lemon Soup
    @FXML
    public void onPlusLem(MouseEvent event) {
        onPlus(quantityLabelLem);
    }


    public void onPlus(Label label) {
        int q = Integer.parseInt(label.getText());
        label.setText(String.valueOf(++q));
    }

    public void onMinus(Label label) {
        int q = Integer.parseInt(label.getText());
        if (q == 1) {
            label.setText("1");
        } else {
            label.setText(String.valueOf(--q));
        }
    }

}
