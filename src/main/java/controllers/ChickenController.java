package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import login.Main;
import model.Product;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ChickenController extends BaseController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelCh, quantityLabelTan, quantityLabelMoj, quantityLabelSal, quantityLabelKeb;

    @FXML
    Label priceCh, priceETan, priceSal, priceMoj, priceKeb;

    @FXML
    Label hoonName, tanName, SalName, mojoName, kebName;

    @FXML
    ScrollPane scrollPane;


    private ProductService service = new ProductService();
    private Product product = new Product();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements(scrollPane);
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


    //add to Cart Chicken HOON
    @FXML
    public void onCartCh(MouseEvent event) throws IOException {
        service.getProduct(hoonName.getText(), Integer.parseInt(quantityLabelCh.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Mojo Chicken
    @FXML
    public void onCartMoj(MouseEvent event) throws IOException {
        service.getProduct(mojoName.getText(), Integer.parseInt(quantityLabelMoj.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Tandoori chicken
    @FXML
    public void onCartTan(MouseEvent event) throws IOException {
        service.getProduct(tanName.getText(), Integer.parseInt(quantityLabelTan.getText()));
        addCartElements(scrollPane);
    }

    //add to Cart Chicken Salad
    @FXML
    public void onCartSal(MouseEvent event) throws IOException {
        service.getProduct(SalName.getText(), Integer.parseInt(quantityLabelSal.getText()));
        addCartElements(scrollPane);
    }
    //add to Cart Chicken Kebab
    @FXML
    public void onCartKeb(MouseEvent event) throws IOException {
        service.getProduct(kebName.getText(), Integer.parseInt(quantityLabelKeb.getText()));
        addCartElements(scrollPane);
    }

    //plus quantity of Chicken HOON
    @FXML
    public void onPlusClickCh(MouseEvent event) {
        onPlus(quantityLabelCh);
    }

    //minus quantity of Chicken HOON
    @FXML
    public void onMinusClickCh(MouseEvent event) {
        onMinus(quantityLabelCh);
    }

    //plus quantity of Tandoori chicken
    @FXML
    public void onPlusTan(MouseEvent event) {
        onPlus(quantityLabelTan);
    }

    //minus quantity of Tandoori chicken
    @FXML
    public void onMinusTan(MouseEvent event) {
        onMinus(quantityLabelTan);
    }

    //minus quantity of Mojo Chicken
    @FXML
    public void onMinusMoj(MouseEvent event) {
        onMinus(quantityLabelMoj);
    }

    //plus quantity of Mojo Chicken
    @FXML
    public void onPlusMoj(MouseEvent event) {
        onPlus(quantityLabelMoj);
    }

    //minus quantity of Chicken Salad
    @FXML
    public void onMinusSal(MouseEvent event) {
        onMinus(quantityLabelSal);
    }

    //plus quantity of Chicken Salad
    @FXML
    public void onPlusSal(MouseEvent event) {
        onPlus(quantityLabelSal);
    }

    //minus quantity of Chicken Kebab
    @FXML
    public void onMinusKeb(MouseEvent event) {
        onMinus(quantityLabelKeb);
    }

    //plus quantity of Chicken Kebab
    @FXML
    public void onPlusKeb(MouseEvent event) {
        onPlus(quantityLabelKeb);
    }


}
