package com.muruoyi.springbootdemo.repository;

import com.muruoyi.springbootdemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByMobile(String mobile);
}
