package model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author yuliiamelnyk on 15/2/21
 * @project HollyOrder
 */

// Class for save orders into database
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private long id;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
