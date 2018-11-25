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

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
