package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        int totalPrice = 0;

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
            int price = quantity * (int) product.getPrice();
            totalPrice += price;

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
            gridPane.add(vBox, index % 2, index / 2);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/total_price.fxml"));
        VBox hBox = loader.load();
        hBox.setMaxHeight(40);
        ((Label) loader.getNamespace().get("totalPrice")).setText(String.valueOf(totalPrice)+" €");
        if (index < 0) {
            gridPane.add(hBox, 0, 0);
        } else {
            gridPane.add(hBox, (index + 1) % 2, (index + 2) / 2);
        }
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
