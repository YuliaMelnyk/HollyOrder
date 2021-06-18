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

/**
 * The type Dessert controller.
 * Class controller for page dessert.fxml
 */

public class DessertController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label apr.
     */
    @FXML
    Label quantityLabelApr, /**
     * The Quantity label yog.
     */
    quantityLabelYog, /**
     * The Quantity label ban.
     */
    quantityLabelBan, /**
     * The Quantity label tir.
     */
    quantityLabelTir;

    /**
     * The Price apr.
     */
    @FXML
    Label priceApr, /**
     * The Price yog.
     */
    priceYog, /**
     * The Price ban.
     */
    priceBan, /**
     * The Price tir.
     */
    priceTir;

    /**
     * The Apr name.
     */
    @FXML
    Label aprName, /**
     * The Yog name.
     */
    yogName, /**
     * The Ban name.
     */
    banName, /**
     * The Tir name.
     */
    tirName;

    /**
     * The Scroll pane.
     */
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
            clickOnRowTableOrder(cartTable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * On back to menu.
     * Click on Image Back
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onBackToMenu(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles/homeStyle.css").toExternalForm());
        Main.getPrimaryStage().setScene(scene);
    }

    /**
     * On cart apr.
     * add to Cart Apricot Dessert
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartApr(MouseEvent event) throws IOException {
        service.getProduct(aprName.getText(), Integer.parseInt(quantityLabelApr.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart yog.
     * add to Cart Frozen Yogurt
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartYog(MouseEvent event) throws IOException {
        service.getProduct(yogName.getText(), Integer.parseInt(quantityLabelYog.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart ban.
     * add to Cart Banana Cake
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartBan(MouseEvent event) throws IOException {
        service.getProduct(banName.getText(), Integer.parseInt(quantityLabelBan.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart tir.
     * add to Cart Tiramisu
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartTir(MouseEvent event) throws IOException {
        service.getProduct(tirName.getText(), Integer.parseInt(quantityLabelTir.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click apr.
     * plus quantity of Apricot Dessert
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickApr(MouseEvent event) {
        onPlus(quantityLabelApr);
    }

    /**
     * On minus click apr.
     * minus quantity of Apricot Dessert
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickApr(MouseEvent event) {
        onMinus(quantityLabelApr);
    }

    /**
     * On plus yog.
     * plus quantity of Frozen Yogurt
     *
     * @param event the event
     */

    @FXML
    public void onPlusYog(MouseEvent event) {
        onPlus(quantityLabelYog);
    }

    /**
     * On minus yog.
     * minus quantity of Frozen Yogurt
     *
     * @param event the event
     */

    @FXML
    public void onMinusYog(MouseEvent event) {
        onMinus(quantityLabelYog);
    }

    /**
     * On minus ban.
     * minus quantity of Banana Cake
     *
     * @param event the event
     */

    @FXML
    public void onMinusBan(MouseEvent event) {
        onMinus(quantityLabelBan);
    }

    /**
     * On plus ban.
     * plus quantity of Banana Cake
     *
     * @param event the event
     */

    @FXML
    public void onPlusBan(MouseEvent event) {
        onPlus(quantityLabelBan);
    }

    /**
     * On minus tir.
     * minus quantity of Tiramisu
     *
     * @param event the event
     */

    @FXML
    public void onMinusTir(MouseEvent event) {
        onMinus(quantityLabelTir);
    }

    /**
     * On plus tir.
     * plus quantity of Tiramisu
     *
     * @param event the event
     */

    @FXML
    public void onPlusTir(MouseEvent event) {
        onPlus(quantityLabelTir);
    }

}
