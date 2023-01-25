package com.example.grpcapplication.util;

import com.example.grpcapplication.domain.Product;
import com.example.grpcapplication.dto.ProductInputDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductConverterUtilTest {

    @Test
    void productToProductOutputDtoTest() {
        var product = new Product(1L, "product name", 10.00, 10);
        var productOutputDto = ProductConverterUtil
                .productToProductOutputDto(product);

        assertThat(product)
                .usingRecursiveComparison()
                .isEqualTo(productOutputDto);
    }

    @Test
    void productInputToProductTest() {
        var productInput = new ProductInputDTO("product name", 10.00, 10);
        var product = ProductConverterUtil
                .productInputDtoToProduct(productInput);

        assertThat(productInput)
                .usingRecursiveComparison()
                .isEqualTo(product);

    }

}
