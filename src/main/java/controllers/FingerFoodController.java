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


public class FingerFoodController implements Initializable {

    @FXML
    Label quantityLabelFCh, quantityLabelKCh, quantityLabelShrimp, quantityLabelCroquetas;

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


    //add to Cart Fried Chicken
    @FXML
    public void onCartFCh(MouseEvent event) {

    }

    //add to Cart Korean Chicken
    @FXML
    public void onCartKCh(MouseEvent event) {

    }

    //add to Cart Shrimp
    @FXML
    public void onCartShr(MouseEvent event) {

    }

    //add to Cart Croquetas
    @FXML
    public void onCartCr(MouseEvent event) {

    }

    //plus quantity of Fried Chicken
    @FXML
    public void onPlusClickFCh(MouseEvent event) {
        onPlus(quantityLabelFCh);
    }

    //minus quantity of Korean Chicken
    @FXML
    public void onMinusClickFCh(MouseEvent event) {
        onMinus(quantityLabelFCh);
    }

    //plus quantity of Korean Chicken
    @FXML
    public void onPlusKCh(MouseEvent event) {
        onPlus(quantityLabelKCh);
    }

    //minus quantity of Fried Chicken
    @FXML
    public void onMinusKCh(MouseEvent event) {
        onMinus(quantityLabelKCh);
    }

    //minus quantity of Shrimp
    @FXML
    public void onMinusShr(MouseEvent event) {
        onMinus(quantityLabelShrimp);
    }

    //plus quantity of Shrimp
    @FXML
    public void onPlusShr(MouseEvent event) {
        onPlus(quantityLabelShrimp);
    }

    //minus quantity of Croquetas
    @FXML
    public void onMinusCr(MouseEvent event) {
        onMinus(quantityLabelCroquetas);
    }

    //plus quantity of Croquetas
    @FXML
    public void onPlusCr(MouseEvent event) {
        onPlus(quantityLabelCroquetas);
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
