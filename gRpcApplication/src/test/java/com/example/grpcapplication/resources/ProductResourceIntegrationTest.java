package com.example.grpcapplication.resources;

import com.example.grpcapplication.ProductRequest;
import com.example.grpcapplication.ProductResponse;
import com.example.grpcapplication.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:application-test.yml")
@DirtiesContext
public class ProductResourceIntegrationTest {

    @GrpcClient("inProcess")
    private ProductServiceGrpc.ProductServiceBlockingStub serviceBlockingStub;

    @DisplayName("when valid data is provided a product is created")
    @Test
    public void createProductSuccessTest() {
        ProductRequest productRequest = ProductRequest.newBuilder()
                .setName("product Name")
                .setPrice(10.00)
                .setQuantityInStock(100)
                .build();

        ProductResponse productResponse = serviceBlockingStub.create(productRequest);

        assertThat(productRequest)
                .usingRecursiveComparison()
                .comparingOnlyFields("name", "price", "quantity_in_stock")
                .isEqualTo(productResponse);
    }


}
