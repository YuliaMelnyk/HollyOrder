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

    }


}
