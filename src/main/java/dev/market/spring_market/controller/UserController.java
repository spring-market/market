package dev.market.spring_market.controller;

import dev.market.spring_market.dto.UserRequest;
import dev.market.spring_market.dto.UserResponse;
import dev.market.spring_market.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    //회원 마이페이지 정보 반환API
   @GetMapping("/{userId}")
    public UserResponse getUserInfo(@PathVariable Long userId){
       System.out.println("컨트롤러 실행");
       return userService.findById(userId);
   }

   @PatchMapping("/{userId}")
    public UserResponse deleteUserInfo(@PathVariable Long userId) {

       return userService.deleteUser(userId);
   }

   @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.registerUser(userRequest);
        return userResponse;
   }

}
