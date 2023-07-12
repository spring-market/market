package dev.market.spring_market.service;

import dev.market.spring_market.dto.UserRequest;
import dev.market.spring_market.dto.UserResponse;

public interface UserService {
    UserResponse findById(Long userId);

    UserResponse deleteUser(Long userId);

    UserResponse registerUser(UserRequest userRequest);

    UserResponse updateUser(Long userId,UserRequest userRequest);
}

