package com.muruoyi.springbootdemo.repository;

import com.muruoyi.springbootdemo.model.TradeHist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TraderHistRepository extends JpaRepository<TradeHist,Integer> {

    List<TradeHist> findByAccountIdAndCurrDate(Integer accountId, Date currDate);
}
