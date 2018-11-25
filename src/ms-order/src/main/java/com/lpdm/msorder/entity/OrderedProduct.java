package com.lpdm.msorder.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordered_product", schema = "public")
public class OrderedProduct {

    @EmbeddedId
    private OrderedProductPK orderedProductPK = new OrderedProductPK();


    @ManyToOne
    @MapsId("orderId")
    private Order order;

    @Column
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
