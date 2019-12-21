package com.muruoyi.springbootdemo.service.impl;

import com.muruoyi.springbootdemo.exception.ServiceError;
import com.muruoyi.springbootdemo.exception.ServiceException;
import com.muruoyi.springbootdemo.model.*;
import com.muruoyi.springbootdemo.repository.AccountRepository;
import com.muruoyi.springbootdemo.repository.OrderDetailRepository;
import com.muruoyi.springbootdemo.repository.OrderRepository;
import com.muruoyi.springbootdemo.repository.TraderHistRepository;
import com.muruoyi.springbootdemo.service.AccountService;
import com.muruoyi.springbootdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TraderHistRepository traderHistRepository;

    @Autowired
    private OrderService orderService;

    @Override
    @Transactional
    public Account getById(Integer id) {
        return accountRepository.getOne(id);
    }

    @Override
    @Transactional
    public Account addAccount(String nickName, String mobile) {
        Account account = Account.builder().mobile(mobile).nickName(nickName).balance(0.0).build();
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Double getBalanceById(Integer id) {
        Account account = accountRepository.getOne(id);
        if (account!=null){
            return account.getBalance();
        }else {
            throw new ServiceException(ServiceError.CanNotFindMember);
        }
    }

    @Override
    @Transactional
    public Account addBalance(String mobile,Double balance) {
        Date currDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            currDate = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Account account = accountRepository.findByMobile(mobile);
        if (account==null) throw new ServiceException(ServiceError.CanNotFindMember);
        Product product = Product.builder().id(001).productCount(1.0).productPrice(balance).productName("充值").build();
        Order order = orderService.addOrder("充值",product);
        TradeHist tradeHist = TradeHist.builder().accountId(account.getId()).actId(order.getId()).type(0)
                                .amount(balance).currDate(currDate).note("会员充值").build();
        traderHistRepository.save(tradeHist);
        account.setBalance(account.getBalance()+balance);
        account = accountRepository.save(account);
        order.setCompleted(true);
        orderRepository.save(order);
        return account;
    }
}
