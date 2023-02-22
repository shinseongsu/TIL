package com.netty.nettyspringboot.ui;

import com.netty.nettyspringboot.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    public void productSave(String name) {
        productService.save(name);
    }

}
