package dev.market.spring_market.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@ToString
@NoArgsConstructor
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

    @Builder
	public Product(Long productId, Category category, User user, String title, int price, String contents,
			LocalDateTime createdAt, LocalDateTime updatedAt, int status, List<ProductImg> productImages) {
		super();
		this.productId = productId;
		this.category = category;
		this.user = user;
		this.title = title;
		this.price = price;
		this.contents = contents;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.productImages = productImages;
	}
    
    
}
