package services;

import dao.DAO.CartItemDAO;
import model.CartItem;
import model.Product;

import java.sql.Timestamp;


/**
 * The type Cart item service.
 *
 * @author yuliiamelnyk on 16/2/21
 * @project HollyOrder
 */
public class CartItemService implements ServiceInterface {
    private CartItemDAO cartItemDAO = new CartItemDAO();
    private CartItem cartItem;


    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void getProduct(String name, int quantity) {

    }

    // method to insert CartItem into DataBase in moment to put on Order
    public void insertCartItem(Timestamp timestamp, double totalprice, String productIds) {
        cartItem = new CartItem(timestamp, totalprice, productIds);
        cartItemDAO.insert(cartItem);
    }
}
