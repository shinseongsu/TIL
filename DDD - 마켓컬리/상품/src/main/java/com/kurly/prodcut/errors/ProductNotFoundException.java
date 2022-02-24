package com.kurly.prodcut.errors;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product Not Found " + id);
    }
}
