package dev.market.spring_market.DTO;

import dev.market.spring_market.entity.ProductImg;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductImgDTO {
    private String productImage;

    public static ProductImgDTO from(ProductImg productImg) {
        final String productImage = productImg.getProductImage();

        return ProductImgDTO.builder().productImage(productImage).build();
    }
}
