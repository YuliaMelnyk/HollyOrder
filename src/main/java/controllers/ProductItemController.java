package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import services.CartItemService;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static controllers.LoginController.*;

/**
 * @author yuliiamelnyk on 9/2/21
 * @project HollyOrder
 */
public class ProductItemController extends BaseController implements Initializable {

    @FXML
    Label totalPrice;

    private CartItemService service = new CartItemService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void putToOrder(MouseEvent mouseEvent) {
        double total = Double.valueOf(totalPrice.getText());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        service.insertCartItem(timestamp,total);
        cartItems.clear();
        products.clear();
    }
}
