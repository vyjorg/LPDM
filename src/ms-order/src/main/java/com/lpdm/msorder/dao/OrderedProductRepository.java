package com.lpdm.msorder.dao;

import com.lpdm.msorder.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
}
