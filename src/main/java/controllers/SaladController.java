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
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

/**
 * The type Salad controller.
 * class controller for page salad.fxml
 *
 * @author yuliiamelnik on 11/2/21
 * @project HollyOrder
 */

public class SaladController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label tun.
     */
    @FXML
    Label quantityLabelTun, /**
     * The Quantity label oc.
     */
    quantityLabelOc, /**
     * The Quantity label ces.
     */
    quantityLabelCes, /**
     * The Quantity label pr.
     */
    quantityLabelPr;

    /**
     * The Price tuna.
     */
    @FXML
    Label priceTuna, /**
     * The Price t ces.
     */
    priceTCes, /**
     * The Price oc.
     */
    priceOc, /**
     * The Price pr.
     */
    pricePr;

    /**
     * The Tuna name.
     */
    @FXML
    Label tunaName, /**
     * The Ces name.
     */
    cesName, /**
     * The Oct name.
     */
    octName, /**
     * The Prim name.
     */
    primName;

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
     * On cart tun.
     * add to Cart Tuna Salad
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartTun(MouseEvent event) throws IOException {
        service.getProduct(tunaName.getText(), Integer.parseInt(quantityLabelTun.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart oc.
     * add to Cart Octopus Salad
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartOc(MouseEvent event) throws IOException {
        service.getProduct(octName.getText(), Integer.parseInt(quantityLabelOc.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart ces.
     * add to Cart Cesar Salad
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartCes(MouseEvent event) throws IOException {
        service.getProduct(cesName.getText(), Integer.parseInt(quantityLabelCes.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart pr.
     * add to Cart Primavera Salad
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartPr(MouseEvent event) throws IOException {
        service.getProduct(primName.getText(), Integer.parseInt(quantityLabelPr.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click tun.
     * plus quantity of Tuna Salad
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickTun(MouseEvent event) {
        onPlus(quantityLabelTun);
    }

    /**
     * On minus click tun.
     * minus quantity of Tuna Salad
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickTun(MouseEvent event) {
        onMinus(quantityLabelTun);
    }

    /**
     * On plus oc.
     * plus quantity of Octopus Salad
     *
     * @param event the event
     */

    @FXML
    public void onPlusOc(MouseEvent event) {
        onPlus(quantityLabelOc);
    }

    /**
     * On minus oc.
     * minus quantity of Octopus Salad
     *
     * @param event the event
     */

    @FXML
    public void onMinusOc(MouseEvent event) {
        onMinus(quantityLabelOc);
    }

    /**
     * On minus ces.
     * minus quantity of Cesar Salad
     *
     * @param event the event
     */

    @FXML
    public void onMinusCes(MouseEvent event) {
        onMinus(quantityLabelCes);
    }

    /**
     * On plus ces.
     * plus quantity of Cesar Salad
     *
     * @param event the event
     */

    @FXML
    public void onPlusCes(MouseEvent event) {
        onPlus(quantityLabelCes);
    }

    /**
     * On minus pr.
     * minus quantity of Primavera Salad
     *
     * @param event the event
     */

    @FXML
    public void onMinusPr(MouseEvent event) {
        onMinus(quantityLabelPr);
    }

    /**
     * On plus pr.
     * plus quantity of Primavera Salad
     *
     * @param event the event
     */

    @FXML
    public void onPlusPr(MouseEvent event) {
        onPlus(quantityLabelPr);
    }
}
