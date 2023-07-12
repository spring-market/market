package dev.market.spring_market.service;

import dev.market.spring_market.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO findById(Long productId);
}
