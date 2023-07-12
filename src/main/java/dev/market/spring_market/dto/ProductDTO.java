package dev.market.spring_market.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ProductDTO {

    private String title;

    private int price;

    private String contents;

    private LocalDateTime createdAt;

    private List<ProductImgDTO> productImages;
}
