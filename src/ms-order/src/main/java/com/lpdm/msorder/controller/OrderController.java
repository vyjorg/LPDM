package com.lpdm.msorder.controller;

import com.lpdm.msorder.dao.OrderDao;
import com.lpdm.msorder.entity.Order;
import com.lpdm.msorder.entity.Store;
import com.lpdm.msorder.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger log = LogManager.getLogger(this.getClass());

    private final OrderDao orderDao;
    private final UserController userController;
    private final StoreController storeController;

    @Autowired
    public OrderController(StoreController storeController, OrderDao orderDao, UserController userController) {
        this.storeController = storeController;
        this.orderDao = orderDao;
        this.userController = userController;
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

            return order;
        }
        else return null;
    }
}