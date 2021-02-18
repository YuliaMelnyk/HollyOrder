package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
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

    public CartItem(Timestamp timestamp, double totalPrice) {
        this.timestamp = timestamp;
        this.totalPrice = totalPrice;
    }

    public CartItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

