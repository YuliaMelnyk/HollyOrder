package model;

import javax.persistence.*;

/**
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    private String name;
    private String image;
    private String description;
    private double price;
    private String category;

}
