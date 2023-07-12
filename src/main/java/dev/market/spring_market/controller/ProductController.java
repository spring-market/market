package dev.market.spring_market.controller;

import dev.market.spring_market.DTO.ProductDTO;
import dev.market.spring_market.entity.Product;
import dev.market.spring_market.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }
}
