package com.example.pricecomparreredis.vo;

import lombok.Getter;

import java.util.List;

@Getter
public class Keyword {

    private String keyword;
    private List<ProductGrp> productGrpList;

}
