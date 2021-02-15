package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Product;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import static controllers.LoginController.cartItems;

/**
 * @author sergeymelnik on 15/2/21
 * @project HollyOrder
 */
public abstract class BaseController {

    //method using foreach to take element book and fill fxml element in positions in gridpane
    public void addCartElements(ScrollPane scrollPane) throws IOException {

        GridPane gridPane = new GridPane();
        // set paddings
        gridPane.setVgap(20);
        gridPane.setHgap(20);

        //cartTab.setContent(gridPane);
        scrollPane.setContent(gridPane);

        int index = -1;

        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            index++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/product_item.fxml"));
            VBox vBox = (VBox) loader.load();
            vBox.setMaxHeight(250);

            Product product = entry.getKey();
            //set quantity
            int quantity = entry.getValue();
            // set name
            String name = product.getName();
            // calculate price
            int price = quantity*(int)product.getPrice();

            ((Label) loader.getNamespace().get("quantity")).setText(String.valueOf(price));
            //put image value en label from DB
            if (product.getImage() != null) {
                // create a background image
                Image image = new Image(new ByteArrayInputStream(product.getImage()));
                // set background image
                ((ImageView) loader.getNamespace().get("productImage")).setImage(image);
            }
            //put name value en label from DB
            ((Label) loader.getNamespace().get("name")).setText(product.getName());

            //add each element in gridpane
            gridPane.add(vBox, index % 2, index/2);
        }
    }
}
