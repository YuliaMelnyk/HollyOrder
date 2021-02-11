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
    @OneToMany(mappedBy = "shoppingCart",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
                    CascadeType.DETACH, CascadeType.MERGE})
    private List<Product> products;
    @Column(name = "totalPrice")
    private double totalPrice;

    public Cart(long id, List<Product> products) {
        this.id = id;
        this.date = new Date();
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

