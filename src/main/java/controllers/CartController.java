package controllers;

import dao.DAO.CartDAO;
import dao.DAO.ProductDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Product;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static controllers.HomeController.products;

/**
 * @author sergeymelnik on 9/2/21
 * @project HollyOrder
 */
public class CartController implements Initializable {

    private CartDAO cartDAO;

    @FXML
    GridPane gridPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCartElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method using foreach to take element book and fill fxml element in positions in gridpane
    private void addCartElements() throws IOException {

        GridPane gp = new GridPane();
        gp.setVgap(200);
        gp.setHgap(200);

        int index = -1;
        cartDAO = new CartDAO();


        for (Product product : products) {
            index++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/product_item.fxml"));
            VBox hb = (VBox) loader.load();
            hb.setMinHeight(350);

            //set isbn
            String Name = product.getName();

            //((Label) loader.getNamespace().get("isbn")).setText(currentISBN);
            //put image value en label from DB
            if (product.getImage() != null) {
                Image image = new Image(new ByteArrayInputStream(product.getImage()));
                ((ImageView) loader.getNamespace().get("bookImage")).setImage(image);
            }
            //put name value en label from DB
            //((Label) loader.getNamespace().get("name")).setText(book.getName());

            //add each element in gridpane
            gridPane.add(hb, index % 2, index/2);
        }
    }
}
