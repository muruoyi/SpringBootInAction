package com.muruoyi.springbootdemo.api;

import com.muruoyi.springbootdemo.api.vo.ApiResult;
import com.muruoyi.springbootdemo.model.Product;
import com.muruoyi.springbootdemo.model.TradeHist;
import com.muruoyi.springbootdemo.service.OrderService;
import com.muruoyi.springbootdemo.service.TradeHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    OrderService orderService;

    @Autowired
    TradeHistService tradeHistService;

    @PostMapping("/new/{title}")
    public ApiResult createOrder(@PathVariable("title") String title, @RequestBody Product product){
        return ApiResult.success(orderService.addOrder(title,product));
    }

    @PostMapping
    public ApiResult getOrderByTradeHist(Integer tradeHistId){
        return ApiResult.success(tradeHistService.getOrderByTradeHist(tradeHistId));
    }

}
