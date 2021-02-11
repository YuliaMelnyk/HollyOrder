package model;

import javax.persistence.*;

/**
 * @author sergeymelnik on 11/2/21
 * @project HollyOrder
 */
@Entity
@Table(name = "CartItem")
class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart shoppingCart;
    @Column(name = "quantity")
    private int quantity;

    public CartItem(Long id, Product product, Cart shoppingCart, int quantity) {
        this.id = id;
        this.product = product;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

