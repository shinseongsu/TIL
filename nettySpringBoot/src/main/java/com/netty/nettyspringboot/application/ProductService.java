package com.netty.nettyspringboot.application;

import com.netty.nettyspringboot.domain.Product;
import com.netty.nettyspringboot.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void save(String name) {
        Product product = Product.builder()
                        .name(name)
                        .build();

        productRepository.save(product);
    }
}
