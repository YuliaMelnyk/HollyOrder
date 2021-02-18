package controllers;

import dao.DAO.CartDAO;
import dao.DAO.OrderDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author yuliiamelnyk on 9/2/21
 * @project HollyOrder
 */
public class CartController extends BaseController implements Initializable {

    private CartDAO cartDAO;
    private OrderDAO orderDAO;



    @FXML
    GridPane gridPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


}
