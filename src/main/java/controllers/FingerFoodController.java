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
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

// class controller for page fingerfoods.fxml
public class FingerFoodController extends BaseController implements Initializable {

    @FXML
    Label quantityLabelFCh, quantityLabelKCh, quantityLabelShrimp, quantityLabelCroquetas;

    @FXML
    ImageView plusFCh;

    @FXML
    Label priceFriedChicken, priceKoreanFried, priceShrimps, priceCroquetas;

    @FXML
    Label friedName, korName, chimName, croName;

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

    //add to Cart Fried Chicken
    @FXML
    public void onCartFCh(MouseEvent event) throws IOException {
        service.getProduct(friedName.getText(), Integer.parseInt(quantityLabelFCh.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Korean Chicken
    @FXML
    public void onCartKCh(MouseEvent event) throws IOException {
        service.getProduct(korName.getText(), Integer.parseInt(quantityLabelKCh.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Shrimp
    @FXML
    public void onCartShr(MouseEvent event) throws IOException {
        service.getProduct(chimName.getText(), Integer.parseInt(quantityLabelShrimp.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Croquetas
    @FXML
    public void onCartCr(MouseEvent event) throws IOException {
        service.getProduct(croName.getText(), Integer.parseInt(quantityLabelCroquetas.getText()));
        addCartElements(scrollPane);
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

}
