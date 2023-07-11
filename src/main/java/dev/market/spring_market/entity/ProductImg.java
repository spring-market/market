package dev.market.spring_market.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ProductImg {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Long productImageId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    @Column(name = "product_image")
    private String productImage;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    private int status;

}
