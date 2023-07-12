package dev.market.spring_market.service;

import dev.market.spring_market.dto.ProductResponse;
import dev.market.spring_market.dto.ProductImgReqRes;
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

    public List<ProductImgReqRes> getProductImgList(Product p) {
        List<ProductImgReqRes> productImgDTOS = p.getProductImages().stream()
                .map(ProductImgReqRes::from)
                .collect(Collectors.toList());
        return productImgDTOS;
    }

    @Override
    public List<ProductResponse> findAll() {
        List<ProductResponse> productDTOS = new ArrayList<>();

        Iterable<Product> products = productRepo.findAll();

        for(Product p : products) {
            List<ProductImgReqRes> productImgDTOS = getProductImgList(p);

            // Product -> ProductDTO 변환
            ProductResponse productDTO = ProductResponse.builder()
                    .title(p.getTitle())
                    .price(p.getPrice())
                    .createdAt(p.getCreatedAt())
                    .productImages(productImgDTOS)
                    .categoryId(p.getCategory().getCategoryId())
                    .build();

            // productDTOS.add()
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    @Override
    public ProductResponse findById(Long productId) {
        Product p = productRepo.getReferenceById(productId);

        List<ProductImgReqRes> productImgDTOS = getProductImgList(p);

        return ProductResponse.builder()
                .title(p.getTitle()).price(p.getPrice())
                .contents(p.getContents()).createdAt(p.getCreatedAt())
                .productImages(productImgDTOS)
                .categoryId(p.getCategory().getCategoryId())
                .build();
    }

}
