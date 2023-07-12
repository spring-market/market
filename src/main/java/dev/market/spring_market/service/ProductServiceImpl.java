package dev.market.spring_market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.market.spring_market.dto.ProductImgReqRes;
import dev.market.spring_market.dto.ProductRequest;
import dev.market.spring_market.dto.ProductResponse;
import dev.market.spring_market.entity.Product;
import dev.market.spring_market.repository.CategoryRepo;
import dev.market.spring_market.repository.ProductRepo;
import dev.market.spring_market.repository.UserRepo;

@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    

    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo, UserRepo userRepo) {
		super();
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.userRepo = userRepo;
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

	@Override
	public void save(ProductRequest productRequest) {
		Product product = Product.builder()
					.user(userRepo.getReferenceById(productRequest.getUserId()))
					.title(productRequest.getTitle())
					.price(productRequest.getPrice())
					.contents(productRequest.getContents())
					.category(categoryRepo.getReferenceById(productRequest.getCategoryId()))
					.build();
		productRepo.save(product);
	}

}
