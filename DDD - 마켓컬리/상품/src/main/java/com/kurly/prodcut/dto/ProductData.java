package com.kurly.prodcut.dto;

import com.github.dozermapper.core.Mapping;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductData {

    private Long id;

    @NotBlank
    @Mapping("name")
    private String name;

    @NotBlank
    @Mapping("price")
    private Integer price;

    public ProductData(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
