package com.example.grpcapplication.service.impl;

import com.example.grpcapplication.domain.Product;
import com.example.grpcapplication.dto.ProductInputDTO;
import com.example.grpcapplication.dto.ProductOutputDTO;
import com.example.grpcapplication.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @DisplayName("when create product service is call with valid data a product is returned")
    @Test
    void createProductSuccessTest() {
        Product product = new Product(1L, "product name", 10.00, 10);

        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        ProductInputDTO inputDTO = new ProductInputDTO("product name", 10.00, 10);
        ProductOutputDTO outputDTO = productService.create(inputDTO);

        assertThat(outputDTO)
                .usingRecursiveComparison()
                .isEqualTo(product);
    }

}
