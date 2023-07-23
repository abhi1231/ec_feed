package com.ec.entity;

import javax.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private String cart_item_id;

    private String cart_id;
    private String product_id;
    private String quantity;
    private String price;

    public String getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(String cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
