package dev.market.spring_market.controller;

import dev.market.spring_market.dto.LoginReq;
import dev.market.spring_market.dto.LoginRes;
import dev.market.spring_market.dto.UserRequest;
import dev.market.spring_market.dto.UserResponse;
import dev.market.spring_market.service.UserService;
import dev.market.spring_market.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    //회원 마이페이지 정보 반환API
    @GetMapping("/{userId}")
    public UserResponse getUserInfo(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/login/{userId}")
    public UserResponse login(@PathVariable Long userId, LoginReq loginReq, HttpServletResponse httpServletResponse) {
        LoginRes loginRes = userService.login(userId, loginReq);
        Cookie cookie = new Cookie("jwt", loginRes.getJwt());
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        UserResponse userResponse = UserResponse.builder().userEmail(loginRes.getUserEmail()).gender(loginRes.getGender()).nickname(loginRes.getNickname()).build();
        httpServletResponse.addCookie(cookie);
        return userResponse;
    }


    @PatchMapping("/{userId}")
    public UserResponse deleteUserInfo(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.registerUser(userRequest);
        return userResponse;
    }
}
