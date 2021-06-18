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

/**
 * The type Soup controller.
 * class controller for page soup.fxml
 */

public class SoupController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label car.
     */
    @FXML
    Label quantityLabelCar, /**
     * The Quantity label tom.
     */
    quantityLabelTom, /**
     * The Quantity label lem.
     */
    quantityLabelLem;

    /**
     * The Plus f ch.
     */
    @FXML
    ImageView plusFCh;

    /**
     * The Price carrot.
     */
    @FXML
    Label priceCarrot, /**
     * The Price tom.
     */
    priceTom, /**
     * The Price lem.
     */
    priceLem;

    /**
     * The Car name.
     */
    @FXML
    Label carName, /**
     * The Tom name.
     */
    tomName, /**
     * The Lem name.
     */
    lemName;

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
     * On cart car.
     * add to Cart Carrot Soup
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartCar(MouseEvent event) throws IOException {
        service.getProduct(carName.getText(), Integer.parseInt(quantityLabelCar.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart tom.
     * add to Cart Tomato Soup
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartTom(MouseEvent event) throws IOException {
        service.getProduct(tomName.getText(), Integer.parseInt(quantityLabelTom.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart lem.
     * add to Cart Lemon Soup
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartLem(MouseEvent event) throws IOException {
        service.getProduct(lemName.getText(), Integer.parseInt(quantityLabelLem.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click car.
     * plus quantity of Carrot Soup
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickCar(MouseEvent event) {
        onPlus(quantityLabelCar);
    }

    /**
     * On minus click car.
     * minus quantity of Carrot Soup
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickCar(MouseEvent event) {
        onMinus(quantityLabelCar);
    }

    /**
     * On plus tom.
     * plus quantity of Tomato Soup
     *
     * @param event the event
     */

    @FXML
    public void onPlusTom(MouseEvent event) {
        onPlus(quantityLabelTom);
    }

    /**
     * On minus tom.
     * minus quantity of Tomato Soup
     *
     * @param event the event
     */

    @FXML
    public void onMinusTom(MouseEvent event) {
        onMinus(quantityLabelTom);
    }

    /**
     * On minus lem.
     * minus quantity of Lemon Soup
     *
     * @param event the event
     */

    @FXML
    public void onMinusLem(MouseEvent event) {
        onMinus(quantityLabelLem);
    }

    /**
     * On plus lem.
     * plus quantity of Lemon Soup
     *
     * @param event the event
     */

    @FXML
    public void onPlusLem(MouseEvent event) {
        onPlus(quantityLabelLem);
    }

}
