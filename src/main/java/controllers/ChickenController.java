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
 * The type Chicken controller.
 * Class controller for page chicken.fxml
 */

public class ChickenController extends BaseController implements Initializable, GeneralController {

    /**
     * The Quantity label ch.
     */
    @FXML
    Label quantityLabelCh, /**
     * The Quantity label tan.
     */
    quantityLabelTan, /**
     * The Quantity label moj.
     */
    quantityLabelMoj, /**
     * The Quantity label sal.
     */
    quantityLabelSal, /**
     * The Quantity label keb.
     */
    quantityLabelKeb;

    /**
     * The Price ch.
     */
    @FXML
    Label priceCh, /**
     * The Price e tan.
     */
    priceETan, /**
     * The Price sal.
     */
    priceSal, /**
     * The Price moj.
     */
    priceMoj, /**
     * The Price keb.
     */
    priceKeb;

    /**
     * The Hoon name.
     */
    @FXML
    Label hoonName, /**
     * The Tan name.
     */
    tanName, /**
     * The Sal name.
     */
    SalName, /**
     * The Mojo name.
     */
    mojoName, /**
     * The Keb name.
     */
    kebName;

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
     * On cart ch.
     * Add to Cart Chicken HOON
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartCh(MouseEvent event) throws IOException {
        service.getProduct(hoonName.getText(), Integer.parseInt(quantityLabelCh.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart moj.
     * add to Cart Mojo Chicken
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartMoj(MouseEvent event) throws IOException {
        service.getProduct(mojoName.getText(), Integer.parseInt(quantityLabelMoj.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart tan.
     * add to Cart Tandoori chicken
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartTan(MouseEvent event) throws IOException {
        service.getProduct(tanName.getText(), Integer.parseInt(quantityLabelTan.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart sal.
     * add to Cart Chicken Salad
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartSal(MouseEvent event) throws IOException {
        service.getProduct(SalName.getText(), Integer.parseInt(quantityLabelSal.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On cart keb.
     * add to Cart Chicken Kebab
     *
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onCartKeb(MouseEvent event) throws IOException {
        service.getProduct(kebName.getText(), Integer.parseInt(quantityLabelKeb.getText()));
        addCartElements(scrollPane);
    }

    /**
     * On plus click ch.
     * plus quantity of Chicken HOON
     *
     * @param event the event
     */

    @FXML
    public void onPlusClickCh(MouseEvent event) {
        onPlus(quantityLabelCh);
    }

    /**
     * On minus click ch.
     * minus quantity of Chicken HOON
     *
     * @param event the event
     */

    @FXML
    public void onMinusClickCh(MouseEvent event) {
        onMinus(quantityLabelCh);
    }

    /**
     * On plus tan.
     * plus quantity of Tandoori chicken
     *
     * @param event the event
     */

    @FXML
    public void onPlusTan(MouseEvent event) {
        onPlus(quantityLabelTan);
    }

    /**
     * On minus tan.
     * minus quantity of Tandoori chicken
     *
     * @param event the event
     */

    @FXML
    public void onMinusTan(MouseEvent event) {
        onMinus(quantityLabelTan);
    }

    /**
     * On minus moj.
     * minus quantity of Mojo Chicken
     *
     * @param event the event
     */

    @FXML
    public void onMinusMoj(MouseEvent event) {
        onMinus(quantityLabelMoj);
    }

    /**
     * On plus moj.
     * plus quantity of Mojo Chicken
     *
     * @param event the event
     */

    @FXML
    public void onPlusMoj(MouseEvent event) {
        onPlus(quantityLabelMoj);
    }

    /**
     * On minus sal.
     * minus quantity of Chicken Salad
     *
     * @param event the event
     */

    @FXML
    public void onMinusSal(MouseEvent event) {
        onMinus(quantityLabelSal);
    }

    /**
     * On plus sal.
     * plus quantity of Chicken Salad
     *
     * @param event the event
     */

    @FXML
    public void onPlusSal(MouseEvent event) {
        onPlus(quantityLabelSal);
    }

    /**
     * On minus keb.
     * minus quantity of Chicken Kebab
     *
     * @param event the event
     */

    @FXML
    public void onMinusKeb(MouseEvent event) {
        onMinus(quantityLabelKeb);
    }

    /**
     * On plus keb.
     * plus quantity of Chicken Kebab
     *
     * @param event the event
     */

    @FXML
    public void onPlusKeb(MouseEvent event) {
        onPlus(quantityLabelKeb);
    }

}
