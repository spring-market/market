package dev.market.spring_market.dto;

import lombok.Builder;
import lombok.Getter;

@Getter

public class UserResponse {
    private String userEmail;
    private String nickname;
    private char gender;


    public UserResponse() {
    }
    @Builder
    public UserResponse(String userEmail, String nickname, char gender) {
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.gender = gender;
    }
}
