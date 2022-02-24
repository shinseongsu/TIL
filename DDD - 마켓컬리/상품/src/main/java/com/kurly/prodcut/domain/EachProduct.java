package com.kurly.prodcut.domain;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public abstract class EachProduct {

    @Column
    private String each;

    @Column
    private Long weight;

}
