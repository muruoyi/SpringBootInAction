package com.muruoyi.springbootdemo.repository;

import com.muruoyi.springbootdemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
