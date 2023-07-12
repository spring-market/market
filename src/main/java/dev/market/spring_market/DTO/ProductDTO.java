package dev.market.spring_market.DTO;

import dev.market.spring_market.entity.ProductImg;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
