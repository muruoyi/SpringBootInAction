package com.muruoyi.springbootdemo.service.impl;

import com.muruoyi.springbootdemo.model.Order;
import com.muruoyi.springbootdemo.model.OrderDetail;
import com.muruoyi.springbootdemo.model.Product;
import com.muruoyi.springbootdemo.repository.OrderDetailRepository;
import com.muruoyi.springbootdemo.repository.OrderRepository;
import com.muruoyi.springbootdemo.repository.TraderHistRepository;
import com.muruoyi.springbootdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    TraderHistRepository traderHistRepository;

    @Override
    @Transactional
    public Order addOrder(String title, Product product) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currDate = new Date();
        try {
            currDate = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double amount = product.getProductPrice()*product.getProductCount();
        Order order = Order.builder().title(title).currDate(currDate).completed(false).amount(amount).build();
        order = orderRepository.save(order);
        OrderDetail orderDetail = OrderDetail.builder().orderId(order.getId())
                .productName(product.getProductName()).productPrice(product.getProductPrice())
                .productId(product.getId()).productCount(product.getProductCount()).build();
        orderDetailRepository.save(orderDetail);
        return order;
    }
}
