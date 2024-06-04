package com.example.pricecomparreredis.vo;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductGrp {

    private String prodGrpId;
    private List<Product> productList;
}
