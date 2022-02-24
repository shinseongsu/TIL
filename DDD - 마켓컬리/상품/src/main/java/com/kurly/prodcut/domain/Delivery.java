package com.kurly.prodcut.domain;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public abstract class Delivery {

    @Column
    private String earlyDelivery = "샛별배송";

    @Column
    private String howtoDelivery = "택배배송";

    @Column
    private String boxingType = "종이포장";

}
