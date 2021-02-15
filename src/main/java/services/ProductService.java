package services;

import dao.DAO.ProductDAO;
import model.Product;

import static controllers.LoginController.cartItems;
import static controllers.LoginController.products;

/**
 * @author yuliiamelnyk on 11/2/21
 * @project HollyOrder
 */
public class ProductService implements ServiceInterface{

    private ProductDAO productDAO = new ProductDAO();
    private Product product = new Product();

    @Override
    public void addProduct(Product product) {

    }

    //method to get Product by its Name from DataBase in moment to put in Cart and save it to List of Products
    @Override
    public void getProduct(String name, int quantity) {
        product = productDAO.getByName(name);
        products.add(product);
        cartItems.put(product, quantity);
    }
}
