package com.example.grpcapplication.service;

import com.example.grpcapplication.domain.Product;
import com.example.grpcapplication.dto.ProductInputDTO;
import com.example.grpcapplication.dto.ProductOutputDTO;
import com.example.grpcapplication.repository.ProductRepository;
import com.example.grpcapplication.util.ProductConverterUtil;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductOutputDTO create(ProductInputDTO inputDTO) {
        var product = ProductConverterUtil.productInputDtoToProduct(inputDTO);
        Product productCreated = this.productRepository.save(product);
        return ProductConverterUtil.productToProductOutputDto(productCreated);
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductOutputDTO> findAll() {
        return null;
    }
}
