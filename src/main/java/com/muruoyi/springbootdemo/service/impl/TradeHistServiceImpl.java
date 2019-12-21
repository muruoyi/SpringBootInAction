package com.muruoyi.springbootdemo.service.impl;

import com.muruoyi.springbootdemo.exception.ServiceError;
import com.muruoyi.springbootdemo.exception.ServiceException;
import com.muruoyi.springbootdemo.model.Account;
import com.muruoyi.springbootdemo.model.Order;
import com.muruoyi.springbootdemo.model.TradeHist;
import com.muruoyi.springbootdemo.repository.AccountRepository;
import com.muruoyi.springbootdemo.repository.OrderRepository;
import com.muruoyi.springbootdemo.repository.TraderHistRepository;
import com.muruoyi.springbootdemo.service.TradeHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TradeHistServiceImpl implements TradeHistService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TraderHistRepository traderHistRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public List<TradeHist> getTradeHistByMobileAndCurrDate(String mobile, Date currDate) {
        Account account = accountRepository.findByMobile(mobile);
        if (account==null) throw new ServiceException(ServiceError.CanNotFindMember);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            currDate = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return traderHistRepository.findByAccountIdAndCurrDate(account.getId(),currDate);
    }

    @Override
    @Transactional
    public Order getOrderByTradeHist(Integer tradeHistId) {
        TradeHist tradeHist = traderHistRepository.getOne(tradeHistId);
        Order order = orderRepository.getOne(tradeHist.getActId());
        return order;
    }

    @Override
    public List<TradeHist> getAll() {
        return traderHistRepository.findAll();
    }
}
