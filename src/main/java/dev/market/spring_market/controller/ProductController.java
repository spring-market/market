package dev.market.spring_market.controller;

import java.util.List;

import javax.validation.Valid;

import dev.market.spring_market.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.market.spring_market.dto.ProductRequest;
import dev.market.spring_market.dto.ProductResponse;
import dev.market.spring_market.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private Object ResponseEntity;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    
    @PostMapping
    public void addProduct(@Valid @RequestBody ProductRequest productRequest) {
    	productService.save(productRequest);
    }
}
