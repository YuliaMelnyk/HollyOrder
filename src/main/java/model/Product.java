package model;

import javax.persistence.*;

/**
 * The type Product.
 *
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


    /**
     * Instantiates a new Product.
     *
     * @param product_id  the product id
     * @param name        the name
     * @param image       the image
     * @param description the description
     * @param price       the price
     */
    public Product(long product_id, String name, byte[] image, String description, double price) {
        this.product_id = product_id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;

    }

    /**
     * Instantiates a new Product.
     */
    public Product() {

    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public long getProduct_id() {
        return product_id;
    }

    /**
     * Gets product id string.
     *
     * @return the product id string
     */
    public String getProductIdString() {
        return Long.toString(product_id);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get image byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
