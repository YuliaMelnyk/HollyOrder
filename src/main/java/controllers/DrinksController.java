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


public class DrinksController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelHib, quantityLabelCoc, quantityLabelBee, quantityLabelMilk;

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


    //add to Cart Hibiscus Lemonade
    @FXML
    public void onCartHib(MouseEvent event) {

    }

    //add to Cart Coca Cola
    @FXML
    public void onCartCoc(MouseEvent event) {

    }

    //add to Cart Craft Beer
    @FXML
    public void onCartBee(MouseEvent event) {

    }

    //add to Cart Milk Shake
    @FXML
    public void onCartMilk(MouseEvent event) {

    }



    //plus quantity of Hibiscus Lemonade
    @FXML
    public void onPlusClickHib(MouseEvent event) {
        onPlus(quantityLabelHib);
    }

    //minus quantity of Hibiscus Lemonade
    @FXML
    public void onMinusClickHib(MouseEvent event) {
        onMinus(quantityLabelHib);
    }

    //plus quantity of Coca Cola
    @FXML
    public void onPlusCoc(MouseEvent event) {
        onPlus(quantityLabelCoc);
    }

    //minus quantity of Coca Cola
    @FXML
    public void onMinusCoc(MouseEvent event) {
        onMinus(quantityLabelCoc);
    }

    //minus quantity of Craft Beer
    @FXML
    public void onMinusBee(MouseEvent event) {
        onMinus(quantityLabelBee);
    }

    //plus quantity of Craft Beer
    @FXML
    public void onPlusBee(MouseEvent event) {
        onPlus(quantityLabelBee);
    }

    //minus quantity of Milk Shake
    @FXML
    public void onMinusMilk(MouseEvent event) {
        onMinus(quantityLabelMilk);
    }

    //plus quantity of Milk Shake
    @FXML
    public void onPlusMilk(MouseEvent event) {
        onPlus(quantityLabelMilk);
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
