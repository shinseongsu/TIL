package com.example.grpcapplication.dto;

public class ProductInputDTO {
    private final String name;
    private final String price;
    private final Integer quantityInStock;

    public ProductInputDTO(String name, String price, Integer quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
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
