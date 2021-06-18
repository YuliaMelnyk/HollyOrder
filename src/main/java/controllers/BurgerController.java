package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
 * The type Burger controller.
 * Class controller for page burger,fxml
 */

public class BurgerController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label sa.
     */
    @FXML
    Label quantityLabelSa, /**
     * The Quantity label tex.
     */
    quantityLabelTex, /**
     * The Quantity label gr.
     */
    quantityLabelGr, /**
     * The Quantity label bean.
     */
    quantityLabelBean, /**
     * The Quantity label shr.
     */
    quantityLabelShr;

    /**
     * The Price sa.
     * labels of prices
     */

    @FXML
    Label priceSa, /**
     * The Price e tex.
     */
    priceETex, /**
     * The Price bean.
     */
    priceBean, /**
     * The Price pork.
     */
    pricePork, /**
     * The Price shr.
     */
    priceShr;

    /**
     * The Salmon name.
     */
    @FXML
    Label salmonName, /**
     * The Texas name.
     */
    texasName, /**
     * The Bean name.
     */
    beanName, /**
     * The Pork name.
     */
    porkName, /**
     * The Shrimp name.
     */
    shrimpName;

    /**
     * The Cart tab.
     */
    @FXML
    Tab cartTab;

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
     * On cart sa.
     * add to Cart Salmon Burger
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartSa(MouseEvent event) throws IOException {
        service.getProduct(salmonName.getText(), Integer.parseInt(quantityLabelTex.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart gr.
     * add to Cart Grilled Pork Burger
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartGr(MouseEvent event) throws IOException {
        service.getProduct(porkName.getText(), Integer.parseInt(quantityLabelGr.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart tex.
     * add to Cart Texas Burger
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartTex(MouseEvent event) throws IOException {
        service.getProduct(texasName.getText(), Integer.parseInt(quantityLabelSa.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart bean.
     * add to Cart Black Bean Burger
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartBean(MouseEvent event) throws IOException {
        service.getProduct(beanName.getText(), Integer.parseInt(quantityLabelBean.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart shr.
     * add to Cart Garlic Shrimp Burger
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartShr(MouseEvent event) throws IOException {
        service.getProduct(shrimpName.getText(), Integer.parseInt(quantityLabelShr.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click sa.
     * plus quantity of Salmon Burger
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickSa(MouseEvent event) {
        onPlus(quantityLabelSa);
    }

    /**
     * On minus click sa.
     * minus quantity of Salmon Burger
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickSa(MouseEvent event) {
        onMinus(quantityLabelSa);
    }

    /**
     * On plus tex.
     * plus quantity of Texas Burger
     *
     * @param event the event
     */

    @FXML
    public void onPlusTex(MouseEvent event) {
        onPlus(quantityLabelTex);
    }

    /**
     * On minus tex.
     * minus quantity of Texas Burger
     *
     * @param event the event
     */

    @FXML
    public void onMinusTex(MouseEvent event) {
        onMinus(quantityLabelTex);
    }

    /**
     * On minus gr.
     * minus quantity of Grilled Pork Burger
     *
     * @param event the event
     */

    @FXML
    public void onMinusGr(MouseEvent event) {
        onMinus(quantityLabelGr);
    }

    /**
     * On plus gr.
     * plus quantity of Grilled Pork Burger
     *
     * @param event the event
     */

    @FXML
    public void onPlusGr(MouseEvent event) {
        onPlus(quantityLabelGr);
    }

    /**
     * On minus bean.
     * minus quantity of Black Bean Burger
     *
     * @param event the event
     */

    @FXML
    public void onMinusBean(MouseEvent event) {
        onMinus(quantityLabelBean);
    }

    /**
     * On plus bean.
     * plus quantity of Black Bean Burger
     *
     * @param event the event
     */

    @FXML
    public void onPlusBean(MouseEvent event) {
        onPlus(quantityLabelBean);
    }

    /**
     * On minus shr.
     * minus quantity of Garlic Shrimp Burger
     *
     * @param event the event
     */

    @FXML
    public void onMinusShr(MouseEvent event) {
        onMinus(quantityLabelShr);
    }

    /**
     * On plus shr.
     * plus quantity of Garlic Shrimp Burger
     *
     * @param event the event
     */

    @FXML
    public void onPlusShr(MouseEvent event) {
        onPlus(quantityLabelShr);
    }

}
