package dev.market.spring_market.dto;

import javax.validation.constraints.NotNull;

import dev.market.spring_market.entity.ProductImg;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImgReqRes {
	@NotNull
    private String productImage;

    public static ProductImgReqRes from(ProductImg productImg) {
        final String productImage = productImg.getProductImage();

        return ProductImgReqRes.builder().productImage(productImage).build();
    }

    @Builder
	public ProductImgReqRes(@NotNull String productImage) {
		super();
		this.productImage = productImage;
	}
}
