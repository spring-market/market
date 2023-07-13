package dev.market.spring_market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

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
    public void saveProduct(@Valid @RequestBody ProductRequest productRequest) {
    	productService.save(productRequest);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest productRequest) {
        productService.update(id, productRequest);
    }

    @PatchMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
