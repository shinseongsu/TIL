package com.kurly.prodcut.domain;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public abstract class Quantity {

    @Column
    private Integer quantiity;
}
