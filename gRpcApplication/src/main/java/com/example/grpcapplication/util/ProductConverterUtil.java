package com.example.grpcapplication.util;

import com.example.grpcapplication.domain.Product;
import com.example.grpcapplication.dto.ProductInputDTO;
import com.example.grpcapplication.dto.ProductOutputDTO;

public class ProductConverterUtil {

    public static ProductOutputDTO productToProductOutputDto(Product product) {
        return new ProductOutputDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }

    public static Product productInputDtoToProduct(ProductInputDTO product) {
        return new Product(
                null,
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }

}
