package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author sergeymelnik on 9/2/21
 * @project HollyOrder
 */
@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", unique = true, nullable = false)
    private long id;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    private Product product;
    @Column(name = "totalPrice")
    private double totalPrice;

    public Cart(long id, Product product) {
        this.id = id;
        this.date = new Date();
        this.product = product;
    }

    public Cart() {
    }

    public long getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

