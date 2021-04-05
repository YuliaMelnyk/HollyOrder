package services;

import model.CartItem;
import model.Product;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author yuliiamelnyk on 11/2/21
 * @project HollyOrder
 */
public interface ServiceInterface {

    void addProduct(Product product);

    void getProduct(String name, int quantity);

    void insertCartItem(Timestamp timestamp, double totalPrice, String productIds);

}
