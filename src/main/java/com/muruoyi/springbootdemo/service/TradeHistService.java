package com.muruoyi.springbootdemo.service;

import com.muruoyi.springbootdemo.model.Order;
import com.muruoyi.springbootdemo.model.TradeHist;

import java.util.Date;
import java.util.List;

public interface TradeHistService {

    List<TradeHist> getTradeHistByMobileAndCurrDate(String mobile, Date currDate);

    Order getOrderByTradeHist(Integer tradeHistId);

    List<TradeHist> getAll();
}
