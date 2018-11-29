package com.lpdm.msorder.controller;

import com.lpdm.msorder.dao.OrderDao;
import com.lpdm.msorder.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger log = LogManager.getLogger(this.getClass());

    private final OrderDao orderDao;
    private final UserController userController;
    private final StoreController storeController;
    private final ProductController productController;

    @Autowired
    public OrderController(StoreController storeController, OrderDao orderDao,
                           UserController userController, ProductController productController) {
        this.storeController = storeController;
        this.orderDao = orderDao;
        this.userController = userController;
        this.productController = productController;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order getOrderById(@PathVariable int id){

        Optional<Order> optionalOrder = orderDao.findById(id);

        if(optionalOrder.isPresent()){

            Order order = optionalOrder.get();

            Store store = storeController.findStoreById(order.getStoreId());
            if(store != null) store.setId(order.getStoreId());
            else log.warn("Store object is null");
            order.setStore(store);

            User user = userController.findUserById(order.getCustomerId());
            if(user != null) user.setId(order.getCustomerId());
            else log.warn("User object is null");
            order.setCustomer(user);

            for(OrderedProduct orderedProduct : order.getOrderedProducts()){
                int productId = orderedProduct.getOrderedProductPK().getProductId();
                Product product = productController.findProductById(productId);
                if(product != null) product.setId(productId);
                else log.warn("Product is null");
                orderedProduct.setProduct(product);
            }

            return order;
        }
        else return null;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order saveOrder(@Valid @RequestBody Order order){

        return orderDao.save(order);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order updateOrder(@Valid @RequestBody Order order){

        return orderDao.save(order);
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order deleteOrder(@Valid @RequestBody Order order){

        return orderDao.save(order);
    }
}