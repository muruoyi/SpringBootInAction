package com.muruoyi.springbootdemo.api;

import com.muruoyi.springbootdemo.api.vo.ApiResult;
import com.muruoyi.springbootdemo.model.Account;
import com.muruoyi.springbootdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountApi {
    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public ApiResult addAccount(@RequestParam  String nickName,@RequestParam String mobile){
        return ApiResult.success(accountService.addAccount(nickName,mobile));
    }

    @PostMapping("/addBalance")
    public ApiResult addBalance(String mobile,Double balance){
        return ApiResult.success(accountService.addBalance(mobile,balance));
    }
}
