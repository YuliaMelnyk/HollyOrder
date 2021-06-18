package services;

import model.CartItem;
import model.Product;
import java.sql.Timestamp;
import java.util.List;

/**
 * The interface Service interface.
 *
 * @author yuliiamelnyk on 11/2/21
 * @project HollyOrder
 */
public interface ServiceInterface {

    /**
     * Add product.
     *
     * @param product the product
     */
    void addProduct(Product product);

    /**
     * Gets product.
     *
     * @param name     the name
     * @param quantity the quantity
     */
    void getProduct(String name, int quantity);

    /**
     * Insert cart item.
     *
     * @param timestamp  the timestamp
     * @param totalPrice the total price
     * @param productIds the product ids
     */
    void insertCartItem(Timestamp timestamp, double totalPrice, String productIds);

}
