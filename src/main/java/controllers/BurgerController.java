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


public class BurgerController implements Initializable, GeneralController {

    //labels of quantities
    @FXML
    Label quantityLabelSa, quantityLabelTex, quantityLabelGr, quantityLabelBean, quantityLabelShr;

    //labels of prices
    @FXML
    Label priceSa, priceETex, priceBean, pricePork, priceShr;

    //labels of names
    @FXML
    Label salmonName, texasName, beanName, porkName, shrimpName;

    @FXML
    ImageView plusFCh;

    private ProductService service = new ProductService();
    private Product product = new Product();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //click on Image Back
    @FXML
    public void onBackToMenu(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/homeStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }


    //add to Cart Salmon Burger
    @FXML
    public void onCartSa(MouseEvent event) {
        service.getProduct(salmonName.getText(), Integer.parseInt(priceETex.getText()));
    }

    //add to Cart Grilled Pork Burger
    @FXML
    public void onCartGr(MouseEvent event) {
        service.getProduct(porkName.getText(), Integer.parseInt(pricePork.getText()));
    }

    //add to Cart Texas Burger
    @FXML
    public void onCartTex(MouseEvent event) {
        service.getProduct(texasName.getText(), Integer.parseInt(priceSa.getText()));
    }

    //add to Cart Black Bean Burger
    @FXML
    public void onCartBean(MouseEvent event) {
        service.getProduct(beanName.getText(), Integer.parseInt(priceBean.getText()));
    }

    //add to Cart Garlic Shrimp Burger
    @FXML
    public void onCartShr(MouseEvent event) {
        service.getProduct(shrimpName.getText(), Integer.parseInt(priceShr.getText()));
    }


    //plus quantity of Salmon Burger
    @FXML
    public void onPlusClickSa(MouseEvent event) {
        onPlus(quantityLabelSa);
    }

    //minus quantity of Salmon Burger
    @FXML
    public void onMinusClickSa(MouseEvent event) {
        onMinus(quantityLabelSa);
    }

    //plus quantity of Texas Burger
    @FXML
    public void onPlusTex(MouseEvent event) {
        onPlus(quantityLabelTex);
    }

    //minus quantity of Texas Burger
    @FXML
    public void onMinusTex(MouseEvent event) {
        onMinus(quantityLabelTex);
    }

    //minus quantity of Grilled Pork Burger
    @FXML
    public void onMinusGr(MouseEvent event) {
        onMinus(quantityLabelGr);
    }

    //plus quantity of Grilled Pork Burger
    @FXML
    public void onPlusGr(MouseEvent event) {
        onPlus(quantityLabelGr);
    }

    //minus quantity of Black Bean Burger
    @FXML
    public void onMinusBean(MouseEvent event) {
        onMinus(quantityLabelBean);
    }

    //plus quantity of Black Bean Burger
    @FXML
    public void onPlusBean(MouseEvent event) {
        onPlus(quantityLabelBean);
    }

    //minus quantity of Garlic Shrimp Burger
    @FXML
    public void onMinusShr(MouseEvent event) {
        onMinus(quantityLabelShr);
    }

    //plus quantity of Garlic Shrimp Burger
    @FXML
    public void onPlusShr(MouseEvent event) {
        onPlus(quantityLabelShr);
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
