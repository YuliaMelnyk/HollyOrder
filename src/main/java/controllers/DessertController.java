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


public class DessertController implements Initializable {

    @FXML
    Label quantityLabelApr, quantityLabelYog, quantityLabelBan, quantityLabelTir;

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


    //add to Cart Apricot Dessert
    @FXML
    public void onCartApr(MouseEvent event) {

    }

    //add to Cart Frozen Yogurt
    @FXML
    public void onCartYog(MouseEvent event) {

    }

    //add to Cart Banana Cake
    @FXML
    public void onCartBan(MouseEvent event) {

    }

    //add to Cart Tiramisu
    @FXML
    public void onCartTir(MouseEvent event) {

    }



    //plus quantity of Apricot Dessert
    @FXML
    public void onPlusClickApr(MouseEvent event) {
        onPlus(quantityLabelApr);
    }

    //minus quantity of Apricot Dessert
    @FXML
    public void onMinusClickApr(MouseEvent event) {
        onMinus(quantityLabelApr);
    }

    //plus quantity of Frozen Yogurt
    @FXML
    public void onPlusYog(MouseEvent event) {
        onPlus(quantityLabelYog);
    }

    //minus quantity of Frozen Yogurt
    @FXML
    public void onMinusYog(MouseEvent event) {
        onMinus(quantityLabelYog);
    }

    //minus quantity of Banana Cake
    @FXML
    public void onMinusBan(MouseEvent event) {
        onMinus(quantityLabelBan);
    }

    //plus quantity of Banana Cake
    @FXML
    public void onPlusBan(MouseEvent event) {
        onPlus(quantityLabelBan);
    }

    //minus quantity of Tiramisu
    @FXML
    public void onMinusTir(MouseEvent event) {
        onMinus(quantityLabelTir);
    }

    //plus quantity of Tiramisu
    @FXML
    public void onPlusTir(MouseEvent event) {
        onPlus(quantityLabelTir);
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
