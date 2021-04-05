package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

// class controller for page sandwich.fxml
public class SandwichController extends BaseController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelPor, quantityLabelEgg, quantityLabelTo, quantityLabelPr;

    @FXML
    Label pricePork, priceEgg, pricePr, priceTo;

    @FXML
    Label porkName, eggName, prosName, tofuName;

    @FXML
    ScrollPane scrollPane;

    // TableView and columns
    @FXML
    private TableView<CartItem> cartTable;
    @FXML
    private TableColumn<CartItem, Long> id;
    @FXML
    private TableColumn<CartItem, Timestamp> timestamp;
    @FXML
    private TableColumn<CartItem, Double> totalPrice;

    private ProductService service = new ProductService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements(scrollPane);
            addToOrder(cartTable, id, timestamp, totalPrice);
            clickOnRowTableOrder(cartTable);
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

    //add to Cart Pork Sandwich
    @FXML
    public void onCartPor(MouseEvent event) throws IOException {
        service.getProduct(porkName.getText(), Integer.parseInt(quantityLabelPor.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Tofu Sandwich
    @FXML
    public void onCartTo(MouseEvent event) throws IOException {
        service.getProduct(tofuName.getText(), Integer.parseInt(quantityLabelTo.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Egg Sandwich
    @FXML
    public void onCartEgg(MouseEvent event) throws IOException {
        service.getProduct(eggName.getText(), Integer.parseInt(quantityLabelEgg.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Prosciutto Sandwich
    @FXML
    public void onCartPr(MouseEvent event) throws IOException {
        service.getProduct(prosName.getText(), Integer.parseInt(quantityLabelPr.getText()));
        addCartElements(scrollPane);
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

}
