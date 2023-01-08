package com.example.grpcapplication.service;

import com.example.grpcapplication.dto.ProductInputDTO;
import com.example.grpcapplication.dto.ProductOutputDTO;

import java.util.List;

public interface IProductService {

    ProductOutputDTO create(ProductInputDTO inputDTO);

    ProductOutputDTO findById(Long id);

    void delete(Long id);
    
    List<ProductOutputDTO> findAll();
}
