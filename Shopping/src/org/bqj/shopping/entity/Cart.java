package org.bqj.shopping.entity;

import java.sql.Timestamp;

public class Cart {
    private Integer cartId;

    private Timestamp cartCreateTime;

    private Integer customerId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Timestamp getCartCreateTime() {
        return cartCreateTime;
    }

    public void setCartCreateTime(Timestamp cartCreateTime) {
        this.cartCreateTime = cartCreateTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}