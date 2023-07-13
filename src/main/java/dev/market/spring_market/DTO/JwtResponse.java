package dev.market.spring_market.dto;

import lombok.Getter;

@Getter
public class JwtResponse {
    private String jwt;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }
}
