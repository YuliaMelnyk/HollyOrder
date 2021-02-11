package services;

import model.Product;

/**
 * @author sergeymelnik on 11/2/21
 * @project HollyOrder
 */
public interface ServiceInterface {

    void addProduct(Product product);

    void getProduct(String name, int quantity);
}
