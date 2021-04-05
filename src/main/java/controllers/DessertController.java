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
import javafx.scene.input.MouseEvent;
import login.Main;
import model.CartItem;
import model.Product;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

// class controller for page dessert.fxml
public class DessertController extends BaseController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelApr, quantityLabelYog, quantityLabelBan, quantityLabelTir;

    @FXML
    Label priceApr, priceYog, priceBan, priceTir;

    @FXML
    Label aprName, yogName, banName, tirName;

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
    private Product product = new Product();


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

    //add to Cart Apricot Dessert
    @FXML
    public void onCartApr(MouseEvent event) throws IOException {
        service.getProduct(aprName.getText(), Integer.parseInt(quantityLabelApr.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Frozen Yogurt
    @FXML
    public void onCartYog(MouseEvent event) throws IOException {
        service.getProduct(yogName.getText(), Integer.parseInt(quantityLabelYog.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Banana Cake
    @FXML
    public void onCartBan(MouseEvent event) throws IOException {
        service.getProduct(banName.getText(), Integer.parseInt(quantityLabelBan.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Tiramisu
    @FXML
    public void onCartTir(MouseEvent event) throws IOException {
        service.getProduct(tirName.getText(), Integer.parseInt(quantityLabelTir.getText()));
        addCartElements(scrollPane);
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

}
