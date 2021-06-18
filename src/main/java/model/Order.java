package model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * The type Order.
 * Class for save orders into database
 *
 * @author yuliiamelnyk on 15/2/21
 * @project HollyOrder
 */

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private long id;

    /**
     * Instantiates a new Order.
     */
    public Order() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

}
