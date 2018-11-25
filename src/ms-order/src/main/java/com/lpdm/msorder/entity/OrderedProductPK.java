package com.lpdm.msorder.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderedProductPK implements Serializable {

    @Column(name = "order_id")
    protected int orderId;

    @Column(name = "product_id")
    protected int productId;

    public OrderedProductPK() {}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
