package dev.market.spring_market.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductRequest {
	@NotNull @Size(min = 1, max = 45)
    private String title;

	@NotNull
	private int price;

	@Size(min = 0, max = 255)
    private String contents;

    private LocalDateTime createdAt;

    private List<ProductImgReqRes> productImages;
    
    @NotNull
    private Long categoryId;
}
