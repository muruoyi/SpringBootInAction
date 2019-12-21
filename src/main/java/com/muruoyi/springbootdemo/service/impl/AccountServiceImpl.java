package com.muruoyi.springbootdemo.service.impl;

import com.muruoyi.springbootdemo.model.Account;
import com.muruoyi.springbootdemo.repository.AccountRepository;
import com.muruoyi.springbootdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getById(Integer id) {
        return accountRepository.getOne(id);
    }
}
