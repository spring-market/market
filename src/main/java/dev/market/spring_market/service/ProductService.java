package dev.market.spring_market.service;

import dev.market.spring_market.DTO.ProductDTO;
import dev.market.spring_market.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO findById(Long productId);
}
