package dev.market.spring_market.service;

import java.util.List;

import dev.market.spring_market.dto.ProductRequest;
import dev.market.spring_market.dto.ProductResponse;
import dev.market.spring_market.entity.Product;

public interface ProductService {
    List<ProductResponse> findAll();

    ProductResponse findById(Long productId);
    
    ProductResponse save(ProductRequest productRequest);
}
