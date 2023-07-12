package dev.market.spring_market.service;

import dev.market.spring_market.DTO.ProductDTO;
import dev.market.spring_market.DTO.ProductImgDTO;
import dev.market.spring_market.entity.Product;
import dev.market.spring_market.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS = new ArrayList<>();

        Iterable<Product> products = productRepo.findAll();

        for(Product p : products) {
            List<ProductImgDTO> productImgDTOS = p.getProductImages().stream()
                    .map(ProductImgDTO::from)
                    .collect(Collectors.toList());

            // Product -> ProductDTO 변환
            ProductDTO productDTO = ProductDTO.builder()
                    .title(p.getTitle())
                    .price(p.getPrice())
                    .createdAt(p.getCreatedAt())
                    .productImages(productImgDTOS)
                    .build();

            // productDTOS.add()
            productDTOS.add(productDTO);
        }


        return productDTOS;
    }


}
