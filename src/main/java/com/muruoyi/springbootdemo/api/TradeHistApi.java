package com.muruoyi.springbootdemo.api;

import com.muruoyi.springbootdemo.api.vo.ApiResult;
import com.muruoyi.springbootdemo.service.TradeHistService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log4j2
@RestController
@RequestMapping("/tradeHist")
public class TradeHistApi {

    @Autowired
    TradeHistService tradeHistService;

    @GetMapping("/list")
    public ApiResult getTradeHistByMobileAndCurrDate(String mobile, Date currDate){
        log.info("mobile: {}, currDate:{}",mobile,currDate);
        return ApiResult.success(tradeHistService.getTradeHistByMobileAndCurrDate(mobile,currDate));
    }

    @GetMapping
    public ApiResult getAll(){
        return ApiResult.success(tradeHistService.getAll());
    }

}
