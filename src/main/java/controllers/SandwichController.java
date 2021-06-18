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
 * The type Sandwich controller.
 * class controller for page sandwich.fxml
 */

public class SandwichController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label por.
     */
    @FXML
    Label quantityLabelPor, /**
     * The Quantity label egg.
     */
    quantityLabelEgg, /**
     * The Quantity label to.
     */
    quantityLabelTo, /**
     * The Quantity label pr.
     */
    quantityLabelPr;

    /**
     * The Price pork.
     */
    @FXML
    Label pricePork, /**
     * The Price egg.
     */
    priceEgg, /**
     * The Price pr.
     */
    pricePr, /**
     * The Price to.
     */
    priceTo;

    /**
     * The Pork name.
     */
    @FXML
    Label porkName, /**
     * The Egg name.
     */
    eggName, /**
     * The Pros name.
     */
    prosName, /**
     * The Tofu name.
     */
    tofuName;

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
     * click on Image Back
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
     * On cart por.
     * add to Cart Pork Sandwich
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartPor(MouseEvent event) throws IOException {
        service.getProduct(porkName.getText(), Integer.parseInt(quantityLabelPor.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart to.
     * add to Cart Tofu Sandwich
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartTo(MouseEvent event) throws IOException {
        service.getProduct(tofuName.getText(), Integer.parseInt(quantityLabelTo.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart egg.
     * add to Cart Egg Sandwich
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartEgg(MouseEvent event) throws IOException {
        service.getProduct(eggName.getText(), Integer.parseInt(quantityLabelEgg.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart pr.
     * add to Cart Prosciutto Sandwich
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartPr(MouseEvent event) throws IOException {
        service.getProduct(prosName.getText(), Integer.parseInt(quantityLabelPr.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click por.
     * plus quantity of Pork Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickPor(MouseEvent event) {
        onPlus(quantityLabelPor);
    }

    /**
     * On minus click por.
     * minus quantity of Pork Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickPor(MouseEvent event) {
        onMinus(quantityLabelPor);
    }

    /**
     * On plus egg.
     * plus quantity of Egg Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onPlusEgg(MouseEvent event) {
        onPlus(quantityLabelEgg);
    }

    /**
     * On minus egg.
     * minus quantity of Egg Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onMinusEgg(MouseEvent event) {
        onMinus(quantityLabelEgg);
    }

    /**
     * On minus to.
     * minus quantity of Tofu Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onMinusTo(MouseEvent event) {
        onMinus(quantityLabelTo);
    }

    /**
     * On plus to.
     * plus quantity of Tofu Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onPlusTo(MouseEvent event) {
        onPlus(quantityLabelTo);
    }

    /**
     * On minus pr.
     * minus quantity of Prosciutto Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onMinusPr(MouseEvent event) {
        onMinus(quantityLabelPr);
    }

    /**
     * On plus pr.
     * plus quantity of Prosciutto Sandwich
     *
     * @param event the event
     */

    @FXML
    public void onPlusPr(MouseEvent event) {
        onPlus(quantityLabelPr);
    }

}
