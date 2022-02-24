package com.kurly.prodcut.application;

import com.github.dozermapper.core.Mapper;
import com.kurly.prodcut.domain.Product;
import com.kurly.prodcut.errors.ProductNotFoundException;
import com.kurly.prodcut.infra.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final Mapper mapper;
    private final ProductRepository productRepository;

    public ProductService(Mapper mapper, ProductRepository productRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return findProduct(id);
    }


    private Product findProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

}
