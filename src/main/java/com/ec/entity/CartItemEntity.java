package com.ec.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cartitem")
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product1 product_id;



    private Long quantity;
    private double price;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }



    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
