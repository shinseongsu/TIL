package com.example.grpcapplication.dto;

public class ProductInputDTO {
    private final String name;
    private final Double price;
    private final Integer quantityInStock;

    public ProductInputDTO(String name, Double price, Integer quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
}
