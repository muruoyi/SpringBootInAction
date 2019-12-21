package com.muruoyi.springbootdemo.repository;

import com.muruoyi.springbootdemo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
