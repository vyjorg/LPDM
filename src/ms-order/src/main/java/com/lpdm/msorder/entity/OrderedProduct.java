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

    @Transient
    @MapsId("productId")
    private Product product = new Product(orderedProductPK.getProductId(), "Fromage");

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
