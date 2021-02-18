package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.CartItemService;

import java.io.IOException;
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
    Label totalPr;

    private CartItemService service = new CartItemService();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void putToOrder(MouseEvent mouseEvent) throws IOException {
        double total = Double.valueOf(totalPr.getText());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        service.insertCartItem(timestamp,total);
        cartItems.clear();
        products.clear();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/WindowAccept.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
