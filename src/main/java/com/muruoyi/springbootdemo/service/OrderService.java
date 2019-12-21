package com.muruoyi.springbootdemo.service;

import com.muruoyi.springbootdemo.model.Order;
import com.muruoyi.springbootdemo.model.Product;

public interface OrderService {

    Order addOrder(String title, Product product);

}
