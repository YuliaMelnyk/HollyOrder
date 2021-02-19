package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import login.Main;
import model.CartItem;
import model.Product;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;


public class BurgerController extends BaseController implements Initializable, GeneralController {

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
    Tab cartTab;

    @FXML
    ScrollPane scrollPane;

    @FXML
    private TableView<CartItem> cartTable;
    @FXML
    private TableColumn<CartItem, Long> id;
    @FXML
    private TableColumn<CartItem, Timestamp> timestamp;
    @FXML
    private TableColumn<CartItem, Double> totalPrice;

    private ProductService service = new ProductService();
    private Product product = new Product();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements(scrollPane);
            addToOrder(cartTable, id, timestamp, totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void onCartSa(MouseEvent event) throws IOException {
        service.getProduct(salmonName.getText(), Integer.parseInt(quantityLabelTex.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Grilled Pork Burger
    @FXML
    public void onCartGr(MouseEvent event) throws IOException {
        service.getProduct(porkName.getText(), Integer.parseInt(quantityLabelGr.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Texas Burger
    @FXML
    public void onCartTex(MouseEvent event) throws IOException {
        service.getProduct(texasName.getText(), Integer.parseInt(quantityLabelSa.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Black Bean Burger
    @FXML
    public void onCartBean(MouseEvent event) throws IOException {
        service.getProduct(beanName.getText(), Integer.parseInt(quantityLabelBean.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Garlic Shrimp Burger
    @FXML
    public void onCartShr(MouseEvent event) throws IOException {
        service.getProduct(shrimpName.getText(), Integer.parseInt(quantityLabelShr.getText()));
        addCartElements(scrollPane);
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


}
