package com.muruoyi.springbootdemo.service;

import com.muruoyi.springbootdemo.model.Account;

public interface AccountService {

    Account getById(Integer id);

    Account addAccount(String nickName,String mobile);

    Double getBalanceById(Integer id);

    Account addBalance(String mobile,Double balance);
}
