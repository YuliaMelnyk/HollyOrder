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


public class SaladController implements Initializable {

    @FXML
    Label quantityLabelTun, quantityLabelOc, quantityLabelCes, quantityLabelPr;

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


    //add to Cart Tuna Salad
    @FXML
    public void onCartTun(MouseEvent event) {

    }

    //add to Cart Octopus Salad
    @FXML
    public void onCartOc(MouseEvent event) {

    }

    //add to Cart Cesar Salad
    @FXML
    public void onCartCes(MouseEvent event) {

    }

    //add to Cart Primavera Salad
    @FXML
    public void onCartPr(MouseEvent event) {

    }


    //plus quantity of Tuna Salad
    @FXML
    public void onPlusClickTun(MouseEvent event) {
        onPlus(quantityLabelTun);
    }

    //minus quantity of Tuna Salad
    @FXML
    public void onMinusClickTun(MouseEvent event) {
        onMinus(quantityLabelTun);
    }

    //plus quantity of Octopus Salad
    @FXML
    public void onPlusOc(MouseEvent event) {
        onPlus(quantityLabelOc);
    }

    //minus quantity of Octopus Salad
    @FXML
    public void onMinusOc(MouseEvent event) {
        onMinus(quantityLabelOc);
    }

    //minus quantity of Cesar Salad
    @FXML
    public void onMinusCes(MouseEvent event) {
        onMinus(quantityLabelCes);
    }

    //plus quantity of Cesar Salad
    @FXML
    public void onPlusCes(MouseEvent event) {
        onPlus(quantityLabelCes);
    }

    //minus quantity of Primavera Salad
    @FXML
    public void onMinusPr(MouseEvent event) {
        onMinus(quantityLabelPr);
    }

    //plus quantity of Primavera Salad
    @FXML
    public void onPlusPr(MouseEvent event) {
        onPlus(quantityLabelPr);
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
