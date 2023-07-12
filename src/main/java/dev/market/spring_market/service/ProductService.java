package dev.market.spring_market.service;

import dev.market.spring_market.dto.ProductResponse;
import dev.market.spring_market.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAll();

    ProductResponse findById(Long productId);
}
