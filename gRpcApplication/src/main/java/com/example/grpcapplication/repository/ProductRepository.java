package com.example.grpcapplication.repository;

import com.example.grpcapplication.domain.Product;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String name);
}
