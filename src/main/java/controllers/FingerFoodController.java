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
 * The type Finger food controller.
 * class controller for page fingerfoods.fxml
 */

public class FingerFoodController extends BaseController implements Initializable {

    /**
     * The Quantity label f ch.
     */
    @FXML
    Label quantityLabelFCh, /**
     * The Quantity label k ch.
     */
    quantityLabelKCh, /**
     * The Quantity label shrimp.
     */
    quantityLabelShrimp, /**
     * The Quantity label croquetas.
     */
    quantityLabelCroquetas;

    /**
     * The Plus f ch.
     */
    @FXML
    ImageView plusFCh;

    /**
     * The Price fried chicken.
     */
    @FXML
    Label priceFriedChicken, /**
     * The Price korean fried.
     */
    priceKoreanFried, /**
     * The Price shrimps.
     */
    priceShrimps, /**
     * The Price croquetas.
     */
    priceCroquetas;

    /**
     * The Fried name.
     */
    @FXML
    Label friedName, /**
     * The Kor name.
     */
    korName, /**
     * The Chim name.
     */
    chimName, /**
     * The Cro name.
     */
    croName;

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
     * On cart f ch.
     * add to Cart Fried Chicken
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartFCh(MouseEvent event) throws IOException {
        service.getProduct(friedName.getText(), Integer.parseInt(quantityLabelFCh.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart k ch.
     * add to Cart Korean Chicken
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartKCh(MouseEvent event) throws IOException {
        service.getProduct(korName.getText(), Integer.parseInt(quantityLabelKCh.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart shr.
     * add to Cart Shrimp
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartShr(MouseEvent event) throws IOException {
        service.getProduct(chimName.getText(), Integer.parseInt(quantityLabelShrimp.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart cr.
     * add to Cart Croquetas
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartCr(MouseEvent event) throws IOException {
        service.getProduct(croName.getText(), Integer.parseInt(quantityLabelCroquetas.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click f ch.
     * plus quantity of Fried Chicken
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickFCh(MouseEvent event) {
        onPlus(quantityLabelFCh);
    }

    /**
     * On minus click f ch.
     * minus quantity of Korean Chicken
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickFCh(MouseEvent event) {
        onMinus(quantityLabelFCh);
    }

    /**
     * On plus k ch.
     * plus quantity of Korean Chicken
     *
     * @param event the event
     */

    @FXML
    public void onPlusKCh(MouseEvent event) {
        onPlus(quantityLabelKCh);
    }

    /**
     * On minus k ch.
     * minus quantity of Fried Chicken
     *
     * @param event the event
     */

    @FXML
    public void onMinusKCh(MouseEvent event) {
        onMinus(quantityLabelKCh);
    }

    /**
     * On minus shr.
     * minus quantity of Shrimp
     *
     * @param event the event
     */

    @FXML
    public void onMinusShr(MouseEvent event) {
        onMinus(quantityLabelShrimp);
    }

    /**
     * On plus shr.
     * plus quantity of Shrimp
     *
     * @param event the event
     */

    @FXML
    public void onPlusShr(MouseEvent event) {
        onPlus(quantityLabelShrimp);
    }

    /**
     * On minus cr.
     * minus quantity of Croquetas
     *
     * @param event the event
     */

    @FXML
    public void onMinusCr(MouseEvent event) {
        onMinus(quantityLabelCroquetas);
    }

    /**
     * On plus cr.
     * plus quantity of Croquetas
     *
     * @param event the event
     */

    @FXML
    public void onPlusCr(MouseEvent event) {
        onPlus(quantityLabelCroquetas);
    }

}
