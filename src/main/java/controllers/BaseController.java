package controllers;

import dao.DAO.CartItemDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.CartItem;
import model.Product;
import services.LocalDateTimeAttributeConverter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static controllers.LoginController.cartItems;

/**
 * @author yuliiamelnyk on 15/2/21
 * @project HollyOrder
 */
public abstract class BaseController extends LocalDateTimeAttributeConverter {

    private CartItemDAO cartItemDAO = new CartItemDAO();

    private CartItem orderItem = new CartItem();
    private List<CartItem> orderItems = new ArrayList<>();


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
        ((Label) loader.getNamespace().get("totalPrice")).setText(String.valueOf(totalPrice));
        if (index < 0) {
            gridPane.add(hBox, 0, 0);
        } else {
            gridPane.add(hBox, (index + 1) % 2, (index + 2) / 2);
        }
    }

    public void addToOrder(TableView<CartItem> cartTable, TableColumn<CartItem, Long> id,
                           TableColumn<CartItem, Timestamp> timestamp,
                           TableColumn<CartItem, Double> totalPrice) {

        // Define data in an Observable list and add data as you want to show inside the table
        ObservableList<CartItem> tempItems = FXCollections.observableArrayList();

        orderItems = cartItemDAO.getAll();
        for (CartItem cartItem :
                orderItems) {

            tempItems.add(cartItem);
        }
        // Associate data with columns
        id.setCellValueFactory(new PropertyValueFactory<CartItem, Long>("id"));
        timestamp.setCellValueFactory(new PropertyValueFactory<CartItem, Timestamp>("timestamp"));

        // set a Date Column
        timestamp.setCellFactory(column -> {
            return new TableCell<CartItem, Timestamp>() {
                @Override
                protected void updateItem(Timestamp item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(String.valueOf(item));

                    }
                }
            };
        });
        totalPrice.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("totalPrice"));
        // Add data inside the table
        cartTable.setItems(tempItems);
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
