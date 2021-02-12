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
import model.Product;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SandwichController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelPor, quantityLabelEgg, quantityLabelTo, quantityLabelPr;

    @FXML
    Label pricePork, priceEgg, pricePr, priceTo;

    @FXML
    Label porkName, eggName, prosName, tofuName;

    private ProductService service = new ProductService();
    private Product product = new Product();


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

    //add to Cart Pork Sandwich
    @FXML
    public void onCartPor(MouseEvent event) {
        service.getProduct(porkName.getText(), Integer.parseInt(pricePork.getText()));
    }

    //add to Cart Tofu Sandwich
    @FXML
    public void onCartTo(MouseEvent event) {
        service.getProduct(tofuName.getText(), Integer.parseInt(priceTo.getText()));
    }

    //add to Cart Egg Sandwich
    @FXML
    public void onCartEgg(MouseEvent event) {
        service.getProduct(eggName.getText(), Integer.parseInt(priceEgg.getText()));
    }

    //add to Cart Prosciutto Sandwich
    @FXML
    public void onCartPr(MouseEvent event) {
        service.getProduct(prosName.getText(), Integer.parseInt(pricePr.getText()));
    }


    //plus quantity of Pork Sandwich
    @FXML
    public void onPlusClickPor(MouseEvent event) {
        onPlus(quantityLabelPor);
    }

    //minus quantity of Pork Sandwich
    @FXML
    public void onMinusClickPor(MouseEvent event) {
        onMinus(quantityLabelPor);
    }

    //plus quantity of Egg Sandwich
    @FXML
    public void onPlusEgg(MouseEvent event) {
        onPlus(quantityLabelEgg);
    }

    //minus quantity of Egg Sandwich
    @FXML
    public void onMinusEgg(MouseEvent event) {
        onMinus(quantityLabelEgg);
    }

    //minus quantity of Tofu Sandwich
    @FXML
    public void onMinusTo(MouseEvent event) {
        onMinus(quantityLabelTo);
    }

    //plus quantity of Tofu Sandwich
    @FXML
    public void onPlusTo(MouseEvent event) {
        onPlus(quantityLabelTo);
    }

    //minus quantity of Prosciutto Sandwich
    @FXML
    public void onMinusPr(MouseEvent event) {
        onMinus(quantityLabelPr);
    }

    //plus quantity of Prosciutto Sandwich
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
