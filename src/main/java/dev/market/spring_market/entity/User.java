package dev.market.spring_market.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email")
    private String userEmail;

    private String password;

    private String nickname;

    private char gender;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private int status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Product> products;


    public User(String userEmail, String password, String nickname, char gender) {
        this.userEmail = userEmail;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
    }
}
