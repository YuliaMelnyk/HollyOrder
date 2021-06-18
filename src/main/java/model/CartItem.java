package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The type Cart item.
 *
 * @author yuliiamelnyk on 11/2/21
 * @project HollyOrder
 */
@Entity
@Table(name = "CartItem")
public class CartItem extends RecursiveTreeObject<CartItem> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private Timestamp timestamp;

    @Column(name = "total")
    private double totalPrice;

    @Column(name = "productIds")
    private String productIds;

    /**
     * Instantiates a new Cart item.
     *
     * @param timestamp  the timestamp
     * @param totalPrice the total price
     * @param productIds the product ids
     */
    public CartItem(Timestamp timestamp, double totalPrice, String productIds) {
        this.timestamp = timestamp;
        this.totalPrice = totalPrice;
        this.productIds = productIds;
    }

    /**
     * Instantiates a new Cart item.
     */
    public CartItem() {

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets product ids.
     *
     * @return the product ids
     */
    public String getProductIds() {
        return productIds;
    }

    /**
     * Sets product ids.
     *
     * @param productIds the product ids
     */
    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

