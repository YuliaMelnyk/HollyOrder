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

/**
 * The type Drinks controller.
 * class controller for page drinks.fxml
 */

public class DrinksController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label hib.
     */
    @FXML
    Label quantityLabelHib, /**
     * The Quantity label coc.
     */
    quantityLabelCoc, /**
     * The Quantity label bee.
     */
    quantityLabelBee, /**
     * The Quantity label milk.
     */
    quantityLabelMilk;

    /**
     * The Price hib.
     */
    @FXML
    Label priceHib, /**
     * The Price coc.
     */
    priceCoc, /**
     * The Price bee.
     */
    priceBee, /**
     * The Price milk.
     */
    priceMilk;

    /**
     * The Hib name.
     */
    @FXML
    Label hibName, /**
     * The Cola name.
     */
    colaName, /**
     * The Beer name.
     */
    beerName, /**
     * The Shake name.
     */
    shakeName;

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
     * On cart hib.
     * add to Cart Hibiscus Lemonade
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartHib(MouseEvent event) throws IOException {
        service.getProduct(hibName.getText(), Integer.parseInt(quantityLabelHib.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart coc.
     * add to Cart Coca Cola
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartCoc(MouseEvent event) throws IOException {
        service.getProduct(colaName.getText(), Integer.parseInt(quantityLabelCoc.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart bee.
     * add to Cart Craft Beer
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartBee(MouseEvent event) throws IOException {
        service.getProduct(beerName.getText(), Integer.parseInt(quantityLabelBee.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart milk.
     * add to Cart Milk Shake
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartMilk(MouseEvent event) throws IOException {
        service.getProduct(shakeName.getText(), Integer.parseInt(quantityLabelMilk.getText()));
        addCartElements(scrollPane);
    }


    /**
     * On plus click hib.
     * plus quantity of Hibiscus Lemonade
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickHib(MouseEvent event) {
        onPlus(quantityLabelHib);
    }

    /**
     * On minus click hib.
     * minus quantity of Hibiscus Lemonade
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickHib(MouseEvent event) {
        onMinus(quantityLabelHib);
    }

    /**
     * On plus coc.
     * plus quantity of Coca Cola
     *
     * @param event the event
     */

    @FXML
    public void onPlusCoc(MouseEvent event) {
        onPlus(quantityLabelCoc);
    }

    /**
     * On minus coc.
     * minus quantity of Coca Cola
     *
     * @param event the event
     */

    @FXML
    public void onMinusCoc(MouseEvent event) {
        onMinus(quantityLabelCoc);
    }

    /**
     * On minus bee.
     * minus quantity of Craft Beer
     *
     * @param event the event
     */

    @FXML
    public void onMinusBee(MouseEvent event) {
        onMinus(quantityLabelBee);
    }

    /**
     * On plus bee.
     * plus quantity of Craft Beer
     *
     * @param event the event
     */

    @FXML
    public void onPlusBee(MouseEvent event) {
        onPlus(quantityLabelBee);
    }

    /**
     * On minus milk.
     * minus quantity of Milk Shake
     *
     * @param event the event
     */

    @FXML
    public void onMinusMilk(MouseEvent event) {
        onMinus(quantityLabelMilk);
    }

    /**
     * On plus milk.
     * plus quantity of Milk Shake
     *
     * @param event the event
     */

    @FXML
    public void onPlusMilk(MouseEvent event) {
        onPlus(quantityLabelMilk);
    }

}
