package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import login.Main;
import model.Product;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DrinksController extends BaseController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelHib, quantityLabelCoc, quantityLabelBee, quantityLabelMilk;

    @FXML
    Label priceHib, priceCoc, priceBee, priceMilk;

    @FXML
    Label hibName, colaName, beerName, shakeName;

    @FXML
    ScrollPane scrollPane;

    private ProductService service = new ProductService();
    private Product product = new Product();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements(scrollPane);
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

    //add to Cart Hibiscus Lemonade
    @FXML
    public void onCartHib(MouseEvent event) throws IOException {
        service.getProduct(hibName.getText(), Integer.parseInt(quantityLabelHib.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Coca Cola
    @FXML
    public void onCartCoc(MouseEvent event) throws IOException {
        service.getProduct(colaName.getText(), Integer.parseInt(quantityLabelCoc.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Craft Beer
    @FXML
    public void onCartBee(MouseEvent event) throws IOException {
        service.getProduct(beerName.getText(), Integer.parseInt(quantityLabelBee.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Milk Shake
    @FXML
    public void onCartMilk(MouseEvent event) throws IOException {
        service.getProduct(shakeName.getText(), Integer.parseInt(quantityLabelMilk.getText()));
        addCartElements(scrollPane);
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

}
