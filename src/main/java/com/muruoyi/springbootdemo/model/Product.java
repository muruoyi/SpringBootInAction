package com.muruoyi.springbootdemo.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
//@Entity
public class Product {

    private Integer id;

    private String productName;

    private Double productPrice;

    private Double productCount;
}
