package dev.market.spring_market.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;


    private String title;

    private int price;

    private String contents;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private int status;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<ProductImg> productImages;
}
