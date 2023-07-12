package dev.market.spring_market.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class UserRequest {
    private String userEmail;
    private String password;
    private String nickname;
    private char gender;
}
