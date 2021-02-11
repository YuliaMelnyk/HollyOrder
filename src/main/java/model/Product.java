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
    @Column(name = "product_id", unique = true, nullable = false)
    private long product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;



    public Product(long product_id, String name, byte[] image, String description, double price) {
        this.product_id = product_id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }

    public long getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
