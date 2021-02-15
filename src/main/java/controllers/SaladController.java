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

/**
 * @author yuliiamelnik on 11/2/21
 * @project HollyOrder
 */

public class SaladController extends BaseController implements Initializable, GeneralController {

    @FXML
    Label quantityLabelTun, quantityLabelOc, quantityLabelCes, quantityLabelPr;

    @FXML
    Label priceTuna, priceTCes, priceOc, pricePr;

    @FXML
    Label tunaName, cesName, octName, primName;

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


    //add to Cart Tuna Salad
    @FXML
    public void onCartTun(MouseEvent event) {
        service.getProduct(tunaName.getText(), Integer.parseInt(quantityLabelTun.getText()));
    }

    //add to Cart Octopus Salad
    @FXML
    public void onCartOc(MouseEvent event) {
        service.getProduct(octName.getText(), Integer.parseInt(quantityLabelOc.getText()));
    }

    //add to Cart Cesar Salad
    @FXML
    public void onCartCes(MouseEvent event) {
        service.getProduct(cesName.getText(), Integer.parseInt(quantityLabelCes.getText()));
    }

    //add to Cart Primavera Salad
    @FXML
    public void onCartPr(MouseEvent event) {
        service.getProduct(primName.getText(), Integer.parseInt(quantityLabelPr.getText()));
    }


    //plus quantity of Tuna Salad
    @FXML
    public void onPlusClickTun(MouseEvent event) {
        onPlus(quantityLabelTun);
    }

    //minus quantity of Tuna Salad
    @FXML
    public void onMinusClickTun(MouseEvent event) {
        onMinus(quantityLabelTun);
    }

    //plus quantity of Octopus Salad
    @FXML
    public void onPlusOc(MouseEvent event) {
        onPlus(quantityLabelOc);
    }

    //minus quantity of Octopus Salad
    @FXML
    public void onMinusOc(MouseEvent event) {
        onMinus(quantityLabelOc);
    }

    //minus quantity of Cesar Salad
    @FXML
    public void onMinusCes(MouseEvent event) {
        onMinus(quantityLabelCes);
    }

    //plus quantity of Cesar Salad
    @FXML
    public void onPlusCes(MouseEvent event) {
        onPlus(quantityLabelCes);
    }

    //minus quantity of Primavera Salad
    @FXML
    public void onMinusPr(MouseEvent event) {
        onMinus(quantityLabelPr);
    }

    //plus quantity of Primavera Salad
    @FXML
    public void onPlusPr(MouseEvent event) {
        onPlus(quantityLabelPr);
    }


    public void onPlus(Label label) {
        int q = Integer.parseInt(label.getText());
        label.setText(String.valueOf(++q));
    }

    public void onMinus(Label label) {
        int q = Integer.parseInt(label.getText());
        if (q == 1) {
            label.setText("1");
        } else {
            label.setText(String.valueOf(--q));
        }
    }

}
