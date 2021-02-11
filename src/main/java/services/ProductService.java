package services;

import dao.DAO.ProductDAO;
import model.Product;

import static controllers.HomeController.cartItems;
import static controllers.HomeController.products;

/**
 * @author sergeymelnik on 11/2/21
 * @project HollyOrder
 */
public class ProductService implements ServiceInterface{

    private ProductDAO productDAO = new ProductDAO();
    private Product product = new Product();
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void getProduct(String name, int quantity) {
        product = productDAO.getByName(name);
        products.add(product);
        cartItems.put(quantity, product);
    }
}
