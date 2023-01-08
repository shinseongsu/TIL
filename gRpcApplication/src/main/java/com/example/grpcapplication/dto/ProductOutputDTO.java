package com.example.grpcapplication.dto;

public class ProductOutputDTO {
    private final Long id;
    private final String name;
    private final String price;
    private final Integer quantityInStock;

    public ProductOutputDTO(Long id, String name, String price, Integer quantityInStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
}
